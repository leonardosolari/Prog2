import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Rational> lista = new ArrayList<Rational>();
        int count = 0;
        while (s.hasNextInt()) {
            Rational rat = new Rational(s.nextInt(), s.nextInt());
            if (lista.contains(rat)) count += 1; 

            lista.add(rat);
        }
        s.close();
        Rational tmp = null;

        //somma
        for (Rational r : lista) {
            if (tmp == null) {
                tmp = r;
            } else {
                tmp = tmp.add(r);
            }
        }
        System.out.println(tmp.toString());

        //moltiplicazione
        tmp = null;
        for (Rational r : lista) {
            if (tmp == null) {
                tmp = r;
            } else {
                tmp = tmp.mul(r);
            }
        }
        System.out.println(tmp.toString());

        //divisione
        tmp = null;
        for (Rational r : lista) {
            if (tmp == null) {
                tmp = r;
            } else {
                tmp = tmp.div(r);
            }
        }
        System.out.println(tmp.toString());

        //equivalenti
        System.out.println(count);





    }
}
