import java.io.IOException;
import java.util.*;

public class ParserString {

    private boolean isError = false;
    private boolean isArabInt = false;
    private boolean isRomanInt = false;
    private List<String> operatorList = Arrays.asList("/", "*", "+", "-");
    private String operator;
    private int A;
    private int B;
    private Result _resultParseString;

    private StepRead stepRead;

    public void ReadString(String someString) throws Exception {
        String[] splittedString = someString.split(" ");

        if (splittedString.length != 3) {
            throw new Exception("Lenght error.");
        }


        boolean resultIsError = WhatIsSetNumber(splittedString[0], splittedString[2]);
        if (resultIsError == true) {
            throw new Exception("Error roman and arabian number.");
        }
        stepRead = StepRead.First;
        for (String partString : splittedString) {
            ProcessString(partString);
            if (isError) {
                throw new Exception("Error.");
            }
        }

        _resultParseString = new Result();

    }


    private boolean WhatIsSetNumber(String first, String second) {

        boolean isPartError = false;
        if (Number.fromString(first) != null && Number.fromString(second) != null) {
            isRomanInt = true;
        } else if (TryParseInt(first) != false && TryParseInt(second) != false) {
            isArabInt = true;
        } else {
            isPartError = true;
        }
        return isPartError;
    }

    private void ProcessString(String splittedString) throws Exception {


        switch (stepRead) {
            case First:
                A = AnalyzeNumber(splittedString);

                stepRead = StepRead.Operator;
                break;

            case Operator:
                operator = AnalyzeOperator(splittedString);
              
                stepRead = StepRead.Second;
                break;

            case Second:
                B = AnalyzeNumber(splittedString);

                break;
        }
    }

    private int AnalyzeNumber(String partString) throws Exception {
        int fromReturn;
        if (Number.fromString(partString) != null) {
            fromReturn = Number.fromString(partString).TranslationInt();
        } else if (TryParseInt(partString) == true) {
            fromReturn = Integer.parseInt(partString);
            // We now know that it safe to parse
        } else {
            throw new Exception("Error parse string to int or roman");
        }
        return fromReturn;
    }


    private String AnalyzeOperator(String subString) throws Exception {
        String operatorToReturn;
        if (operatorList.contains(subString) == false) {
            throw new Exception("Error operator");
        } else {
            operatorToReturn = subString;
        }
        return operatorToReturn;
    }


    private boolean TryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
