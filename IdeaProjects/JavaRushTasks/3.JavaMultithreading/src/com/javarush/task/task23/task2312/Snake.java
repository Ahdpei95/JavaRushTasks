package com.javarush.task.task23.task2312;


import java.util.ArrayList;
import java.util.List;

public class Snake {
    private ArrayList<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;


    public Snake(int x, int y) {
        this.sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        this.isAlive = true;
    }

    public void move() {
        if (isAlive) {
            switch (direction) {
                case UP: move(0, -1);
                case DOWN: move(0, 1);
                case LEFT: move(-1, 0);
                case RIGHT: move(1, 0);
            }
        }
    }

    public void checkBorders(SnakeSection head) {
        if(head.getX() >= Room.game.getWidth() || head.getX() < 0
                || head.getY() >= Room.game.getHeight()|| head.getY() < 0)
            isAlive = false;
    }
    public void checkBody(SnakeSection head) {
        if(sections.contains(head))
            isAlive = false;
    }

    public void move (int a, int b) {
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + a, head.getY() + b);


        checkBorders(head);
        if (!isAlive) return;

        checkBody(head);
        if (!isAlive) return;
    }
    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }


    public ArrayList<SnakeSection> getSections() {
        return this.sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
}
