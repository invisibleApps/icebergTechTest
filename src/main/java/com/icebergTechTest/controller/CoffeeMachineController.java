package com.icebergTechTest.controller;

import com.icebergTechTest.domain.CoffeeMachine;
import com.icebergTechTest.domain.MachineStatus;
import com.icebergTechTest.drinks.CoffeeDrink;
import com.icebergTechTest.drinks.CoffeeDrinkType;
import com.icebergTechTest.service.CoffeeMachineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeMachineController {

    @Autowired
    private CoffeeMachineService machineService;

    @GetMapping("/parameters")
    public CoffeeMachine getFullStatus(){
      return machineService.getFullStatus();
    }

    @PostMapping("/addwater")
    public String addWater(@RequestParam int water){
        if (machineService.addWater(water)) return "OK";
        return "NOT_EXECUTED";
    }

    @PostMapping("/addmilk")
    public String addMilk(@RequestParam int milk){
        if (machineService.addMilk(milk)) return "OK";
        return "NOT_EXECUTED";
    }

    @PostMapping("/addbeans")
    public String addCoffeeBeans(@RequestParam int beans){
        if (machineService.addCoffeeBeans(beans)) return "OK";
        return "NOT_EXECUTED";
    }

    @GetMapping("/status")
    public MachineStatus getCurrentStatus(){return machineService.getCurrentStatus();}


    @PostMapping("/makecoffee")
    public String makeCoffee(@RequestParam String coffeetype){
        if (CoffeeDrinkType.valueOf(coffeetype) != null) {
            String packName = CoffeeDrink.class.getPackage().getName();
            CoffeeDrink coffeeDrink = null;
            try {
                coffeeDrink = (CoffeeDrink) Class.forName(packName + '.' + coffeetype).newInstance();
                if (machineService.makeCoffee(coffeeDrink)) return "OK";
                return machineService.getCurrentStatus().name();
            } catch (InstantiationException e) {
                return "INVALID_COFFE_TYPE";
            } catch (IllegalAccessException e) {
                return "INVALID_COFFE_TYPE";
            } catch (ClassNotFoundException e) {
                return "INVALID_COFFE_TYPE";
            }
        }
        return "INVALID_COFFE_TYPE";
    }


    @PostMapping("/clean")
    public String cleaning(){
        machineService.cleaningMachine();
        return machineService.getCurrentStatus().name();
    }


}
