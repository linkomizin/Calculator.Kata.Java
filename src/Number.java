public enum Number {
    I("I", 1, "1"),
    II("II", 2, "2"),
    III("III", 3, "3"),
    IV("IV", 4, "4"),
    V("V", 5, "5"),
    VI("VI", 6, "6"),
    VII("VII", 7, "7"),
    IIX("IIX", 8, "8"),
    IX("IX", 9, "9"),
    X("X", 10, "10"),
    XI("XI", 11, "11"),
    XII("XII", 12, "12"),
    XIII("XIII", 13, "13"),
    XIV("XIV", 14, "14"),
    XV("XV", 15, "15"),
    XVI("XVI", 16, "16"),
    XVII("XVII", 17, "17"),
    XVIII("XVIII", 18, "18"),
    XIX("XIX", 19, "19"),
    XX("XX", 20, "20");

    private String stringRoman;
    private int anInt;
    private String anIntString;

    private Number(String stringRoman, int anInt, String anIntString) {
        this.stringRoman = stringRoman;
        this.anInt = anInt;
        this.anIntString = anIntString;
    }

    public String TranslationString() {
        return stringRoman;
    }

    public int TranslationInt() {
        return anInt;
    }

    public static String getAnIntString(int someInt) {
        for (Number b : Number.values()) {
            if (b.anInt == someInt) {
                return b.stringRoman;
            }
        }
        return null;
    }

    public static Number fromString(String text) {
        for (Number b : Number.values()) {
            if (b.stringRoman.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
