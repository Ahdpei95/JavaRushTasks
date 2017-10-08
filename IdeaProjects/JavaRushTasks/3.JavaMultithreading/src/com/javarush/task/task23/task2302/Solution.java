package com.javarush.task.task23.task2302;

/* 
Запрети переопределение
*/
public class Solution {

    public static class Listener {
        public final void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][6];
        System.out.println(matrix.length + " " + matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("1");
            }
            System.out.println();
        }
    }
}
