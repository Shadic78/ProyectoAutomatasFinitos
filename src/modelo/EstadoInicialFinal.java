package modelo;

import processing.core.PApplet;

public class EstadoInicialFinal extends Estado {

    public EstadoInicialFinal(PApplet parent, Punto vertice, String nombre) {
        super(parent, vertice, nombre);
    }

    @Override
    public void show() {
        //parent.fill(81, 237, 236);
        parent.fill(super.getColorBackground());
        parent.strokeWeight(super.getGrosorBorde());
        parent.stroke(70, 206, 205);
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), super.getRadio() * 2, super.getRadio() * 2);

        //parent.fill(81, 237, 236);
        parent.fill(super.getColorBackground());
        parent.strokeWeight(super.getGrosorBorde());
        parent.stroke(super.getColorBordes());        
        parent.triangle(super.getCoordenadas().getX() - super.getRadio() * 2, super.getCoordenadas().getY() - super.getRadio(),
                super.getCoordenadas().getX() - super.getRadio() - 5, super.getCoordenadas().getY(),
                super.getCoordenadas().getX() - super.getRadio() * 2, super.getCoordenadas().getY() + super.getRadio());
        
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), super.getRadio() * 2, super.getRadio() * 2);
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), (super.getRadio() * 2) - 10, (super.getRadio() * 2) - 10);

        //parent.fill(0);
        parent.fill(super.getColorTexto());
        parent.textSize(16);
        parent.textFont(super.getFuenteTexto());        
        parent.text(super.getNombre(), super.getCoordenadas().getX(), super.getCoordenadas().getY());
    }

}
