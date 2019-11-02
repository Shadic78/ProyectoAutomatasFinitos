package controlador;

import controlP5.ControlP5;
import controlP5.Toggle;
import processing.core.PApplet;
import static processing.core.PApplet.println;
import modelo.*;
import processing.core.PFont;
import vista.*;

public class ControladorVentana extends PApplet
{
    int estadoDelPrograma = 0;
    AutomataFinito automata;
    ControlP5 ventana;
    
    @Override
    public void settings()
    {
        super.settings(); 
        fullScreen();
    }
    
    
    @Override
    public void setup()
    {
        //super.setup();
        VentanaPrincipal ventana1 = new VentanaPrincipal(this);
        
        ventana = ventana1.getButton();
        automata = new AutomataFinito(this);
        
        textAlign(CENTER, CENTER);
        textSize(14);
        noStroke();
    }
    
    @Override
    public void draw(){
    	background(232, 233, 234);
    	noStroke();
    	fill(255, 218, 143);
    	rect(width - 300, 0, 300, height);
        fill(0, 0, 0);
        
        //Etiquetas del menu
        PFont f = createFont("Georgia", 25);
        textFont(f);
        text("Menu", width-130, 15 );
        text("Agregar estados: ", width-130, 60 );
        text("Agregar Conexiones:", width-130, 260 );
        text("Ejecutar Automata:", width-130, 460);

    	
    	automata.imprimirEstados();
    	
    	fill(0);
    	text("Estado del programa:  " + estadoDelPrograma, width / 3, height - 80);
    }
   
    @Override
    public void mouseClicked() {
    	if(mouseX < width - 360) {
        	switch(estadoDelPrograma) {
	    		case 1: 
                            EstadoInicial estadoInicial = new EstadoInicial(this, new Punto(mouseX, mouseY, 100), "EstadoInicial");
                            automata.agregarEstado(estadoInicial);
                            break;
                        case 2:
                            EstadoNormal estadoNormal = new EstadoNormal(this, new Punto(mouseX, mouseY, 100), "EstadoNormal");
                            automata.agregarEstado(estadoNormal);
                            break;
                            
                        case 3:
                            EstadoFinal estadoFinal = new EstadoFinal(this, new Punto(mouseX, mouseY, 100), "EstadoFinal");
                            automata.agregarEstado(estadoFinal);
                            break;
                        default:
                            break;
        	}    		
    	}
    }
    
    public void actualizarEstadoDelPrograma(int estado) {
    	estadoDelPrograma = estado;
    	switch(estadoDelPrograma) {
    		case 1:
                    
                    ((Toggle) ventana.getController("addEstadoNormal")).setState(false);   
                    ((Toggle) ventana.getController("addEstadoFinal")).setState(false);
                    //((Toggle) ventana.getController("addEstadoInicialFinal")).setState(false);
                    ((Toggle) ventana.getController("MoverEstado")).setState(false);
                    ((Toggle) ventana.getController("BorrarEstado")).setState(false);
                    println("Estado Inicial");
                    break;

               case 2:
                    ((Toggle) ventana.getController("addEstadoInicial")).setState(false);   
                    ((Toggle) ventana.getController("addEstadoFinal")).setState(false);
                    ((Toggle) ventana.getController("addEstadoInicialFinal")).setState(false);
                    ((Toggle) ventana.getController("MoverEstado")).setState(false);
                    ((Toggle) ventana.getController("BorrarEstado")).setState(false);
                    println("Estado Normal");
                    break;
                case 3:
                    ((Toggle) ventana.getController("addEstadoInicial")).setState(false);   
                    ((Toggle) ventana.getController("addEstadoNormal")).setState(false);
                    ((Toggle) ventana.getController("addEstadoInicialFinal")).setState(false);
                    ((Toggle) ventana.getController("MoverEstado")).setState(false);
                    ((Toggle) ventana.getController("BorrarEstado")).setState(false);
                    println("Estado Final");
                    break;
                /*case 4:
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
    
    //Evento de los botones
    public void addEstadoInicial() {
         if(((Toggle)ventana.getController("addEstadoInicial")).isMousePressed()) {
        	if(((Toggle)ventana.getController("addEstadoInicial")).getState() == true) {
                    
                    actualizarEstadoDelPrograma(1);
                    
                }
        	else {
                    actualizarEstadoDelPrograma(0);
        	}    		
    	}
    	
    } 
    
    public void addEstadoNormal()
    {
        if(((Toggle)ventana.getController("addEstadoNormal")).isMousePressed()) {
        	if(((Toggle)ventana.getController("addEstadoNormal")).getState() == true) {
                    actualizarEstadoDelPrograma(2);
                }
        	else {
        		actualizarEstadoDelPrograma(0);
        	}    		
    	}
    }
    
    public void addEstadoFinal()
    {
        if(((Toggle)ventana.getController("addEstadoFinal")).isMousePressed()) {
        	if(((Toggle)ventana.getController("addEstadoFinal")).getState() == true) {
        		actualizarEstadoDelPrograma(3);
        	}   
        	else {
        		actualizarEstadoDelPrograma(0);
        	}    		
    	}
    }
    
    public void addEstadoInicialFinal()
    {
        
    }
    
    public void borrarEstado()
    {
        
    }
    
    public void moverEstado()
    {
        
    }
    
    
}
