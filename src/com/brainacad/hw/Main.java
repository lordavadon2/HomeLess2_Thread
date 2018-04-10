package com.brainacad.hw;

import com.brainacad.hw.FileWork.DirView;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        String path = "qwerty"; //Введите ваш путь
        try {
            new DirView(path).print();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}