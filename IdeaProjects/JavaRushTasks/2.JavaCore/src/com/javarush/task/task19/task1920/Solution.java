package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> treeMap = new TreeMap<>();
        ArrayList<Double> list = new ArrayList<>();
        while (reader.ready()) {
            String[] strings = reader.readLine().split(" ");
           // list.add(Double.valueOf(strings[1]));
            if (treeMap.containsKey(strings[0])) {
                double value = treeMap.get(strings[0]);
                treeMap.put(strings[0], value + Double.parseDouble(strings[1]));
            } else {
                treeMap.put(strings[0], Double.parseDouble(strings[1]));
            }
        }
        reader.close();
        list.addAll(treeMap.values());
        Collections.sort(list);
        double dbMax = list.get(list.size() - 1);
        for (Map.Entry entry: treeMap.entrySet()
             ) {
            if (((double) entry.getValue()) == dbMax) {
                System.out.println(entry.getKey());
            }
        }
    }
}
