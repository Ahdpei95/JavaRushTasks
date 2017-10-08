package com.javarush.task.task22.task2202;
import java.util.Arrays;
/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();
        String[] words1 = string.split(" ");
        if (words1.length < 5)
            throw new TooShortStringException();
        String[] words2 = Arrays.copyOfRange(words1, 1, 5);
        return "".join(" ", words2);
    }
    public static class TooShortStringException extends RuntimeException {
    }
}