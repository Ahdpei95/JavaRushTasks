package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

Возвращает
{"level22", "lesson13", "task01"}


Требования:
1. Метод getTokens должен использовать StringTokenizer.
2. Метод getTokens должен быть публичным.
3. Метод getTokens должен принимать два параметра типа String.
4. Массив типа String возвращенный методом getTokens должен быть заполнен правильно(согласно условию задачи).
*/
public class Solution {
    public static void main(String[] args) {

        String[] array = getTokens("level22.lesson13.task01", ".");
        //System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] strings = new String[stringTokenizer.countTokens()];
        for (int i = 0; stringTokenizer.hasMoreTokens(); i++) {
          strings[i] = stringTokenizer.nextToken();
        }
    return strings;
    }

}
