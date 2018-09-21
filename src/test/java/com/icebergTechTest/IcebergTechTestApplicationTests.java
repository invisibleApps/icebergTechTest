package com.icebergTechTest;

import com.icebergTechTest.domain.CoffeeMachine;
import com.jayway.restassured.RestAssured;


import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;


public class IcebergTechTestApplicationTests {


    @Test
    public void addWaterPOSTTest() {
        CoffeeMachine machine = get("/parameters").as(CoffeeMachine.class);
        int addWater = 1000;
        int willBeWater = addWater + machine.getWater();
        if (willBeWater <= machine.MAX_WATER) {
            assertEquals(true,
                    RestAssured.given()
                            .param("water", addWater)
                            .when()
                            .post("/addwater")
                            .then()
                            .statusCode(200).extract().response().prettyPrint().equals("OK")
            );
        } else
        {
            assertEquals(true,
                    RestAssured.given()
                            .param("water", addWater)
                            .when()
                            .post("/addwater")
                            .then()
                            .statusCode(200).extract().response().prettyPrint().equals("NOT_EXECUTED")
            );
        }
        getParametersTest();
    }

    @Test
    public void addMilkPOSTTest() {
        CoffeeMachine machine = get("/parameters").as(CoffeeMachine.class);
        int addMilk = 1000;
        int willBeMilk = addMilk + machine.getMilk();
        if (willBeMilk < machine.MAX_MILK) {
            assertEquals(true,
                    RestAssured.given()
                            .param("milk", addMilk)
                            .when()
                            .post("/addmilk")
                            .then()
                            .statusCode(200).extract().response().prettyPrint().equals("OK")
            );
        } else
        {
            assertEquals(true,
                    RestAssured.given()
                            .param("milk", addMilk)
                            .when()
                            .post("/addmilk")
                            .then()
                            .statusCode(200).extract().response().prettyPrint().equals("NOT_EXECUTED")
            );
        }
        getParametersTest();
    }


    @Test
    public void addCoffeeBeansPOSTTest() {
        CoffeeMachine machine = get("/parameters").as(CoffeeMachine.class);
        int addBeans = 50;
        int willBeBeans = addBeans + machine.getCoffee();
        if (willBeBeans < machine.MAX_COFFEE_BEANS) {
            assertEquals(true,
                    RestAssured.given()
                            .param("beans", addBeans)
                            .when()
                            .post("/addbeans")
                            .then()
                            .statusCode(200).extract().response().prettyPrint().equals("OK")
            );
        } else
        {
            assertEquals(true,
                    RestAssured.given()
                            .param("beans", addBeans)
                            .when()
                            .post("/addbeans")
                            .then()
                            .statusCode(200).extract().response().prettyPrint().equals("NOT_EXECUTED")
            );
        }
        getParametersTest();
    }


    @Test
    public void getParametersTest() {
        RestAssured.given()
                .get("/parameters")
                .then()
                .extract().response().prettyPrint();
    }


}
