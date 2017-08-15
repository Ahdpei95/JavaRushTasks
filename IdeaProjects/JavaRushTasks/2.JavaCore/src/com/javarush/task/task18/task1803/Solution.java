package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты

Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }
        inputStream.close();
        ArrayList<Integer> testList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            int bute = list.get(i);
            int count = 1;
            for (int j = i + 1; j < list.size(); j++) {
                if (bute == list.get(j)) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                testList.clear();
                testList.add(bute);
            } else if (max == count) {
                testList.add(bute);
            }
        }
        for (int i = 0; i < testList.size(); i++) {
            System.out.print(testList.get(i) + " ");
        }
    }
}

