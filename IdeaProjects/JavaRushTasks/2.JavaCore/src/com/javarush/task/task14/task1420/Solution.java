package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
       /* try {*/
            a = Integer.parseInt(reader.readLine());
            if (a <= 0) throw new Exception();
            b = Integer.parseInt(reader.readLine());
            if (b <= 0) throw new Exception();
            //System.out.println(a + " " + b);
            int min = Integer.min(a, b);

            for (int i = min; i > 0; i--) {
                if (a % i == 0 && b % i == 0) {
                    System.out.println(i);
                    break;
                }
            }
       /* } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
