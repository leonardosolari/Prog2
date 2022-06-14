import java.util.Objects;

/**
 * OVERVIEW: le istanze di questa classe rappresentano numeri razionali.
 * Gli oggetti di questo tipo sono immutabili.
 * Un numero razionale tipico è n/d, dove n e d sono numeri interi e 
 *      d è diverso da 0.
 */
public class Rational {

    //ATTRIBUTI:
    private int numerator, denominator;

    /** 
     * ABS FUN: AF[numerator, denominator] = numerator/denominator
     * REP INV: denominator > 0
     * ABS INV: denominator != 0 
    */
    
    //COSTRUTTORI:

    /**
     * Post-condizioni: inizializza this affinchè rappresenti il razionale n/d
     *                  se d == 0 solleva AritmethicException 
     * Preservazione RI: se d == 0 è sollevata un'eccezione e quindi this non è istanziato
     *                   altrimenti è utilizzato il valore assoluto
     * Correttezza:
     * Preservazione AI:
    */
    public Rational(int num, int den) {
        if (den == 0) throw new ArithmeticException(
            "Illegal rational number. The denominator must be a non-zero integer. Given: " + den);
        numerator = num * den >= 0 ? Math.abs(num) : -Math.abs(num); //condizione ? se vera : se falsa
        denominator = Math.abs(den);
        reduce();

        assert repOK();
    } 

    //METODI:
    
    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: restituisce il massimo comune divisore tra a e b
     *                  solleva un'eccezione se a < 0 o b < 0
    */
    private int gcd(int a, int b) {
        if (a<0 || b<0) throw new IllegalArgumentException("A e B must be greater than 0.");
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
   
    /**
     * Pre-condizioni: denominator != 0
     * Effetti collaterali: potrebbe modificare this se non è ridotto ai minimi termini
     * Post-condizioni: modifica this affinchè rappresenti il numero razionale ridotto ai minimi termini.
     * Preservazione RI: this.denominator > 0 -> gcd(|numerator|, denominator) > 0
     *                   pertanto (denominator / gcd(|numerator|, denominator)) > 0
    */
    private void reduce() {
        int cd = gcd(Math.abs(numerator), denominator);
        numerator /= cd;
        denominator /= cd;
    }

    /**
     * Post-condizioni: restituisce il numero razionale this + o
     *                  se o è null solleva NullPointerException
    */
    public Rational add(Rational o) {
        Objects.requireNonNull(o);
        return new Rational(
            this.numerator * o.denominator + o.numerator * this.denominator, this.denominator * o.denominator);
    }

    /**
     * Post-condizioni: restituisce il numero razionale this * o
     *                  se o è null solleva NullPointerException
    */
    public Rational mul(Rational o) {
        Objects.requireNonNull(o);
        return new Rational(this.numerator * o.numerator, this.denominator * o.denominator);
    }

    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: restituisce il numero razionale -this
    */
    public Rational minus() {
        return new Rational(-numerator, denominator);
    }

    /**
     * Post-condizioni: restituisce il numero razionale this - o
    */
    public Rational sub(Rational o) {
        return add(o.minus());
    }

    /**
     * Post-condizioni: restituisce il numero razionale 1/this
     *                  solleva AritmethicException se this == 0
    */
    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }

    /**
     * Post-condizioni: restituisce il numero razionale this / o
     *                  solleva ArithmeticException se o = 0
    */
    public Rational div(Rational o) {
        return mul(o.reciprocal());
    }


    @Override
    public String toString() {
        if (denominator == 1) return "" + numerator;
        return numerator + "/" + denominator;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(numerator);
        result = 31 * result + Integer.hashCode(denominator);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rational)) return false;
        Rational other = (Rational) o;
        return numerator == other.numerator && denominator == other.denominator;
    }
    
    private boolean repOK() {
        return denominator > 0;
    }

}