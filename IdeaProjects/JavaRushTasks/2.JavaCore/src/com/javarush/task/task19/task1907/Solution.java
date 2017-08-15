package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileReader fileReader = new FileReader(name);

        String string = "";
        char ch;
        while (fileReader.ready())
        {
            ch = (char) fileReader.read();
            string += ch;
        }


        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher = pattern.matcher(string);

        int count = 0;
        while (matcher.find())
        {
            count++;
        }

        System.out.println(count);

        fileReader.close();
        reader.close();
    }
}
