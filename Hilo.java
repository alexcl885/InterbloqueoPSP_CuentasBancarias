public class Hilo extends Thread {
    private String nombre;
    private Transferencia transferencia;
    private GestorTransferencias gestorTransferencias;

    private Cuenta c1;
    private Cuenta c2;


    public Hilo(String nombre, Transferencia transferencia,GestorTransferencias gestorTransferencias, Cuenta c1, Cuenta c2) {
        this.nombre = nombre;
        this.transferencia = transferencia;
        this.gestorTransferencias= gestorTransferencias;
        this.c1 = c1;
        this.c2 = c2;
    }

    public String getNombre() {
        return this.nombre;
    }
    /**
     * Metodo que realiza un bucle 1000 veces que realiza una transferencia segun el
     * nombre del hilo para no dar caso a un interbloqueo.
     * 
     * Cada transferencia es de 10 unidades y se ejecuta 1000 veces.
     * 
     * Al finalizar las transferencias, imprime el saldo final de ambas cuentas.
     * 
     */
    @Override
    public void run() {
        
        for (int i=0; i< 100; i++){
            if ("Alejandro Copado".equals(this.nombre)){
                gestorTransferencias.transferencia(c1, c2, 10);
                
            }
            else{
                gestorTransferencias.transferencia(c1, c2, 10);
                
            }
        }
        
        System.out.println("Hilo: " + getNombre()+" SALDO 1 -> " + c1.getSaldo() + "  SALDO 2 -> " + c2.getSaldo() );
    }
    
    
}