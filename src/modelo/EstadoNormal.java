package modelo;

import processing.core.PApplet;

public class EstadoNormal extends Estado {

    public EstadoNormal(PApplet parent, Punto punto, String nombre) {
        super(parent, punto, nombre);
    }

    @Override
    public void show() {
        parent.fill(81, 237, 236);
        parent.strokeWeight(5);
        parent.stroke(70, 206, 205);
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), radio * 2, radio * 2);

        parent.fill(0);
        parent.textSize(16);        
        parent.text(super.getNombre(), super.getCoordenadas().getX(), super.getCoordenadas().getY());
    }

}
