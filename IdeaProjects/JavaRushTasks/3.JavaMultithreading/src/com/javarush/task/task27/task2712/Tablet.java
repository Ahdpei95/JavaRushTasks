package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;



import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ahdpe on 05.10.2017.
 */
public class Tablet extends Observable {
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }
    public Order createOrder()  {
        try {
            Order newOrder = new Order(this);
            ConsoleHelper.writeMessage(newOrder.toString());
            if (newOrder.isEmpty()) return null;
            try
            {
                AdvertisementManager advertisementManager = new AdvertisementManager(newOrder.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
            }
            catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, String.format("No video is available for the order %s", newOrder));
            }
            setChanged();
            notifyObservers(newOrder);
            new AdvertisementManager(newOrder.getTotalCookingTime() * 60).processVideos();
            return newOrder;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return "Tablet{number=" + number + '}';
    }
}
