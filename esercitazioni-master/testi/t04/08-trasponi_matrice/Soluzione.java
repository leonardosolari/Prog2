import java.util.Scanner;

/**
 * Soluzione
 */
public class Soluzione {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = Integer.parseInt(args[0]); //converte in intero la stringa in args[0]
        int M = Integer.parseInt(args[1]);
        int[][] A = new int[N][M]; //creo la matrice

        //riempio la matrice
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                A[r][c] = s.nextInt();
            }
        }

        int[][] T = new int[M][N]; //creo la matrice per la trasposizione

        //faccio la trasposizione
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                T[r][c] = A[c][r];
            }
        }

        //stampo la matrice
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(T[r][c] + " ");
            }
            System.out.println();
        }


        s.close();
    }
}