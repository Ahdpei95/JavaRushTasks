package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить «InterruptedException» при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить «Ура«;
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово «N«, а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()
 */

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    public static void main(String[] args) {
    }
    static {
        threads.add(new Nit_1());
        threads.add(new Nit_2());
        threads.add(new Nit_3());
        threads.add(new Nit_4());
        threads.add(new Nit_5());
    }
    public static class Nit_1 extends Thread {
        @Override
        public void run() {
            while(true);
        }
    }
    public static class Nit_2 extends Thread {
        @Override
        public void run() {
            try {
                sleep(5000000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Nit_3 extends Thread {
        @Override
        public void run() {
            while(true) {
                System.out.println("Ура");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    public static class Nit_4 extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
        }
        @Override
        public void run() {
            //showWarning();
            super.run();
        }
    }
    public static class Nit_5 extends Thread {

        int x;
        @Override
        public void run() {
            BufferedReader qwe = new BufferedReader(new InputStreamReader(System.in));
            try {
                String s = qwe.readLine();
                while (!s.equals("N")) {
                    x += Integer.parseInt(s);
                    s = qwe.readLine();
                }
                qwe.close();
                System.out.println(x);
            } catch (IOException e) {
            }
        }
    }
}