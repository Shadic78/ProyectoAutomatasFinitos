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
public class EstadoInicial extends Estado {
    
     public EstadoInicial(PApplet p, Punto punto, String nombre) {
        super(p, punto, nombre);
    }

    @Override
    public void show() {
       
        parent.fill(81, 237, 236);
        parent.strokeWeight(5);
        parent.stroke(70, 206, 205);
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), radio * 2, radio * 2);
       
        parent.fill(81, 237, 236);
        parent.strokeWeight(2);
        parent.triangle(super.getCoordenadas().getX() - radio * 2, super.getCoordenadas().getY() - radio, 
                super.getCoordenadas().getX() - radio - 5, super.getCoordenadas().getY(), 
                super.getCoordenadas().getX() - radio * 2, super.getCoordenadas().getY() + radio);
      
        parent.fill(0);
        parent.textSize(16);
        parent.text(super.getNombre(), super.getCoordenadas().getX(), super.getCoordenadas().getY());
    }
    
    
}
