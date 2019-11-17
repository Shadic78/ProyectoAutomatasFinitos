package vista;

import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 *
 * @author Usuario
 */
public class VentanaPrincipal {

    public ControlP5 button;
    private PApplet parent;
    private int widthBtn;
    private int heightBtn;
    private PFont fuenteMenu;

    public VentanaPrincipal(PApplet p) {
        this.parent = p;
        button = new ControlP5(p);
        // Tamanio de los botones
        this.widthBtn = 110;
        this.heightBtn = 40;
        this.fuenteMenu = parent.createFont("Fuentes/OpenSans-SemiBold.ttf", 14);
        // Se crean los botones
        setButtons(button, widthBtn, heightBtn);
    }

    public void setButtons(ControlP5 b, int widthBtn, int heightBtn) {
        // Etiquetas
        b.addLabel("Menu")
                .setColor(parent.color(255, 255, 255))
                .setPosition(parent.width - (290 / 2) - 25, 10)
                .setFont(parent.createFont("Fuentes/OpenSans-SemiBold.ttf", 16));

        b.addLabel("Agregar estados")
                .setColor(parent.color(159, 162, 166))
                .setPosition(parent.width - (290 / 2) - 55, 50)
                .setFont(fuenteMenu);

        b.addLabel("Agregar conexiones")
                .setColor(parent.color(159, 162, 166))
                .setPosition(parent.width - (290 / 2) - 66, 262)
                .setFont(fuenteMenu);

        b.addLabel("Ejecutar automata")
                .setColor(parent.color(159, 162, 166))
                .setPosition(parent.width - (290 / 2) - 67, 410)
                .setFont(fuenteMenu);

        // Botones
        b.addToggle("BtnAddEstadoInicial")
                .setPosition(parent.width - 260, 80)
                .setSize(widthBtn, heightBtn)
                .setLabel("Estado inicial")
                .setId(1)
                .setImages(parent.loadImage("EstadoInicial1.png"), parent.loadImage("EstadoInicial2.png"), parent.loadImage("EstadoInicial2.png"))
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("BtnAddEstadoNormal")
                .setPosition(parent.width - 140, 80)
                .setSize(widthBtn, heightBtn)
                .setLabel("Estado Normal")
                .setId(2)
                .setImages(parent.loadImage("EstadoNormal1.png"), parent.loadImage("EstadoNormal2.png"), parent.loadImage("EstadoNormal2.png"))
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("BtnAddEstadoFinal")
                .setPosition(parent.width - 260, 140)
                .setSize(widthBtn, heightBtn)
                .setLabel("Estado Final")
                .setId(3)
                .setImages(parent.loadImage("EstadoFinal1.png"), parent.loadImage("EstadoFinal2.png"), parent.loadImage("EstadoFinal2.png"))
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("BtnAddEstadoInicialFinal")
                .setPosition(parent.width - 140, 140)
                .setSize(widthBtn, heightBtn)
                .setLabel("Estado Inicial-Final")
                .setId(4)
                .setImages(parent.loadImage("EstadoInicialFinal1.png"), parent.loadImage("EstadoInicialFinal2.png"), parent.loadImage("EstadoInicialFinal2.png"))
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("BtnMoverEstado")
                .setPosition(parent.width - 260, 200)
                .setSize(widthBtn, heightBtn)
                .setLabel("Mover Estados")
                .setId(5)
                .setImages(parent.loadImage("MoverEstado1.png"), parent.loadImage("MoverEstado2.png"), parent.loadImage("MoverEstado2.png"))
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("BtnBorrarEstado")
                .setPosition(parent.width - 140, 200)
                .setSize(widthBtn, heightBtn)
                .setLabel("Borrar Estado")
                .setId(6)
                .setImages(parent.loadImage("BorrarEstado1.png"), parent.loadImage("BorrarEstado2.png"), parent.loadImage("BorrarEstado2.png"))
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("BtnAddConexionNormal")
                .setPosition(parent.width - 260, 290)
                .setSize(widthBtn, heightBtn)
                .setLabel("Conexion Normal")
                .setId(7)
                .setImages(parent.loadImage("ConexionNormal1.png"), parent.loadImage("ConexionNormal2.png"), parent.loadImage("ConexionNormal2.png"))
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("BtnAddConexionBucle")
                .setPosition(parent.width - 140, 290)
                .setSize(widthBtn, heightBtn)
                .setLabel("Conexion bucle")
                .setId(9)
                .setImages(parent.loadImage("ConexionBucle1.png"), parent.loadImage("ConexionBucle2.png"), parent.loadImage("ConexionBucle2.png"))
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("BtnAddBorrarConexion")
                .setPosition(parent.width - 200, 350)
                .setSize(widthBtn, heightBtn)
                .setLabel("Borrar Conexion")
                .setId(10)
                .setImages(parent.loadImage("BorrarConexion1.png"), parent.loadImage("BorrarConexion2.png"), parent.loadImage("BorrarConexion2.png"))
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        /**
         * ** Objetos para ejecutar el automata ***
         */
        b.addTextfield("txtPalabra")
                .setPosition(parent.width - 200, 440)
                .setSize(110, 40)
                .setColorBackground(parent.color(255, 255, 255))
                .setColor(parent.color(159, 162, 166))
                .setFont(fuenteMenu)
                .setColorCursor(parent.color(159, 162, 166))
                .setLabelVisible(false)
                .setAutoClear(true);

        b.addBang("Submit")
                .setPosition(parent.width - 80, 440)
                .setSize(40, 40)
                .setColorCaptionLabel(parent.color(159, 162, 166))
                .setColorBackground(parent.color(60, 150, 215));

        b.addToggle("BtnAddPasoSiguiente")
                .setPosition(parent.width - 200, 490)
                .setSize(widthBtn, heightBtn)
                .setLabel("Paso siguiente")
                .setId(12)
                .setImages(parent.loadImage("PasoSiguiente1.png"), parent.loadImage("PasoSiguiente2.png"), parent.loadImage("PasoSiguiente2.png"))
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
