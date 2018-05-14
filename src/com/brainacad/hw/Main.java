package com.brainacad.hw;

import com.brainacad.hw.ThreadWork.Progress;
import com.brainacad.hw.ThreadWork.ThreadFileWork;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("Старт основного потока");
        System.out.println("Для поиска файла или директории введите данные в формате:");
        System.out.println("\"Путь_к_директории пробельный_символ маска_для_поиска_файла_или_директории\"");
        System.out.println("пример: \"С:\\some_path some_mask\", \"С:\\some_path .txt\"");
        String userInput = new Scanner(System.in).nextLine();
        Thread newStream = new Thread(new ThreadFileWork(),userInput);
        newStream.start();
        System.out.println("Старт потока на ввод/вывод файлов");
        while (newStream.isAlive());
        System.out.println("Завершение основоного потока");
    }
}