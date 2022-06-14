import java.util.Scanner;

/**

import javax.lang.model.util.ElementScanner6;
 * Soluzione
 */
public class Soluzione {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();

        s.close();

        for (int i = 1; i <= n; i++) {
            if ((i%3 == 0) && (i%7 == 0)) 
                System.out.println("Tico Taco");
            else if (i%3 == 0)
                System.out.println("Tico");
            else if (i%7 == 0)
                System.out.println("Taco");
            else 
                System.out.println(i);
        }
    }
}