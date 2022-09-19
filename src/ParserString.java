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

    private StepRead stepRead;

    public void ReadString(String someString) throws Exception {
        String[] splittedString = someString.split(" ");

        if (splittedString.length != 3) {
            throw new Exception("Lenght error.");
        }


        boolean resultIsError = WhatIsSetNumber(splittedString[0], splittedString[2]);
        if(resultIsError == true)
        {
            throw new Exception("Error roman and arabian number.");
        }
        stepRead = StepRead.First;
        for (String partString : splittedString) {

            ProcessString(partString);

            if (isError) {
                throw new Exception("Error.");
            }
        }
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
                AnalyzeNumber(splittedString);

                if (isError == true) {
                    System.out.println("Error first number");
                    throw new Exception();
                }
                stepRead = StepRead.Operator;
                break;

            case Operator:
                AnalyzeOperator(splittedString);
                if (isError == true) {
                    System.out.println("Error operator");
                    throw new Exception();
                }
                stepRead = StepRead.Second;
                break;

            case Second:
                AnalyzeNumber(splittedString);

                if (isError == true) {
                    System.out.println("Error first number");
                    throw new Exception();
                }
                break;
        }
    }

    private void AnalyzeNumber(String partString) {

        if (Number.fromString(partString) != null) {

        } else if (TryParseInt(partString) == true) {
            Integer.parseInt(partString);  // We now know that it safe to parse
        } else {
            isError = true;
        }


    }


    private void AnalyzeOperator(String subString) {
        if (operatorList.contains(subString) == false) {
            isError = true;
        } else {
            operator = subString;
        }
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
