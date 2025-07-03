package Tpe;

import java.util.ArrayList;

public class DatosEntrada {
    private int piezasNecesarias;
    private ArrayList<Maquina> maquinas;
    
    public DatosEntrada(ArrayList<Maquina> maquinas, int piezasNecesarias) {
        this.maquinas = maquinas;
        this.piezasNecesarias = piezasNecesarias;
    }

    public int getPiezasNecesarias() {
        return piezasNecesarias;
    }

    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }
}


