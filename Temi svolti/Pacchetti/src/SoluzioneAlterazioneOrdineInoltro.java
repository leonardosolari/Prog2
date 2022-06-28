import java.nio.charset.Charset;
import java.util.zip.Adler32;

public class SoluzioneAlterazioneOrdineInoltro {
    
    public static void main(String[] args) {
        final int dimensione = Integer.parseInt(args[0]);
        final Charset charset = Charset.forName(args[1]);
        final Parametri parametri = new Parametri(dimensione, charset, new Adler32());

        final Destinatario destinatario = new DestinatarioAlterazioneOrdineInoltro(parametri);
        final Canale canale = new CanaleAlterazioneOrdineInoltro(destinatario, parametri);
        final Sorgente sorgente = new SorgenteElementare(canale, parametri);
        sorgente.trasmetti(args[2]);
    }
}
