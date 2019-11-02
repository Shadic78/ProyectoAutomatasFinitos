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
    public PApplet parent;

    public Conexion(PApplet p, Estado origen, Estado destino) {
        this.parent = p;
        this.origen = origen;
        this.destino = destino;
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
    
    public abstract void show();
    
}
