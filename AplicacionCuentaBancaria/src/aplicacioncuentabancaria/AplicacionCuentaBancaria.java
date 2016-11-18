
package aplicacioncuentabancaria;

import java.util.Scanner;

public class AplicacionCuentaBancaria {
    
    public static void validarCodigo(String ccc){
        String vDigitos[] = new String[4];
        String codigo = ccc.trim();
        
        if(codigo.length() == 10){
            
        }
        
        /*Scanner digitos = new Scanner(ccc);
        
        digitos.useDelimiter("-");
        
        while(digitos.hasNext()){
            for(int i=0;i<vDigitos.length;i++){
                vDigitos[i] = digitos.next();
                System.out.println(vDigitos[i]);
            }
        }
        */
        
        
        
        
    }
    
    public static int menu(){
        Scanner leer = new Scanner(System.in);
        int opcion = 1;
        
        do{
            System.out.println("1. Ver el número de cuenta completo.");
            System.out.println("2. Ver el titular de la cuenta.");
            System.out.println("3. Ver el código de la entidad.");
            System.out.println("4. Ver el código de la oficina.");
            System.out.println("5. Ver el número de la cuenta.");
            System.out.println("6. Ver los dígitos de control de la cuenta.");
            System.out.println("7. Realizar un ingreso.");
            System.out.println("8. Retirar efectivo.");
            System.out.println("9. Consultar saldo.");
            System.out.println("10. Salir de la aplicación.");
            
            System.out.println("");
            System.out.println("Introduzca la opción que desee realizar");
            opcion = leer.nextInt();
        }while(opcion < 1 || opcion > 10);
        
        return opcion;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String nombre = "";
        String ccc = "";
        
        System.out.println("Introduzca el nombre del titular de la cuenta");
        nombre = leer.next();
        System.out.println("Introduzca el CCC de la cuenta completo");
        ccc = leer.next();
        
        validarCodigo(ccc);
    }
    
}
