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
public class Condicion {
    
    private Punto coordenadas;
    private String cadena;
    private PApplet parent;
    private int radio;

    public Condicion(PApplet p, Punto coordenadas, String cadena) {
        this.coordenadas = coordenadas;
        this.cadena = cadena;
        this.parent = p;
        this.radio = 0;
    }

    public Punto getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Punto coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    public void show() {
        //parent.fill(0);
        //parent.ellipse(getCoordenadas().getX(), getCoordenadas().getY(), radio, radio);
        parent.fill(0);
        parent.textSize(16);        
        parent.text(cadena, getCoordenadas().getX(), getCoordenadas().getY());
    }
    
}
