package prácticamatricesdispersas;

import java.util.Random;
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
        System.out.println("(1) * Generar");
        System.out.println("(2) * Insertar (sumando)");
        System.out.println("(3) * Insertar (Cambiando dato)");
        System.out.println("(4) * Eliminar");
        System.out.println("(5) * Ordenar Datos asc por fila");
        System.out.println("(6) * Sumar");
        System.out.println("(7) * Multiplicar");
        System.out.println("(8) * Sumar filas");
        System.out.println("(9) * Sumar columnas");
        System.out.println("(10)* T  + F1 = F2");
        System.out.println("(11)* F1 + F2 = T");
        System.out.println("(12)* T  + F2 = F1");
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
                    generate();
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
                case 11:
                    again();
                case 12:
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
    
    //Devuelve un entero aleatorio (del 0 hasta "max") con probabilidad "ratio" para el número "num"
    public static int getAleatorio(int max, int num, float ratio) {
        Random r = new Random();//Una instancia de esta clase es usada para generar números pseudoaleatorios
        int rand = r.nextInt(max); //Genera un número aleatorio del 0 hasta (max) y le suma 1
        boolean m = r.nextBoolean();
        if (rand <= max * ratio) { //Si el número generado es menor al máximo por la probabilidad
            return num; 
        } else {
            do {
                rand = r.nextInt(max);
            } while (rand == num);
            if(m)
                rand = rand * -1;
            return rand;
        }
    }
    
    //Crea una matriz de números aleatorios
    public static void generate(){
        
        System.out.print("\nIngrese el número de filas: ");
            String cS = INGRESO.nextLine();
            while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("\nIngrese un dato válido para el número de filas: ");
                cS = INGRESO.nextLine();
            }
        int filas = Integer.parseInt(cS);
        
        System.out.print("\nIngrese el número de columnas: ");
            cS = INGRESO.nextLine();
            while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("\nIngrese un dato válido para el número de columnas: ");
                cS = INGRESO.nextLine();
            }
        int columnas = Integer.parseInt(cS);
        
        System.out.print("\nIngrese un rango  para llenar la matriz: ");
            cS = INGRESO.nextLine();
            while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("\nIngrese un dato válido para el rango numérico: ");
                cS = INGRESO.nextLine();
            }
        int rango = Integer.parseInt(cS);
        
        float matriz[][] = new float[filas][columnas];
        float max = 0;
        float min = 0;
        System.out.println("");
        for(int i = 0; i < filas; i++){ //Imprime la matriz
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = getAleatorio(rango, 0, (float) 0.6);
                if(matriz[i][j] > max) //Guarda el dato mayor de la matriz
                    max = matriz[i][j];
                if(matriz[i][j] < min)
                    min = matriz[i][j]; //Guarda el dato menor de la matriz
            }
        }
        
        float maxlen = min;
        if (Float.toString(min).length() < Float.toString(max).length())
            maxlen = max;
        
        for(int i = 0; i < filas; i++){ //Imprime la matriz
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                int digitos = Float.toString(maxlen).length();
                String espacios = " ";
                for (int k = 1 ; k <= digitos - Float.toString(matriz[i][j]).length(); k++) //Calcula el número de espacios para ordenar la impresión
                    espacios = espacios + " ";
                System.out.print(espacios + matriz[i][j]);
            }
            System.out.println(" |");
        }
    }
}
