import java.io.IOException;
import java.util.*;

public class ParserString {
    
    private boolean isError = false;
    private boolean isArabInt = false;
    private boolean isRomanInt = false;
    private List<String> operatorList = Arrays.asList("/", "*", "+", "-");


    private StepRead stepRead;

    public void ReadString(String someString) {
        String[] splittedString = someString.split(" ");

        if(splittedString.length >3){
            System.out.println("Error length");
        }
        stepRead = StepRead.First;
        switch (stepRead) {

            case First:

                break;

            case Operator:

                break;

            case Second:

                break;
        }

        for (String partString : splittedString) {
            AnalyzeString(partString);
        }

        if(isError == true){
            System.out.println("Error");
        }

    }

    private void AnalyzeString(String patrString) {


        if (operatorList.contains(patrString) == false) {
            System.out.println(operatorList.contains(patrString) == false);
            isError = true;
        }
        var resultEnum = Number.valueOf(patrString);
        if(  ) ){
            System.out.println(operatorList.contains(patrString) == false);
        }

    }



}
