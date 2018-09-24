package com.icebergTechTest.drinks;

public class Capuchino implements CoffeeDrink {

    private int water = 150;
    private int milk = 100;
    private int coffeeBeans = 15;

    @Override
    public int getWater() {
        return water;
    }

    @Override
    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    @Override
    public int getMilk() {
        return milk;
    }
}
