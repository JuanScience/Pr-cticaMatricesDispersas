
package prácticamatricesdispersas;

/**
 * Objeto de tripletas en matrices dispersas* 
 */
public class MDTripletas {
    
    //Declaración de atributos
    protected int nFilas, nColumnas, nT; //Número de filas, columnas y datos diferentes a cero
    protected float[][] lista; //Lista de tripletas
    
    //Constructor
    public MDTripletas (int nf, int nc, int cd){
        lista = new float[cd + 1][3]; //[filas 3][columnas]
        lista[0][0] = nf;
        lista[0][1] = nc;
        lista[0][2] = cd;
    }
    
    //Métodos
    
    //muestra la lista de tripletas
    public void mostrar(){
        int digitos = this.findBigger(); //Encuentra el número más grande
        for (int i = 0; i < this.getNDatos() + 1; i++) {
            System.out.print("|");       
            for (int j = 0; j < 3; j++) {
                String espacios = " ";
                for (int k = 1 ; k <= digitos - Float.toString(this.lista[i][j]).length(); k++) //Calcula el número de espacios para ordenar la impresión
                    espacios = espacios + " ";
                System.out.print(espacios + this.lista[i][j]); //Imprime el dato
            }
            System.out.println(" |");
        }
    }
    
    //Almacena una tripleta, si encuentra un dato en la misma posición lo suma
    public void almacenarTrip(int f, int c, float d){
        int datos = getNDatos() + 1;
        int k = 1;
        //Mientras recorre toda las filas de la tripleta hasta la posición de almacenamiento
        while(k < datos && (lista[k][0] < f) && lista[k][2] != 0){ 
            k++; //Identifica la fila de inserción
        }
        while(k < datos && lista[k][0] == f && lista[k][1] < c && lista[k][2] != 0){ 
            k++; //Identifica la fila de inserción
        }
        if (k >= datos){
            this.makeCopyPlusOne(k);
            this.setDato(k, 0, f);
            this.setDato(k, 1, c);
            this.setDato(k, 2, d);
        }else if (lista[k][0] == f && lista[k][1] == c) {
            this.setDato(k, 2,  d + lista[k][2]);
        }else if (lista[k][2] == 0){
            this.setDato(k, 0, f);
            this.setDato(k, 1, c);
            this.setDato(k, 2, d);
        }else{
            this.makeCopyPlusOne(k);
            this.setDato(k, 0, f);
            this.setDato(k, 1, c);
            this.setDato(k, 2, d);
        }
        this.redimensionarListaTrip();
        System.out.println("Dato ingresado");
    }
    
    //Inserta una tripleta, si encuentra un dato en la misma posición lo cambia
    public void insertarTrip(int f, int c, float d){
        
        int datos = getNDatos() + 1;
        int k = 1;
        //Mientras recorre toda las filas de la tripleta hasta la posición de almacenamiento
        while(k < datos && (lista[k][0] < f) && lista[k][2] != 0){ 
            k++; //Identifica la fila de inserción
        }
        while(k < datos && lista[k][0] == f && lista[k][1] < c && lista[k][2] != 0){ 
            k++; //Identifica la fila de inserción
        }
        if (k >= datos){
            this.makeCopyPlusOne(k);
            this.setDato(k, 0, f);
            this.setDato(k, 1, c);
            this.setDato(k, 2, d);
        }else if (lista[k][0] == f && lista[k][1] == c) {
            this.setDato(k, 2,  d);
        }else if (lista[k][2] == 0){
            this.setDato(k, 0, f);
            this.setDato(k, 1, c);
            this.setDato(k, 2, d);
        }else{
            this.makeCopyPlusOne(k);
            this.setDato(k, 0, f);
            this.setDato(k, 1, c);
            this.setDato(k, 2, d);
        }
        this.redimensionarListaTrip();
        System.out.println("Dato ingresado");
    }
    
    //Elimina una fila de la tripleta si encuentra un cero
    public void redimensionarListaTrip(){
        int f = 1;
        int datos = getNDatos() + 1;
        while (f < datos && this.getDato(f, 2) != 0) {            
            f++; //encuentra la fila donde hay cero
        }
        if (f < datos) {
            float[][] listaAux = new float[datos - 1][3];
            listaAux[0][0] = this.lista[0][0];
            listaAux[0][1] = this.lista[0][1];
            listaAux[0][2] = datos - 2;
            for (int i = 1; i < f; i++) {
                listaAux[i][0] = this.lista[i][0];
                listaAux[i][1] = this.lista[i][1];
                listaAux[i][2] = this.lista[i][2];
            }
            for (int i = f; i < datos - 1; i++) {
                listaAux[i][0] = this.lista[i + 1][0];
                listaAux[i][1] = this.lista[i + 1][1];
                listaAux[i][2] = this.lista[i + 1][2];
            }
            this.lista = listaAux;
        }
    }
    
    //Devuelve el número de filas de la matriz
    public int getNFilas(){
        return (int) lista[0][0];
    }
    
    //Devuelve el número de columnas de la matriz
    public int getNCol(){
        return (int) lista[0][1];
    }
    
    //Devuelve el número de datos diferentes de cero de la matriz
    public int getNDatos(){
        return (int) lista[0][2];
    }
    
    //Devuelve la columna donde está un dato (pensar método)
    public int getFila(){
        return 0;
    }
    
    //Devuelve la fila donde está un dato (pensar método)
    public int getCol(){
        return 0;
    }
    
    //Devuelve el Dato de una posición específica
    public float getDato(int f, int c){
        return lista[f][c];
    }
    
    //inserta un dato en una posición específica
    public void setDato(int f, int c, float d){
        this.lista[f][c] = d;
    }
    
    //Suma las filas de la matriz
    public void sumarFilas(){
        
    }
    
    //Calcula el promedio de las columnas de la matriz
    public void promedioCol(){
        
    }
    
    //Muestra el mayor número de la tripleta
    public void mayorMdTrip(){
        
    }
    
    //Elimina una tripleta
    public void eliminarTrip(int f, int c){
        int datos = this.getNDatos() + 1;
        int row = 1; 
        while (row < datos) {
            if(this.lista[row][0] == f && this.lista[row][1] == c)
                break;
            row++;
        }
        if (row < datos){
            for (int i = row; i < datos - 1; i++) {
                this.lista[i][0] = this.lista[i + 1][0];
                this.lista[i][1] = this.lista[i + 1][1];
                this.lista[i][2] = this.lista[i + 1][2];
            }
            this.lista[datos - 1][2] = 0;
            this.redimensionarListaTrip();
            System.out.println("Dato eliminado");
        }else{
            System.out.println("No se encontró dato");
        }
    }
    
    //Suma dos matrices en forma de tripletas
    public void sumar(MDTripletas B){
        if (this.getNFilas() != B.getNFilas() || this.getNCol() != B.getNCol() ){
            System.out.println("No se pueden sumar las matrices, dimensiones incompatibles");
        }else{
            MDTripletas R = new MDTripletas(this.getNFilas(), this.getNCol(), 0);
            for (int i = 1; i <= this.getNDatos(); i++) {
                R.almacenarTrip((int)this.getDato(i, 0), (int)this.getDato(i, 1), this.getDato(i, 2));
            }
            for (int i = 1; i <= B.getNDatos(); i++) {
                R.almacenarTrip((int)B.getDato(i, 0), (int)B.getDato(i, 1), B.getDato(i, 2));
            }
            System.out.println("El resultado de la suma genera la siguiente tripleta: ");
            R.mostrar();
        }
    }
    
    //multiplica dos matrices en forma de tripletas
    public void multiplicar(MDTripletas B){
        if(this.getNCol() != B.getNFilas()){
            System.out.println("No se pueden multiplicar las matrices, dimensiones incompatibles");
        }else{
            int filas = this.getNCol();
            int columnas = B.getNFilas();
            MDTripletas R = new MDTripletas(filas, columnas, 0);
            float dato = 0;
            
            for (int i = 1; i <= this.getNDatos(); i++) {
                
                for (int j = 1; j <= B.getNDatos(); j++) {
                    if (this.getDato(i, 0) == B.getDato(j, 1) && this.getDato(i, 1) == B.getDato(j, 0)) {
                        dato = dato + (this.getDato(i, 2) * B.getDato(j, 2));
                        if (i < this.getNDatos()){
                            if (this.getDato(i, 0) != this.getDato(i + 1, 0) && dato != 0) {
                                R.insertarTrip((int)this.getDato(i, 0), (int)B.getDato(j, 1), dato);
                                dato = 0;
                            }
                        }else{
                            if (dato != 0) {
                                R.insertarTrip((int)this.getDato(i, 0), (int)B.getDato(j, 1), dato);
                            }
                        }
                    }                    
                }
            }
            System.out.println("El resultado de la multiplicación genera la siguiente tripleta: ");
            R.mostrar();
        }
        
    }
    
    //Compara dos tripletas
    public MDTripletas comparar(MDTripletas B){
        return null;
    }
    
    //Hace una copia de una tripleta
    public MDTripletas hacerCopia(){
        return null;
    }
    
    //Hace una copia de la tripleta aumentada en un espacio y corre los datos dejando libre la fila del parámetro
    public void makeCopyPlusOne(int k){
        int datos = this.getNDatos();
        float[][] listaAux = new float[datos + 2][3]; //[filas 3][columnas]
        listaAux[0][0] = this.lista[0][0];
        listaAux[0][1] = this.lista[0][1];
        listaAux[0][2] = this.lista[0][2] + 1;
        for (int i = 1; i < k; i++) {
            listaAux[i][0] = this.lista[i][0];
            listaAux[i][1] = this.lista[i][1];
            listaAux[i][2] = this.lista[i][2];
        }
        for (int i = k; i < datos + 1 ; i++) {
            listaAux[i + 1][0] = this.lista[i][0];
            listaAux[i + 1][1] = this.lista[i][1];
            listaAux[i + 1][2] = this.lista[i][2];
        }
        this.lista = listaAux;
    }   
    
    //Busca el número con mayor cantidad de dígitos
    public int findBigger(){
        int bigger = 0;
        for (int i = 0; i < this.getNDatos(); i++) {
            for (int j = 0; j < 3; j++) {
                if (bigger < Float.toString(this.lista[i][j]).length())
                    bigger = Float.toString(this.lista[i][j]).length();
            }
        }
        return bigger;
    }
}
