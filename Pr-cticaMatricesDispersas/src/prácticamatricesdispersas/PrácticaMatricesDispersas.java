package prácticamatricesdispersas;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Juan Carlos Salazar Muñoz
 */
public class PrácticaMatricesDispersas {

    private static final Scanner INGRESO = new Scanner (System.in);
    private static String cS;
    private static MDTripletas TA;
    
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
        System.out.println("(13)* Imprimir");
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
                    insertSum();
                    again();
                case 3:
                    insertChange();
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
                case 13:
                    show();
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
            cS = INGRESO.nextLine();
            while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido para el número de filas: ");
                cS = INGRESO.nextLine();
            }
        int filas = Integer.parseInt(cS); //Número de filas que ingresa el usuario
        
        System.out.print("Ingrese el número de columnas: ");
            cS = INGRESO.nextLine();
            while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido para el número de columnas: ");
                cS = INGRESO.nextLine();
            }
        int columnas = Integer.parseInt(cS); //Número de columnas que ingresa el usuario
        
        System.out.print("Ingrese un rango n de números para llenar la matriz: (Se generarán números entre -n y n): ");
            cS = INGRESO.nextLine();
            while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido para el rango numérico: ");
                cS = INGRESO.nextLine();
            }
        int rango = Integer.parseInt(cS); //Rango numérico del usuario (va desde -n hasta n)
        
        float matriz[][] = new float[filas][columnas]; //Matriz generadora
        float max = 0; //Guarda el mayor número
        float min = 0; //Guarda el menor número
        int count = 0; //Cuenta el número de posiciones diferentes a cero en la matriz
        
        for(int i = 0; i < filas; i++){ //Genera la matriz aleatoria
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = getAleatorio(rango, 0, (float) 0.6);
                if(matriz[i][j] > max) //Guarda el dato mayor de la matriz
                    max = matriz[i][j];
                if(matriz[i][j] < min)
                    min = matriz[i][j]; //Guarda el dato menor de la matriz
                if(matriz[i][j] != 0)
                    count++; //Guarda el número de datos diferentes a cero
            }
        }
        
        float maxlen = min;
        if (Float.toString(min).length() < Float.toString(max).length())
            maxlen = max;
        int digitos = Float.toString(maxlen).length(); //Guarda el número de dígitos del número más lárgo de la matriz
        
        // Convierte a tripletas
        System.out.println("\nMatriz:\n");
        TA = new MDTripletas(filas, columnas, count); //Instancia e inicializa la tripleta
        int conteof = 1;
        for(int i = 0; i < filas; i++){ //Imprime la matriz y convierte a tripleta
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                String espacios = " ";
                for (int k = 1 ; k <= digitos - Float.toString(matriz[i][j]).length(); k++) //Calcula el número de espacios para ordenar la impresión
                    espacios = espacios + " ";
                System.out.print(espacios + matriz[i][j]); //Imprime el dato
                if(matriz[i][j] != 0){ //Si el dato es diferente de cero, lo ingresa en la tripleta
                    TA.setDato(conteof, 0, i);
                    TA.setDato(conteof, 1, j);
                    TA.setDato(conteof, 2, (int) matriz[i][j]);
                    conteof++;
                }
            }
            System.out.println(" |");
        }
        System.out.println("\nLista tripleta:\n");
        //Imprime tripleta
        TA.mostrar();
    }
    
    public static void initialize(){ //Crea una matriz sin datos
        System.out.print("\nIngrese el número de filas de la matriz: ");
            cS = INGRESO.nextLine();
            while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido para el número de filas: ");
                cS = INGRESO.nextLine();
            }
            int filas = Integer.parseInt(cS); //Número de filas que ingresa el usuario

            System.out.print("Ingrese el número de columnas de la matriz: ");
                cS = INGRESO.nextLine();
                while(!isNumeric(cS)){//Mientras no sea numérico
                    System.out.print("Ingrese un dato válido para el número de columnas: ");
                    cS = INGRESO.nextLine();
                }
            int columnas = Integer.parseInt(cS); //Número de columnas que ingresa el usuario
            TA = new MDTripletas(filas, columnas, 1); //Instancia e inicializa la tripleta
    }
    
    //Inserta dato, si encuentra uno en la posición lo suma
    public static void insertSum(){
               
        System.out.print("Inserte la fila del dato a ingresar: ");
        cS = INGRESO.nextLine();
        while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido para el número de fila: ");
                cS = INGRESO.nextLine();
            }
        int fila = Integer.parseInt(cS); //Fila del dato a insertar
        System.out.print("Inserte la columna del dato a ingresar: ");
        cS = INGRESO.nextLine();
        while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido para el número de columna: ");
                cS = INGRESO.nextLine();
            }
        int columna = Integer.parseInt(cS); //Columna del dato a insertar
        System.out.print("Inserte el dato a ingresar: ");
        cS = INGRESO.nextLine();
        while(!isFloat(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido: ");
                cS = INGRESO.nextLine();
            }
        int dato = Integer.parseInt(cS); //dato a insertar
        if (TA == null) {
            initialize();
            TA.almacenarTrip(fila, columna, dato); 
        }else if(fila > TA.getNFilas() || columna > TA.getNCol()){
            System.out.println("La posición del dato excede la dimensión de la matríz.");
        }else{
            TA.almacenarTrip(fila, columna, dato); 
        }           
    }
    
    public static void insertChange(){
        
        System.out.print("Inserte la fila del dato a ingresar: ");
        cS = INGRESO.nextLine();
        while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido para el número de fila: ");
                cS = INGRESO.nextLine();
            }
        int fila = Integer.parseInt(cS); //Fila del dato a insertar
        System.out.print("Inserte la columna del dato a ingresar: ");
        cS = INGRESO.nextLine();
        while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido para el número de columna: ");
                cS = INGRESO.nextLine();
            }
        int columna = Integer.parseInt(cS); //Columna del dato a insertar
        System.out.print("Inserte el dato a ingresar: ");
        cS = INGRESO.nextLine();
        while(!isFloat(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido: ");
                cS = INGRESO.nextLine();
            }
        int dato = Integer.parseInt(cS); //dato a insertar
        if(fila > TA.getNFilas() || columna > TA.getNCol()){
            System.out.println("La posición del dato excede la dimensión de la matríz.");
        }else{
            if (TA == null) {
                initialize();
            }
            TA.insertarTrip(fila, columna, dato);
        }
    }
    
    //muestra la matriz en su forma dispersa
    private static void show(){
        if (TA != null) {
            TA.mostrar();
        }else{
            System.out.println("No hay nada para ver");
        }
    }
}
