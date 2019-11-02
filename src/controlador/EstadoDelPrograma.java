package controlador;

import controlP5.ControlP5;
import controlP5.Toggle;
import processing.core.PApplet;

public class EstadoDelPrograma {
    /* Variable que controla el estado global del programa
     * 0 - Default
     * 1 - Agregar estado inicial
     * 2 - Agregar estado normal
     * 3 - Agregar estado final
     * 4 - Agregar estado inicial-final
     * 5 - Mover estados
     * 6 - Borrar estados
     * 7 - Agregar conexion normal (Al dar click a un estado el estado del programa cambia a 8)
     * 8 - (Dar click en el segundo estado para agregar una conexion)
     * 9 - Agregar conexion bucle    
     * 10 - Borrar conexion (Primer click)
     * 11 - Borrar conexion (segundo click)
     */
    private int estadoDelPrograma = 0;
	
    private PApplet parent;
    private ControlP5 ventana;
    // Variables para almacenar los estados a los que se les dio click
    private int estadoClick1 = -1;
    private int estadoClick2 = -1;
    // Variables para saber si se esta moviendo un estado y cual es
    private boolean moviendoEstado;
    private int estadoMoviendoID;

    public EstadoDelPrograma(PApplet p, ControlP5 ventana) {
        this.parent = p;
        this.ventana = ventana;
        // Para evitar problemas al mover estados por primera vez
        this.moviendoEstado = false;
        this.estadoMoviendoID = -1;		
    }
		
    public int getEstadoClick1() {
        return estadoClick1;
    }

    public void setEstadoClick1(int estadoClick1) {
        this.estadoClick1 = estadoClick1;
    }

    public int getEstadoClick2() {
        return estadoClick2;
    }

    public void setEstadoClick2(int estadoClick2) {
        this.estadoClick2 = estadoClick2;
    }

    public int getEstadoDelPrograma() {
        return estadoDelPrograma;
    }

    public void setEstadoDelPrograma(int estadoDelPrograma) {
        this.estadoDelPrograma = estadoDelPrograma;
    }

    public boolean getMoviendoEstado() {
        return moviendoEstado;
    }

    public void setMoviendoEstado(boolean moviendoEstado) {
        this.moviendoEstado = moviendoEstado;
    }

    public int getEstadoMoviendoID() {
        return estadoMoviendoID;
    }

    public void setEstadoMoviendoID(int estadoMoviendoID) {
        this.estadoMoviendoID = estadoMoviendoID;
    }

    // De acuerdo al estado del programa desactiva los otros botones
    public void actualizarEstadoDelPrograma(int estado) {
        estadoDelPrograma = estado;
        // Desactiva los botones que no hayas presionado de acuerdo al estado del programa
        switch(estadoDelPrograma) {
            case 1:
                //((Toggle) ventana.getController("BtnAddEstadoInicial")).setState(false);                
                ((Toggle) ventana.getController("BtnAddEstadoNormal")).setState(false);
        	((Toggle) ventana.getController("BtnAddEstadoFinal")).setState(false);       
        	((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).setState(false);           		
        	((Toggle) ventana.getController("BtnMoverEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnBorrarEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionNormal")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionBucle")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddBorrarConexion")).setState(false);      
        	((Toggle) ventana.getController("BtnAddPasoEjecucion")).setState(false);           		
        	PApplet.println("Estado 1");        		
        	break;
                
            case 2: 
                ((Toggle) ventana.getController("BtnAddEstadoInicial")).setState(false);                
                //((Toggle) ventana.getController("BtnAddEstadoNormal")).setState(false);
        	((Toggle) ventana.getController("BtnAddEstadoFinal")).setState(false);       
        	((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).setState(false);           		
        	((Toggle) ventana.getController("BtnMoverEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnBorrarEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionNormal")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionBucle")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddBorrarConexion")).setState(false);      
        	((Toggle) ventana.getController("BtnAddPasoEjecucion")).setState(false);       		
        	PApplet.println("Estado 2");        		
        	break;
                
            case 3:
                ((Toggle) ventana.getController("BtnAddEstadoInicial")).setState(false);                
                ((Toggle) ventana.getController("BtnAddEstadoNormal")).setState(false);
        	//((Toggle) ventana.getController("BtnAddEstadoFinal")).setState(false);       
        	((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).setState(false);           		
        	((Toggle) ventana.getController("BtnMoverEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnBorrarEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionNormal")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionBucle")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddBorrarConexion")).setState(false);      
        	((Toggle) ventana.getController("BtnAddPasoEjecucion")).setState(false);   
        	PApplet.println("Estado 2");        		                
    	break;
        
            case 4:
                ((Toggle) ventana.getController("BtnAddEstadoInicial")).setState(false);                
                ((Toggle) ventana.getController("BtnAddEstadoNormal")).setState(false);
        	((Toggle) ventana.getController("BtnAddEstadoFinal")).setState(false);       
        	//((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).setState(false);           		
        	((Toggle) ventana.getController("BtnMoverEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnBorrarEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionNormal")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionBucle")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddBorrarConexion")).setState(false);      
        	((Toggle) ventana.getController("BtnAddPasoEjecucion")).setState(false);   
        	PApplet.println("Estado 4");    			
    	break;
        
            case 5:
                ((Toggle) ventana.getController("BtnAddEstadoInicial")).setState(false);                
                ((Toggle) ventana.getController("BtnAddEstadoNormal")).setState(false);
        	((Toggle) ventana.getController("BtnAddEstadoFinal")).setState(false);       
        	((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).setState(false);           		
        	//((Toggle) ventana.getController("BtnMoverEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnBorrarEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionNormal")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionBucle")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddBorrarConexion")).setState(false);      
        	((Toggle) ventana.getController("BtnAddPasoEjecucion")).setState(false);   
        	PApplet.println("Estado 5");        		                
                break;
                
            case 6:
                ((Toggle) ventana.getController("BtnAddEstadoInicial")).setState(false);                
                ((Toggle) ventana.getController("BtnAddEstadoNormal")).setState(false);
        	((Toggle) ventana.getController("BtnAddEstadoFinal")).setState(false);       
        	((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).setState(false);           		
        	((Toggle) ventana.getController("BtnMoverEstado")).setState(false);           		
        	//((Toggle) ventana.getController("BtnBorrarEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionNormal")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionBucle")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddBorrarConexion")).setState(false);      
        	((Toggle) ventana.getController("BtnAddPasoEjecucion")).setState(false);  
        	PApplet.println("Estado 6");        		                
                break;
                
            case 7:
                ((Toggle) ventana.getController("BtnAddEstadoInicial")).setState(false);                
                ((Toggle) ventana.getController("BtnAddEstadoNormal")).setState(false);
        	((Toggle) ventana.getController("BtnAddEstadoFinal")).setState(false);       
        	((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).setState(false);           		
        	((Toggle) ventana.getController("BtnMoverEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnBorrarEstado")).setState(false);           		
        	//((Toggle) ventana.getController("BtnAddConexionNormal")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionBucle")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddBorrarConexion")).setState(false);      
        	((Toggle) ventana.getController("BtnAddPasoEjecucion")).setState(false); 
        	PApplet.println("Estado 7");        		                
                break;
                
            case 9:
                ((Toggle) ventana.getController("BtnAddEstadoInicial")).setState(false);                
                ((Toggle) ventana.getController("BtnAddEstadoNormal")).setState(false);
        	((Toggle) ventana.getController("BtnAddEstadoFinal")).setState(false);       
        	((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).setState(false);           		
        	((Toggle) ventana.getController("BtnMoverEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnBorrarEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionNormal")).setState(false);           		
        	//((Toggle) ventana.getController("BtnAddConexionBucle")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddBorrarConexion")).setState(false);      
        	((Toggle) ventana.getController("BtnAddPasoEjecucion")).setState(false); 
        	PApplet.println("Estado 9");        		                
                break;  
                
            case 10:
                ((Toggle) ventana.getController("BtnAddEstadoInicial")).setState(false);                
                ((Toggle) ventana.getController("BtnAddEstadoNormal")).setState(false);
        	((Toggle) ventana.getController("BtnAddEstadoFinal")).setState(false);       
        	((Toggle) ventana.getController("BtnAddEstadoInicialFinal")).setState(false);           		
        	((Toggle) ventana.getController("BtnMoverEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnBorrarEstado")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionNormal")).setState(false);           		
        	((Toggle) ventana.getController("BtnAddConexionBucle")).setState(false);           		
        	//((Toggle) ventana.getController("BtnAddBorrarConexion")).setState(false);      
        	((Toggle) ventana.getController("BtnAddPasoEjecucion")).setState(false); 
        	PApplet.println("Estado 10");        		                
                break;                
            default:
                PApplet.println("Estado default");
        }
    }
    
}
