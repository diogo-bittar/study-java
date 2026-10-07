package modulo2;

public class NotificadorEmail implements Notificador {
    public void notificar(String message, String destinatary){
        System.out.println("E-mail for " + destinatary + ": " + message);
    }
}
