package com.company;

import com.github.javafaker.Faker;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker();
        MyFaker myFaker = new MyFaker();
        for (int i = 0; i < 50;i++){
            System.out.println(myFaker.carBrand() + " " + myFaker.carModel());
        }
    }
}
