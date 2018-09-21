package com.icebergTechTest.service;

import com.icebergTechTest.domain.CoffeeMachine;
import com.icebergTechTest.domain.MachineStatus;
import com.icebergTechTest.drinks.CoffeeDrink;

import org.springframework.stereotype.Service;

@Service
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    private final CoffeeMachine machine = new CoffeeMachine();

    @Override
    public boolean makeCoffee(CoffeeDrink drink) {
        int water = drink.getWater();
        int milk = drink.getMilk();
        int beans = drink.getCoffeeBeans();
        if (water <= machine.getWater() && milk <= machine.getMilk() && beans <= machine.getCoffee() && machine.getCupsCount() < machine.MAX_CUPS_BEFORE_CLEARNING) {
            machine.setStatus(MachineStatus.MAKING_COFFEE);
            machine.setWater(machine.getWater() - water);
            machine.setMilk(machine.getMilk() - milk);
            machine.setCoffee(machine.getCoffee() - beans);
            machine.setCupsCount(machine.getCupsCount() + 1);
            machine.setStatus(checkStatus());
            return true;
        } else
            if (machine.getCupsCount() == machine.MAX_CUPS_BEFORE_CLEARNING) machine.setStatus(MachineStatus.NEED_CLEANING);
            else
              if (water > machine.getWater()) machine.setStatus(MachineStatus.NEED_WATER);
               else
                 if (milk > machine.getMilk()) machine.setStatus(MachineStatus.NEED_MILK);
                  else
                    if (beans > machine.getCoffee()) machine.setStatus(MachineStatus.NEED_COFFEE_BEANS);
        return false;
    }

    @Override
    public CoffeeMachine getFullStatus() {
        return machine;
    }

    @Override
    public boolean addWater(int water) {
        int waterInMachine = machine.getWater();
        if ((water >= 0) && (water + waterInMachine <= machine.MAX_WATER)) {
            machine.setWater(water + waterInMachine);
            machine.setStatus(checkStatus());
            return true;
        }
        return false;
    }

    @Override
    public boolean addMilk(int milk) {
        int milkInMachine = machine.getMilk();
        if ((milk >= 0) && (milk + milkInMachine <= machine.MAX_MILK)) {
            machine.setMilk(milk + milkInMachine);
            machine.setStatus(checkStatus());
            return true;
        }
        return false;
    }

    @Override
    public boolean addCoffeeBeans(int coffeeBeans) {
        int beansInMachine = machine.getCoffee();
        if ((coffeeBeans >= 0) && (coffeeBeans + beansInMachine <= machine.MAX_COFFEE_BEANS)) {
            machine.setCoffee(coffeeBeans + beansInMachine);
            machine.setStatus(checkStatus());
            return true;
        }
        return false;
    }


    public MachineStatus checkStatus() {
        if (machine.getCupsCount() == machine.MAX_CUPS_BEFORE_CLEARNING) return MachineStatus.NEED_CLEANING;
        if (machine.getWater() == 0) return MachineStatus.NEED_WATER;
        if (machine.getMilk() == 0) return MachineStatus.NEED_MILK;
        if (machine.getCoffee() == 0) return MachineStatus.NEED_COFFEE_BEANS;
        return MachineStatus.READY;
    }

    @Override
    public void cleaningMachine(){
        if (machine.getStatus().equals(MachineStatus.NEED_CLEANING)){
            machine.setStatus(MachineStatus.CLEANING);
            machine.setCupsCount(0);
            machine.setStatus(checkStatus());
        }
    }

    @Override
    public MachineStatus getCurrentStatus() {
        return machine.getStatus();
    }
}
