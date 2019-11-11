/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import processing.core.PApplet;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.radians;
import static processing.core.PApplet.sin;
import static processing.core.PConstants.PI;

/**
 *
 * @author Usuario
 */
public class ConexionBucle extends Conexion{
     private Punto puntoDeInicioIzquierdo;
     private Punto puntoDeInicioDerecho;    
     private Punto puntoDeControlIzquierdo;
     private Punto puntoDeControlDerecho;       
     private int alturaCurvatura;
     private int radioVertice;

    public ConexionBucle(PApplet p, Estado origen, Estado destino, Condicion condicion) {
        super(p, origen, destino, condicion);
        this.radioVertice = 24;
        this.alturaCurvatura = 50;
        // Inicializar los puntos
        this.puntoDeInicioIzquierdo = new Punto(0, 0);   
        this.puntoDeInicioDerecho = new Punto(0, 0);        
        this.puntoDeControlIzquierdo = new Punto(0, 0);
        this.puntoDeControlDerecho = new Punto(0, 0);
        calcularPuntosDeControl();
    }

    @Override
    public void show() {
        actualizarCoordenadasCondicion();
        
        parent.strokeWeight(2);
        parent.noFill();
        parent.stroke(super.getColorRelleno());
        
        parent.bezier(super.getOrigen().getCoordenadas().getX() + getPuntoDeInicioIzquierdo().getX(), super.getOrigen().getCoordenadas().getY() + getPuntoDeInicioIzquierdo().getY(), 
                super.getOrigen().getCoordenadas().getX() + getPuntoDeControlIzquierdo().getX(), super.getOrigen().getCoordenadas().getY() + getPuntoDeControlIzquierdo().getY(), 
                super.getOrigen().getCoordenadas().getX() + getPuntoDeControlDerecho().getX(), super.getOrigen().getCoordenadas().getY() + getPuntoDeControlDerecho().getY(), 
                super.getOrigen().getCoordenadas().getX() + getPuntoDeInicioDerecho().getX(), super.getOrigen().getCoordenadas().getY() + getPuntoDeInicioDerecho().getY());
        
        // Dibujar el triangulo
        parent.fill(super.getColorRelleno());
        parent.pushMatrix();
        parent.translate(super.getOrigen().getCoordenadas().getX(), super.getOrigen().getCoordenadas().getY());
        parent.rotate(radians(125));
        parent.triangle(-radioVertice- 10, -3,
                -radioVertice - 4, 6,
                -radioVertice, -2);
        parent.popMatrix();    
        
        super.getCondicion().show();
    }
     
    public void calcularPuntosDeControl() {
        // Se calculan los puntos de inicio y fin del bezier
        puntoDeInicioDerecho.setX((int) (radioVertice * cos(-PI/4)));
        puntoDeInicioDerecho.setY((int) (radioVertice * sin(-PI/4)));
        
        puntoDeInicioIzquierdo.setX((int) (radioVertice * cos(PI + PI/4)));
        puntoDeInicioIzquierdo.setY((int) (radioVertice * sin(PI + PI/4)));        
        
        // Se calculan los puntos de control del bezier
        puntoDeControlDerecho.setX(puntoDeInicioDerecho.getX());
        puntoDeControlDerecho.setY(puntoDeInicioDerecho.getY() - getAlturaCurvatura());
        
        puntoDeControlIzquierdo.setX(puntoDeInicioIzquierdo.getX());
        puntoDeControlIzquierdo.setY(puntoDeInicioIzquierdo.getY() - getAlturaCurvatura());        
    }
    
    public void actualizarCoordenadasCondicion() {
        super.getCondicion().getCoordenadas().setX(super.getOrigen().getCoordenadas().getX());
        super.getCondicion().getCoordenadas().setY(super.getOrigen().getCoordenadas().getY() + getPuntoDeControlDerecho().getY());        
    }    

    public Punto getPuntoDeInicioIzquierdo() {
        return puntoDeInicioIzquierdo;
    }

    public void setPuntoDeInicioIzquierdo(Punto puntoDeInicioIzquierdo) {
        this.puntoDeInicioIzquierdo = puntoDeInicioIzquierdo;
    }

    public Punto getPuntoDeInicioDerecho() {
        return puntoDeInicioDerecho;
    }

    public void setPuntoDeInicioDerecho(Punto puntoDeInicioDerecho) {
        this.puntoDeInicioDerecho = puntoDeInicioDerecho;
    }

    public Punto getPuntoDeControlIzquierdo() {
        return puntoDeControlIzquierdo;
    }

    public void setPuntoDeControlIzquierdo(Punto puntoDeControlIzquierdo) {
        this.puntoDeControlIzquierdo = puntoDeControlIzquierdo;
    }

    public Punto getPuntoDeControlDerecho() {
        return puntoDeControlDerecho;
    }

    public void setPuntoDeControlDerecho(Punto puntoDeControlDerecho) {
        this.puntoDeControlDerecho = puntoDeControlDerecho;
    }   

    public int getAlturaCurvatura() {
        return alturaCurvatura;
    }

    public void setAlturaCurvatura(int alturaCurvatura) {
        this.alturaCurvatura = alturaCurvatura;
    }
    
}
