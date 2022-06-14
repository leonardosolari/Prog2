import java.util.Scanner;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        IntQueue q = new IntQueue(n);
        for (int i = 1; i <= n; i++) {
            q.enqueue(i);
        }
        System.out.println(q.toString());
    }
}