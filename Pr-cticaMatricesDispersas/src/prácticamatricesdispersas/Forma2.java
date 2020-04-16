
package prácticamatricesdispersas;


public class Forma2 {
    //Declaración de atributos
    protected Nodo2 punta;
    
    //Constructor
    public Forma2 (int filas, int columnas){
        punta = new Nodo2(filas, columnas, 0);
        punta.setLF(punta);
        punta.setLC(punta);
    }
    
    //Métodos
    
    //Mostrar

    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertarS(int i, int j, float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertarC(int fila, int columna, int dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sumar(Forma2 F2B) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void multiplicar(Forma2 F2B) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sumarFilas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void promedioCol() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
