import java.util.Arrays;
import java.util.Scanner;

/**
 * Ho bisogno:
 * procedura di ordinamento (c'è un metodo in libreria)
 * inversione ordine 
 * conversione (numero <=> collezione)
 * calcolo sequenza
 * un passo della sequenza
 */
public class Soluzione {

    /** 
     * Effetti collaterali: potrebbe modificare l'ordine degli elementi di a
     * Post-condizioni: inverte l'ordine degli elementi di a
     *                  NullPointerException se a è null
    */
    public static void reverse(byte[] a) {
        if (a==null) throw new NullPointerException();
        for (int i = 0; i < a.length/2; i++) {
            byte tmp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = tmp;
        }
    }

    
    /** 
     * Post-condizioni: restituisce un array contenente le cifre di n
     *                  IllegalArgumentException se n ha più di digits cifre
    */
    public static byte[] numToDigits(int n, int digits) {
        byte[] a = new byte[digits];
        for (int i = digits - 1; i >= 0; i--, n /= 10) {
            a[i] = (byte)(n%10);
        }
        
        if (n>0) {
            throw new IllegalArgumentException(
                "Il valore passato come argomento ha più di " + digits + " cifre");
        }
        
        return a;
    }

    /** 
     * Pre-condizioni:
     * Effetti collaterali:
     * Post-condizioni: converte il numero memorizzato (in cifre) in a in un intero
     *                  solleva un'eccezione di tipo NullPointerException se a è null
     *                  solleva un'eccezione di tipo IllegalArgumentException se qualunque elemento di a non è una cifra decimale
    */
    public static int digitsToNum(byte[] a) {
        if (a==null) throw new NullPointerException();
        int n = 0;
        for (byte b : a) {
            if (b<0 || b>9) throw new IllegalArgumentException(
                "Valori attesi per argomento compresi tra 0 e 9");
            n = n*10 + b;
        }
        return n;
    }
    
    /**  
     * Post-condizioni: esegue un passo della sequenza di kaprecar
     *                  IllegalArgumentException se n non è compreso tra 1 e 9999
    */
    public static int stepKaprekar(int n) {
        if (n < 1000 || n > 9999) throw new IllegalArgumentException(
            "Il numero passato come valore deve avere al più 4 cifre ed essere positivo");
        byte[] digits = numToDigits(n, 4);
        Arrays.sort(digits);
        n = -digitsToNum(digits);
        reverse(digits);
        return n + digitsToNum(digits);
    }

    
    /** 
     * Effetti collaterali: modifica System.out
     * Post-condizioni: Stampa la sequenza di Kaprekar
     *                  IllegalArgumentException se n non è compreso tra 1 e 9999
    */
    public static void printKaprekar(int n) {
        if (n < 1000 || n > 9999) throw new IllegalArgumentException(
            "Il numero passato come valore deve avere al più 4 cifre ed essere positivo");
        while (n != 6174) {
            n = stepKaprekar(n);
            if (n == 0) throw new IllegalAccessException(
                "Almeno due cifre del numero in input devono essere diverse");
            System.out.println(n);
        }
    }
    
    
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(n); // serve per far funzionare la verifica ma è brutto
        printKaprekar(n);
        s.close();
    }
}