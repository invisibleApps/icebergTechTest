package com.icebergTechTest.drinks;

public class Americano implements CoffeeDrink {

    private final int water = 200;
    private final int milk = 0;
    private final int coffeeBeans = 20;

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
