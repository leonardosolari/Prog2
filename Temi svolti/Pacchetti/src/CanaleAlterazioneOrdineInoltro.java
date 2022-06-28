import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CanaleAlterazioneOrdineInoltro implements Canale {

    // OVERVIEW classe concreta che implementa un Canale che scombina l'ordine dei pacchetti
    //          simulando una congestione nella rete
    //          istanze di questa classe sono mutabili

    // AF(caoi) = caoi |
    //            destinatario, vedi AF(destinatarioAlterazioneOrdineInoltro)
    //            parametri, vedi AF(parametri)
    //            pacchetti ricevuti, vedi AF(pacchetto)

    // RI destinatario diverso da null

    private final Destinatario destinatario;
    private final Parametri parametri;
    private final List<Pacchetto> pacchettiRicevuti;

    public CanaleAlterazioneOrdineInoltro(Destinatario destinatario, Parametri parametri) {
        Objects.requireNonNull(destinatario);
        Objects.requireNonNull(parametri);
        this.destinatario = destinatario;
        this.parametri = parametri;
        pacchettiRicevuti = new ArrayList<>();
    }

    @Override
    public Parametri parametri() {
        return parametri;
    }

    @Override
    public boolean inoltra(Pacchetto pacchetto) {
        if (pacchetto == null) {
            Collections.shuffle(pacchettiRicevuti);
        } else {
            pacchettiRicevuti.add(pacchetto);
            // simula una congestione
            return false;
        }

        for (Pacchetto p : pacchettiRicevuti) {
            destinatario.ricevi(p);
        }
        destinatario.ricevi(null);
        // simula lo sblocco della congestione
        return true;
    }
    
}
