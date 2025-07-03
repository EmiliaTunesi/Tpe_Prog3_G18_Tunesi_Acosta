package Tpe;

public class Maquina{
    private int piezas;
    private String nombre;

    public Maquina(int piezas, String nombre){
        this.piezas= piezas;
        this.nombre=nombre;
    }
    public int getPiezas() {
        return piezas;
    }
    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}