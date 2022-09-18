public enum Number {
    I("One",1),
    II("Two",2),
    III ("Three",3),
    IV (" Four",4),
    V   ("Five",5),
    VI ("Six",6),
    VII ("Seven",7),
    IIX   ("Eight",8),
    IX  ("Nine",9),
    X ("Ten", 10);

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
}
