/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlP5.ControlP5;
import processing.core.PApplet;

/**
 *
 * @author Usuario
 */
public class VentanaPrincipal {
    public ControlP5 button;
    private PApplet parent;
    
    public VentanaPrincipal(PApplet p) {
        this.parent = p;
        button = new ControlP5(p);	
    	setButtons(button);
        /**	Se crean los botones **/
        
	
    }
    
    public void setButtons(ControlP5 b){
        b.addToggle("AddEstado")
    	.setPosition(parent.width - 130, 80)
    	.setSize(100,40)
    	.setLabel("Agregar estado")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER); 
    	
    	b.addToggle("AddEstadoInicial")
    	.setPosition(parent.width - 130, 140)
    	.setSize(100,40)
    	.setLabel("AddEstadoInicial")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);     

        b.addToggle("AddEstadoFinal")
    	.setPosition(parent.width - 130, 200)
    	.setSize(100,40)
    	.setLabel("AddEstadoFinal")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER); 
    }
        

    public void setParent(PApplet parent) {
        this.parent = parent;
    }
    

    public void setButton(ControlP5 button) {
        this.button = button;
    }

    public ControlP5 getButton() {
        return button;
    }

    public PApplet getParent() {
        return parent;
    }
    
}
    
