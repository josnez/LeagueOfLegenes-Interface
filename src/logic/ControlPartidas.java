package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import models.Partida;

public class ControlPartidas {
    
    private ArrayList<Partida> partidas;

    public ControlPartidas() {

        partidas = new ArrayList<Partida>();
        cargarDatos();
    }

    private void cargarDatos() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File("src/archives/partidas.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea=br.readLine()) != null) {

                String[] atributos = linea.split(",");

                Partida partida = new Partida();
                partida.setNombre(atributos[0]);  
                partida.setPropietario(atributos[1]);
                partida.setMapa(atributos[2]);
                partida.setJugadores(atributos[3]);
                partida.setExpectadores(atributos[4]);
                partidas.add(partida);
            }
            fr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Partida> gPartidas() {
        return partidas;
    }
}