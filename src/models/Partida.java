package models;

public class Partida {
    
    private String nombre, propietario, mapa, jugadores, expectadores;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getJugadores() {
        return jugadores;
    }

    public void setJugadores(String jugadores) {
        this.jugadores = jugadores;
    }

    public String getExpectadores() {
        return expectadores;
    }

    public void setExpectadores(String expectadores) {
        this.expectadores = expectadores;
    }
    
    
}