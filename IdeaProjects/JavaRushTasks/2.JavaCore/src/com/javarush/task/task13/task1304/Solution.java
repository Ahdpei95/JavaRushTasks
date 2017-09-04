package com.javarush.task.task13.task1304;

/* 
Selectable и Updatable
Создай класс Screen и реализуй в нем интерфейсы Selectable и Updatable.
Не забудь реализовать методы!


*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable {
        void refresh();
    }

    public class Screen implements Selectable, Updatable {
        public void onSelect(){}
        public void refresh(){}

    }
    //напишите тут ваш класс
}
