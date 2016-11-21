
package aplicacioncuentabancaria;

import java.util.Scanner;

public class AplicacionCuentaBancaria {
    
    public static boolean comprobarNombre(String nombre){
        boolean nombreValido = false;
        
        if(nombre.length() <= 10){
            nombreValido = true;
        }else{
            nombreValido = false;
        }
        
        return nombreValido;
    }
    
    public static String calculoDigitosControl(String entidad, String oficina, String numCompleto){
        int vFactores[] = new int []{1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
        int resultadoComprobacion = 0;
        String codigoComprobacion = "00" + entidad + oficina;
        
        for(int i=0;i<codigoComprobacion.length();i++){
            
        }
    }
    
    public static void validarCodigo(String ccc){
        String vDigitos[] = new String[4];
        String codigo = ccc.trim();
        
        if(codigo.length() == 10){
            vDigitos[0] = codigo.substring(0, 3);
            vDigitos[1] = codigo.substring(4, 7);
            vDigitos[2] = codigo.substring(8, 9);
            vDigitos[3] = codigo.substring(10, 19);
            
            
        }else{
            System.out.println("Extensión de código errónea");
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

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String nombre = "";
        String ccc = "";
        boolean comprobacionNombre = false;
        
        do{
           System.out.println("Introduzca el nombre del titular de la cuenta");
           nombre = leer.next();
           
           comprobacionNombre = comprobarNombre(nombre);
           
           if(comprobacionNombre == false){
               System.out.println("Nombre de titular no válido");
           }else{
               System.out.println("Nombre de titular válido");
           }
           
        }while(comprobacionNombre == false);
        
        System.out.println("Introduzca el CCC de la cuenta completo");
        ccc = leer.next();
        
        validarCodigo(ccc);
    }
    
}
