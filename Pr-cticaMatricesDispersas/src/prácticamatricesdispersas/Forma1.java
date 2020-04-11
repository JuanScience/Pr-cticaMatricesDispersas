
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
        mayor = mayor - 1;
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
    
}
