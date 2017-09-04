package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(new FileInputStream(reader.readLine()));
        ArrayList<Integer> list = new ArrayList<>();
        while (scan.hasNextInt()) {
            int data = scan.nextInt();
            if (data % 2 == 0) {
                list.add(data);
            }
        }
        scan.close();
        reader.close();
        Collections.sort(list);
        for (int numb :
                list) {
            if (numb % 2 == 0)
                System.out.println(numb);
        }
    }
}
