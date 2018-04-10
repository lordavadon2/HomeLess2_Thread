package com.brainacad.hw;

import com.brainacad.hw.FileWork.DirView;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        try {
            new DirView("Введите ваш путь").print();
        } catch (IOException e) {
            System.out.println("Cannot access " + e.getMessage());
        }
    }
}