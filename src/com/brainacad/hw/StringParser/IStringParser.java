package com.brainacad.hw.StringParser;

public interface IStringParser {
    boolean tryParse() throws ValidationExaption;
    public String getParsePath();
    public String getParseMask();
}
