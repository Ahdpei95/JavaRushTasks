package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) throws FirstException, SecondException, ThirdException, FourthException, FivethException, SixthException, SeventhException, EighthException {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() throws FirstException, SecondException, ThirdException, FourthException, FivethException, SixthException, SeventhException, EighthException {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

      /*  try {
            ArrayList list = new ArrayList(4);
            list.get(2);
        } catch (NullPointerException e) {
            exceptions.add(e);
        }*/

        try {
            float i = 1/0;
        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        /*try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
        } catch (IOException e) {
            exceptions.add(e);
        }*/


      /*  try {
            ArrayList list = new ArrayList(4);
            list.get(11);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }*/

        try {
            helloM("1");
        } catch (FirstException e) {
            exceptions.add(e);
        }

        try {
            helloM("2");
        } catch (SecondException e) {
            exceptions.add(e);
        }

        try {
            helloM("3");
        } catch (ThirdException e) {
            exceptions.add(e);
        }

        try {
            helloM("4");
        } catch (FourthException e) {
            exceptions.add(e);
        }

        try {
            helloM("5");
        } catch (FivethException e) {
            exceptions.add(e);
        }

        try {
            helloM("6");
        } catch (SixthException e) {
            exceptions.add(e);
        }

        try {
            helloM("7");
        } catch (SeventhException e) {
            exceptions.add(e);
        }

        try {
            helloM("8");
        } catch (EighthException e) {
            exceptions.add(e);
        }
    }
    public static String helloM(String name) throws FirstException, SecondException, ThirdException, FourthException, FivethException, SixthException, SeventhException, EighthException {
        if (name.equals("1"))
            throw new  FirstException("First Exception");
        if (name.equals("2"))
            throw new SecondException("Second Exception");
        else if (name.equals("3"))
            throw new ThirdException("Third Exception");
        else if (name.equals("4"))
            throw new FourthException("Fourth Exception");
        else if (name.equals("5"))
            throw new FivethException("Fiveth Exception");
        else if (name.equals("6"))
            throw  new SixthException("Six");
        else if (name.equals("7"))
            throw new SeventhException("seven");
        else if (name.equals("8"))
            throw new EighthException("8");
        else return "9";
    }

    //public static String helloM1 (String name)
}
class FirstException extends Exception {
    public FirstException(String string) {
        System.out.println(string);
    }
}


class SecondException extends Exception {
    public SecondException(String string) {
        System.out.println(string);
    }
}

class ThirdException extends Exception {
    public ThirdException(String string) {
        System.out.println(string);
    }
}

class FourthException extends Exception {
    public FourthException(String string) {
        System.out.println(string);
    }
}

class FivethException extends Exception {
    public FivethException(String string) {
        System.out.println(string);
    }
}

class SixthException extends Exception {
    public SixthException(String string) {
        System.out.println(string);
    }
}

class SeventhException extends Exception {
    public SeventhException(String string) {
        System.out.println(string);
    }
}

class EighthException extends Exception {
    public EighthException(String string) {
        System.out.println(string);
    }
}