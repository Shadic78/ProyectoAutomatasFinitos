package controlador;

import controlP5.CallbackEvent;
import controlP5.CallbackListener;
import controlP5.ControlP5;
import controlP5.Toggle;
import processing.core.PApplet;
import static processing.core.PApplet.println;
import modelo.*;
import processing.core.PFont;
import vista.*;

public class ControladorVentana extends PApplet {

    // El objeto que usaremos para crear la interfaz de usuario
    ControlP5 ventana;
    CallbackListener cb;        
    AutomataFinito automata1;
    EstadoDelPrograma controladorPrograma;
    PFont fuenteMenu;

    @Override
    public void settings() {
        fullScreen();
        //size(640, 480);
    }

    @Override
    public void setup() {
        fuenteMenu = createFont("Georgia", 23);

        VentanaPrincipal ventana1 = new VentanaPrincipal(this);
        ventana = ventana1.getButton();
        automata1 = new AutomataFinito(this);
        controladorPrograma = new EstadoDelPrograma(this, ventana);
        
        // Se declara el listener y hace que el mouse cambie al pasar sobre un objeto grafico
        cb = new CallbackListener() {
            public void controlEvent(CallbackEvent theEvent) {
                switch (theEvent.getAction()) {
                    case (ControlP5.ACTION_ENTER):
                        cursor(HAND);
                        break;
                    case (ControlP5.ACTION_LEAVE):
                    case (ControlP5.ACTION_RELEASEDOUTSIDE):
                        cursor(ARROW);
                        break;
                }
            }
        };
        ventana.addCallback(cb);       

        textAlign(CENTER, CENTER);
        textSize(14);
        noStroke();
    }

    @Override
    public void draw() {
        background(232, 233, 234);
        noStroke();
        fill(255, 218, 143);
        rect(width - 300, 0, 300, height);

        //Etiquetas del menu        
        fill(0, 0, 0);
        textFont(fuenteMenu);
        text("Menu", width - 130, 15);
        text("Agregar estados: ", width - 130, 60);
        text("Agregar Conexiones:", width - 130, 260);
        text("Ejecutar Automata:", width - 130, 460);

        automata1.imprimirConexiones();
        automata1.imprimirEstados();
        

        fill(0, 0, 0);
        textSize(16);
       
        text("Estado del programa: " + controladorPrograma.getEstadoDelPrograma(), width / 2, height - 80);
        /*Funcion que dibuja una linea de referencia para insertar una conexion*/
        if(controladorPrograma.getEstadoDelPrograma() == 8){
            fill(0, 0, 0);
            stroke(1);
            Punto puntoEstado = automata1.getListaEstados().get(controladorPrograma.getEstadoClick1()).getCoordenadas();
            line(puntoEstado.getX(), puntoEstado.getY(), mouseX, mouseY);
            
            triangle(mouseX, mouseY+6, mouseX, mouseY-6, mouseX+6, mouseY);
        }
    }

    @Override
    public void mouseClicked() {
        // Este if es para que no pongan vertices en el area donde estan los botones
        if (mouseX < width - 320) {
            // De acuerdo al estado del programa se hace una cosa u otra
            switch (controladorPrograma.getEstadoDelPrograma()) {
                case 1: // Agregar estado inicial
                    EstadoInicial estadoInicial = new EstadoInicial(this, new Punto(mouseX, mouseY), "VerticeNuevo");
                    automata1.agregarEstado(estadoInicial);
                    break;

                case 2: // Agregar estado normal
                    EstadoNormal estadoNormal = new EstadoNormal(this, new Punto(mouseX, mouseY), "VerticeNuevo");
                    automata1.agregarEstado(estadoNormal);
                    break;

                case 3: // Agregar estado final
                    EstadoFinal estadoFinal = new EstadoFinal(this, new Punto(mouseX, mouseY), "VerticeNuevo");
                    automata1.agregarEstado(estadoFinal);
                    break;

                case 4: // Agregar estado inicial-final
                    EstadoInicialFinal estadoInicialFinal = new EstadoInicialFinal(this, new Punto(mouseX, mouseY), "VerticeNuevo");
                    automata1.agregarEstado(estadoInicialFinal);
                    break;

                case 6: // Borrar estado
                    println("Borrando estado");
                    break;

                case 7: // Primer click para agregar una conexion entre estados
                    if (automata1.getEstadoClickeado() >= 0) {
                        controladorPrograma.setEstadoClick1(automata1.getEstadoClickeado());
                        controladorPrograma.actualizarEstadoDelPrograma(8);
                    }
                    break;

                case 8: // Segundo click para agregar una conexion entre estados
                    if (automata1.getEstadoClickeado() >= 0) {
                        controladorPrograma.setEstadoClick2(automata1.getEstadoClickeado());
                        automata1.agregarConexion(controladorPrograma.getEstadoClick1(), controladorPrograma.getEstadoClick2(), "a");
                        controladorPrograma.setEstadoClick1(-1);
                        controladorPrograma.setEstadoClick2(-1);
                        controladorPrograma.actualizarEstadoDelPrograma(7);
                    }
                    break;

                default:
                    println("mouseclicked estado default");
            }
        }
    }

    public void mouseDragged() {
        if (mouseX < width - 320){
            if (controladorPrograma.getEstadoDelPrograma() == 5) {
                if (!controladorPrograma.getMoviendoEstado()) {
                    controladorPrograma.setEstadoMoviendoID(automata1.getEstadoClickeado());
                }
                if (controladorPrograma.getEstadoMoviendoID() >= 0) {
                    controladorPrograma.setMoviendoEstado(true);
                    automata1.getListaEstados().get(controladorPrograma.getEstadoMoviendoID()).getCoordenadas().setX(mouseX);
                    automata1.getListaEstados().get(controladorPrograma.getEstadoMoviendoID()).getCoordenadas().setY(mouseY);
                }
            }
        }
    }

    public void mouseReleased() {
        if (controladorPrograma.getMoviendoEstado()) {
            controladorPrograma.setMoviendoEstado(false);
            controladorPrograma.setEstadoMoviendoID(-1);
        }
    }

    /********* Funcion que controla los eventos de los objetos graficos *********/
    public void controlEvent(CallbackEvent theEvent) {
        if (theEvent.getController().isMousePressed()) {
            // Si se presiono un boton toggle
            if (theEvent.getController() instanceof Toggle && theEvent.getController().getId() <= 11) {
                if (((Toggle) theEvent.getController()).getState() == true) {
                    controladorPrograma.actualizarEstadoDelPrograma(theEvent.getController().getId());
                } else {
                    controladorPrograma.actualizarEstadoDelPrograma(0);
                }

            }
        }
    }
    
}
