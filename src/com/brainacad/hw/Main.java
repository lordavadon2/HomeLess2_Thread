package com.brainacad.hw;

import com.brainacad.hw.FileWork.DirView;
import com.brainacad.hw.FileWork.IDirView;
import com.brainacad.hw.FileWork.IOFileOperation;
import com.brainacad.hw.StringParser.IStringParser;
import com.brainacad.hw.StringParser.InputValidator;
import com.brainacad.hw.StringParser.StringParser;
import com.brainacad.hw.StringParser.ValidationExaption;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("Старт Основного потока");
        Thread mainStream = new ThreadFileWork();
        mainStream.run();
        mainStream.join();
        System.out.println("Конец основоного потока");
    }
}