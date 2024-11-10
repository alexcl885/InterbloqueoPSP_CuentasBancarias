# Ejercicio de Transferencia de Dinero entre Cuentas

#### RAMA main

Este proyecto simula la transferencia de dinero entre cuentas bancarias utilizando hilos y sincronización en Java. Para ello, he creado las siguientes clases:

- **Cuenta**
- **Hilo**
- **Transferencia**
- **TransferenciaConBloqueo** (Clase principal `main`)

## Clases

### 1. `Cuenta`

La clase `Cuenta` representa una cuenta bancaria con los siguientes atributos y métodos:

- **Atributos**:
  - `numeroCuenta`: el número identificador de la cuenta.
  - `saldo`: el saldo disponible en la cuenta.

- **Métodos**:
  - `ingresar(int cantidad)`: añade dinero a la cuenta.
  - `retirar(int cantidad)`: retira dinero de la cuenta si hay saldo suficiente.

Todos los métodos relacionados con el saldo están sincronizados para asegurar que solo un hilo puede acceder a estos métodos en un momento dado, evitando condiciones de carrera.

### 2. `Hilo`

La clase `Hilo` extiende `Thread` y representa un hilo que realiza transferencias entre dos cuentas. Sus características son:

- **Atributos**:
  - `nombre`: nombre del hilo.
  - `transferencia`: objeto de la clase `Transferencia` que permite realizar transferencias.
  - `c1` y `c2`: las cuentas bancarias involucradas en la transferencia.

- **Método `run()`**:
  - Sobreescribimos el método `run` para realizar un bucle de 1000 iteraciones, en el cual se hace una transferencia de `c1` a `c2` o de `c2` a `c1` dependiendo del nombre del hilo.

### 3. `Transferencia`

La clase `Transferencia` contiene los métodos para realizar las transferencias entre las cuentas, con sincronización para asegurar que solo un hilo puede ejecutar una transferencia en un momento dado:

- **Métodos**:
  - `realizarTransferencia1a2(Cuenta c1, Cuenta c2, int cantidad)`: transfiere dinero de `c1` a `c2`.
  - `realizarTransferencia2a1(Cuenta c1, Cuenta c2, int cantidad)`: transfiere dinero de `c2` a `c1`.

Ambos métodos están sincronizados para evitar conflictos entre las operaciones de distintos hilos.

### 4. `TransferenciaConBloqueo` (Clase principal)

`TransferenciaConBloqueo` es la clase `main`, donde se realiza la prueba del ejercicio. Aquí:

- Se crean dos instancias de `Cuenta`.
- Se verifica el saldo inicial de ambas cuentas mediante una salida en consola.
- Se crean dos hilos de la clase `Hilo`, cada uno realizando transferencias.
- Se utiliza `join()` en ambos hilos para asegurar que finalicen correctamente antes de continuar, garantizando que todas las transferencias se completen.

## Ejecución

Este programa permite observar cómo se sincronizan las operaciones de transferencia entre cuentas utilizando hilos, para evitar inconsistencias y conflictos de concurrencia.


--- 
---
#### RAMA main2

Nos dan una clase llamada GestorTransferencias para corregir el interbloqueo:

**java**

```java
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
```