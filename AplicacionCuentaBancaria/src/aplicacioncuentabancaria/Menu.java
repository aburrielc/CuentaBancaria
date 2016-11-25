
package aplicacioncuentabancaria;

import java.util.Scanner;

/**
 * 
 * @author Andrés Burriel Cantisano
 */
public class Menu {
    
    /**
     * Menú de la cuenta bancaria.
     * @return devuelve la opción elegida por el usuario. 
     */
    public static int menu(){
        Scanner leer = new Scanner(System.in);
        int opcion = 1;
        
        do{
            System.out.println("");
            System.out.println("1. Ver el número de cuenta completo.");
            System.out.println("2. Ver el titular de la cuenta.");
            System.out.println("3. Ver el código de la entidad.");
            System.out.println("4. Ver el código de la oficina.");
            System.out.println("5. Ver el número de la cuenta.");
            System.out.println("6. Ver los dígitos de control de la cuenta.");
            System.out.println("7. Realizar un ingreso.");
            System.out.println("8. Retirar efectivo.");
            System.out.println("9. Consultar saldo.");
            System.out.println("10. Volver al menú de inicio");
            System.out.println("11. Cerrar aplicación");
            
            System.out.println("");
            System.out.println("Introduzca la opción que desee realizar");
            opcion = leer.nextInt();
        }while(opcion < 1 || opcion > 11);
        
        return opcion;
    }
    
    /**
     * Menú de inicio.
     * @return devuelve la opción elegida por el usuario.
     */
    public static int menuIntro(){
        Scanner leer = new Scanner(System.in);
        int opcion = 1;
        
        do{
            System.out.println("");
            System.out.println("1. Introducir una cuenta nueva");
            System.out.println("2. Elegir cuenta ya creada");
            
            System.out.println("");
            System.out.println("Introduzca la opción que desee realizar");
            opcion = leer.nextInt();
        }while(opcion < 1 || opcion > 2);
        
        return opcion;
    }
}
