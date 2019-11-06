package modelo;

import processing.core.PApplet;

public class EstadoInicialFinal extends Estado {

    public EstadoInicialFinal(PApplet parent, Punto vertice, String nombre) {
        super(parent, vertice, nombre);
    }

    @Override
    public void show() {
        parent.fill(81, 237, 236);
        parent.strokeWeight(grosorBorde - 2);
        parent.stroke(70, 206, 205);
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), radio * 2, radio * 2);

        parent.fill(81, 237, 236);
        parent.strokeWeight(grosorBorde - 3);
        parent.triangle(super.getCoordenadas().getX() - radio * 2, super.getCoordenadas().getY() - radio,
                super.getCoordenadas().getX() - radio - 5, super.getCoordenadas().getY(),
                super.getCoordenadas().getX() - radio * 2, super.getCoordenadas().getY() + radio);

        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), radio * 2, radio * 2);
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), (radio * 2) - 10, (radio * 2) - 10);

        parent.fill(0);
        parent.textSize(16);
        parent.text(super.getNombre(), super.getCoordenadas().getX(), super.getCoordenadas().getY());
    }

}
