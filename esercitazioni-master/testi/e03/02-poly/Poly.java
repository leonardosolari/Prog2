

/**
 * Poly
 */
//OVERVIEW: le istanze di questa classe rappresentano polinomi
//          Gli oggetti di questo tipo NON sono mutabili

public class Poly {
    private final int[] terms;
    private final int degree;
    
    //COSTRUTTORI:

    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: inizializza this affinchè rappresenti il polinomio 0
    */
    public Poly() {
        terms = new int[1];
        degree = 0;
    }

    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: inizializza this affinchè rappresenti il polinomio (cx^n)
    */
    public Poly(int c, int n) throws NegativeExponentException {
        if (n < 0) throw new NegativeExponentException();
        if (c == 0) degree = 0;
        else degree = n;
        terms = new int[n+1];
        terms[n] = c;
    }

    //METODI:

    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: Restituisce il valore massimo tra a.degree e b.degree
    */
    private int maxDegree(Poly a, Poly b) {
        return Math.max(a.degree, b.degree);
    }
    
    /**
     * Post-condizioni: restituisce il polinomio this + q
     *                  solleva NullPointerException se q è null
    */
    public Poly add(Poly q) {
        int maxDegree = maxDegree(this, q);

        Poly res = new Poly(0, maxDegree);
        for (int i = 0; i <= maxDegree - 1; i++) {
            res.terms[i] = this.terms[i] + q.terms[i];
        }
        return res;
    }

    /**
     * Post-condizioni: restituisce il polinomio this - q
     *                  solleva NullPointerException se q è null
    */
    public Poly sub(Poly q) {
        return this.add(q.minus());
    }

    /**
     * Post-condizioni: restituisce il polinomio this * q
     *                  solleva NullPointerException se q è null
    */
    public Poly mul(Poly q) {
        int degree = this.degree + q.degree;
        Poly res = new Poly(0, degree);
        for (int i = 0; i <= this.degree; i++) {
            for (int j = 0; j <= q.degree; j++) {
                res.terms[i+j] = this.terms[i] * q.terms[j];
            }
        }
        return res;
    }

    /**
     * Post-condizioni: restituisce il polinomio -this
    */
    public Poly minus() {
        Poly res = new Poly(0, this.degree);
        for (int i = 0; i <= this.degree; i++) {
            res.terms[i] = -this.terms[i];
        }
        return res;
    }

    /**
     * Post-condizioni: restituisce il grado del polinomio this
    */
    public int degree() {
        return this.degree;
    }

    /**
     * Post-condizioni: restituisce il termine corrispondente alla variabile di grado d
    */
    public int coeff(int d) {
        if (d > this.degree)
            return 0;      
        else 
            return this.terms[d];
    }

    /**
     * Post-condizioni: restituisce una rappresentazione testuale dell'istanza
    */
    @Override
    public String toString() {
        String res = "";
        for (Integer i = this.degree; i >= 0; i--) {
            Integer c = this.coeff(i);
            if (c == 0) {
                continue;
            }
            if (c > 0) {
                res += "+";
            }
            if (i != 0) {
                res += (c.toString() + "x^" + i.toString());
            } else {
                res += c.toString();
            }
            res += " ";

        }
        return res;
    }

    
}