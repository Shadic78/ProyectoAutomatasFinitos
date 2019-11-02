package vista;

import controlP5.ControlP5;
import processing.core.PApplet;

/**
 *
 * @author Usuario
 */
public class VentanaPrincipal{
    public ControlP5 button;
    private PApplet parent;

    public VentanaPrincipal(PApplet p)
    {
        this.parent = p;
        button = new ControlP5(p);
        setButtons(button);
        /**
         * Se crean los botones *
         */
    }
    
    public void setButtons(ControlP5 b){
        //Estados
        b.addToggle("addEstadoInicial")
    	.setPosition(parent.width - 260, 80)
    	.setSize(100,40)
    	.setLabel("Estado inicial")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER); 
    	
    	b.addToggle("addEstadoNormal")
    	.setPosition(parent.width - 140, 80)
    	.setSize(100,40)
    	.setLabel("Estado Normal")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);     

        b.addToggle("addEstadoFinal")
    	.setPosition(parent.width - 260, 140)
    	.setSize(100,40)
    	.setLabel("Estado Final")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
        
        b.addToggle("addEstadoInicialFinal")
    	.setPosition(parent.width - 140, 140)
    	.setSize(100,40)
    	.setLabel("Estado Inicial-Final")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
        
        b.addToggle("addMoverEstado")
    	.setPosition(parent.width - 260, 200)
    	.setSize(100,40)
    	.setLabel("Mover Estados")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
        
        b.addToggle("addBorrarEstado")
    	.setPosition(parent.width - 140, 200)
    	.setSize(100,40)
    	.setLabel("Borrar Estado")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);        
 
         b.addToggle("ConexionNormal")
        .setPosition(parent.width - 250, 290)
    	.setSize(100,40)
    	.setLabel("Conexión Normal")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
         
         b.addToggle("ConexionBucle")
        .setPosition(parent.width - 130, 290)
    	.setSize(100,40)
    	.setLabel("Conexión bucle")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
         
          b.addToggle("BorrarConexion")
        .setPosition(parent.width - 190, 350)
    	.setSize(100,40)
    	.setLabel("Borrar Conexi" + (char)162 + "n")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);
         
          b.addToggle("PasoEjecucion")
        .setPosition(parent.width - 190, 580)
    	.setSize(100,40)
    	.setLabel("Paso A Paso")
    	.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER); 
          
          
        b.addTextfield("Escribe tu palabra").setPosition(parent.width-220, 500)
        .setSize(130,35).setAutoClear(true);
        b.addBang("Iniciar/Detener").setPosition(parent.width-80, 500).setSize(40, 35);
    }

    public void setParent(PApplet parent)
    {
        this.parent = parent;
    }

    public void setButton(ControlP5 button)
    {
        this.button = button;
    }

    public ControlP5 getButton()
    {
        return button;
    }

    public PApplet getParent()
    {
        return parent;
    }

}
