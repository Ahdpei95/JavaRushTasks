package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable{
    private static int hitCount;
    private String name;

    public AbstractRobot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4){
            attackedBodyPart = BodyPart.CHEST;
            //hitCount = 0;
        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defencedBodyPart = null;
        hitCount = hitCount;

        if (hitCount == 1) {
            defencedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            defencedBodyPart = BodyPart.HEAD;
            //hitCount -= 2;
        } else if (hitCount == 3) {
            defencedBodyPart = BodyPart.LEG;
            //hitCount -= 2;
        } else if (hitCount == 4) {
            defencedBodyPart = BodyPart.CHEST;
            hitCount = 0;
        }
        return defencedBodyPart;
    }

}
