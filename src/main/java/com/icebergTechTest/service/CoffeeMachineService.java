package com.icebergTechTest.service;

import com.icebergTechTest.domain.CoffeeMachine;
import com.icebergTechTest.domain.MachineStatus;
import com.icebergTechTest.drinks.CoffeeDrink;

public interface CoffeeMachineService {

    boolean makeCoffee(CoffeeDrink drink);

    CoffeeMachine getFullStatus();

    boolean addWater(int water);
    boolean addMilk(int milk);
    boolean addCoffeeBeans(int coffeeBeans);

    void cleaningMachine();

    MachineStatus getCurrentStatus();
}
