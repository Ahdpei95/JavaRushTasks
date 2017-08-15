package com.javarush.task.task18.task1808;

/* 
Разделение файла

Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String name1 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String name2 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String name3 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream inputStream = new FileInputStream(name1);
        FileOutputStream outputStream = new FileOutputStream(name2);
        FileOutputStream outputStream1 = new FileOutputStream(name3);
        int y = 0;
        if (inputStream.available() % 2 == 0) {
            y = 0;
        } else {
            y = 1;
        }
        int first = inputStream.available() / 2 + y;
        while (inputStream.available() > first - y) {
            System.out.println(inputStream.available());
            int data = inputStream.read();
            outputStream.write(data);
        }
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (!(inputStream.available() > first - y)) {
                outputStream1.write(data);
            }
        }
        inputStream.close();
        outputStream.close();
        outputStream1.close();
    }
}
