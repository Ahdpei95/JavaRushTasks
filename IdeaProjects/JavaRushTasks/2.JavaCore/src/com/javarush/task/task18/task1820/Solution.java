package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 — 3
3.50 — 4
3.51 — 4
-3.49 — -3
-3.50 — -3
-3.51 — -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String name1  = reader.readLine ( );
        String name2  = reader.readLine ( );
        //  name1 = "c:/1.txt";
        // name2 = "c:/2.txt";
        FileInputStream f1 = new FileInputStream (name1);
        FileOutputStream f2 = new FileOutputStream (name2);
        double value;
        long vI;
        String tmp;
        StringBuilder sb = new StringBuilder ( );
        int j = 0;
        boolean fWrite = false;
        while ((j = f1.available ( )) > 0) //пока остались непрочитанные байты
        {
            char data = (char) f1.read ( ); //прочитать очередной байт
            fWrite = false;
            if (data == 32)
            {
                fWrite = true;
            }
            else
            {
                sb.append (data);
                if (j == 1)
                {
                    fWrite = true;
                }
            }
            if (fWrite)
            {
                value = Double.parseDouble (sb.toString ( ));
                vI = Math.round (value);
                tmp = Long.toString (vI);
                sb = new StringBuilder ( );
                f2.write (tmp.getBytes ( ), 0, tmp.length ( ));
                f2.write (32);
            }
        }
        f1.close ( );
        f2.close ( );
        reader.close ( );
    }
}

