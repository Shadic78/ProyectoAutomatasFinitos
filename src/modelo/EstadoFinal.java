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
public class EstadoFinal extends Estado {
    
    public EstadoFinal(PApplet p, Punto punto, String nombre) {
        super(p, punto, nombre);
    }

    @Override
    public void show() {
        parent.fill(81, 237, 236);
        parent.strokeWeight(3);
        parent.stroke(70, 206, 205);
       
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), radio * 2, radio * 2);
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), (radio * 2) - 10, (radio * 2) - 10);
        
        parent.fill(0);
        parent.textSize(16);        
        parent.text(super.getNombre(), super.getCoordenadas().getX(), super.getCoordenadas().getY());
    }
    
}
