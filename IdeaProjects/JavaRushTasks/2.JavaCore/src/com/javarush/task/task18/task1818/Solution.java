package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName_1 = reader.readLine();
        String fileName_2 = reader.readLine();
        String fileName_3 = reader.readLine();

        FileOutputStream outputStream = new FileOutputStream(fileName_1);
        FileInputStream inputStream = new FileInputStream(fileName_2);
        FileInputStream inputStream1 = new FileInputStream(fileName_3);

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            outputStream.write(data);
        }

        inputStream.close();

        while (inputStream1.available() > 0) {
            int data = inputStream1.read();
            outputStream.write(data);
        }
        inputStream1.close();
        outputStream.close();
    }
}
