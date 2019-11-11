/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import processing.core.PApplet;

/**
 *
 * @author Usuario
 */
public abstract class Conexion {
    private Estado origen;
    private Estado destino;
    private Condicion condicion;
    public PApplet parent;
    private int colorRelleno;

    public Conexion(PApplet p, Estado origen, Estado destino, Condicion condicion) {
        this.parent = p;
        this.origen = origen;
        this.destino = destino;
        this.condicion = condicion;
        // Color de la conexion
        this.colorRelleno = parent.color(155, 92, 181);
    }

    public Estado getOrigen() {
        return origen;
    }

    public void setOrigen(Estado origen) {
        this.origen = origen;
    }

    public Estado getDestino() {
        return destino;
    }

    public void setDestino(Estado destino) {
        this.destino = destino;
    }

    public PApplet getParent() {
        return parent;
    }

    public void setParent(PApplet parent) {
        this.parent = parent;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public int getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(int colorRelleno) {
        this.colorRelleno = colorRelleno;
    }
    
    public abstract void show();
    
}
