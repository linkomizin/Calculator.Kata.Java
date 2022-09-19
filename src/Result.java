public class Result {
    private int _aInt;
    private int _bInt;
    private String _operator;

    public int get_aInt() {
        return _aInt;
    }

    public int get_bInt() {
        return _bInt;
    }

    public String get_operator() {
        return _operator;
    }

    public Result(int aInt, int bInt, String operator){
        _aInt = aInt;
        _bInt = bInt;
        _operator = operator;
    }

}
