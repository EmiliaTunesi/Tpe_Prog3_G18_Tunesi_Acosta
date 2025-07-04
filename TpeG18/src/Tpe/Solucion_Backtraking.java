package Tpe;

import java.util.*;

public class Solucion_Backtraking {
    private ArrayList<Maquina> secuencia_maquinas = null;
    private ArrayList<Maquina> secuencia_actual = new ArrayList<>();
    private int estadosGenerados = 0;

    public ArrayList<Maquina> getSecuenciaMaquinas(ArrayList<Maquina> maquinas, Integer produccion) {
        getSecuenciaMaquinas(maquinas, produccion, 0, 0);
        return secuencia_maquinas;
    }

    private void getSecuenciaMaquinas(List<Maquina> maquinas, int produccion, int produccion_actual, int start) {

    	if (secuencia_maquinas != null && secuencia_actual.size() >= secuencia_maquinas.size()) {
            return;
        }                                                                                           //poda por optimizacion
        if (produccion_actual > produccion) {
            return;
        }

        estadosGenerados++;

        if (produccion_actual == produccion) { //estado final
            if ((secuencia_maquinas == null) || (secuencia_actual.size() < secuencia_maquinas.size())) {
                secuencia_maquinas = new ArrayList<>(secuencia_actual);
            }
            return;
        }

        for (int i = start; i < maquinas.size(); i++) { //ramifica en ancho
            Maquina m = maquinas.get(i);
            secuencia_actual.add(m);
            getSecuenciaMaquinas(maquinas, produccion, produccion_actual + m.getPiezas(), i); //ramifica en profundidad
            secuencia_actual.removeLast();
        }
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }
}

