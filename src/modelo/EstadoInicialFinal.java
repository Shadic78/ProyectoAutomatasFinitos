
package modelo;

import processing.core.PApplet;

public class EstadoInicialFinal extends Estado{

    public EstadoInicialFinal(PApplet parent, Punto vertice, String nombre) {
        super(parent, vertice, nombre);
    }

    @Override
    public void show() {
        parent.fill(81, 237, 236);
        parent.strokeWeight(3);
        parent.stroke(70, 206, 205);
        parent.ellipse(super.getVertice().getX(), super.getVertice().getY(), super.getVertice().getRadio(), super.getVertice().getRadio());
        parent.ellipse(super.getVertice().getX(), super.getVertice().getY(), super.getVertice().getRadio()-10, super.getVertice().getRadio()-10);
       
        parent.fill(232, 233, 234);
        parent.strokeWeight(3);
        parent.triangle(super.getVertice().getX()-50, super.getVertice().getY(), super.getVertice().getX()-60, super.getVertice().getY()+30, super.getVertice().getX()-60, super.getVertice().getY()-30);

        parent.fill(0);
        parent.text(super.getNombre(), super.getVertice().getX(), super.getVertice().getY());
    }
    
}
