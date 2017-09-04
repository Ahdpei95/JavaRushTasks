package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;
import com.sun.javafx.iio.ImageStorage;

/**
 * Created by ahdpe on 07.06.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader reader;
        if (type == ImageTypes.BMP){
            reader = new BmpReader();
        } else {
            if (type == ImageTypes.JPG){
                reader = new JpgReader();
            } else {
                if (type == ImageTypes.PNG){
                    reader = new PngReader();
                } else {
                    throw new IllegalArgumentException("Неизвестный тип картинки");
                }
            }
        }
        return reader;
    }
}
