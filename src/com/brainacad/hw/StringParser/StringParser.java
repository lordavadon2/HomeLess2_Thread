package com.brainacad.hw.StringParser;

public class StringParser implements IStringParser {
    private String parsePath;
    private String parseMask;
    private String userInput;
    private IInputValidator validator;
    private static String separator = " ";

    public StringParser(String userInput, IInputValidator validator) {
//        tryParse(input);
        this.validator = validator;
        this.userInput = userInput;
        this.parsePath = "";
        this.parseMask = "";
    }

    @Override
    public boolean tryParse() throws ValidationExaption {
            validator.validate();
            String[] stringArray = userInput.split(separator);
            this.parsePath = new String(stringArray[0]);
            this.parseMask = new String(stringArray[1]);
            return true;
    }

    @Override
    public String getParsePath() {
        return parsePath;
    }

    @Override
    public String getParseMask() {
        return parseMask;
    }
}
