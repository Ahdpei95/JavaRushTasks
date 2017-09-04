package com.javarush.task.task16.task1630;

import java.io.*;
public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try
        {
            firstFileName=reader.readLine();
            secondFileName=reader.readLine();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public static interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String fileData="";

        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        public String getFileContent() {
            return fileData;
        }

        public void run() {
            String line;
            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()) != null) {
                    fileData = fileData + " " + line;
                }
                bufferedReader.close();
            } catch (IOException e) {}
        }
    }
}