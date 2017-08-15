package com.javarush.task.task18.task1825;

/* 
Собираем файл

Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
Закрыть потоки.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        //String str = "Lion.avi.part1";
        /*TreeSet<String> treeSet = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filesName;
        while (true) {
            filesName = reader.readLine();
            if (filesName.equals("end")) {
                break;
            }
            treeSet.add(filesName);
        }
        reader.close();
        String s = "";
        String[] buffer = treeSet.last().replace(".", ",").split(",");
        for (String str :
             buffer) {
            if (!str.contains("part")) {
                s += str;
            }
        }
        File file = new File(s);
        if(file.createNewFile()){
            System.out.println(" Файл создан");
        } else {
            System.out.println("Файл уже существует");
            System.out.println(s);
        }
        //FileOutputStream outputStream = new FileOutputStream(s);
        FileOutputStream outputStream = new FileOutputStream(s);
        for (String strName :
                treeSet) {
            FileInputStream inputStream = new FileInputStream(strName);
            String string;
            byte[] bt = new byte[1000];
            while (inputStream.available() > 0) {
                int count = inputStream.read(bt);
                outputStream.write(bt, 0, count);
            }
            inputStream.close();
        }
        outputStream.close();*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        String fileName;

        while(!(fileName = bufferedReader.readLine()).equals("end"))
            list.add(fileName);

        bufferedReader.close();
        Collections.sort(list);

        String[] stringArray = list.get(0).split(".part");
        String summaryFileName = stringArray[0];

        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(summaryFileName, true);
        byte[] buffer;

        for (String aList : list)
        {
            fileInputStream = new FileInputStream(aList);
            buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileInputStream.close();
            fileOutputStream.write(buffer);
        }

        fileOutputStream.close();
    }
}
