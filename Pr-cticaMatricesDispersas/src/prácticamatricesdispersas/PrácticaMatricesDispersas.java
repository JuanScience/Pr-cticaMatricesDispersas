package prácticamatricesdispersas;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Juan Carlos Salazar Muñoz
 */
public class PrácticaMatricesDispersas {

    private static final Scanner INGRESO = new Scanner (System.in);
    private static String cS;
    private static MDTripletas TA, TB;
    private static Forma1 F1A, F1B;
    private static Forma2 F2A, F2B;
    
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
        System.out.println("(5) * Sumar");
        System.out.println("(6) * Multiplicar");
        System.out.println("(7) * Sumar filas");
        System.out.println("(8) * Promediar columnas");
        System.out.println("(9) * T  + F1 = F2");
        System.out.println("(10)* F1 + F2 = T");
        System.out.println("(11)* T  + F2 = F1");
        System.out.println("(12)* Imprimir");
        System.out.println("(13)* Borrar");
        System.out.println("(0) * Salir");
        System.out.println("----------------------------------------\n");
        System.out.print("Ingrese una opción (0-13) -> ");
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
                    remove();
                    again();
                case 5:
                    plus();
                    again();
                case 6:
                    multiply();
                    again();
                case 7:
                    sumRows();
                    again();
                case 8:
                    averageCol();
                    again();
                case 9:
                    again();
                case 10:
                    again();
                case 11:
                    again();
                case 12:
                    show();
                    again();
                case 13:
                    erase();
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
        F1A = new Forma1(filas, columnas);
        F2A = new Forma2(filas, columnas);
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
                    F1A.insertarS(i, j, matriz[i][j]);
                    F2A.insertarS(i, j, matriz[i][j]);
                }
            }
            System.out.println(" |");
        }
        System.out.println("\nLista tripleta:\n");
        //Imprime tripleta
        TA.mostrar();
        System.out.println("\nLista Forma 1:\n");
        F1A.mostrar();
        System.out.println("\nLista Forma 2:\n");
        F2A.mostrar();        
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
        F1A = new Forma1(filas, columnas);
        F2A = new Forma2(filas, columnas);
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
            F1A.insertarS(fila, columna, dato);
            F2A.insertarS(fila, columna, dato);
        }else if(fila > TA.getNFilas() - 1 || columna > TA.getNCol() - 1){
            System.out.println("La posición del dato excede la dimensión de la matríz.");
        }else{
            TA.almacenarTrip(fila, columna, dato); 
            F1A.insertarS(fila, columna, dato);
            F2A.insertarS(fila, columna, dato);
            System.out.println("Dato ingresado");
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
        
        if (TA == null) {
            initialize();
            TA.insertarTrip(fila, columna, dato);
            F1A.insertarC(fila, columna, dato);
            F2A.insertarC(fila, columna, dato);
        }else if(fila > TA.getNFilas() - 1 || columna > TA.getNCol() - 1){
            System.out.println("La posición del dato excede la dimensión de la matríz.");
        }else{
            TA.insertarTrip(fila, columna, dato);
            F1A.insertarC(fila, columna, dato);
            F2A.insertarC(fila, columna, dato);
            System.out.println("Dato ingresado");
        }       
    }
    
    //Elimina el dato ingresado por el usuario
    public static void remove(){
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
        if(TA != null){
            TA.eliminarTrip(fila, columna);
            F1A.eliminar(fila, columna);
            F2A.eliminar(fila, columna);
            System.out.println("Dato eliminado");
        }else{
            System.out.println("No se ha creado ninguna matriz");
        }
    }
    
    //Valida si hay matriz para sumar
    public static void plus (){
        TB = null;
        F1B = null;
        F2B = null;
        if (TA == null){
            System.out.println("Declare primero una matriz para sumar");
            again();
        }else{
            plusMenu();
        }
    }
    
    //menú de suma de matrices
    public static void plusMenu(){
        System.out.println("\n--------- MENÚ SUMAR ---------");
        System.out.println("(1) * Generar");
        System.out.println("(2) * Insertar (Cambiando dato)");
        System.out.println("(3) * Sumar");
        System.out.println("(4) * Mostrar primera matriz");
        System.out.println("(5) * Mostrar segunda matriz");
        System.out.println("(6) * Regresar");
        System.out.println("------------------------------");
        System.out.print("Ingrese una opción (0-6) -> ");
        opcionesPlus(INGRESO.nextLine());
    }
    
    //Manejo de desición menú sumar
    public static void opcionesPlus(String o){
        if(isNumeric(o)){
            int n = Integer.parseInt(o);
            switch (n){
                case 1:
                    generateB();
                    plusMenu();
                case 2:
                    insertChangeB();
                    plusMenu();
                case 3:
                    if(TB == null)
                        System.out.println("No hay matriz que sumar");
                    else{
                        TA.sumar(TB);
                        F1A.sumar(F1B);
                        F2A.sumar(F2B);
                    }
                    again();
                case 4:
                    TA.mostrar();
                    F1A.mostrar();
                    F2A.mostrar();
                    plusMenu();
                case 5:
                    if(TB == null)
                        System.out.println("No hay matriz que mostrar");
                    else{
                        TB.mostrar();
                        F1B.mostrar();
                        F2B.mostrar();
                    }
                    plusMenu();
                case 6:
                    again();
                default:
                    System.out.println("Ingreso no válido");
                    plusMenu();
            }
        }else{
            System.out.println("Ingreso no válido");
            plusMenu();
        }
    }
    
    //Crea una matriz de números aleatorios para sumar
    public static void generateB(){
        if(TA == null){
            System.out.println("No ha ingresado matriz alguna");
        }else{
            int filas = TA.getNFilas(); //Número de filas 
            int columnas = TA.getNCol(); //Número de columnas 

            System.out.print("Ingrese un rango n de números para llenar la matriz: (Se generarán números entre -n y n): ");
                cS = INGRESO.nextLine();
                while(!isNumeric(cS)){//Mientras no sea numérico
                    System.out.print("Ingrese un dato válido para el rango numérico: ");
                    cS = INGRESO.nextLine();
                }
            int rango = Integer.parseInt(cS); //Rango numérico del usuario (va desde -n hasta n)
            
            TB = new MDTripletas(filas, columnas, 0); //Instancia e inicializa la tripleta
            F1B = new Forma1(filas, columnas);
            F2B = new Forma2(filas, columnas);
            int dato;
            for(int i = 0; i < filas; i++){ //Genera la matriz aleatoria
                for (int j = 0; j < columnas; j++) {
                    dato = getAleatorio(rango, 0, (float) 0.6);
                    if(dato > 0){ //Guarda el dato en la tripleta
                        TB.almacenarTrip(i, j, dato);
                        F1B.insertarC(i, j, dato);
                        F2B.insertarC(i, j, dato);
                    }
                }
            }

            System.out.println("\nLista tripleta:\n");
            //Imprime tripleta
            TB.mostrar();
            System.out.println("\nForma 1:\n");
            //Imprime F1
            F1B.mostrar();
            System.out.println("\nForma 2:\n");
            //Imprime F2
            F2B.mostrar();
        }
    }
    
    //Inserta datos en segunda matriz para suma
    public static void insertChangeB(){
        
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
        
        if (TB == null) {
            initializeB();
            TB.insertarTrip(fila, columna, dato);
            F1B.insertarC(fila, columna, dato);
            F2B.insertarC(fila, columna, dato);
        }else if(fila > TB.getNFilas() || columna > TB.getNCol()){
            System.out.println("La posición del dato excede la dimensión de la matríz.");
        }else{
            TB.insertarTrip(fila, columna, dato);
            F1B.insertarC(fila, columna, dato);
            F2B.insertarC(fila, columna, dato);
        }    
    }
    
    //Inicializa la matriz B para sumar
    public static void initializeB(){ //Crea una matriz sin datos
            int filas = TA.getNFilas(); //Número de filas 
            int columnas = TA.getNCol(); //Número de columnas 
            TB = new MDTripletas(filas, columnas, 1); //Instancia e inicializa la tripleta
            F1B = new Forma1(filas, columnas);
            F2B = new Forma2(filas, columnas);
    }
    
    
    
    //muestra la matriz en su forma dispersa
    public static void show(){
        if (TA != null) {
            TA.mostrar();
            F1A.mostrar();
            F2A.mostrar();
        }else{
            System.out.println("No hay nada para ver");
        }
    }
    
    //Valida si hay matriz para multiplicar
    public static void multiply (){
        TB = null;
        F1B = null;
        F2B = null;
        if (TA == null){
            System.out.println("Declare primero una matriz para multiplicar");
            again();
        }else{
            multiplyMenu();
        }
    }
        
    //menú de suma de matrices
    public static void multiplyMenu(){
        System.out.println("\n--------- MENÚ MULTIPLICAR ---------");
        System.out.println("(1) * Generar");
        System.out.println("(2) * Insertar (Cambiando dato)");
        System.out.println("(3) * Multiplicar");
        System.out.println("(4) * Mostrar primera matriz");
        System.out.println("(5) * Mostrar segunda matriz");
        System.out.println("(6) * Regresar");
        System.out.println("---------------------------------------");
        System.out.print("Ingrese una opción (0-6) -> ");
        opcionesMultiply(INGRESO.nextLine());
    }
    
    //Manejo de desición menú sumar
    public static void opcionesMultiply(String o){
        if(isNumeric(o)){
            int n = Integer.parseInt(o);
            switch (n){
                case 1:
                    generateMB();
                    multiplyMenu();
                case 2:
                    insertChangeMB();
                    multiplyMenu();
                case 3:
                    if(TB == null)
                        System.out.println("No hay matriz por la cual multiplicar");
                    else{
                        TA.multiplicar(TB);
                        F1A.multiplicar(F1B);
                        F2A.multiplicar(F2B);
                    }
                    again();
                case 4:
                    TA.mostrar();
                    F1A.mostrar();
                    F2A.mostrar();
                    multiplyMenu();
                case 5:
                    if(TB == null)
                        System.out.println("No hay matriz que mostrar");
                    else{
                        TB.mostrar();
                        F1B.mostrar();
                        F2B.mostrar();
                    }
                    multiplyMenu();
                case 6:
                    again();
                default:
                    System.out.println("Ingreso no válido");
                    multiplyMenu();
            }
        }else{
            System.out.println("Ingreso no válido");
            plusMenu();
        }
    }
    
    //Inserta datos en segunda matriz para multiplicación
    public static void insertChangeMB(){
        
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
        
        if (TB == null) {
            initializeMB();
            TB.insertarTrip(fila, columna, dato);
            F1B.insertarC(fila, columna, dato);
            F2B.insertarC(fila, columna, dato);
        }else if(fila > TB.getNFilas() || columna > TB.getNCol()){
            System.out.println("La posición del dato excede la dimensión de la matríz.");
        }else{
            TB.insertarTrip(fila, columna, dato);
            F1B.insertarC(fila, columna, dato);
            F2B.insertarC(fila, columna, dato);
        }  
    }
    
    //Inicializa la matriz B para multiplicar
    public static void initializeMB(){ //Crea una matriz sin datos
        int filas = TA.getNCol(); //Número de filas 
        System.out.print("Ingrese el número de columnas de la matriz: ");
            cS = INGRESO.nextLine();
            while(!isNumeric(cS)){//Mientras no sea numérico
                System.out.print("Ingrese un dato válido para el número de columnas: ");
                cS = INGRESO.nextLine();
            }
        int columnas = Integer.parseInt(cS); //Número de columnas que ingresa el usuario
        TB = new MDTripletas(filas, columnas, 1); //Instancia e inicializa la tripleta
        F1B = new Forma1(filas, columnas);
        F2B = new Forma2(filas, columnas);
    }
    
    //Crea una matriz de números aleatorios para multiplicar
    public static void generateMB(){
        if(TA == null){
            System.out.println("No ha ingresado matriz alguna");
        }else{
            int filas = TA.getNCol(); //Número de filas
            
            System.out.print("Ingrese el número de columnas de la matriz: ");
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
            
            TB = new MDTripletas(filas, columnas, 0); //Instancia e inicializa la tripleta
            F1B = new Forma1(filas, columnas);
            F2B = new Forma2(filas, columnas);
            int dato;
            for(int i = 0; i < filas; i++){ //Genera la matriz aleatoria
                for (int j = 0; j < columnas; j++) {
                    dato = getAleatorio(rango, 0, (float) 0.6);
                    if(dato > 0){ //Guarda el dato en la tripleta
                        TB.almacenarTrip(i, j, dato);
                        F1B.insertarC(i, j, dato);
                        F2B.insertarC(i, j, dato);
                    }
                }
            }

            System.out.println("\nLista tripleta:\n");
            //Imprime tripleta
            TB.mostrar();
            System.out.println("\nForma 1:\n");
            //Imprime forma 1
            F1B.mostrar();
            System.out.println("\nForma 2:\n");
            //Imprime forma 2
            F2B.mostrar();
        }
    }
    
    //Suma las filas
    public static void sumRows(){
        if(TA == null){
            System.out.println("No ha ingresado matriz alguna");
        }else{
            System.out.println("Para la tripleta:");
            TA.sumarFilas();
            System.out.println("Para la forma 1:");
            F1A.sumarFilas();
            System.out.println("Para la forma 2:");
            F2A.sumarFilas();
        }
    }
    
    //Promedio de las columnas
    public static void averageCol(){
        if(TA == null){
            System.out.println("No ha ingresado matriz alguna");
        }else{
            System.out.println("Para la tripleta:");
            TA.promedioCol();
            System.out.println("Para la forma 1:");
            F1A.promedioCol();
            System.out.println("Para la forma 2:");
            F2A.promedioCol();
        }
    }
    
    //Borra las matrices
    public static void erase(){
        TA = null;
        F1A = null;
        F2A = null;
        System.out.println("Borradas correctamente");
    }
    
}
