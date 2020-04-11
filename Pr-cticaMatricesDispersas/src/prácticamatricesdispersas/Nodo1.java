
package prácticamatricesdispersas;

public class Nodo1 {
    
    //Declaración de atributos
    private int fila, columna;
    private float dato;
    private Nodo1 liga, lF, lC;
    
    //Constructor
    public Nodo1(int f, int c, float d){
        this.fila = f;
        this.columna = c;
        this.dato = d;
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
    
    public Nodo1 getLiga(){
        return liga;
    }
    
    public Nodo1 getLF(){
        return lF;
    }
    
    public Nodo1 getLC(){
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
    
    public void setLiga(Nodo1 l){
        this.liga = l;
    }
    
    public void setLF(Nodo1 lF){
        this.lF = lF;
    }

    public void setLC(Nodo1 lC){
        this.lC = lC;
    }

}
