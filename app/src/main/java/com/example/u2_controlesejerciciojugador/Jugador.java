package com.example.u2_controlesejerciciojugador;

/**
 * Created by DIDACT on 07/02/2018.
 */

public class Jugador {

    //ATRIBUTOS

    String nombre;
    int dorsal;
    String posicion;
    boolean tienemundial;

    //CONSTRUCTOR


    public Jugador(String nombre, int dorsal, String posicion, boolean tienemundial) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.tienemundial = tienemundial;
    }

    //GETTER & SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isTienemundial() {
        return tienemundial;
    }

    public void setTienemundial(boolean tienemundial) {
        this.tienemundial = tienemundial;
    }
}
