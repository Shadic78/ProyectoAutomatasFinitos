package modelo;

import processing.core.PApplet;

public abstract  class Estado {
    private Punto coordenadas;   
    private String nombre;
    public PApplet parent;
    public int radio;

    public Estado(PApplet parent, Punto punto, String nombre) {
        this.parent = parent;
        this.coordenadas = punto;
        this.nombre = nombre;
        this.radio = 20;
    }

    public Punto getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Punto punto) {
        this.coordenadas = punto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PApplet getParent() {
        return parent;
    }

    public void setParent(PApplet parent) {
        this.parent = parent;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public abstract void show();

}
