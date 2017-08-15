package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println(args[0] + " " + args[1]);
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
       // byte[] b = new byte[1000];
        ArrayList<Integer> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(fileName1);
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            list.add(data);
        }
        inputStream.close();
        FileWriter fstream1 = new FileWriter(fileName1);
        BufferedWriter out1 = new BufferedWriter(fstream1);
        out1.write("");
        out1.close();
        FileOutputStream outputStream = new FileOutputStream(fileName1);
        FileInputStream inputStream1 = new FileInputStream(fileName2);
        while (inputStream1.available() > 0) {
            int data = inputStream1.read();
            outputStream.write(data);
        }

        for (int i = 0; i < list.size(); i++) {
            outputStream.write(list.get(i));
        }
        inputStream1.close();
        outputStream.close();
       // reader.close();
        /*

        FileInputStream fileInputStream = new FileInputStream(fileName2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName1, "rw");

        randomAccessFile.seek(0);
        ArrayList<Integer> list = new ArrayList<Integer>((int) randomAccessFile.length());
        long leng = randomAccessFile.length();
        while (leng != 0) {
            list.add(randomAccessFile.read());
            leng--;
        }

        randomAccessFile.seek(0);
        while(fileInputStream.available() > 0){
            int count = fileInputStream.read(b);
            randomAccessFile.write(b, 0, count);
        }
        for (int i = 0; i < list.size(); i++) {
            randomAccessFile.write(list.get(i));
        }

        fileInputStream.close();
        randomAccessFile.close();
        reader.close();*/

        //RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\test1.txt", "rw");
        //System.out.println(randomAccessFile.length());
    }
}
