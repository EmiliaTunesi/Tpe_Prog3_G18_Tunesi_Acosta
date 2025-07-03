package Tpe;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LectorTexto {

    public DatosEntrada leerDatosDesdeArchivo() {
        ArrayList<Maquina> maquinas = new ArrayList<>();
        int piezasNecesarias = 0;

        InputStream is = getClass().getClassLoader().getResourceAsStream("datos.txt");
        if (is == null) {
            System.err.println("No se encontró datos.txt en el classpath");
            return new DatosEntrada(maquinas, piezasNecesarias);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String linea;

            // Leer la primera línea: cantidad de piezas necesarias
            if ((linea = br.readLine()) != null) {
                piezasNecesarias = Integer.parseInt(linea.trim());
            }

            // Leer las máquinas
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim(); // primero el nombre
                    int piezas = Integer.parseInt(partes[1].trim()); // luego la cantidad
                    maquinas.add(new Maquina(piezas, nombre));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new DatosEntrada(maquinas, piezasNecesarias);
    }
}


