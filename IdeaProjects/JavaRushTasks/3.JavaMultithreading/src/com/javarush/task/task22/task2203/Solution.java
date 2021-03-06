package com.javarush.task.task22.task2203;

/* 
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Требования:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        /*if (string == null) {
            throw new TooShortStringException();
        } if (!string.contains("\t"))
            throw new TooShortStringException();
        String[] strings = string.split("\t");
        if (string.indexOf("\t") == string.lastIndexOf("\t")) {
            throw new TooShortStringException();
        }*/
        //return strings[1];
        if (string == null) throw new TooShortStringException();
        String result;
        try {
            int index = string.indexOf("\t") + 1;
            result = string.substring(index, string.indexOf("\t", index));
        }catch (StringIndexOutOfBoundsException e) {
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("vddfsdf\tsd\t"));
    }
}
