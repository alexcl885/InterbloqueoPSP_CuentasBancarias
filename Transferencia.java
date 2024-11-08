public class Transferencia {
    public boolean realizarTransferencia1a2 (Cuenta c1, Cuenta c2, int cantidad){
        synchronized (c1) { // primero bloqueo c1 para retirar el dinero
            if (c1.sacarCantidad(cantidad)) { // y si el retiro devuelve true
                synchronized (c2) { // bloqueo c2 para ingresar el dinero
                    c2.ingresaCantidad(cantidad);
                    System.out.println("Cantidad ingresada en la cuenta 2! SALDO ACTUAL ->>"+ c2.getSaldo());
                }
                return true; // transferencia exitosa
            }
        }
        return false; // no se pudo realizar la transferencia
            
    }
    public boolean realizarTransferencia2a1 (Cuenta c1, Cuenta c2, int cantidad){
        synchronized (c2) { // primero bloqueo c2 para retirar el dinero
            if (c2.sacarCantidad(cantidad)) { // y si el retiro devuelve true
                synchronized (c1) { // Bboqueo c1 para ingresar el dinero
                    c1.ingresaCantidad(cantidad);
                    System.out.println("Cantidad ingresada en la cuenta 1! SALDO ACTUAL ->>" + c1.getSaldo());
                }
                return true; // transferencia exitosa
            }
        }
        return false; // no se pudo realizar la transferencia
            
    }
}
