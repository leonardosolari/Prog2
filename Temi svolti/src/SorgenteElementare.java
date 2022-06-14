import java.util.Objects;
import java.util.zip.Checksum;

public class SorgenteElementare implements Sorgente {

    // OVERVIEW classe concreta che implementa una Sorgente elementare, si assume
    // che non ci
    // siano modifiche di sorta nella trasmissione
    // istanze di questa classe sono immutabili

    // AF(sorgenteElementare) = sorgenteElementare |
    // canale, vedi AF(canaleElementare)
    // parametri, vedi AF(parametri)

    // RI canale diverso da null e parametri diverso da null

    private final Canale canale;
    private final Parametri parametri;

    public SorgenteElementare(Canale canale, Parametri parametri) {
        Objects.requireNonNull(canale);
        Objects.requireNonNull(parametri);

        this.canale = canale;
        this.parametri = parametri;
    }

    @Override
    public void trasmetti(String messaggio) {
        Objects.requireNonNull(messaggio);

        byte[] bytes = messaggio.getBytes(parametri.charset());
        Checksum algoritmo = parametri.algoritmo();
        algoritmo.reset();
        algoritmo.update(bytes);
        long checksum = algoritmo.getValue();
        int dimensionePacchetto = parametri.dimensione();

        int numeroPacchetti = bytes.length / dimensionePacchetto;
        int indiceByte = 0;
        int sequenza = 0;
        for (int i = 0; i < numeroPacchetti; i++) {
            byte[] contenuto = new byte[dimensionePacchetto];
            for (int j = 0; j < dimensionePacchetto; j++) {
                contenuto[j] = bytes[indiceByte];
                indiceByte++;
            }
            Pacchetto pacchetto = new Pacchetto(sequenza, contenuto, checksum);
            canale.inoltra(pacchetto);
            sequenza++;
        }

        byte[] contenuto = new byte[dimensionePacchetto];
        int i = 0;
        for (; indiceByte < bytes.length; indiceByte++) {
            contenuto[i] = bytes[indiceByte];
            i++;
        }
        Pacchetto pacchetto = new Pacchetto(sequenza, contenuto, checksum);
        canale.inoltra(pacchetto);
        canale.inoltra(null);
    }

}
