package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String key = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);
        ArrayList<Integer> list = new ArrayList<>(inputStream.available());
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            System.out.println(data);
            list.add(data);
        }
        ArrayList<Integer> listDSH = new ArrayList<>(list.size());
        if (key.equals("-e")) {
            for (int i = 0; i < list.size(); i++) {
                listDSH.add(list.get(i) + 1);
            }
        }
        if (key.equals("-d")) {
            for (int i = 0; i < list.size(); i++) {
                listDSH.add(list.get(i) - 1);
            }
        }
        for (int i = 0; i < listDSH.size(); i++) {
            outputStream.write(listDSH.get(i));
        }
        inputStream.close();
        outputStream.close();
    }

}
