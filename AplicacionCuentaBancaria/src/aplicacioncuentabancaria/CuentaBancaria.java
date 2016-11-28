
package aplicacioncuentabancaria;

import java.util.Scanner;

/**
 * 
 * @author Andrés Burriel Cantisano
 */
public class CuentaBancaria {
    
    private String nombre;
    private String codigo;
    private double saldo;
    private String numEntidad;
    private String numOficina;
    private String numControl;
    private String numCuenta;
    
    /**
     * Constructor vacío.
     */
    public CuentaBancaria() {
    }
    
    /**
     * Constructor por defecto.
     * @param nombre nombre del titular.
     * @param codigo código cuenta cliente (CCC).
     * @param saldo cantidad de saldo de la cuenta.
     * @param numEntidad número de entidad de la cuenta.
     * @param numOficina número de oficina de la cuenta.
     * @param numControl dígitos de control de la cuenta.
     * @param numCuenta número de cuenta.
     */
    public CuentaBancaria(String nombre, String codigo, double saldo, String numEntidad, String numOficina, String numControl, String numCuenta) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.saldo = saldo;
        this.numEntidad = numEntidad;
        this.numOficina = numOficina;
        this.numControl = numControl;
        this.numCuenta = numCuenta;
    }
    
    /**
     * Método que comprueba si el usuario puede ingresar una cierta cantidad al saldo de su cuenta.
     * @param cantidad cantidad de saldo introducida por el usuario.
     * @return si la cantidad introducida por el usuario es mayor o igual que 0, devuelve true, si no, false.
     */
    public boolean ingresar(double cantidad){
        Scanner leer = new Scanner(System.in);
        boolean realizarIngreso = false;
 
        if(cantidad >= 0){
            System.out.println("");
            System.out.println("Se ha podido realizar el ingreso");
            realizarIngreso = true;
            saldo += cantidad;
        }else{
            System.out.println("");
            System.out.println("No se ha podido realizar el ingreso");
            realizarIngreso = false;
        }
        
        return realizarIngreso;
    }
    
    /**
     * Método que comprueba si el usuario puede retirar una cierta cantidad del saldo de su cuenta.
     * @param cantidad de saldo introducida por el usuario.
     * @return si la cantidad introducida por el usuario es menor o igual al saldo actual de la cuenta, devuelve true, si no, false.
     */
    public boolean retirar(double cantidad){
        Scanner leer = new Scanner(System.in);
        boolean realizarRetirada = false;
        
        if(cantidad <= saldo && cantidad >= 0){
            System.out.println("");
            System.out.println("Se ha podido realizar la retirada de efectivo");
            realizarRetirada = true;
            saldo -= cantidad;
        }else{
            System.out.println("");
            System.out.println("No se ha podido realizar la retirada de efectivo");
            realizarRetirada = false;
        }
        
        return realizarRetirada;
    }

    /**
     * @return devuelve el nombre del titular de la cuenta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre nombre del titular de la cuenta.
     */
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return devuelve el código cuenta cliente (CCC).
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo código cuenta cliente (CCC).
     */
    private void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return devuelve el saldo actual de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo saldo de la cuenta.
     */
    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return devuelve el número de entidad de la cuenta.
     */
    public String getNumEntidad() {
        return numEntidad;
    }

    /**
     * @param numEntidad número de entidad de la cuenta.
     */
    private void setNumEntidad(String numEntidad) {
        this.numEntidad = numEntidad;
    }

    /**
     * @return devuelve el número de oficina de la cuenta.
     */
    public String getNumOficina() {
        return numOficina;
    }

    /**
     * @param numOficina número de oficina de la cuenta.
     */
    private void setNumOficina(String numOficina) {
        this.numOficina = numOficina;
    }

    /**
     * @return devuelve los dígitos de control de la cuenta.
     */
    public String getNumControl() {
        return numControl;
    }

    /**
     * @param numControl dígitos de control de la cuenta.
     */
    private void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    /**
     * @return devuelve el número de cuenta.
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * @param numCuenta número de cuenta.
     */
    private void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
    
}
