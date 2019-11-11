package modelo;

import processing.core.PApplet;

public class EstadoNormal extends Estado {

    public EstadoNormal(PApplet parent, Punto punto, String nombre) {
        super(parent, punto, nombre);
    }

    @Override
    public void show() {
        //parent.fill(81, 237, 236);
        parent.fill(super.getColorBackground());
        parent.strokeWeight(super.getGrosorBorde());
        //parent.stroke(70, 206, 205);
        parent.stroke(super.getColorBordes());
        parent.ellipse(super.getCoordenadas().getX(), super.getCoordenadas().getY(), super.getRadio() * 2, super.getRadio() * 2);

        //parent.fill(0);
        parent.fill(super.getColorTexto());
        parent.textSize(16);     
        parent.textFont(super.getFuenteTexto());        
        parent.text(super.getNombre(), super.getCoordenadas().getX(), super.getCoordenadas().getY());
    }

}
