package controlador;

import controlP5.ControlP5;
import controlP5.Toggle;
import processing.core.PApplet;
import static processing.core.PApplet.println;
import modelo.*;
import processing.core.PFont;
import vista.*;

public class ControladorVentana extends PApplet {

    int estadoDelPrograma = 0;
    AutomataFinito automata;
    ControlP5 ventana;
    public ControlP5 cp5;

    @Override
    public void settings() {
        super.settings();
        fullScreen();
    }

    @Override
    public void setup() {
        super.setup();
        VentanaPrincipal ventana1 = new VentanaPrincipal(this);

        ventana = ventana1.getButton();
        automata = new AutomataFinito(this);
        textAlign(CENTER, CENTER);
        textSize(14);
        noStroke();
    }

    @Override
    public void draw() {
        background(232, 233, 234);
        noStroke();
        fill(255, 218, 143);
        rect(width - 350, 0, 350, height);
        fill(0, 0, 0);
        //Etiquetas del menu
        PFont f = createFont("Georgia", 20);
        textFont(f);
        text("Menu", width - 170, 20);
        text("Estados ", width - 300, 50);
        text("Conexiones", width - 280, 260);
        text("Ejecutar Automata", width - 250, 420);

        automata.imprimirEstados();

        fill(0);
        text("Estado del programa:  " + estadoDelPrograma, width / 3, height - 80);
    }

    @Override
    public void mouseClicked() {
        if (mouseX < width - 400) {
            switch (estadoDelPrograma) {
                case 1:
                    break;
                case 2:
                    EstadoNormal estadoNormal = new EstadoNormal(this, new Punto(mouseX, mouseY, 60), "VerticeNuevo");
                    automata.agregarEstado(estadoNormal);
                    break;
                default:
                    break;
            }
        }
    }

    public void actualizarEstadoDelPrograma(int estado) {
        estadoDelPrograma = estado;
        switch (estadoDelPrograma) {
            /*case 1:
                    
                    ((Toggle) ventana.getController("addEstadoNormal")).setState(false);   
                    ((Toggle) ventana.getController("addEstadoFinal")).setState(false);
                    ((Toggle) ventana.getController("addEstadoInicialFinal")).setState(false);
                    ((Toggle) ventana.getController("moverEstado")).setState(false);
                    ((Toggle) ventana.getController("borrarEstado")).setState(false);
                    println("Estado Inicial");
                    break;
             */
            case 2:
                ((Toggle) ventana.getController("EstadoInicial")).setState(false);
                ((Toggle) ventana.getController("EstadoFinal")).setState(false);
                ((Toggle) ventana.getController("EstadoInicialFinal")).setState(false);
                ((Toggle) ventana.getController("MoverEstado")).setState(false);
                ((Toggle) ventana.getController("BorrarEstado")).setState(false);
                println("Estado Normal");
                break;
            /*case 3:
                    ((Toggle) ventana.getController("addEstadoInicial")).setState(false);   
                    ((Toggle) ventana.getController("addEstadoNormal")).setState(false);
                    ((Toggle) ventana.getController("addEstadoInicialFinal")).setState(false);
                    ((Toggle) ventana.getController("moverEstado")).setState(false);
                    ((Toggle) ventana.getController("borrarEstado")).setState(false);
                    println("Estado Final");
                    break;
                case 4:
                    ((Toggle) ventana.getController("addEstadoInicial")).setState(false);   
                    ((Toggle) ventana.getController("addEstadoNormal")).setState(false);
                    ((Toggle) ventana.getController("addEstadoFinal")).setState(false);
                    ((Toggle) ventana.getController("moverEstado")).setState(false);
                    ((Toggle) ventana.getController("borrarEstado")).setState(false);
                    println("Estado Inicial-Final");
                    break;
                case 5:
                    ((Toggle) ventana.getController("addEstadoInicial")).setState(false);   
                    ((Toggle) ventana.getController("addEstadoNormal")).setState(false);
                    ((Toggle) ventana.getController("addEstadoFinal")).setState(false);
                    ((Toggle) ventana.getController("addEstadoInicialFinal")).setState(false);
                    ((Toggle) ventana.getController("borrarEstado")).setState(false);
                    println("Moviendo Estado");
                    break;
                case 6:
                    ((Toggle) ventana.getController("addEstadoInicial")).setState(false);   
                    ((Toggle) ventana.getController("addEstadoNormal")).setState(false);
                    ((Toggle) ventana.getController("addEstadoFinal")).setState(false);
                    ((Toggle) ventana.getController("addEstadoInicialFinal")).setState(false);
                    ((Toggle) ventana.getController("moverEstado")).setState(false);
                    println("Estado Borrado");
                    break;*/
            default:
                println("Estado default");
                break;
        }
    }

    public void addEstadoInicial() {

    }

    public void addEstadoNormal() {
        if (((Toggle) ventana.getController("addEstadoNormal")).isMousePressed()) {
            if (((Toggle) ventana.getController("addEstadoNormal")).getState() == true) {
                actualizarEstadoDelPrograma(2);
            } else {
                actualizarEstadoDelPrograma(0);
            }
        }
    }

    public void addEstadoFinal() {
        if (((Toggle) ventana.getController("EstadoFinal")).isMousePressed()) {
            if (((Toggle) ventana.getController("EstadoFinal")).getState() == true) {
                actualizarEstadoDelPrograma(3);
            } else {
                actualizarEstadoDelPrograma(0);
            }
        }
    }

    public void addEstadoInicialFinal() {

    }

    public void borrarEstado() {

    }

    public void moverEstado() {

    }

}
