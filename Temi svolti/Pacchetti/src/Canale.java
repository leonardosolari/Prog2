// interfaccia che stabilisce il contratto di un Canale
public interface Canale {
    
    // EFFECTS restituisce i parametri
    Parametri parametri();

    // inoltra il pacchetto al destinatario
    // EFFECTS restituisce 
    //          * true se il pacchetto e' stato correttamente inoltrato
    //          * false altrimenti
    boolean inoltra(Pacchetto pacchetto);
}
