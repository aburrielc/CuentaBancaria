
package aplicacioncuentabancaria;

import java.util.Scanner;

public class AplicacionCuentaBancaria {
    
    public static int buscarHueco(CuentaBancaria vCuentas[]){
        int posicion = -1;
        
        for(int i=0;i<vCuentas.length;i++){
            if(vCuentas[i] == null){
                posicion = i;
                i = vCuentas.length + 1;
            }    
        }
        
        return posicion;
    }
    
    public static int buscarCuenta(CuentaBancaria vCuentas[], String nombre){
        int posicion = -1;
        
        for(int i=0;i<vCuentas.length;i++){
            if(vCuentas[i] != null)
            if(vCuentas[i].getNombre().equals(nombre)){
                posicion = i;
                i = vCuentas.length;
            }
        }
        
        return posicion;
    }
    
    public static boolean comprobarNombre(String nombre){
        boolean nombreValido = false;
        
        if(nombre.length() <= 10){
            System.out.println("");
            System.out.println("Nombre de titular válido");
            nombreValido = true;
        }else{
            System.out.println("");
            System.out.println("Nombre de titular erróneo");
            nombreValido = false;
        }
        
        return nombreValido;
    }
    
    public static boolean comprobarSaldo(double saldo){
        boolean saldoValido = false;
        
        if(saldo >= 0){
            System.out.println("");
            System.out.println("Saldo válido");
            saldoValido = true;
        }else{
            System.out.println("");
            System.out.println("Saldo erróneo");
            saldoValido = false;
        }
        
        return saldoValido;
    }
    
    public static String calculoDigitosControl(String entidad, String oficina, String cuenta){
        int vFactores[] = new int []{6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
        String codigoComprobacion = entidad + oficina;
        String digitosControl = "";
        int sumaCodigo = 0;
        int resto = 0;
        int resultado = 0;
        
        for(int i=0;i<codigoComprobacion.length();i++){
            sumaCodigo += (Integer.valueOf(codigoComprobacion.substring(i,i+1)) * (vFactores[7 - i]));
        }
        
        resto = sumaCodigo % 11;
        resultado = 11 - resto;
        
        if(resultado == 10){
            digitosControl += String.valueOf(1);
        }else if(resultado == 11){
            digitosControl += String.valueOf(0);
        }else{
            digitosControl += String.valueOf(resultado);
        }

        sumaCodigo = 0;
        resto = 0;
        resultado = 0;
        
        for(int i=0;i<cuenta.length();i++){
            sumaCodigo += (Integer.valueOf(cuenta.substring(i,i+1)) * (vFactores[9 - i]));
        }
        
        resto = sumaCodigo % 11;
        resultado = 11 - resto;
        
        if(resultado == 10){
            digitosControl += String.valueOf(1);
        }else if(resultado == 11){
            digitosControl += String.valueOf(0);
        }else{
            digitosControl += String.valueOf(resultado);
        }
        
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
            System.out.println("");
            System.out.println("Extensión de código errónea");
            
        }else{
            
            comprobacionDigitos = calculoDigitosControl(vDigitos[0],vDigitos[1],vDigitos[3]);
            
            if(comprobacionDigitos.equals(vDigitos[2])){
                System.out.println("");
                System.out.println("El Código de Control es correcto");
                valido = true;
            }else{
                System.out.println("");
                System.out.println("El Código de Control es erróneo");
                valido = false;
            } 
        }

        return valido;
    }
    
    public static void crearCuenta(CuentaBancaria vCuentas[]){
        Scanner leer = new Scanner(System.in);
        String vDigitos[] = new String[4];
        String nombre = "";
        double saldo = 0.0;
        String ccc = "";
        
        boolean comprobacionNombre = false;
        boolean comprobacionSaldo = false;
        boolean comprobacionCuenta = false;
        
                
        int hueco = buscarHueco(vCuentas);
        
        if(hueco == -1){
            System.out.println("");
            System.out.println("No hay huecos disponibles para añadir una nueva cuenta");
        }else{
            System.out.println("");
            System.out.println("Hay hueco disponible para añadir una nueva cuenta");
            
            do{
            System.out.println("");
            System.out.println("Introduzca el nombre del titular de la cuenta");
            nombre = leer.next();

            comprobacionNombre = comprobarNombre(nombre);

            }while(comprobacionNombre == false);

            do{
                System.out.println("");
                System.out.println("Introduzca el saldo de la cuenta");
                saldo = leer.nextDouble();

                comprobacionSaldo = comprobarSaldo(saldo);

            }while(comprobacionSaldo == false);

            do{
                System.out.println("");
                System.out.println("Introduzca los dígitos de ENTIDAD");
                vDigitos[0] = leer.next();
                System.out.println("");
                System.out.println("Introduzca los dígitos de OFICINA");
                vDigitos[1] = leer.next();
                System.out.println("");
                System.out.println("Introduzca los dígitos de CONTROL");
                vDigitos[2] = leer.next();
                System.out.println("");
                System.out.println("Introduzca los dígitos de CUENTA");
                vDigitos[3] = leer.next();

                comprobacionCuenta = validarCodigo(vDigitos);

            }while(comprobacionCuenta == false);

            for(int i=0;i<vDigitos.length;i++){

                if(i == 3){
                    ccc += vDigitos[i];
                }else{
                    ccc += vDigitos[i] + "-";
                }   
            }

            CuentaBancaria cuenta = new CuentaBancaria(nombre,ccc,saldo,vDigitos[0],vDigitos[1],vDigitos[2],vDigitos[3]);
            
            vCuentas[hueco] = cuenta;
        }      
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int posicion = -1;
        int opcion1 = 0;
        int opcion2 = 0;
        boolean salir = false;
        boolean bandera = false;
        
        System.out.println("");
        System.out.println("Introduzca el número de cuentas que quiera agregar");
        int numCuentas = leer.nextInt();
        
        CuentaBancaria vCuentas[] = new CuentaBancaria[numCuentas];
        
        do{
           opcion1 = Menu.menuIntro();
        
            switch(opcion1){
                case 1:
                    crearCuenta(vCuentas);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Introduzca el nombre del titular de la cuenta con la que desee operar");
                    String nombre = leer.next();

                    posicion = buscarCuenta(vCuentas,nombre);
                    
                    if(posicion == -1){
                        System.out.println("");
                        System.out.println("No se ha encontrado la cuenta");
                    }else{
                        System.out.println("");
                        System.out.println("Se ha encontrado la cuenta");
                        
                        do{
                            opcion2 = Menu.menu();

                            switch(opcion2){
                                case 1:
                                    System.out.println("");
                                    System.out.println("Número de cuenta completo (CCC): " + vCuentas[posicion].getCodigo());
                                    break;
                                case 2:
                                    System.out.println("");
                                    System.out.println("Nombre del titular: " + vCuentas[posicion].getNombre());
                                    break;
                                case 3:
                                    System.out.println("");
                                    System.out.println("Código de la entidad: " + vCuentas[posicion].getNumEntidad());
                                    break;
                                case 4:
                                    System.out.println("");
                                    System.out.println("Código de la oficina: " + vCuentas[posicion].getNumOficina());
                                    break;
                                case 5:
                                    System.out.println("");
                                    System.out.println("Número de la cuenta: " + vCuentas[posicion].getNumCuenta());
                                    break;
                                case 6:
                                    System.out.println("");
                                    System.out.println("Dígitos de control de la cuenta: " + vCuentas[posicion].getNumControl());
                                    break;
                                case 7:
                                    System.out.println("");
                                    System.out.println("Introduzca la cantidad que desea ingresar");
                                    double ingreso = leer.nextDouble();

                                    vCuentas[posicion].ingresar(ingreso);
                                    break;
                                case 8:
                                    System.out.println("");
                                    System.out.println("Introduzca la cantidad que desea retirar");
                                    double retiro = leer.nextDouble();

                                    vCuentas[posicion].retirar(retiro);
                                    break;
                                case 9:
                                    System.out.println("");
                                    System.out.println("Saldo actual: " + vCuentas[posicion].getSaldo());
                                    break;
                                case 10:
                                    salir = true;
                                    break;
                                case 11:
                                    System.out.println("");
                                    System.out.println("¡Hasta luego!");
                                    bandera = true;
                                    break;
                            }
                        }while(salir != true);
                    }
                break;
            }
        }while(bandera == false);
    }    
}
