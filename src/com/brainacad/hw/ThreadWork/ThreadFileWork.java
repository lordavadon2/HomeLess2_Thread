package com.brainacad.hw.ThreadWork;

import com.brainacad.hw.FileWork.DirView;
import com.brainacad.hw.FileWork.IDirView;
import com.brainacad.hw.StringParser.IStringParser;
import com.brainacad.hw.StringParser.InputValidator;
import com.brainacad.hw.StringParser.StringParser;
import com.brainacad.hw.StringParser.ValidationExaption;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class ThreadFileWork implements Runnable {

    @Override
    public void run() {
        IStringParser parser = new StringParser(Thread.currentThread().getName(),
                            new InputValidator(Thread.currentThread().getName()));

        try {
            parser.tryParse();
            IDirView dirView = new DirView(parser.getParsePath());
            dirView.getListOfFile();
            dirView.getListOfMaskFile(parser.getParseMask());
            Progress progressBar = new Progress();
            ThreadChanger t1 = new ThreadChanger("Thread 1", dirView, progressBar);
            ThreadChanger t2 = new ThreadChanger("Thread 2", dirView, progressBar);
            t1.start();
            t2.start();
            while (t1.isAlive() || t2.isAlive());
        }
        catch (ValidationExaption exc){
            System.out.println("Ошибка валидации: " + exc.getValidationErrorInfo());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nЗавершение потока на ввод/вывод файлов");
        }
    }
}
