/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlP5.ControlP5;
import modelo.*;
import processing.core.PApplet;
import vista.*;

/**
 *
 * @author Usuario
 */
public class Main extends PApplet {	
	
    // El objeto que usaremos para crear la interfaz de usuario
	ControlP5 ventana;
	boolean AddEstado = false;
	boolean AddEstadoInicial = false;
	AutomataFinito automata1;
	
	/* Variable que controla el estado global del programa
	 * 0 - Default
	 * 1 - Agregar estados
	 * 2 - Mover estados
	 */
	int estadoDelPrograma = 0;	
	
    public static void main(String[] args) {
        PApplet.main("controlador.Main");
    }

    public void settings(){
    	//size(640, 480);
    	fullScreen();
    }
    
    public void setup() {
    	// Se crea un objeto VentanaPrincipal que es la que contiene
    	// los elementos graficos con los que interactuara el usuario
    	VentanaPrincipal ventana1 = new VentanaPrincipal(this);
    	// Se asigna la ventana
    	ventana = ventana1.getButton();
    	
    	//automata1 = new AutomataFinito(this);
    	
    	textAlign(CENTER, CENTER);
    	textSize(14);
    	noStroke();    	
    }
    
    public void draw(){
      
        
    	background(232, 233, 234);
    	noStroke();
    	fill(255, 218, 143);
        
    	rect(width - 300, 0, 300, height);
        fill(50, 50 ,50);
        
        //Etiquetas para el menu
        fill(0, 0, 0);
        text("Menu", width-130, 40 );
        text("Agregar estados: ", width-130, 65 );
        text("Agregar Conexiones:", width-130, 260 );
    	
    	//automata1.imprimirEstados();
    	
    	fill(0);
    	text("Estado del programa: " + estadoDelPrograma, width / 2, height - 80);
    }
    
}