import java.util.Scanner;

/**
 * Soluzione
 */
public class Soluzione {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        int counter = 1;

        for(;;) {
           
            System.out.print(n + " ");
            if (n==1)
                break;
            else if (n%2 == 0)
                n = n/2;
            else 
                n = (n*3) + 1;
            counter += 1;    
        }


        System.out.println(counter);
    }
}