package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }
    public void run() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            move();
            print();
        }
    }
    public void print(){
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Collections.sort(horses, new Comparator<Horse>() {
            @Override
            public int compare(Horse o1, Horse o2) {
                return Double.compare(o1.getDistance(), o2.getDistance());
            }
        });
        //System.out.println(horses.get(0).getDistance() + " " + horses.get(1).getDistance() + " " + horses.get(2).getDistance());
       // System.out.println(horses.get(2).getName());
        return horses.get(horses.size() - 1);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("FirstHorse", 3, 0));
        horses.add(new Horse("SecondHorse", 3, 0));
        horses.add(new Horse("ThirdHorse", 3, 0));
        Hippodrome.game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
