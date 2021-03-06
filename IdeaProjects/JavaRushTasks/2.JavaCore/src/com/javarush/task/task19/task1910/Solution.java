package com.javarush.task.task19.task1910;

/* 
Пунктуация
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F

Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.

        Pattern pattern = Pattern.compile("\\b[0-9]+\\b");
        Matcher matcher = pattern.matcher(string);
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();

        BufferedReader readerFile = new BufferedReader(new FileReader(firstName));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(secondName));
        StringBuilder stringBuilder = new StringBuilder();
        while (readerFile.ready()) {
            stringBuilder.append(readerFile.readLine());
        }
        String result = stringBuilder.toString().replaceAll("\\p{Punct}", "");
        /*Pattern pattern = Pattern.compile("\\b");
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()) {
            stringBuilder.deleteCharAt(matcher.start());
            matcher.reset(stringBuilder);
        }*/
        System.out.println(result);
        writerFile.write(result);
        writerFile.close();
        readerFile.close();
        reader.close();
    }
}
