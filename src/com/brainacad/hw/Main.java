package com.brainacad.hw;

import com.brainacad.hw.FileWork.DirView;
import com.brainacad.hw.FileWork.IDirView;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        String path = "D:\\250_2"; //Введите ваш путь
        String mask = ".zip";
        try {
            IDirView dirView = new DirView(path);
            dirView.getListOfFile();
            dirView.print();
            System.out.println();
            dirView.getListOfMaskFile(mask);
            dirView.print();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}