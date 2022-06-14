//OVERVIEW: eccezione sollevata nel caso di un esponente negativo.

public class NegativeExponentException extends RuntimeException {
    public NegativeExponentException() {super();}
    public NegativeExponentException(String m) {super(m);}
}