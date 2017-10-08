package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by ahdpe on 05.10.2017.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes = ConsoleHelper.getAllDishesForOrder();


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
    }

    @Override
    public String toString() {
        return !dishes.isEmpty() ? String.format("Your order: %s of %s", dishes, tablet) : "";
    }

    public int getTotalCookingTime() {
        int timeToDoDishes = 0;
        for (Dish dish :
                dishes) {
            timeToDoDishes += dish.getDuration();
        }
        return timeToDoDishes;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
