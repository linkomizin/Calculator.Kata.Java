public enum Number {
    I("1",1),
    II("2",2),
    III ("3",3),
    IV ("4",4),
    V   ("5",5),
    VI ("6",6),
    VII ("7",7),
    IIX   ("8",8),
    IX  ("9",9),
    X ("10", 10);

    private String stringRoman;
    private int anInt;
    private Number(String stringRimski, int anInt){
        this.stringRoman = stringRimski;
        this.anInt = anInt;
    }

    public String TranslationString()
    {
        return stringRoman;
    }
    public int TranslationInt()
    {
        return anInt;
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
