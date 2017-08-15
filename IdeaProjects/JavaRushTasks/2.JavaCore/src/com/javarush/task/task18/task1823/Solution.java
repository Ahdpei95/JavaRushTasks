package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем, нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити до
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String string = reader.readLine();
            if (string.equals("exit")) {
                break;
            }
            new ReadThread(string).start();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(this.fileName);
                ArrayList<Integer> list = new ArrayList<>(inputStream.available());
                ArrayList<Integer> provenList = new ArrayList<>();
                while (inputStream.available() > 0) {
                    int data = inputStream.read();
                    list.add(data);
                }
                int maxBt = 0;
                int maxCount = 0;
                for (int i = 0; i < list.size(); i++) {
                    int count = 1;
                    int bt = list.get(i);
                    if (!provenList.contains(list.get(i))) {
                        for (int j = i + 1; j < list.size(); j++) {
                            if (list.get(j) == bt) {
                                count++;
                            }
                        }
                    }
                    if (maxCount < count) {
                        maxCount = count;
                        maxBt = bt;
                    }
                }
                resultMap.put(this.fileName, maxBt);
                inputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
