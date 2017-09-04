package com.javarush.task.task14.task1408;

/**
 * Created by ahdpe on 26.04.2017.
 */
public class MoldovanHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 4;
    }
    String getDescription(){return super.getDescription()+ " Моя страна - "+ Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";}
}
