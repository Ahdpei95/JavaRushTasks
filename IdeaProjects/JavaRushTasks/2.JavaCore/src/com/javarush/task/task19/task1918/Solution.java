package com.javarush.task.task19.task1918;
/*
Знакомство с тегами
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Solution {
    public static void main(String[] args) {
        String tag = args[0];
        try (
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String fileName = consoleReader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            StringBuilder fileEntityBuilder = new StringBuilder();
            String line;
            boolean isNotFirst = false;
            while ((line = fileReader.readLine()) != null) {
                if (isNotFirst) {
                    if (line.charAt(0) != '>')
                        fileEntityBuilder.append(' ');
                }
                fileEntityBuilder.append(line);
                isNotFirst = true;
            }
            fileReader.close();
            String htmlDocument = fileEntityBuilder.toString();
            List<Integer> listStart = new ArrayList<>();
            List<Pair> pairList = new ArrayList<>();
            String openTag = "(<)(" + tag + ")(([\\s][^>]*)?)(>)";
            String closeTag = "((<)(/)(" + tag + ")(>))";
            Pattern pattern = Pattern.compile(openTag + "|" + closeTag);
            Matcher matcher = pattern.matcher(htmlDocument);
            while (matcher.find()) {
               String teg = matcher.group();
               int start = matcher.start();
               int end = matcher.end();
               if (Pattern.matches(openTag, teg)) {
                   listStart.add(start);
               } else if (Pattern.matches(closeTag, teg) && !listStart.isEmpty()) {
                   pairList.add(new Pair(listStart.get(listStart.size() - 1), end));
                   listStart.remove(listStart.size() - 1);
               }
               if (listStart.isEmpty()) {
                   for (int j = pairList.size() - 1; j >= 0 ; j--) {
                       System.out.println(htmlDocument.substring(pairList.get(j).startInd, pairList.get(j).EndInd));
                   }
                   pairList.clear();
               }
            }
        } catch (Exception e) {
            System.out.println("Exception occured: " + e);
        }
    }

    public static class Pair {
        int startInd;
        int EndInd;

        public Pair(int startInd, int endInd) {
            this.startInd = startInd;
            EndInd = endInd;
        }
    }
}