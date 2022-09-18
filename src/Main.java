import javax.swing.*;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    private static int minInt = 1;
    private static int maxInt = 10;
    private static ParserString parserString;

    public static void main(String[] args) {
        parserString = new ParserString();

        String inputString = GetInputString();

       // parserString.ReadString(inputString);
    var result = Number.valueOf(inputString);


    out.println(result);
    }

    private static String GetInputString() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        return str;
    }

}