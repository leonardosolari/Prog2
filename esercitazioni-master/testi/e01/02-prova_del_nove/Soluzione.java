import java.util.Scanner;

/**
 * Soluzione
 */
public class Soluzione {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        for (int i = 1; i<n; i++) {
            for (int j = 1; j<n; j++) {
                for (int k = 1; k<n; k++) {
                    if ((i%9 * j%9) % 9 == k%9 && (i*j) != k)
                        System.out.println(i + " " + j + " " + k);
                }
            }
        }
    }
}