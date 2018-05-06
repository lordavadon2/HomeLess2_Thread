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
        Progress.setProgress(0.2);
        try {
            Thread.sleep(500);
            parser.tryParse();
            Progress.setProgress(0.4);
            Thread.sleep(500);
            IDirView dirView = new DirView(parser.getParsePath());
            dirView.getListOfFile();
            Progress.setProgress(0.6);
            Thread.sleep(500);
//            dirView.print();
//            System.out.println();
            dirView.getListOfMaskFile(parser.getParseMask());
            Progress.setProgress(0.8);
            Thread.sleep(500);
//            dirView.print();
//            dirView.changerFiles();
            for (int i = 0; i < 2; i++) {
                Thread t = new Thread((Runnable) dirView);
                t.setName("Thread "+ i);
                t.start();
            }
            Progress.setProgress(1.0);
            Thread.sleep(500);
//            Map<String, String> map = dirView.getFileMap();
//            for(Map.Entry<String, String> item : map.entrySet()){
//                System.out.println("Ключ: \n" + item.getKey());
//                System.out.printf("Значение: \n" + item.getValue());
//            }
        }
        catch (ValidationExaption exc){
            System.out.println("Ошибка валидации: " + exc.getValidationErrorInfo());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nЗавершение потока на ввод/вывод файлов");
        }
    }
}
