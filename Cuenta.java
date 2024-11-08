/**Recurso compartido */
public class Cuenta {
    //ATRIBUTOS
    private String n_cuenta;
    private double saldo;

    public Cuenta(String n_cuenta, double saldo) {
        this.n_cuenta = n_cuenta;
        this.saldo = saldo;
    }
    
    //GETTERS
    public String getN_cuenta() {
        return this.n_cuenta;
    }
    public synchronized  double getSaldo() {
        return this.saldo;
    }
    //METODOS INGRESAR Y SACAR DINERO 
    public synchronized  void ingresaCantidad(double cantidad){
        saldo += cantidad;
    }
    public synchronized  boolean  sacarCantidad(double cantidad){
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
    
    //METOTO TOSTRING
    @Override
    public String toString() {
        return "{" +
            " n_cuenta='" + n_cuenta + "'" +
            ", saldo='" + saldo + "'" +
            "}";
    }

    
}
