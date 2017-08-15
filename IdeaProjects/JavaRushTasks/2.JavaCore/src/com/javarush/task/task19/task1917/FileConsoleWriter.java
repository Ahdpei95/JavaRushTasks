package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.

При записи данных в файл, должен дублировать эти данные на консоль.


Требования:
1. Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter, которое не должно быть сразу проинициализировано.
2. Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
3. Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException, в котором данные
 для записи должны записываться в fileWriter и дублироваться в консоль.
4. Класс FileConsoleWriter должен содержать метод write(int c) throws IOException, в котором данные для записи должны записываться
 в fileWriter и дублироваться в консоль.
5. Класс FileConsoleWriter должен содержать метод write(String str) throws IOException, в котором данные для записи должны
 записываться в fileWriter и дублироваться в консоль.
6. Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException, в котором данные
 для записи должны записываться в fileWriter и дублироваться в консоль.
7. Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException, в котором данные для записи должны
 записываться в fileWriter и дублироваться в консоль.
8. Класс FileConsoleWriter должен содержать метод close() throws IOException, в котором должен вызываться такой же метод поля fileWriter.
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        //super(fileName);
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        //super(fileName, append);
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        //super(file);
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        //super(file, append);
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        //super(fd);
        this.fileWriter = new FileWriter(fd);
    }

    //@Override
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    //@Override
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    //@Override
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: cbuf)
            stringBuilder.append(c);
        System.out.println(stringBuilder);
    }

    //@Override
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off,off + len));
    }

    //@Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = off; i < len + off; i++) {
            stringBuilder.append(cbuf[i]);
        }
        System.out.println(stringBuilder.toString());
    }

    //@Override
    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
    //    FileConsoleWriter fileConsoleWriter = new FileConsoleWriter(new FileWriter("D:\\test.txt"));
    }

}
