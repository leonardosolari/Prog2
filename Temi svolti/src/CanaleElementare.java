import java.util.Objects;

public class CanaleElementare implements Canale {

    // OVERVIEW classe concreta che implementa un Canale elementare, si assume che non ci 
    //          siano modifiche di sorta nella trasmissione
    //          istanze di questa classe sono mutabili

    // AF(canaleElementare) = canaleElementare |
    //                          destinatario, vedi AF(destinatarioElementare)
    //                          parametri, vedi AF(parametri)

    // RI destinatario diverso da null

    private final Destinatario destinatario;
    private final Parametri parametri;

    public CanaleElementare(Destinatario destinatario, Parametri parametri) {
        Objects.requireNonNull(destinatario);
        Objects.requireNonNull(parametri);
        this.destinatario = destinatario;
        this.parametri = parametri;
    }

    @Override
    public Parametri parametri() {
        return parametri;
    }

    @Override
    public boolean inoltra(Pacchetto pacchetto) {
        destinatario.ricevi(pacchetto);
        return true;
    }
    
}
