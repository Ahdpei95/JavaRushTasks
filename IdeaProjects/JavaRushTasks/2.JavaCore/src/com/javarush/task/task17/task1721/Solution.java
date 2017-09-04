package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность

Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла — в allLines, из второго — в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String allLinesName = reader.readLine();
        String forREmoveLinesName = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(allLinesName));
        BufferedReader reader2 = new BufferedReader(new FileReader(forREmoveLinesName));
        String line = reader1.readLine();
        while (line != null) {
            allLines.add(line);
            line = reader1.readLine();
        }
        line = reader2.readLine();
        while (line != null) {
            forRemoveLines.add(line);
            line = reader2.readLine();
        }
        Solution solution = new Solution();
        solution.joinData();
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            for (String str :
                    forRemoveLines) {
                allLines.remove(str);
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
