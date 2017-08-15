package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //String string = "";
        List<String> list = new ArrayList<>();
        while (reader.ready()) {
          list.add(reader.readLine());
        }
        for (String str :
                list) {
            String[] arr = str.split(" ");
            //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD MM YYYY");
            String dateStr = arr[arr.length - 2]+"/"+arr[arr.length - 3]+"/"+arr[arr.length - 1];
            Date date = new Date(dateStr);

            String[] arr1 = new String[arr.length - 3];
            System.arraycopy(arr, 0, arr1, 0, arr.length - 3);
            String str1 = "";
            for (int i = 0; i < arr1.length; i++) {
                str1 += arr1[i];
                str1 += " ";
            }
            str1 = str1.trim();
            PEOPLE.add(new Person(str1, date));
        }
        reader.close();
        for (int i = 0; i < PEOPLE.size(); i++) {
            System.out.println(PEOPLE.get(i).getBirthday() + " " + PEOPLE.get(i).getName());
        }
    }
}
