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

        if (splittedString.length > 3 && splittedString.length < 3) {
            System.out.println("Error length");
        }
        stepRead = StepRead.First;
        for (String partString : splittedString) {
            try {
                ProcessString(partString);
            } catch (Exception e) {
                if(isError){
                    throw new Exception();
                }
            }
        }
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
                if (isError == true){
                    System.out.println("Error operator");
                    throw new Exception();
                }
                    break;

            case Second:

                break;
        }
    }

    private void AnalyzeNumber(String partString) {
        Number resultEnum ;
        try
        {
            resultEnum = Number.valueOf(partString);
        } catch (NumberFormatException e)
        {

        }


        if (TryParseInt(partString) == true) {
            Integer.parseInt(partString);  // We now know that it safe to parse
        } else {
            isError = true;
        }


    }


    private void AnalyzeOperator(String subString) {
        if (operatorList.contains(subString) == false) {
            System.out.println(operatorList.contains(subString) == false);
            isError = true;
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
