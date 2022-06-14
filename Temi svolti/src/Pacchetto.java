public record Pacchetto(int sequenza, byte[] contenuto, long checksum) {

    // OVERVIEW le istanze di questo record rappresentano pacchetti immutabili contenenti 
    // l'informazione trasmessa e metadati

    // AF(pacchetto) = pacchetto |
    //                  numero di sequenza, intero che rappresenta il post occupato nella sequenza
    //                  contenuto, array di byte rappresentante parte del messaggio codificato in byte
    //                  checksum, long che consente di verificare l'integrita' del messaggio

    // RI sequenza deve essere maggiore o uguale a zero e
    //      contenuto deve essere non null

    // NOTA: non ho aggiunto checksum nella RI perche' non sono sicuro se e' possibile ottenere 
    //          un valore negativo, nel caso in cui fosse possibile si deve tenere conto di questa
    //          modifica nella RI

    public Pacchetto(int sequenza, byte[] contenuto, long checksum) {
        if (sequenza < 0) {
            throw new IllegalArgumentException("La sequenza deve essere maggiore o uguale a 0");
        }
        if (contenuto == null) {
            throw new IllegalArgumentException("Il contenuto non puo' essere null");
        }

        this.sequenza = sequenza;
        this.contenuto = contenuto;
        this.checksum = checksum;
    }
    
}
