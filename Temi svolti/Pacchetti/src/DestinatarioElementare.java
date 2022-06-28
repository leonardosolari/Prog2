import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DestinatarioElementare implements Destinatario {

    // OVERVIEW classe concreta che implementa un Destinatario elementare, si assume che non ci 
    //          siano modifiche di sorta nella trasmissione
    //          istanze di questa classe sono mutabili

    // AF(destinatarioElementare) = destinatarioElementare |
    //                                  parameti, vedere AF(parametri)
    //                                  ricevuti, lista di pacchetti vedere AF(pacchetto) 

    // RI parametri non deve essere null

    // NOTA: non controllo qui altri valori di parametri perche' sono controllati
    //      nel costruttore della classe Parametri

    private final Parametri parametri;
    private final List<Pacchetto> pacchetti;

    public DestinatarioElementare(Parametri parametri) {
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
            byte[] bytes;
            try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                for (final Pacchetto p : pacchetti) baos.write(p.contenuto());
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
