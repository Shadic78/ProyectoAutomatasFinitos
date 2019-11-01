package vista;

import controlP5.ControlP5;
import processing.core.PApplet;

public class VentanaPrincipal{
    public ControlP5 cp5;
    private PApplet parent;
    
    public VentanaPrincipal(PApplet p){
        this.parent = p;
        
        cp5 = new ControlP5(p);
        
        //Estados
        cp5.addToggle("addEstadoInicial")
    	.setPosition(parent.width - 260, 80)
    	.setSize(100,40)
    	.setLabel("Estado inicial")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER); 
    	
    	cp5.addToggle("addEstadoNormal")
    	.setPosition(parent.width - 140, 80)
    	.setSize(100,40)
    	.setLabel("Estado Normal")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);     

        cp5.addToggle("addEstadoFinal")
    	.setPosition(parent.width - 260, 140)
    	.setSize(100,40)
    	.setLabel("Estado Final")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
        
        cp5.addToggle("addEsatdoInicialFinal")
    	.setPosition(parent.width - 140, 140)
    	.setSize(100,40)
    	.setLabel("Estado Inicial-Final")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
        
        cp5.addToggle("addMoverEstado")
    	.setPosition(parent.width - 260, 200)
    	.setSize(100,40)
    	.setLabel("Mover Estados")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
        
        cp5.addToggle("addBorarEstado")
    	.setPosition(parent.width - 140, 200)
    	.setSize(100,40)
    	.setLabel("Borrar Estado")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
    
        //Conexiones
        
        //Ejecutar Automata
    }
    
    public ControlP5 getControlVentanaPrincipal()
    {
        return this.cp5;
    }
    
    
    
}
