import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    private static int minInt = 1;
    private static int maxInt = 10;
    private static ParserString parserString;

    public static void main(String[] args) throws Exception {
        parserString = new ParserString();
        String inputString = GetInputString();

        var res = Number.fromString(inputString);
        //out.println(res);


        Result resultParseString = null;
        try {
            resultParseString = parserString.ReadString(inputString);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        int calcS = 0;

        if (resultParseString != null) {
            calcS = Calculate(resultParseString);
        }

        if (resultParseString.is_isRoman() == true) {
            var resNumner = Number.getAnIntString(calcS);
            if (resNumner != null) {
                out.println(resNumner);
            } else {
                int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
                String[] numerals = new String[]
                        {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


                StringBuilder result = new StringBuilder();


                for (int i = 0; i < 13; i++) {
                    while (calcS >= values[i]) {
                        calcS -= values[i];
                        result.append(numerals[i]);
                    }
                }

                out.println(result);
            }

        } else {
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
                if (resultParseString.is_isRoman() && resul < 0) {
                    throw new Exception("Roman cannot be negative: " + resul);
                }
                break;

            case "*":
                resul = resultParseString.get_aInt() * resultParseString.get_bInt();
                break;

            case "/":
                if (resultParseString.get_bInt() == 0) {
                    throw new Exception("Division by zero");
                }
                resul = resultParseString.get_aInt() / resultParseString.get_bInt();
                break;
        }

        return resul;
    }

}