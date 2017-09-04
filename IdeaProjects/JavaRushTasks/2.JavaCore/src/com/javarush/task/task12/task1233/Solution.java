package com.javarush.task.task12.task1233;

/* 
Изоморфы наступают
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        int minIndex = 0;
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        } else {
            int min = array[0];

            for (int i = 0; i < array.length; i++) {
                int temp = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] > temp) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
                if (min > array[0]) {
                    minIndex = i;
                    min = array[0];
                }
               /* for (int k = 0; k < array.length; k++) {
                    System.out.print(array[k] + " ");
                }*/
            }
            //System.out.println(min + " " + minIndex);

        }
        //System.out.println();

        //напишите тут ваш код

        return new Pair<Integer, Integer>(array[0], minIndex);
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
