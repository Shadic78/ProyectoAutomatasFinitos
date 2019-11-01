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
public class VentanaPrincipal extends PApplet{
    public ControlP5 button;
    private PApplet parent;
    
    public VentanaPrincipal(PApplet p) {
        this.parent = p;
        button = new ControlP5(p);	
    	setButtons(button);
        /**	Se crean los botones **/
        
	
    }
    
    public void setButtons(ControlP5 b){
        
        b.addToggle("Estadoinicial")
    	.setPosition(parent.width - 250, 80)
    	.setSize(100,40)
    	.setLabel("Estado inicial")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER); 
    	
    	b.addToggle("EstadoNormal")
    	.setPosition(parent.width - 130, 80)
    	.setSize(100,40)
    	.setLabel("Estado normal")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);     

        b.addToggle("EstadoFinal")
    	.setPosition(parent.width - 250, 130)
    	.setSize(100,40)
    	.setLabel("Estado final")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER); 
        
        b.addToggle("BorrarEstado")
        .setPosition(parent.width - 130, 130)
    	.setSize(100,40)
    	.setLabel("Borrar Estado")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
        
         b.addToggle("MoverEstado")
        .setPosition(parent.width - 190, 180)
    	.setSize(100,40)
    	.setLabel("Mover Estado")
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
    