// interfaccia che stabilisce il contratto di un Destinatario
public interface Destinatario {

    // EFFECTS restituisce i parametri
    Parametri parametri();

    // EFFECTS restituisce 
    //          * true se il pacchetto e' stato correttamente ricevuto
    //          * false altrimenti
    // metodo mutazionale
    boolean ricevi(Pacchetto pacchetto);
}