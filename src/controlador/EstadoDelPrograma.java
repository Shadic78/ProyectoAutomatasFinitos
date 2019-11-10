package controlador;

import controlP5.ControlP5;
import controlP5.Toggle;
import java.util.List;
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
     * 10 - 
     * 11 - 
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
    private boolean borrandoConexion;

    public EstadoDelPrograma(PApplet p, ControlP5 ventana) {
        this.parent = p;
        this.ventana = ventana;
        // Para evitar problemas al mover estados por primera vez
        this.moviendoEstado = false;
        this.estadoMoviendoID = -1;
        this.borrandoConexion = false;
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
        
        // Obtiene una lista de los botones que hay en ventana
        List listaBotones = ventana.getAll(Toggle.class);    
        /* 
        Desactiva los botones que no hayas presionado de acuerdo al estado del programa,
        si el estado del programa es cero o 8 no desactiva nada, debido a que si el estado es cero
        no hay nada que desactivar y si el estado es 8 significa que estas agregando una conexion 
        y ya diste el primer click, por lo que el boton AgregarConexion debe mantenerse encendido
        */
        if(estadoDelPrograma != 0 && estadoDelPrograma != 8) {
            for(int i = 0; i < listaBotones.size() ; i++) {
                if( ((Toggle)listaBotones.get(i)).getId() != estadoDelPrograma) {
                    // Si el estado es 10 y no se esta borrando una conexion entonces se desactiva el btn de borrar conexion
                    if( ((Toggle)listaBotones.get(i)).getId() == 10 ) {
                        if(!borrandoConexion) {
                            ((Toggle)listaBotones.get(i)).setState(false);                                                    
                        }
                    }
                    else {
                        ((Toggle)listaBotones.get(i)).setState(false);                                              
                    }
                }
                // Si el estado es 7 y se esta borrando una conexion se desactiva el btn de agregar conexion
                else if(((Toggle)listaBotones.get(i)).getId() == 7 && borrandoConexion) {
                    ((Toggle)listaBotones.get(i)).setState(false);                                           
                }
            }            
        }

    }

    public boolean isBorrandoConexion() {
        return borrandoConexion;
    }

    public void setBorrandoConexion(boolean borrandoConexion) {
        this.borrandoConexion = borrandoConexion;
    }
        
}
