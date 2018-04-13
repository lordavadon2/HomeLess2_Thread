package com.brainacad.hw;

import com.brainacad.hw.FileWork.DirView;
import com.brainacad.hw.FileWork.IDirView;
import com.brainacad.hw.StringParser.IStringParser;
import com.brainacad.hw.StringParser.InputValidator;
import com.brainacad.hw.StringParser.StringParser;
import com.brainacad.hw.StringParser.ValidationExaption;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Для поиска файла или директории введите данные в формате:");
        System.out.println("\"Путь_к_директории пробельный_символ маска_для_поиска_файла_или_директории\"");
        System.out.println("пример: \"С:\\some_path some_mask\", \"С:\\some_path .txt\"");
        String userInput = new Scanner(System.in).nextLine();
        IStringParser parser = new StringParser(userInput, new InputValidator(userInput));
        try{
            parser.tryParse();
            IDirView dirView = new DirView(parser.getParsePath());
            dirView.getListOfFile();
            dirView.print();
            System.out.println();
            dirView.getListOfMaskFile(parser.getParseMask());
            dirView.print();
        }
        catch (ValidationExaption exc){
            System.out.println("Ошибка валидации: " + exc.getValidationErrorInfo());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}