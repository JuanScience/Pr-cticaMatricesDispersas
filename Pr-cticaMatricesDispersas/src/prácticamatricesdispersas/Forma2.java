
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
        Nodo2 head;
        head = this.punta;
        String lf, lc, n;
        lf = head.getLF().toString().substring(head.getLF().toString().length() - 6);
        lc = head.getLC().toString().substring(head.getLC().toString().length() - 6);
        n = head.toString().substring(head.toString().length() - 6);
        System.out.print("\n\n[*" + n + "* " + lf + "(" + head.getFila() + ")"
            + "(" + head.getColumna() + ")" + lc 
            + " / (" + head.getDato() + ")]\n");
        head = head.getLF();
        while (head != this.punta) {
            lf = head.getLF().toString().substring(head.getLF().toString().length() - 6);
            lc = head.getLC().toString().substring(head.getLC().toString().length() - 6);
            n = head.toString().substring(head.toString().length() - 6);
            System.out.print("[*" + n + "* " + lf + "(" + head.getFila() + ")"
                + "(" + head.getColumna() + ")" + lc 
                + " / (" + head.getDato() + ")] ");
            if(head.getFila() != head.getLF().getFila())
                System.out.print("\n");
            head = head.getLF();
        }
    }
    
    //inserta dato, si encuentra uno en la misma posición lo suma
    public void insertarS(int fila, int columna, float dato) {
        if(fila < this.punta.getFila() && columna < this.punta.getColumna() && dato != 0){
            Nodo2 position = this.punta;
            //Mientras recorre toda las filas de la tripleta hasta la posición de almacenamiento
            while(position.getLF() != this.punta && position.getLF().getFila() < fila){ 
                position = position.getLF();
            }
            while(position.getLF() != this.punta && position.getLF().getFila() == fila && position.getLF().getColumna() < columna){ 
                position = position.getLF();
            }
            if (position.getLF().getFila() == fila && position.getLF().getColumna() == columna) {
                if(position.getLF().getDato() + dato != 0){
                    position.getLF().setDato(position.getLF().getDato() + dato);
                }else{
                    this.eliminar(fila, columna);
                }         
            }else{
                Nodo2 fresh = new Nodo2(fila, columna, dato);
                fresh.setLF(position.getLF());
                position.setLF(fresh);
                position = this.punta;
                while(position.getLC() != this.punta && position.getLC().getColumna() < columna){ 
                    position = position.getLC();
                }
                while(position.getLC() != this.punta && position.getLC().getColumna() == columna && position.getLC().getFila() < fila){ 
                    position = position.getLC();
                }
                fresh.setLC(position.getLC());
                position.setLC(fresh);
            }
        }
    }

    public void insertarC(int fila, int columna, float dato) {
        if(fila < this.punta.getFila() && columna < this.punta.getColumna() && dato != 0){
            Nodo2 position = this.punta;
            //Mientras recorre toda las filas de la tripleta hasta la posición de almacenamiento
            while(position.getLF() != this.punta && position.getLF().getFila() < fila){ 
                position = position.getLF();
            }
            while(position.getLF() != this.punta && position.getLF().getFila() == fila && position.getLF().getColumna() < columna){ 
                position = position.getLF();
            }
            if (position.getLF().getFila() == fila && position.getLF().getColumna() == columna) {
                position.getLF().setDato(dato);
            }else{
                Nodo2 fresh = new Nodo2(fila, columna, dato);
                fresh.setLF(position.getLF());
                position.setLF(fresh);
                position = this.punta;
                while(position.getLC() != this.punta && position.getLC().getColumna() < columna){ 
                    position = position.getLC();
                }
                while(position.getLC() != this.punta && position.getLC().getColumna() == columna && position.getLC().getFila() < fila){ 
                    position = position.getLC();
                }
                fresh.setLC(position.getLC());
                position.setLC(fresh);
            }
        }
    }

    public void eliminar(int fila, int columna) {
        if(fila >= 0 && columna >= 0 && fila < this.punta.getFila() && columna < this.punta.getColumna() ){
            Nodo2 head = this.punta.getLF();
            Nodo2 tail = this.punta;
            while((head.getFila() != fila && head.getColumna() != columna) || head != this.punta){
                tail = head;
                head = head.getLF();
            }
            if(head.getFila() == fila && head.getColumna() == columna){
                tail.setLF(head.getLF());
                head = this.punta.getLC();
                tail = this.punta;
                while(head.getFila() != fila && head.getColumna() != columna){
                    tail = head;
                    head = head.getLC();
                }
                tail.setLC(head.getLC());
            }
        }
    }

    public void sumar(Forma2 F2B) {
        Forma2 R = new Forma2(this.punta.getFila(), this.punta.getColumna());
        Nodo2 head = this.punta.getLF();
        while(head != this.punta){
            R.insertarS(head.getFila(), head.getColumna(), head.getDato());
            head = head.getLF();
        }
        head = F2B.punta.getLF();
        while(head != F2B.punta){
            R.insertarS(head.getFila(), head.getColumna(), head.getDato());
            head = head.getLF();
        }
        System.out.println("El resultado de la suma genera la siguiente lista F2: ");
        R.mostrar();
    }

    public void multiplicar(Forma2 F2B) {
        Forma2 R = new Forma2(this.punta.getFila(), F2B.punta.getColumna());
        Nodo2 headA = this.punta.getLF();
        Nodo2 headB;
        while(headA != this.punta){
            headB = F2B.punta.getLF();
            while(headB != F2B.punta){
                if(headA.getColumna() == headB.getFila())
                    R.insertarS(headA.getFila(), headB.getColumna(), headA.getDato() * headB.getDato());
                headB = headB.getLF();
            }
            headA = headA.getLF();
        }
        System.out.println("El resultado de la multiplicación genera la siguiente lista F2: ");
        R.mostrar();
    }

    public void sumarFilas() {
        int filas = this.punta.getFila();
        float sum = 0;
        Nodo2 head;
        for (int i = 0; i < filas; i++) {
            head = this.punta.getLF();
            while(head != this.punta){
                if(head.getFila() == i)
                    sum = sum + head.getDato();
                head = head.getLF();
            }
            System.out.println("La suma de la fila " + i + "es: " + sum);
            sum = 0;
        }
    }

    public void promedioCol() {
        int columnas = this.punta.getColumna();
        float average = 0;
        Nodo2 head;
        for (int i = 0; i < columnas; i++) {
            head = this.punta.getLF();
            while(head != this.punta){
                if(head.getColumna() == i)
                    average = average + head.getDato();
                head = head.getLF();
            }
            average = average / columnas;
            System.out.println("El promedio de la columna " + i + "es: " + average);
            average = 0;
        }
    }
    
}
