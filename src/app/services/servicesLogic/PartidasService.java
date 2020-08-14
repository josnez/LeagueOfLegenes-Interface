package app.services.servicesLogic;

import java.util.ArrayList;

import logic.ControlPartidas;
import models.Partida;

public class PartidasService {

    private static PartidasService partidasService;
    private ControlPartidas controlPartidas;
    private ArrayList<Partida> partidas;

    public PartidasService() {
    
        controlPartidas = new ControlPartidas();
        partidas = controlPartidas.gPartidas();
    }

    public static PartidasService getServicio() {
        if (partidasService == null)
            partidasService = new PartidasService();
        
        return partidasService;
    }

    public Partida devolverPartida(int posicion) {
        try {
            return partidas.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void agregarPartida(Partida partida) {
        partidas.add(partida);
    }

    public int cantidadPartidas() {
        return partidas.size();
    }
    
}