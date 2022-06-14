//OVERVIEW: le istanze di questa classe rappresentano code di interi (limitate)
//          gli oggetti di questo tipo sono mutabili
//          Una coda tipica è [x1, x2, .... , xk], k minore o uguale alla dimensione fissata
//          Dato che è una struttura dati FIFO a seguito di un'enqueue di y si otterrà [x1, x2, ..., xk, y]
//          A seguito di una dequeue si otterrà [x2, ..., xk]
public class IntQueue {
    //ATTRIBUTI:
    
    //struttura dati che contiene gli elementi della IntQueue this
    final private int[] elements;
    /**Gli indici della testa e della coda della IntQueue this
     * Head: primo elemento di this (-1 se al coda è vuota)
     * Tail: indice della prima posizione disponibile (tail == null se la coda è piena)
     */
    private int head;
    private int tail;

    /**
     * Funzione di astrazione: AF(elements, head, tail) = 
     *                         = [elements[i] | head <= i < tail] 
     *                         = [] se head == -1 e tail == 0 
     *                         = [...] se la coda è piena
     *                         = [elements[head], elements[head+1],...elements[size-1], elements[0],...elements[tail-1]] se tail < head
     *                         = [elements[head], elements[head+1],...elements[tail-1] se head < tail
     * 
     * Invariante di rappresentazione: la cosa non contiene più elementi della sua capienza massima
     *                                 elements non deve essere null
     *                                -1 <= head < elements.size -1 
     *                                 0 <= tail < elements.size -1
     *                                 head == -1 ==> tail == 0
     *                       
     */

    //COSTRUTTORI:

    /**
     * Pre-condizioni: n >= 0
     * Effetti collaterali:
     * Post-condizioni: Inizializza this affinchè rappresenti una coda vuota di dimensione massima n
    */
    public IntQueue(int n) {
        elements = new int[n];
        head = -1;
        tail = 0;
        assert repOK();
    }

    //METODI

    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: restituisce il numero di elementi presenti nella coda
    */
    public int size() {
        assert repOK(); 
        if (isEmpty()) return 0;
        if (isFull()) return elements.length;
        return (tail -head + elements.length) % elements.length;

    }
    
    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: restituisce true se la coda è piena, false altrimenti
    */
    public boolean isFull() {
        assert repOK();
        return head == tail;
    }

    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: restituisce true se la coda è vouta, false altrimenti
    */
    public boolean isEmpty() {
        assert repOK();
        return head == -1;
    }
    
    /**
     * Pre-condizioni: 
     * Effetti collaterali: potrebbe modificare this
     * Post-condizioni: se la coda è piena solleva un'eccezione di tipo FullException, mentre
     *                  se la coda non è piena aggiunge n alla coda
     *                  this = [x1, x2,..., xk], this_post = [x1, x2, ...., xn, n]
    */
    public void enqueue(int n) {
        if (isFull()) throw new FullException("Impossibile aggiungere elemento. Coda piena.");
        if (isEmpty()) head = 0;
        elements[tail] = n;
        tail = (tail + 1) % elements.length; //incrementa tail e si assicura che non vada oltre alla dimensione dell'array
        assert repOK();
    }

    /**
     * Pre-condizioni: 
     * Effetti collaterali: potrebbe modificare this
     * Post-condizioni: se la coda non è vuota, restituisce l'elemento in testa e lo elimina da this
     *                  se la coda è vuota solleva EmptyException
     *                  this = [x1, x2,..., xk], this_post = [x2, ...., xn]
    */
    public int dequeue() {
        if (isEmpty()) throw new EmptyException("Impossibile estrarre elemento. Coda vuota.");
        int r = elements[head];
        head = (head+1) % elements.length;
        if (head == tail) {
            head = -1;
            tail = 0;
        }
        assert repOK();
        return r;
    }

    @Override
    public String toString() {
        assert repOK();
        String r = "IntQueue : [";
        if (!isEmpty()) {
            for (int i = 0; i < size() -1; i++) {
                r += elements[(head + i) % elements.length] + ", ";
            }
        }
        return r + "]";
    }
    
    /**
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni:implementa l'invariante di rappresentazione
    */
    private boolean repOK() {
        return size() < elements.length
            && elements != null
            && -1 <= head
            && head < elements.length
            && tail >= 0
            && tail < elements.length
            && (head != -1 || tail == 0);
    }


}
