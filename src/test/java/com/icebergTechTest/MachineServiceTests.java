package com.icebergTechTest;

import com.icebergTechTest.domain.MachineStatus;
import com.icebergTechTest.drinks.Americano;
import com.icebergTechTest.drinks.Capuchino;
import com.icebergTechTest.drinks.CoffeeDrink;
import com.icebergTechTest.drinks.Espresso;
import com.icebergTechTest.service.CoffeeMachineService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineServiceTests {

    @Autowired
    private CoffeeMachineService machineService;

    @Test
    public void TestAddWater() {
        assertEquals(true, machineService.addWater(1000));
        assertEquals(false, machineService.addWater(-1000));
        assertEquals(false, machineService.addWater(2500));
    }

    @Test
    public void TestAddMilk() {
        assertEquals(true, machineService.addMilk(1000));
        assertEquals(false, machineService.addMilk(-1000));
        assertEquals(false, machineService.addMilk(1500));
    }

    @Test
    public void TestAddCoffeebeans() {
        assertEquals(true, machineService.addCoffeeBeans(60));
        assertEquals(false, machineService.addCoffeeBeans(-10));
        assertEquals(false, machineService.addCoffeeBeans(50));
    }

    @Test
    public void makeCapuchinoTest() {
        CoffeeDrink cupOfCoffee = new Capuchino();

        //loading coffee machine
        machineService.addWater(2000);
        machineService.addMilk(1000);
        machineService.addCoffeeBeans(100);

        //make 8 cups of capuchino
        for (int i = 1; i <= 8; i++) {
            if (machineService.getFullStatus().getCoffee() < cupOfCoffee.getCoffeeBeans()) {
                //need coffee beans
                assertEquals(false, machineService.makeCoffee(cupOfCoffee));
                assertEquals(MachineStatus.NEED_COFFEE_BEANS, machineService.getCurrentStatus());
                machineService.addCoffeeBeans(cupOfCoffee.getCoffeeBeans());
            }
            if (machineService.getFullStatus().getWater() < cupOfCoffee.getWater()) {
                //need water
                assertEquals(false, machineService.makeCoffee(cupOfCoffee));
                assertEquals(MachineStatus.NEED_WATER, machineService.getCurrentStatus());
                machineService.addWater(cupOfCoffee.getWater());
            }
            if (machineService.getFullStatus().getMilk() < cupOfCoffee.getMilk()) {
                //need milk
                assertEquals(false, machineService.makeCoffee(cupOfCoffee));
                assertEquals(MachineStatus.NEED_MILK, machineService.getCurrentStatus());
                machineService.addMilk(cupOfCoffee.getMilk());
            }
            assertEquals(true, machineService.makeCoffee(cupOfCoffee));
        }

        //result is false, need cleaning
        assertEquals(false, machineService.makeCoffee(cupOfCoffee));
        assertEquals(MachineStatus.NEED_CLEANING, machineService.getCurrentStatus());

        //machine cleaning
        machineService.cleaningMachine();
        assertEquals(MachineStatus.READY,machineService.getCurrentStatus());
    }

    @Test
    public void makeAmericanoTest() {
        CoffeeDrink cupOfCoffee = new Americano();

        //loading coffee machine
        machineService.addWater(2000);
        machineService.addMilk(1000);
        machineService.addCoffeeBeans(100);

        //make 8 cups of capuchino
        for (int i = 1; i <= 8; i++) {
            if (machineService.getFullStatus().getCoffee() < cupOfCoffee.getCoffeeBeans()) {
                //need coffee beans
                assertEquals(false, machineService.makeCoffee(cupOfCoffee));
                assertEquals(MachineStatus.NEED_COFFEE_BEANS, machineService.getCurrentStatus());
                machineService.addCoffeeBeans(cupOfCoffee.getCoffeeBeans());
            }
            if (machineService.getFullStatus().getWater() < cupOfCoffee.getWater()) {
                //need water
                assertEquals(false, machineService.makeCoffee(cupOfCoffee));
                assertEquals(MachineStatus.NEED_WATER, machineService.getCurrentStatus());
                machineService.addWater(cupOfCoffee.getWater());
            }
            if (machineService.getFullStatus().getMilk() < cupOfCoffee.getMilk()) {
                //need milk
                assertEquals(false, machineService.makeCoffee(cupOfCoffee));
                assertEquals(MachineStatus.NEED_MILK, machineService.getCurrentStatus());
                machineService.addMilk(cupOfCoffee.getMilk());
            }
            assertEquals(true, machineService.makeCoffee(cupOfCoffee));
        }

        //result is false, need cleaning
        assertEquals(false, machineService.makeCoffee(cupOfCoffee));
        assertEquals(MachineStatus.NEED_CLEANING, machineService.getCurrentStatus());

        //machine cleaning
        machineService.cleaningMachine();
        assertEquals(MachineStatus.READY,machineService.getCurrentStatus());

    }

    @Test
    public void makeEspressoTest() {
        CoffeeDrink cupOfCoffee = new Espresso();

        //loading coffee machine
        machineService.addWater(2000);
        machineService.addMilk(1000);
        machineService.addCoffeeBeans(100);

        //make 8 cups of capuchino
        for (int i = 1; i <= 8; i++) {
            if (machineService.getFullStatus().getCoffee() < cupOfCoffee.getCoffeeBeans()) {
                //need coffee beans
                assertEquals(false, machineService.makeCoffee(cupOfCoffee));
                assertEquals(MachineStatus.NEED_COFFEE_BEANS, machineService.getCurrentStatus());
                machineService.addCoffeeBeans(cupOfCoffee.getCoffeeBeans());
            }
            if (machineService.getFullStatus().getWater() < cupOfCoffee.getWater()) {
                //need water
                assertEquals(false, machineService.makeCoffee(cupOfCoffee));
                assertEquals(MachineStatus.NEED_WATER, machineService.getCurrentStatus());
                machineService.addWater(cupOfCoffee.getWater());
            }
            if (machineService.getFullStatus().getMilk() < cupOfCoffee.getMilk()) {
                //need milk
                assertEquals(false, machineService.makeCoffee(cupOfCoffee));
                assertEquals(MachineStatus.NEED_MILK, machineService.getCurrentStatus());
                machineService.addMilk(cupOfCoffee.getMilk());
            }
            assertEquals(true, machineService.makeCoffee(cupOfCoffee));
        }

        //result is false, need cleaning
        assertEquals(false, machineService.makeCoffee(cupOfCoffee));
        assertEquals(MachineStatus.NEED_CLEANING, machineService.getCurrentStatus());

        //machine cleaning
        machineService.cleaningMachine();
        assertEquals(MachineStatus.READY,machineService.getCurrentStatus());

    }

}
