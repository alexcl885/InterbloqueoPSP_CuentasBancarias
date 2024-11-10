
/**
 * Clase que pone orden de transferencia 
 * desde la cuenta cuyo numero cuenta 
 * es por oden la menor
 * Si no se puede , no se efectuará la transferencia.
 */
public class GestorTransferencias {
    public boolean transferencia(Cuenta c1, Cuenta c2, int cantidad){
        Cuenta cuentaOrdenMenor, cuentaOrdenMayor;
        if (c1.getN_cuenta().compareTo(c2.getN_cuenta()) < 0){
            //por orden la cuenta1 esta antes que c2
            cuentaOrdenMenor = c1;
            cuentaOrdenMayor = c2;
            System.out.println("C1 es menor que C2\n");
        }
        else{
            cuentaOrdenMenor = c2;
            cuentaOrdenMayor = c1;
            System.out.println("C2 es menor que C1\n");
        }
        synchronized (cuentaOrdenMenor) {
            synchronized (cuentaOrdenMayor) {
                if (cuentaOrdenMenor.getSaldo() >= cantidad){
                    cuentaOrdenMenor.sacarCantidad(cantidad);
                    cuentaOrdenMayor.ingresaCantidad(cantidad);
                    return  true;
                }
                return false; //no hay saldo suficiente en la cuenta Menor
            }
        }
    }

}
