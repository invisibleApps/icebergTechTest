package com.icebergTechTest.drinks;

public class Espresso implements CoffeeDrink{

    private int water = 35;
    private int milk = 0;
    private int coffeeBeans = 10;

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
