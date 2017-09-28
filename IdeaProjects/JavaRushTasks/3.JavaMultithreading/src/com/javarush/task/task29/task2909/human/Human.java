package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    private List<Human> children = new ArrayList<>();
    protected Size size;

    public Human(String name, int age) {
        this.age = age;
        this.name = name;
    }
    private BloodGroup bloodGroup;

    public class Size {

        public int height;
        public int weight;


    }


    public void setBloodGroup(BloodGroup code) {
        bloodGroup = code;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human) {
        this.children.add(human);
    }

    public void removeChild (Human human) {
        this.children.remove(human);
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    @Override
    public void live() {

    }
}