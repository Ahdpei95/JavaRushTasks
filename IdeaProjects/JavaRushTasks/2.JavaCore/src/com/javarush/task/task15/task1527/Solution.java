package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) — для чисел (дробные числа разделяются точкой)
alert(String value) — для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Программа должна выводить данные на экран в соответствии с условием.
3. Программа должна вызывать метод alert с параметром double в случае,
 если значение параметра obj может быть корректно преобразовано в число типа double.
4. Программа должна вызывать метод alert с параметром String в случае,
 если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
       // reader.close();
        int beginString = url.indexOf("?");
        String s = url.substring(beginString);
        s = s.replaceAll("\\?", "&");
        ArrayList<String> list = new ArrayList<>();
        while (s.length() > 0) {
            int lastIndex = s.lastIndexOf("&");
            list.add((s.substring(lastIndex)).replaceAll("&", ""));
            s = s.replace(s.substring(lastIndex), "");
        }
        Collections.reverse(list);
        ArrayList<String> resultPlaceList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String x : list) {
            int index = x.indexOf("=");
            if (index > 0) {
                sb.append(x.substring(0, index));
                if ((x.substring(0, index)).equals("obj")) {
                    resultPlaceList.add(x.substring(index + 1, x.length()));
                }
            } else {
                sb.append(x);
            }
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
        for (String x : resultPlaceList) {
            if (x != null) {
                try {
                    alert(Double.parseDouble(x));
                } catch (NumberFormatException e) {
                    alert(x);
                }
            }

        }
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
