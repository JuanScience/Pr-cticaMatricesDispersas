/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        for(int i = 0; i < lista[0][2] + 1; i++){
            System.out.println("[" + lista[i][0] + "]" + "[" + lista[i][1] + "]" + "[" + lista[i][2] + "]");
        }
    }
    
    //Almacena una tripleta, si encuentra un dato en la misma posición no permite
    public void almacenarTrip(int f, int c, float d){
        int k = 1, j;
        //Mientras recorre toda las filas de la tripleta, la fila de la matriz del dato que se va a ingresar es menor a la fila de la tripleta y el dato es diferente de cero
        while(k < lista[0][2] + 1 && lista[k][0] <= f && lista[k][2] != 0){ 
            k = k + 1; //Identifica la fila de la tripleta igual o anterior a la correspondiente fila de la matriz
        }
        //Recorre las siguientes filas si hay más datos en la misma fila de la matriz
        while (k < lista[0][2] + 1 && lista[k][0] <= f && lista[k][0] <= f) {
            
        }
    }
    
    //Inserta una tripleta, si encuentra un dato en la misma posición lo suma
    public void insertarTrip(int f, int c, float d){
        
    }
    
    //
    public void redimensionarListaTrip(){
        
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
    public void setDato(int f, int c, int d){
        
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
    public void EliminarTrip(){
        
    }
    
    //Suma dos matrices en forma de tripletas
    public MDTripletas sumar(MDTripletas B){
        return null;
    }
    
    //multiplica dos matrices en forma de tripletas
    public MDTripletas multiplicar(MDTripletas B){
        return null;
    }
    
    //Compara dos tripletas
    public MDTripletas comprarar(MDTripletas B){
        return null;
    }
    
    //Hace una copia de una tripleta
    public MDTripletas hacerCopia(){
        return null;
    }
}
