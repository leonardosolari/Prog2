import java.util.Scanner;

/**
 * Soluzione
 */
public class Soluzione {
/**
 * Avrò bisogno delle funzioni:
 * isPalindrome(String s)
 * 
 */

    /**
     * 
     * Post-condizioni: restituisce una stringa che rappresenta n
     * 
    */
    public static String convertToString(long n) {
        return "" + n;
    }


    /**
     * Pre-requisiti: s non è un riferimento null
     * Effetti collaterali: 
     * Post-condizioni: restituisce true se s è palindroma, false altrimenti
     */
    public static boolean isPalindrome(String s) {
        if (s.equals(reverseString(s)))
            return true;
        else
            return false;
    }

    /**
     * Post-condizioni: restituisce una rappresentazione di s tramite un long
     */
    public static long convertToLong(String s) {
        return Long.parseLong(s);
    }
    
    /**
     * Pre-requisiti: s non è un riferimento null
     * Post-condizioni: restituisce la stringa reverse di s
     */
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s); 
        sb.reverse();
        return sb.toString();
    }

    /** 
     * Post-condizioni: restituisce il valore successivo nella sequenza di Lychrel
    */
    public static long lychrelStep(long n) {
        return n + convertToLong(reverseString(convertToString(n)));
    }

    /** 
     * Pre-requisiti: n non è un numero di Lychrel
     * Post-condizioni: stampa la sequenza di Lychrel di n
    */
    public static void lychrelSequence(long n) {
        while (!isPalindrome(convertToString(n))) {
            System.out.println(n);
            n = lychrelStep(n);
        }
        System.out.println(n);
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        s.close();
        lychrelSequence(n);
    }
}
