package com.javarush.task.task19.task1909;

/* 
Замена знаков
Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки «.» на знак «!«.
Результат вывести во второй файл.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();

        BufferedReader readerFile = new BufferedReader(new FileReader(firstName));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(secondName));
        StringBuilder stringBuilder = new StringBuilder();
        char ch;
        while (readerFile.ready()) {
            ch = (char) readerFile.read();
            if (ch == '.') {
                ch = '!';
            }
            stringBuilder.append(ch);
        }
        writerFile.write(stringBuilder.toString());
        writerFile.close();
        readerFile.close();
        reader.close();
    }
}
