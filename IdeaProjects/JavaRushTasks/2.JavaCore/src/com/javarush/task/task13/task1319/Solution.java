package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа должна читывать строки с консоли, пока пользователь не введет строку "exit".
4. Программа должна записать абсолютно все введенные строки (включая "exit") в файл, каждую строчку с новой строки.
5. Метод main должен закрывать объект типа BufferedWriter после использования.

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String path = read.readLine();
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));

        String line;
        while(!(line=read.readLine()).equals("exit")){
            wr.append(line);
            wr.append("\n");
        }
        wr.write("exit");
        wr.close();
    }
}
