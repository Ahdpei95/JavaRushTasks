package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом

В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.

Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC


Требования:
1. Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
2. После вызова uncaughtException нужно прервать нить, которая бросила исключение.
3. Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
4. Сообщения должны выводиться в формате "exception class : exception message".
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<String> trace = new ArrayList<String>();
        //trace.add(e.toString());
        while (true){
            if ( e.getCause() == null ) {
                trace.add(e.toString());
                break;
            }
            trace.add(e.toString());
            e = e.getCause();

        }
        for (int i = trace.size() - 1; i >= 0; i--) {
            System.out.println(trace.get(i));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
