/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import processing.core.PApplet;

/**
 *
 * @author emman
 */
public class EstadoFinal extends Estado{
    public EstadoFinal(PApplet p, Punto vertice, String nombre) {
        super(p, vertice, nombre);
    }

    @Override
    public void show() {
        parent.fill(81, 237, 236);
        parent.strokeWeight(3);
        parent.stroke(70, 206, 205);
       
        parent.ellipse(super.getVertice().getX(), super.getVertice().getY(), super.getVertice().getRadio(), super.getVertice().getRadio());
        parent.ellipse(super.getVertice().getX(), super.getVertice().getY(), super.getVertice().getRadio()-10, super.getVertice().getRadio()-10);
        
        parent.fill(0);
        parent.text(super.getNombre(), super.getVertice().getX(), super.getVertice().getY());
    }
    
}
