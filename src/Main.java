import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    private static int minInt = 1;
    private static int maxInt = 10;
    private static ParserString parserString;

    public static void main(String[] args) throws Exception {
        parserString = new ParserString();

        String inputString = GetInputString();
        Result resultParseString = null;
        try {
             resultParseString = parserString.ReadString(inputString);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        int calcS = 0;

        if(resultParseString != null){
          calcS =  Calculate(resultParseString);
        }

        if (resultParseString.is_isRoman() == true){

            out.println(Number.fromString(String.valueOf(calcS)));
        }
        else {
            out.println(calcS);
        }


    }

    private static String GetInputString() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        return str;
    }

    private static int Calculate(Result resultParseString) throws Exception {
        int resul = 9999;
        switch (resultParseString.get_operator()) {
            case "+":
                resul = resultParseString.get_aInt() + resultParseString.get_bInt();
                break;

            case "-":
                resul = resultParseString.get_aInt() - resultParseString.get_bInt();
                if(resultParseString.is_isRoman() && resul < 0){
                    throw new Exception("Roman not -"+resul);
                }
                break;

            case "*":
                resul = resultParseString.get_aInt() * resultParseString.get_bInt();
                break;

            case "/":
                if(resultParseString.get_bInt() == 0){
                    throw new Exception("Division by zero");
                }
                resul = resultParseString.get_aInt() / resultParseString.get_bInt();
                break;
        }

        return resul;
    }

}