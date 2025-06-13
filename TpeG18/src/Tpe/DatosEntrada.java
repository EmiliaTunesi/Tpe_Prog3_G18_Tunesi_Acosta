package Tpe;

import java.util.ArrayList;

public class DatosEntrada {
    private int piezasNecesarias;
    private ArrayList<Maquina> maquinas;

    public DatosEntrada(int piezasNecesarias, ArrayList<Maquina> maquinas) {
        this.piezasNecesarias = piezasNecesarias;
        this.maquinas = maquinas;
    }

    public int getPiezasNecesarias() {
        return piezasNecesarias;
    }

    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }
}

