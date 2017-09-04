package com.javarush.task.task14.task1408;

/**
 * Created by ahdpe on 26.04.2017.
 */

/*Методы должны возвращать строку вида:
<getDescription() родительского класса> + <» Моя страна — Sssss. Я несу N яиц в месяц.»>
        где Sssss — название страны
        где N — количество яиц в месяц*/
public class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 5;
    }
    /*public String getDescription() {
        Solution.Hen hen = new BelarusianHen();
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }*/
    String getDescription(){return super.getDescription()+ " Моя страна - "+ Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";}
}
