
package prácticamatricesdispersas;


public class Nodo2 {
    //Declaración de atributos
    private int fila, columna;
    private float dato;
    private Nodo2 lF, lC;
    
    //Constructor
    public Nodo2(int f, int c, float d){
        this.fila = f;
        this.columna = c;
        this.dato = d;
        this.lF = null;
        this.lC = null;
    }
    
    //Métodos
    
    public int getFila(){
        return fila;
    }
    
    public int getColumna(){
        return columna;
    }
    
    public float getDato(){
        return dato;
    }
    
    public Nodo2 getLF(){
        return lF;
    }
    
    public Nodo2 getLC(){
        return lC;
    }
    
    public void setFila(int fila){
        this.fila = fila;
    }
    
    public void setColumna(int columna){
        this.columna = columna;
    }
    
    public void setDato(float dato){
        this.dato = dato;
    }
    
    public void setLF(Nodo2 lF){
        this.lF = lF;
    }

    public void setLC(Nodo2 lC){
        this.lC = lC;
    }
}
