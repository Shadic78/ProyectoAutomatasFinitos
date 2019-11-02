package modelo;

import processing.core.PApplet;

public class EstadoNormal extends Estado
{

    public EstadoNormal(PApplet parent, Punto vertice, String nombre)
    {
        super(parent, vertice, nombre);
    }

    @Override
    public void show()
    {
        parent.fill(81, 237, 236);
        parent.strokeWeight(5);
        parent.stroke(70, 206, 205);
        parent.ellipse(super.getVertice().getX(), super.getVertice().getY(), super.getVertice().getRadio(), super.getVertice().getRadio());
        parent.fill(0);
        parent.text(super.getNombre(), super.getVertice().getX(), super.getVertice().getY());
    }
    
}
