
package prácticamatricesdispersas;

public class Forma1 {
    
    //Declaración de atributos
    protected Nodo1 punta;
    
    //Constructor
    public Forma1 (int filas, int columnas){
        punta = new Nodo1(filas, columnas, 0);
        punta.setLF(punta);
        punta.setLC(punta);
        int mayor = filas;
        if(columnas > filas)
            mayor = columnas;
        Nodo1 anterior = punta;
        for (int i = 0; i < mayor; i++) {
            Nodo1 nuevo = new Nodo1(i, i, 0);
            nuevo.setLF(nuevo);
            nuevo.setLC(nuevo);
            anterior.setLiga(nuevo);
            anterior = nuevo;
        }
        anterior.setLiga(punta);
    }
    
    //Métodos
    
    //Mostrar
    public void mostrar(){
        Nodo1 head, row;
        head = this.punta;
        String lf, lc, l, n;
        int rows = this.punta.getFila();
        if (this.punta.getColumna() > rows)
            rows = this.punta.getColumna();
        for (int i = 0; i <= rows; i++) {
            lf = head.getLF().toString().substring(head.getLF().toString().length() - 6);
            lc = head.getLC().toString().substring(head.getLC().toString().length() - 6);
            l = head.getLiga().toString().substring(head.getLiga().toString().length() - 6);
            n = head.toString().substring(head.toString().length() - 6);
            System.out.print("\n[*" + n + "* " + lf + "(" + head.getFila() + ")"
                + "(" + head.getColumna() + ")" + lc 
                + " / (" + head.getDato() + ")" + l + "] ");
            row = head.getLF();
            while (row.getLiga() == null ) {
                lf = row.getLF().toString().substring(row.getLF().toString().length() - 6);
                lc = row.getLC().toString().substring(row.getLC().toString().length() - 6);
                n = row.toString().substring(row.toString().length() - 6);
                System.out.print("[*" + n + "* " + lf + "(" + row.getFila() + ")"
                    + "(" + row.getColumna() + ")" + lc 
                    + " / (" + row.getDato() + ")" + row.getLiga()+ "] ");
                row = row.getLF();
            }
            head = head.getLiga();
        }

    }
    
    //Inserta dato, si encuentra uno en la posición lo suma
    public void insertarS (int f, int c, float d){
        if (f > this.punta.getFila() || c > this.punta.getColumna()){
            System.out.println("La posición del dato excede la dimensión de la matriz.");
        }else if(d != 0){
            Nodo1 row, location;
            row = this.punta.getLiga();
            
            for (int i = 0; i < f; i++) {//Busca la fila para insertar
                row = row.getLiga();
            }
            
            if(row.getLF().getColumna() <= c && row.getLF() != row ){
                location = row.getLF();
                while(location.getLF().getColumna() <= c && location.getLF() != row){ //Busca la posición para insertar
                    location = location.getLF();
                }
            }else{
                location = row;
            }
            
            if(location.getColumna() == c && location.getLiga() == null){
                if (location.getDato() + d != 0) {
                    location.setDato(location.getDato() + d);
                }else{
                    this.eliminar(f, c);
                }
            }else{
                Nodo1 nuevo = new Nodo1(f, c, d);
                nuevo.setLF(location.getLF());
                location.setLF(nuevo);
                
                row = this.punta.getLiga();
                
                for (int i = 0; i < c; i++) {
                    row = row.getLiga();
                }
                
                if(row.getLC().getFila() <= f && row.getLC() != row ){
                    location = row.getLC();
                    while(location.getLC().getFila() <= f && location.getLC() != row){ //Busca la posición para insertar
                        location = location.getLC();
                    }
                }else{
                    location = row;
                }
                
                while(location.getFila() < f && location.getLC() != row){
                    location = location.getLC();
                }
                nuevo.setLC(location.getLC());
                location.setLC(nuevo);
            }
        }
    }
    
    //Inserta dato, si encuentra uno en la posición lo suma
    public void insertarC (int f, int c, float d){
        if (f > this.punta.getFila() || c > this.punta.getColumna()){
            System.out.println("La posición del dato excede la dimensión de la matriz.");
        }else{
            Nodo1 row, location;
            row = this.punta.getLiga();
            
            for (int i = 0; i < f; i++) {//Busca la fila para insertar
                row = row.getLiga();
            }
            
            if(row.getLF().getColumna() <= c && row.getLF() != row ){
                location = row.getLF();
                while(location.getLF().getColumna() <= c && location.getLF() != row){ //Busca la posición para insertar
                    location = location.getLF();
                }
            }else{
                location = row;
            }
            
            if(location.getColumna() == c && location.getLiga() == null){
                location.setDato(d);
            }else{
                Nodo1 nuevo = new Nodo1(f, c, d);
                nuevo.setLF(location.getLF());
                location.setLF(nuevo);
                
                row = this.punta.getLiga();
                
                for (int i = 0; i < c; i++) {
                    row = row.getLiga();
                }
                
                if(row.getLC().getFila() <= f && row.getLC() != row ){
                    location = row.getLC();
                    while(location.getLC().getFila() <= f && location.getLC() != row){ //Busca la posición para insertar
                        location = location.getLC();
                    }
                }else{
                    location = row;
                }
                
                while(location.getFila() < f && location.getLC() != row){
                    location = location.getLC();
                }
                nuevo.setLC(location.getLC());
                location.setLC(nuevo);
            }
        }
    }
    
    //Elimina un dato
    public void eliminar(int f, int c){
        if (f > this.punta.getFila() || c > this.punta.getColumna()){
            System.out.println("La posición del dato excede la dimensión de la matriz.");
        }else{
            Nodo1 row, location, before;
            row = this.punta.getLiga();
            for (int i = 0; i < f; i++) {
                row = row.getLiga();
            }
            
            if(row.getLF().getColumna() <= c && row.getLF() != row ){
                location = row.getLF();
                before = row;
                while(location.getLF().getColumna() <= c && location.getLF() != row){ //Busca la posición para eliminar
                    location = location.getLF();
                    before = before.getLF();
                }
                if(location.getColumna() == c && location.getLiga() == null){
                    before.setLF(location.getLF());

                    row = this.punta.getLiga();
                    for (int i = 0; i < c; i++) {
                        row = row.getLiga();
                    }
                    
                    if(row.getLC().getFila()<= f && row.getLC() != row ){
                        location = row.getLC();
                        before = row;
                        while(location.getLC().getFila() <= f && location.getLC() != row){ //Busca la posición para eliminar
                            location = location.getLC();
                            before = before.getLC();
                        }
                        if(location.getFila() == f && location.getLiga() == null){
                            before.setLC(location.getLC());
                        }
                    }
                }
            }
        }
    }    

    public void sumar(Forma1 F1B) {
        int filas = this.punta.getFila();
        int columnas = this.punta.getColumna();
        if (filas == F1B.punta.getFila() && columnas == F1B.punta.getColumna()){
            Forma1 F1R = new Forma1(filas, columnas);
            Nodo1 head, row;
            head = this.punta;
            int rows = filas;
            if (columnas > rows)
                rows = columnas;
            for (int i = 0; i <= rows; i++) {
                row = head.getLF();
                while (row.getLiga() == null ) {
                    F1R.insertarS(row.getFila(), row.getColumna(), row.getDato());
                    row = row.getLF();
                }
                head = head.getLiga();
            }
            head = F1B.punta;
            for (int i = 0; i <= rows; i++) {
                row = head.getLF();
                while (row.getLiga() == null ) {
                    F1R.insertarS(row.getFila(), row.getColumna(), row.getDato());
                    row = row.getLF();
                }
                head = head.getLiga();
            }
            System.out.println("El resultado de la suma genera la siguiente forma 1: ");
            F1R.mostrar();
        }
    }

    public void multiplicar(Forma1 F1B) {

        if(this.punta.getColumna() == F1B.punta.getFila()){
            int filas = this.punta.getFila();
            int columnas = F1B.punta.getColumna();
            Forma1 R = new Forma1(filas, columnas);
            Nodo1 pointA, pointB, rowA, rowB;
            pointA = this.punta.getLiga();
            while(pointA != this.punta){//recorre los nodos cabeza la primara matriz
                rowA = pointA.getLF();
                while(rowA != pointA){//recorre todas las filas de la primera matriz
                    pointB = F1B.punta.getLiga();
                    while(pointB != F1B.punta){//recorre los nodos cabeza de F1B
                        rowB = pointB.getLF();
                        while(rowB != pointB){//recorre las filas de F1B
                            if(rowA.getColumna()== rowB.getFila()){
                                R.insertarS(rowA.getFila(), rowB.getColumna(), rowA.getDato() * rowB.getDato());
                            }
                            rowB = rowB.getLF();
                        }
                        pointB = pointB.getLiga();
                    }
                    rowA = rowA.getLF();
                }
                pointA = pointA.getLiga();
            }
            
            System.out.println("El resultado de la multiplicación genera la siguiente lista F1: ");
            R.mostrar();
        }else{
            System.out.println("No se pueden multiplicar las matrices, dimensiones incompatibles");
        }
    }

    public void sumarFilas() {
        int rows = this.punta.getFila();
        Nodo1 location;
        Nodo1 row = this.punta.getLiga();
        float sum = 0;
        for (int i = 0; i < rows; i++) {
            location = row.getLF();
            while (location != row) {                
                sum = sum + location.getDato();
                location = location.getLF();
            }
            System.out.println("La suma de la fila " + i + " es: " + sum);
            sum = 0;
            row = row.getLiga();
        }
    }

    public void promedioCol() {
        int columns = this.punta.getColumna();
        Nodo1 location;
        Nodo1 column = this.punta.getLiga();
        float average = 0;
        for (int i = 0; i < columns; i++) {
            location = column.getLC();
            while (location != column) {                
                average = average + location.getDato();
                location = location.getLC();
            }
            System.out.println("El promedio de la columna " + i + " es: " + average / this.punta.getFila());
            average = 0;
            column = column.getLiga();
        }
    }

    public void plus(Forma2 F2B) {
        Nodo1 head, row;
        MDTripletas R = new MDTripletas(this.punta.getFila(), this.punta.getColumna(), 0);
        head = this.punta.getLiga();
        while (head != this.punta) {
            row = head.getLF();
            while (row != head) {                
                R.almacenarTrip(row.getFila(), row.getColumna(), row.getDato());
                row = row.getLF();
            }
            head = head.getLiga();
        }
        Nodo2 position;
        position = F2B.punta.getLF();
        while (position != F2B.punta) {
            R.almacenarTrip(head.getFila(), head.getColumna(), head.getDato());
            head = head.getLF();
        }
        System.out.println("El resultado es la siguiente tripleta");
        R.mostrar();
    }
}
