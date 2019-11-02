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
       
        parent.fill(232, 233, 234);
        parent.strokeWeight(3);
        parent.triangle(super.getCoordenadas().getX() - 50, super.getCoordenadas().getY(), 
                super.getCoordenadas().getX() - 60, super.getCoordenadas().getY() + 30, 
                super.getCoordenadas().getX() - 60, super.getCoordenadas().getY() - 30);
      
        parent.fill(0);
        parent.text(super.getNombre(), super.getCoordenadas().getX(), super.getCoordenadas().getX());
    }
    
    
}
