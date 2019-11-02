package controlador;

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
    AutomataFinito automata1;
    EstadoDelPrograma controladorPrograma;	
    PFont fuenteMenu;    
    
    @Override
    public void settings() {
        fullScreen();
    }
   
    @Override
    public void setup() {
        fuenteMenu = createFont("Georgia", 25);
        
        VentanaPrincipal ventana1 = new VentanaPrincipal(this);
        
        ventana = ventana1.getButton();
        automata1 = new AutomataFinito(this);
        controladorPrograma = new EstadoDelPrograma(this, ventana);        
        
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
        text("Menu", width - 130, 15 );
        text("Agregar estados: ", width - 130, 60 );
        text("Agregar Conexiones:", width - 130, 260 );
        text("Ejecutar Automata:", width - 130, 460);
	
        automata1.imprimirConexiones();
        automata1.imprimirEstados();    	

        fill(0);
        text("Estado del programa: " + controladorPrograma.getEstadoDelPrograma(), width / 2, height - 80);    }
   
    @Override
    public void mouseClicked() {
        // Este if es para que no pongan vertices en el area donde estan los botones
        if (mouseX < width - 150) {
            // De acuerdo al estado del programa se hace una cosa u otra
            switch (controladorPrograma.getEstadoDelPrograma()) {
                case 1: // Agregar estado normal
                    Estado estadoNuevo = new Estado(this, mouseX, mouseY, "VerticeNuevo");
                    automata1.agregarEstado(estadoNuevo);
                    break;
                case 2: // Mover vertices
                    println("mouseclicked 2");
                    break;
                case 3: // Borrar vertices
                    break;
                case 4: // Primer click para agregar una conexion entre estados
                    if (automata1.getEstadoClickeado() >= 0) {
                        controladorPrograma.setEstadoClick1(automata1.getEstadoClickeado());
                        controladorPrograma.actualizarEstadoDelPrograma(5);
                        println("estado id: " + controladorPrograma.getEstadoClick1());
                    }
                    break;
                case 5: // Segundo click para agregar una conexion entre estados
                    if (automata1.getEstadoClickeado() >= 0) {
                        controladorPrograma.setEstadoClick2(automata1.getEstadoClickeado());
                        automata1.agregarConexion(controladorPrograma.getEstadoClick1(), controladorPrograma.getEstadoClick2(), "a");
                        println("estado id2: " + controladorPrograma.getEstadoClick2());
                        controladorPrograma.setEstadoClick1(-1);
                        controladorPrograma.setEstadoClick2(-1);
                        controladorPrograma.actualizarEstadoDelPrograma(4);
                    }
                    break;
                default:
                    println("mouseclicked default");
            }
        }
    }
    
    public void mouseDragged() {
        if (controladorPrograma.getEstadoDelPrograma() == 2) {
            if (!controladorPrograma.getMoviendoEstado()) {
                controladorPrograma.setEstadoMoviendoID(automata1.getEstadoClickeado());
            }
            if (controladorPrograma.getEstadoMoviendoID() >= 0) {
                controladorPrograma.setMoviendoEstado(true);
                automata1.listaEstados.get(controladorPrograma.getEstadoMoviendoID()).setX(mouseX);
                automata1.listaEstados.get(controladorPrograma.getEstadoMoviendoID()).setY(mouseY);
            }
        }
    }
    
    public void mouseReleased() {
        if (controladorPrograma.getMoviendoEstado()) {
            controladorPrograma.setMoviendoEstado(false);
            controladorPrograma.setEstadoMoviendoID(-1);
        }
    }
  
    /**
     * ******** EVENTOS DE LOS BOTONES *********
     */
    public void BtnAddEstadoInicial() {
        if (((Toggle) ventana.getController("BtnAddEstadoInicial")).isMousePressed()) {
            if (((Toggle) ventana.getController("BtnAddEstadoInicial")).getState() == true) {
                controladorPrograma.actualizarEstadoDelPrograma(1);
            } else {
                controladorPrograma.actualizarEstadoDelPrograma(0);
            }
        }
    }
    
    public void BtnAddEstadoNormal() {
        if (((Toggle) ventana.getController("BtnAddEstadoNormal")).isMousePressed()) {
            if (((Toggle) ventana.getController("BtnAddEstadoNormal")).getState() == true) {
                controladorPrograma.actualizarEstadoDelPrograma(2);
            } else {
                controladorPrograma.actualizarEstadoDelPrograma(0);
            }
        }
    }    
    
    public void BtnAddEstadoFinal() {
        if (((Toggle) ventana.getController("BtnAddEstadoFinal")).isMousePressed()) {
            if (((Toggle) ventana.getController("BtnAddEstadoFinal")).getState() == true) {
                controladorPrograma.actualizarEstadoDelPrograma(3);
            } else {
                controladorPrograma.actualizarEstadoDelPrograma(0);
            }
        }
    }    

     public void BtnAddEstadoInicialFinal() {
        if (((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).isMousePressed()) {
            if (((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).getState() == true) {
                controladorPrograma.actualizarEstadoDelPrograma(4);
            } else {
                controladorPrograma.actualizarEstadoDelPrograma(0);
            }
        }
    }      

    public void BtnMoverEstado() {
        if (((Toggle) ventana.getController("BtnMoverEstado")).isMousePressed()) {
            if (((Toggle) ventana.getController("BtnMoverEstado")).getState() == true) {
                controladorPrograma.actualizarEstadoDelPrograma(5);
            } else {
                controladorPrograma.actualizarEstadoDelPrograma(0);
            }
        }
    }

    public void BtnAddConexionNormal() {
        if (((Toggle) ventana.getController("BtnAddConexionNormal")).isMousePressed() && automata1.listaEstados.size() >= 2) {
            if (((Toggle) ventana.getController("BtnAddConexionNormal")).getState() == true) {
                controladorPrograma.actualizarEstadoDelPrograma(7);
            } else {
                controladorPrograma.actualizarEstadoDelPrograma(0);
            }
        }
    }
    /**
     * ****** FIN EVENTOS DE LOS BOTONES *******
     */  
    
}
