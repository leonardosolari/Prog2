import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DestinatarioAlterazioneOrdineInoltro implements Destinatario {
    
    // OVERVIEW classe concreta che implementa un Destinatario che riesce a gestire il caso
    //          in cui i messaggi arrivano in ordine casuale
    //          istanze di questa classe sono mutabili

    // AF(daoi) = daoi |
    //              parametri, vedere AF(parametri)
    //              ricevuti, lista di pacchetti vedere AF(pacchetto) 

    // RI parametri non deve essere null

    // NOTA: non controllo qui altri valori di parametri perche' sono controllati
    //      nel costruttore della classe Parametri

    private final Parametri parametri;
    private final List<Pacchetto> pacchetti;

    public DestinatarioAlterazioneOrdineInoltro(Parametri parametri) {
        Objects.requireNonNull(parametri);
        this.parametri = parametri;
        pacchetti = new ArrayList<>();
    }

    @Override
    public Parametri parametri() {
        return parametri;
    }

    @Override
    public boolean ricevi(Pacchetto pacchetto) {
        if (pacchetto == null) {
            int numeroPacchettiOttenuti = pacchetti.size();
            List<Pacchetto> pacchettiOrdinati = new ArrayList<>();
            for (int i = 0; i < numeroPacchettiOttenuti; i++) {
                boolean trovato = false;
                for (Pacchetto p : pacchetti) {
                    if (p.sequenza() == i) {
                        pacchettiOrdinati.add(p);
                        trovato = true;
                    }
                }
                if (!trovato) {
                    String msg = "Il pacchetto avente sequenza " + i + " non e' stato trovato!";
                    throw new IllegalArgumentException(msg);
                }
            }
           
            byte[] bytes;
            try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                for (final Pacchetto p : pacchettiOrdinati) baos.write(p.contenuto());
                bytes = baos.toByteArray();
            } catch (IOException cantHappen) {
                bytes = null;
            }

            String messaggio = new String(bytes, parametri.charset());
            System.out.println(messaggio);
        } else {
            pacchetti.add(pacchetto);
        }
        return true;
    }

    
}
