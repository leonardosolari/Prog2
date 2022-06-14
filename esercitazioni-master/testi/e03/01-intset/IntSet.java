import java.util.ArrayList;
import java.util.List;

/**
 * IntSet
 * OVERVIEW: le istanze di questa classe rappresentano insiemi (non limitati)
 *           di interi. Gli oggetti di questo tipo sono mutabili
 */
public class IntSet {
    
    //CAMPI
    /** Struttura dati contenente gli elementi dell'insieme */
    private List<Integer> elements;

    //COSTRUTTORI
    /** 
     * Pre-Condizioni:
     * Effetti collaterali: 
     * Post-condizioni: inizializza un nuovo insieme di interi vuoto
    */
    public IntSet() {
        elements = new ArrayList<>();
    }

    
    //METODI
    /**
     * Pre-condizioni:
     * Effetti collaterali: modifica this: this_post = this + {x}
     * Post-condizioni: Aggiunge x all'insieme this
    */
    public void insert(int x) {
        if(!this.contains(x)) elements.add(x);
    }
    
    
    /*
     * Pre-condizioni:
     * Effetti collaterali: modifica this: this_post = this {x}
     * Post-condizioni: rimuove x dall'insieme this
    */
    public void remove(int x) {
        //elements.remove(Integer.valueOf(x));
        int index = elements.indexOf(x);
        if (index != -1) {
            int lastIndex = elements.size() - 1;
            elements.set(index, elements.get(lastIndex));
            elements.remove(lastIndex);
        }
    }
    
    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: restituisce un intero scelto arbitrariamente tra gli 
     * elementi di this e solleva EmptyException se l'insieme è vuoto
    */
    public int choose() {
        if (size() == 0) throw new EmptyException("Impossibile estrarre elemento. Insieme vuoto.");
        return elements.get(elements.size()-1);
    }

    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: restituisce la cardinalità dell'insieme x
    */
    public int size() {
        return elements.size();
    }


    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: restituisce true se this contiene x, false altrimenti
    */
    public boolean contains(int x) {
        return elements.contains(x);
    }

    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: restituisce una rappresentazione testuale di this, ad esempio {1, 2. 3}
    */
    @Override //serve per dire al compilatore che sto facendo un override
              // e non un overloading.
              //ciò vuol dire che IntSet "eredita" toString da Object 
    public String toString() {
        String r = "Intset: {";
        if (size() > 0) {
            for (int i = 0; i < size(); i++) {
                r += i + ", ";
            } 
        }
        r += elements.get(elements.size() - 1);
        return r + "}";
    }

}