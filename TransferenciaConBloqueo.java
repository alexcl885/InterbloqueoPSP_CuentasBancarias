
public class TransferenciaConBloqueo {

    public static void main(String[] args) {
        //cuentas
        Cuenta c1 = new Cuenta("ES388388433883838388484", 20500);
        Cuenta c2 = new Cuenta("ES99090499388484889399", 50000);
        //aseguramos ver que el saldo esta bien
        System.out.println("SALDO 1 ->"+c1.getSaldo());
        System.out.println("SALDO 2 ->"+c2.getSaldo());

        Transferencia transferencia = new Transferencia();
        GestorTransferencias gestorTransferencias = new GestorTransferencias();
        //creacion de hilos
        Hilo h1 = new Hilo("Alejandro Copado", transferencia,gestorTransferencias ,c1, c2);
        Hilo h2 = new Hilo("Copado Alejandro", transferencia, gestorTransferencias,c2, c1);
        
        //iniciamos los hilos
        h1.start();
        h2.start();
        
        try {
            h1.join();
            h2.join();
        } catch (InterruptedException e) {
            e.getLocalizedMessage();
        }

    }
}
