package com.javarush.task.task18.task1809;

/* 
Реверс файла

Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        String name1 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String name2 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream inputStream = new FileInputStream(name1);
        FileOutputStream outputStream = new FileOutputStream(name2);
        ArrayList<Integer> list = new ArrayList<>(inputStream.available());
        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }
        Collections.reverse(list);
        for (Integer bytes :
                list) {
            outputStream.write(bytes);
        }
        inputStream.close();
        outputStream.close();
    }
}
