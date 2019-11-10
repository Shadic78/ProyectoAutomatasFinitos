package modelo;

import processing.core.PApplet;

public class ConexionNormal extends Conexion{
    
    private Punto puntoMedio;
    private Punto puntoDeControl;
    private float angulo;
    private int alturaCurvatura;
    // Variables de la punta de flecha
    private float anguloFlecha;
    private int tamFlecha;

    public ConexionNormal (PApplet p, Estado origen, Estado destino, Condicion condicion) {
        super(p, origen, destino, condicion);
        this.alturaCurvatura = 40;
        this.tamFlecha = 6;
        
        // Se inicializan los puntos para posterior actualizarlos
        this.puntoMedio = new Punto(0, 0);
        this.puntoDeControl = new Punto(0, 0);

        actualizarPuntoDeControl();
        actualizarCoordenadasCondicion();
    }

    @Override    
    public void show() {
        actualizarPuntoDeControl();
        actualizarCoordenadasCondicion();
        parent.noFill();
        parent.strokeWeight(1);
        parent.stroke(0);
        parent.bezier(super.getOrigen().getCoordenadas().getX(), super.getOrigen().getCoordenadas().getY(), 
                puntoMedio.getX() + puntoDeControl.getX(), puntoMedio.getY() + puntoDeControl.getY(),
                puntoMedio.getX() + puntoDeControl.getX(), puntoMedio.getY() + puntoDeControl.getY(), 
                super.getDestino().getCoordenadas().getX(), super.getDestino().getCoordenadas().getY());
        dibujarPuntaDeFlecha();
        super.getCondicion().show();
    }

    public void actualizarPuntoDeControl() {
        /* Calcular los datos para trazar el bezier */
        // Se calcula el punto medio entre los vertices
        puntoMedio.setX( (super.getOrigen().getCoordenadas().getX() + super.getDestino().getCoordenadas().getX()) / 2 );
        puntoMedio.setY( (super.getOrigen().getCoordenadas().getY() + super.getDestino().getCoordenadas().getY()) / 2 );
        // Se calcula el angulo entre los estados y se le resta 90 grados para calcular el punto de control
        angulo = PApplet.atan2(super.getDestino().getCoordenadas().getY() - super.getOrigen().getCoordenadas().getY(), 
                super.getDestino().getCoordenadas().getX() - super.getOrigen().getCoordenadas().getX()) - PApplet.radians(90);
        // Se calcula las coordenadas de los puntos de control del bezier
        puntoDeControl.setX( (int) (alturaCurvatura * PApplet.cos(angulo)) );
        puntoDeControl.setY( (int) (alturaCurvatura * PApplet.sin(angulo)) );
    }

    public void dibujarPuntaDeFlecha() {
        /*
        * Para calcular donde se debe dibujar la flecha lo que hago
        * es calcular el angulo entre el vertice destino y el punto de control del bezier (xControl + xMedio, yControl + yMedio)
        * y de esa manera dibujo la flecha respecto a la recta que va del punto de control del bezier
        * hasta el vertice destino
        */
        anguloFlecha = PApplet.atan2(super.getDestino().getCoordenadas().getY() - (puntoDeControl.getY() + puntoMedio.getY()), 
                super.getDestino().getCoordenadas().getX() - (puntoDeControl.getX() + puntoMedio.getX()));

        parent.pushMatrix();
        parent.translate(super.getDestino().getCoordenadas().getX(), super.getDestino().getCoordenadas().getY());
        parent.rotate(anguloFlecha);

        parent.noStroke();
        parent.fill(0);
        parent.triangle(-tamFlecha -super.getDestino().getRadio() -super.getDestino().getGrosorBorde(), -tamFlecha,
                             -super.getDestino().getRadio() -super.getDestino().getGrosorBorde() + 2, 0,
                             -tamFlecha - super.getDestino().getRadio() -super.getDestino().getGrosorBorde(), tamFlecha);
        parent.popMatrix();

    }
    
    public void actualizarCoordenadasCondicion() {
        super.getCondicion().getCoordenadas().setX(puntoMedio.getX() + puntoDeControl.getX());
        super.getCondicion().getCoordenadas().setY(puntoMedio.getY() + puntoDeControl.getY());        
    }

}

