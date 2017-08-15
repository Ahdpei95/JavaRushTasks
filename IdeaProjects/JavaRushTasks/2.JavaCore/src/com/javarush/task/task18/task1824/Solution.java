package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();


Требования:
1. Программа должна считывать имена файлов с консоли.
2. Для каждого файла нужно создавать поток для чтения.
3. Если файл не существует, программа должна перехватывать исключение FileNotFoundException.
4. После перехвата исключения, программа должна вывести имя файла в консоль и завершить работу.
5. Потоки для чтения из файла должны быть закрыты.
6. Команду "System.exit();" использовать нельзя.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<FileInputStream> inputStreamsList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            while (true) {
                fileName = reader.readLine();
                FileInputStream inputStream = new FileInputStream(fileName);
                inputStreamsList.add(inputStream);
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
            for (int i = 0; i < inputStreamsList.size(); i++) {
                inputStreamsList.get(i).close();
               // System.out.println("Поток " + i + " закрыт");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
