public class Result {
    private int _aInt;
    private int _bInt;
    private String _operator;
    private boolean _isRoman;
    public int get_aInt() {
        return _aInt;
    }

    public int get_bInt() {
        return _bInt;
    }

    public String get_operator() {
        return _operator;
    }

    public boolean is_isRoman() {
        return _isRoman;
    }

    public Result(int aInt, int bInt, String operator, boolean isRoman){
        _aInt = aInt;
        _bInt = bInt;
        _operator = operator;
        _isRoman = isRoman;
    }

}
