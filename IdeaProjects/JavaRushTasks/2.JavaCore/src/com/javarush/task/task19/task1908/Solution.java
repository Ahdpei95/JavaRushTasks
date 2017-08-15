package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();
        BufferedReader firstFileReader = new BufferedReader(new FileReader(firstName));
        BufferedWriter secondFileWriter = new BufferedWriter(new FileWriter(secondName));
        String string = "";
        while (firstFileReader.ready()) {
            string = firstFileReader.readLine();
        }
        Pattern pattern = Pattern.compile("\\b[0-9]+\\b");
        Matcher matcher = pattern.matcher(string);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(string.substring(matcher.start(), matcher.end()));
            stringBuilder.append(" ");
        }
        //secondFileWriter.newLine();
        secondFileWriter.write(stringBuilder.toString());
        reader.close();
        firstFileReader.close();
        secondFileWriter.close();
        System.out.println(stringBuilder.toString());
    }
}
