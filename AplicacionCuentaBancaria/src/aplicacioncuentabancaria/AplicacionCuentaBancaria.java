
package aplicacioncuentabancaria;

import java.util.Scanner;

public class AplicacionCuentaBancaria {
    
    public static boolean comprobarNombre(String nombre){
        boolean nombreValido = false;
        
        if(nombre.length() <= 10){
            System.out.println("Nombre de titular válido");
            nombreValido = true;
        }else{
            System.out.println("Nombre de titular erróneo");
            nombreValido = false;
        }
        
        return nombreValido;
    }
    
    public static String calculoDigitosControl(String entidad, String oficina, String cuenta){
        int vFactores[] = new int []{6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
        String codigoComprobacion = entidad + oficina;
        String digitosControl = "";
        int sumaCodigo = 0;
        int resto = 0;
        
        for(int i=0;i<codigoComprobacion.length();i++){
            sumaCodigo += Integer.parseInt(codigoComprobacion.substring(i)) * vFactores[7 - i];
        }
        
        resto = sumaCodigo % 11;
        digitosControl += String.valueOf(11 - resto);
        
        sumaCodigo = 0;
        resto = 0;
        
        for(int i=0;i<cuenta.length();i++){
            sumaCodigo += Integer.parseInt(cuenta.substring(i)) * vFactores[9 - i];
        }
        
        resto = sumaCodigo % 11;
        digitosControl += String.valueOf(11 - resto);
        
        return digitosControl;
    }
    
    public static boolean validarCodigo(String vDigitos[]){
        int extension = 0;
        String comprobacionDigitos = "";
        boolean valido = false;
        
        for(int i=0;i<vDigitos.length;i++){
            extension += vDigitos[i].length();
        }
        
        if(extension < 20){
            
            System.out.println("Extensión de código errónea");
            
        }else{
            
            comprobacionDigitos = calculoDigitosControl(vDigitos[0],vDigitos[1],vDigitos[3]);
            
            if(comprobacionDigitos.equals(vDigitos[2])){
                System.out.println("El Código de Control es correcto");
                valido = true;
            }else{
                System.out.println("El Código de Control es erróneo");
                valido = false;
            } 
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
        return valido;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String nombre = "";
        String ccc = "";
        
        String vDigitos[] = new String[4];
        
        boolean comprobacionNombre = false;
        boolean comprobacionCuenta = false;
        
        do{
           System.out.println("Introduzca el nombre del titular de la cuenta");
           nombre = leer.next();
           
           comprobacionNombre = comprobarNombre(nombre);
           
        }while(comprobacionNombre == false);
        
        do{
            System.out.println("Introduzca los dígitos de ENTIDAD");
            vDigitos[0] = leer.next();
            System.out.println("Introduzca los dígitos de OFICINA");
            vDigitos[1] = leer.next();
            System.out.println("Introduzca los dígitos de CONTROL");
            vDigitos[2] = leer.next();
            System.out.println("Introduzca los dígitos de CUENTA");
            vDigitos[3] = leer.next();

            comprobacionCuenta = validarCodigo(vDigitos);
            
        }while(comprobacionCuenta == false);
        
    }
    
}
