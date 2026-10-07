package modulo2;

public class NotificadorSms implements Notificador {
    public void notificar(String message, String destinatary){
        System.out.println("Sms for " + destinatary + ": " + message);
    }
}
