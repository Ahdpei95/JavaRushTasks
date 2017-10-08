package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahdpe on 05.10.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        boolean exitFlag = false;
        List<Dish> dishes = new ArrayList<>();
        while (!exitFlag) {
            writeMessage("Выберите блюдо:");
            String dish = readString();
            switch (dish) {
                case "Fish": dishes.add(Dish.Fish); break;
                case "Steak": dishes.add(Dish.Steak); break;
                case "Soup": dishes.add(Dish.Soup); break;
                case "Juice": dishes.add(Dish.Juice); break;
                case "Water": dishes.add(Dish.Water); break;
                case "exit": exitFlag = true; break;
                default:
                    writeMessage("Такого блюда нет!");
            }
        }
        return dishes;
    }
}
