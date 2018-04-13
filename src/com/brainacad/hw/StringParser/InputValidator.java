package com.brainacad.hw.StringParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator implements IInputValidator {

    private String data;

    public InputValidator(String data){
        this.data = data;
    }

    private void checkInputFormat() throws ValidationExaption {
        Pattern pattern = Pattern.compile("^[A-Za-z][:][\\\\][a-zA-Z0-9._\\\\]+[\\s][^\\s]+$");
        Matcher matcher = pattern.matcher(this.data);
        if (!matcher.matches()) {throw new ValidationExaption(
                "Заданная строка не соответствует формату...");}
    }

    @Override
    public boolean validate() throws ValidationExaption {
        checkInputFormat();
        return false;
    }
}
