import java.nio.charset.Charset;
import java.util.Objects;
import java.util.zip.Checksum;

public record Parametri(int dimensione, Charset charset, Checksum algoritmo) {
    
    // OVERVIEW le istanze di questo record rappresentano parametri immutabili che permettono
    //              la conversione stringa a sequenza di pacchetti e viceversa

    // AF(parametri) = parametri |
    //                  dimensione, intero che rappresenta la dimensione del pacchetto
    //                  charset, di tipo Charset rappresentante la codifica con cui vengono prodotti i byte
    //                  algoritmo, di tipo Checksum usato per calcolare il numero di controllo

    // RI dimensione maggiore di zero e
    //      charset diverso da null e
    //      algoritmo diverso da null

    // NOTA: instanze della classe Charset sono immutabili, quindi non devo preoccuparmi che la rep
    // possa essere modificata tramite metodi invocati su questa classe

    public Parametri(int dimensione, Charset charset, Checksum algoritmo) {
        if (dimensione <= 0) {
            throw new IllegalArgumentException("La dimensione deve essere maggiore di zero");
        }
        Objects.requireNonNull(charset);
        Objects.requireNonNull(algoritmo);

        this.dimensione = dimensione;
        this.charset = charset;
        this.algoritmo = algoritmo;
    }

}
