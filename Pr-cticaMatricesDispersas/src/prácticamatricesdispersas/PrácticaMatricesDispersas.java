package prácticamatricesdispersas;

import java.util.Scanner;

/**
 * @author Juan Carlos Salazar Muñoz
 */
public class PrácticaMatricesDispersas {

    private static final Scanner INGRESO = new Scanner (System.in);
    
    //Método principal
    public static void main(String[] args) {      
        menu();
    }
    
    //menú de opciones
    public static void menu(){
        System.out.println("\n\n-----------------MENÚ-------------------");
        System.out.println("(1) * Crear");
        System.out.println("(2) * Insertar (sumando)");
        System.out.println("(3) * Insertar (Cambiando dato)");
        System.out.println("(4) * Eliminar");
        System.out.println("(5) * Ordenar Datos asc por fila");
        System.out.println("(6) * Sumar");
        System.out.println("(7) * Multiplicar");
        System.out.println("(8) * F1 + F2 = T");
        System.out.println("(9) * ");
        System.out.println("(10)* ");
        System.out.println("(0) * Salir");
        System.out.println("----------------------------------------\n");
        System.out.print("Ingrese una opción (0-?) -> ");
        opciones(INGRESO.nextLine());
    }
    
        //Vuelve a mostrar el menú
    public static void again(){
        System.out.print("\n\nPresiona la tecla ENTER para continuar");
        INGRESO.nextLine();
        menu();
    }

    //Desición de elección del menú
    public static void opciones(String o){
        if(isNumeric(o)){
            int n = Integer.parseInt(o);
            switch (n){
                case 1:
                    again();
                case 2:
                    again();
                case 3:
                    again();
                case 4:
                    again();
                case 5:
                    again();
                case 6:
                    again();
                case 7:
                    again();
                case 8:
                    again();
                case 9:
                    again();
                case 10:
                    again();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Ingreso no válido");
                    again();
            }
        }else{
            System.out.println("Ingreso no válido");
            again();
        }
    }
    
    //Valida si un string es numérico
    public static boolean isNumeric(String s){
        if("".equals(s) || (s == null ? ("\"" + s + "\"") == null : s.equals("\"" + s + "\""))){//Si se envía un enter
            return false;
        }
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-'){//Si en la primera posición no hay "-" o números
            return false;
        }
        for (int i = 1; i < s.length(); i++){//valida caracter por caracter si es dígito
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    //Valida si un número es real
    public static boolean isFloat(String s){
        if("".equals(s) || (s == null ? ("\"" + s + "\"") == null : s.equals("\"" + s + "\""))){//Si se envía un enter
            return false;
        }
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-'){//Si en la primera posición no hay "-" o números
            return false;
        }
        int control = 0;
        for (int i = 1; i < s.length(); i++){//valida caracter por caracter si es dígito
            if(!Character.isDigit(s.charAt(i))){
                if (s.charAt(i) == '.' && control == 0) {
                    control++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    //Crea una matriz de números aleatorios
    public void random(){
        for(int i = 0; i < 1; i++){
            
        }
    }
    
}
