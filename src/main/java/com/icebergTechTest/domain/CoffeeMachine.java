package com.icebergTechTest.domain;

public class CoffeeMachine {

    public final int MAX_WATER = 2000;
    public final int MAX_MILK = 1000;
    public final int MAX_COFFEE_BEANS = 100;
    public final int MAX_CUPS_BEFORE_CLEARNING = 8;

    private int water;
    private int milk;
    private int coffee;
    private MachineStatus status;
    private int cupsCount;

    public CoffeeMachine() {
        this.water = 0;
        this.coffee = 0;
        this.milk = 0;
        this.status = MachineStatus.EMPTY_CHECK_STATUS;
        this.cupsCount = 0;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public MachineStatus getStatus() {
        return status;
    }

    public int getCupsCount() {
        return cupsCount;
    }

    public void setStatus(MachineStatus status) {
        this.status = status;
    }

    public void setCupsCount(int cupsCount) {
        this.cupsCount = cupsCount;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }
}
