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
public class EstadoInicial extends Estado{
     public EstadoInicial(PApplet p, Punto vertice, String nombre) {
        super(p, vertice, nombre);
    }

    @Override
    public void show() {
       
        parent.fill(81, 237, 236);
        parent.strokeWeight(5);
        parent.stroke(70, 206, 205);
        parent.ellipse(super.getVertice().getX(), super.getVertice().getY(), super.getVertice().getRadio(), super.getVertice().getRadio());
       
        parent.fill(232, 233, 234);
        parent.strokeWeight(3);
        parent.triangle(super.getVertice().getX()-50, super.getVertice().getY(), super.getVertice().getX()-60, super.getVertice().getY()+30, super.getVertice().getX()-60, super.getVertice().getY()-30);
      
        parent.fill(0);
        parent.text(super.getNombre(), super.getVertice().getX(), super.getVertice().getY());
    }
    
    
}
