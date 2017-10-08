package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;
import java.util.Observable;

/**
 * Created by ahdpe on 04.10.2017.
 */
public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Cook cooker = new Cook("Amigo");
        tablet.addObserver(cooker);
        Waiter waiter = new Waiter();
        cooker.addObserver(waiter);
        tablet.createOrder();
    }

    public void createOrder() {

    }
}
