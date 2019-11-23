package controlador;

import controlP5.Button;
import controlP5.CallbackEvent;
import controlP5.CallbackListener;
import controlP5.ControlP5;
import controlP5.Textfield;
import controlP5.Toggle;
import javax.swing.JOptionPane;
import modelo.*;
import processing.core.PApplet;
import static processing.core.PApplet.println;
import processing.core.PFont;
import vista.*;

public class ControladorVentana extends PApplet {

    // El objeto que usaremos para crear la interfaz de usuario
    ControlP5 ventana;
    int cont = 0;
    PApplet parent = new PApplet();
    CallbackListener cb;
    AutomataFinito automata1;
    EstadoDelPrograma controladorPrograma;
    PFont fuenteMenu;
    int colorFlecha;

    @Override
    public void settings() {
        // fullScreen();
        size(1200, 600);
    }

    @Override
    public void setup() {
        fuenteMenu = createFont("Fuentes/OpenSans-SemiBold.ttf", 14);

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
        // Decoracion del menu
        //background(232, 233, 234);
        background(243, 243, 243);
        noStroke();
        fill(255);
        rect(width - 290, 0, 290, height);
        fill(60, 150, 215);
        // Titulo del menu
        rect(width - 290, 0, 290, 40);
        // Barra separadora del menu
        rect(width - 295, 0, 5, height);

        automata1.imprimirConexiones();
        automata1.imprimirEstados();

        fill(0, 0, 0);
        textSize(16);
        text("Estado del programa: " + controladorPrograma.getEstadoDelPrograma(), width / 2, height - 80);
        text("Borrando conexion: " + controladorPrograma.isBorrandoConexion(), width / 2, height - 60);

        /*Funcion que dibuja una linea de referencia para insertar una conexion*/
        if (controladorPrograma.getEstadoDelPrograma() == 8) {
            Punto puntoEstado = automata1.getListaEstados().get(controladorPrograma.getEstadoClick1()).getCoordenadas();
            if (controladorPrograma.isBorrandoConexion()) {
                colorFlecha = color(255, 141, 141);
            } else {
                colorFlecha = color(155, 92, 181);
            }
            dibujarFlecha(puntoEstado.getX(), puntoEstado.getY(), mouseX, mouseY, 0, 5, 0, colorFlecha, colorFlecha, true);
        }
    }

    @Override
    public void mouseClicked() {
        String nombreEstado = " ";

        // Este if es para que no pongan vertices en el area donde estan los botones
        if (mouseX < width - 310) {
            // De acuerdo al estado del programa se hace una cosa u otra
            switch (controladorPrograma.getEstadoDelPrograma()) {
                case 1: // Agregar estado inicial
                    nombreEstado = JOptionPane.showInputDialog("Ingrese nombre:");
                    if (nombreEstado != null) {
                        EstadoInicial estadoInicial = new EstadoInicial(this, new Punto(mouseX, mouseY), nombreEstado);
                        automata1.agregarEstado(estadoInicial);

                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de ingresar un nombre");
                    }

                    break;

                case 2: // Agregar estado normal
                    nombreEstado = JOptionPane.showInputDialog("Ingrese nombre:");
                    if (nombreEstado != null) {
                        EstadoNormal estadoNormal = new EstadoNormal(this, new Punto(mouseX, mouseY), nombreEstado);
                        automata1.agregarEstado(estadoNormal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de ingresar un nombre");
                    }
                    break;

                case 3: // Agregar estado final
                    nombreEstado = JOptionPane.showInputDialog("Ingrese nombre:");
                    if (nombreEstado != null) {
                        EstadoFinal estadoFinal = new EstadoFinal(this, new Punto(mouseX, mouseY), nombreEstado);
                        automata1.agregarEstado(estadoFinal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de ingresar un nombre");
                    }
                    break;

                case 4: // Agregar estado inicial-final
                    nombreEstado = JOptionPane.showInputDialog("Ingrese nombre:");
                    if (nombreEstado != null) {
                        EstadoInicialFinal estadoInicialFinal = new EstadoInicialFinal(this, new Punto(mouseX, mouseY), nombreEstado);
                        automata1.agregarEstado(estadoInicialFinal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de ingresar un nombre");
                    }
                    break;

                case 6: // Borrar estado
                    if (automata1.getEstadoClickeado() >= 0) {
                        automata1.imprimirMatriz();
                        automata1.eliminarConexiones(automata1.getEstadoClickeado());
                        System.out.println("matrizDeCondiciones Actualizado");
                        automata1.imprimirMatriz();
                    }
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
                        /**
                         * ***************************************************
                         * BORRAR CONEXION
                         * **************************************************
                         */
                        if (controladorPrograma.isBorrandoConexion()) {
                            println("Borrando conexion");
                        } /**
                         * ***************************************************
                         * AGREGAR CONEXION
                         * **************************************************
                         */
                        else {
                            try {
                                String condicion = JOptionPane.showInputDialog("Ingresa la condicion:");
                                automata1.agregarConexion(controladorPrograma.getEstadoClick1(), controladorPrograma.getEstadoClick2(), condicion);
                            } catch (NullPointerException ex) {
                                JOptionPane.showMessageDialog(null, "Error ingrese una condicion");
                            }
                        }
                        controladorPrograma.setEstadoClick1(-1);
                        controladorPrograma.setEstadoClick2(-1);
                        controladorPrograma.actualizarEstadoDelPrograma(7);
                    }
                    break;

                case 9: // Agregar conexion bucle
                    if (automata1.getEstadoClickeado() >= 0) {
                        controladorPrograma.setEstadoClick1(automata1.getEstadoClickeado());
                        String condicion = JOptionPane.showInputDialog("Ingresa la condicion:");
                        if (condicion != null) {
                            automata1.agregarConexion(controladorPrograma.getEstadoClick1(), controladorPrograma.getEstadoClick1(), condicion);
                            controladorPrograma.setEstadoClick1(-1);
                        }

                    }
                    break;

                case 12://darle click al cuando el boton paso a paso este activo
                    String palabra = ventana.get(Textfield.class, "txtPalabra").getText();//lee la palabra
                    try {
                        if (cont > 0) {//para regresar el color del estado anterior
                            automata1.getListaEstados().get(automata1.getEstadosConCoicidencia()[cont - 1]).setColorBackground(parent.color(81, 237, 236));
                        }
                        automata1.llenarEstadosConCoicidencia(palabra);//funcion que rellena un array

                        automata1.getListaEstados().get(automata1.getEstadosConCoicidencia()[cont]).setColorBackground(parent.color(251, 186, 0));//cambia el estado a color amarrillo

                        System.out.print(cont + ". " + automata1.getEstadosConCoicidencia()[cont] + " ");
                        //System.out.print(cont + " ");
                        if (cont > palabra.length()) {//para reiniciar el cont
                            cont = 0;
                            automata1.resetColor();
                            break;
                        }

                        if (automata1.getListaEstados().get(automata1.getEstadosConCoicidencia()[cont]) instanceof EstadoFinal && cont == palabra.length()) {
                            JOptionPane.showMessageDialog(null, "Palabra aceptada", "Yes", 1);

                        } else if (cont == palabra.length()) {
                            JOptionPane.showMessageDialog(null, "Palabra No Aceptada");
                        }
                        cont++;

                    } catch (IndexOutOfBoundsException ex) {
                        JOptionPane.showMessageDialog(null, "No existe estados");
                    }
                    break;

                default:
                    println("mouseclicked estado default");
            }
        }
    }

    public void mouseDragged() {
        if (mouseX < width - 310) {
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

    /* Funcion que controla los eventos de los objetos graficos*/
    public void controlEvent(CallbackEvent theEvent) {
        if (theEvent.getController().isMousePressed()) {
            // Si se presiono un boton toggle
            if (theEvent.getController() instanceof Toggle) {

                if (theEvent.getController().getId() != 10) {
                    controladorPrograma.setBorrandoConexion(false);
                }

                if (((Toggle) theEvent.getController()).getState() == true) {
                    // Si se presiono borrarConexion entonces se pasa al estado de dar el primer click pero se activa la variable borrandoConexion
                    if (theEvent.getController().getId() == 10) {
                        controladorPrograma.setBorrandoConexion(true);
                        controladorPrograma.actualizarEstadoDelPrograma(7);
                    } else {
                        controladorPrograma.actualizarEstadoDelPrograma(theEvent.getController().getId());
                    }

                } else {
                    controladorPrograma.actualizarEstadoDelPrograma(0);
                    // Si se desactivo el boton de borrar conexion
                    if (theEvent.getController().getId() == 10) {
                        controladorPrograma.setBorrandoConexion(false);
                    }
                }

            }
        }
    }

    // Dibuja una flecha entre dos puntos
    void dibujarFlecha(float x0, float y0, float x1, float y1, float tamTrianguloInicio, float tamTrianguloFinal, int desfaceFlecha, int colorTriangulo, int colorLinea, boolean dibujarLinea) {
        // Obtener el angulo entre los puntos
        float angulo = atan2(y1 - y0, x1 - x0);

        // Dibujar la linea entre los dos puntos
        if (dibujarLinea) {
            fill(colorLinea);
            stroke(colorLinea);
            strokeWeight(2);
            line(x0, y0, x1, y1);
        }

        /* Dibujar los triangulos */
        // triangulo del inicio
        if (tamTrianguloInicio > 0) {
            pushMatrix();
            translate(x0, y0);
            rotate(angulo + PI);
            fill(colorTriangulo);
            stroke(colorTriangulo);
            triangle(-tamTrianguloInicio - desfaceFlecha, -tamTrianguloInicio,
                    -tamTrianguloInicio - desfaceFlecha, tamTrianguloInicio,
                    -desfaceFlecha, 0);
            popMatrix();
        }

        // triangulo del final
        if (tamTrianguloFinal > 0) {
            pushMatrix();
            translate(x1, y1);
            rotate(angulo);
            fill(colorTriangulo);
            stroke(colorTriangulo);
            triangle(-tamTrianguloFinal - desfaceFlecha, -tamTrianguloFinal,
                    -tamTrianguloFinal - desfaceFlecha, tamTrianguloFinal,
                    -desfaceFlecha, 0);
            popMatrix();
        }
        noFill();
    }

    //Funcion que controla el boton y empieza a comprobar la cadena
    public void Submit() {
        String palabra = ventana.get(Textfield.class, "txtPalabra").getText();
        automata1.iniciarAutomata(palabra);
        print(palabra);

    }

}
