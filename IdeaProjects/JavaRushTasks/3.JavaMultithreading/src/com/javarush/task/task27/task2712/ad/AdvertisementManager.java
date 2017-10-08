package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

/**
 * Created by ahdpe on 05.10.2017.
 */
public class AdvertisementManager {
    int timeSeconds;
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty())
            throw new NoVideoAvailableException();
    }
}
