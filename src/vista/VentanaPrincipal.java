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
        /**
         * Se crean los botones *
         */
    }

    public void setButtons(ControlP5 b) {
        b.addToggle("addEstadoInicial")
                .setPosition(parent.width - 340, 80)
                .setSize(100, 40)
                .setLabel("Estado inicial")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("addEstadoNormal")
                .setPosition(parent.width - 225, 80)
                .setSize(100, 40)
                .setLabel("Estado normal")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("addEstadoFinal")
                .setPosition(parent.width - 110, 80)
                .setSize(100, 40)
                .setLabel("Estado final")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("addEstadoInicialFinal")
                .setPosition(parent.width - 340, 130)
                .setSize(100, 40)
                .setLabel("Estado Inicial-Final")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("borrarEstado")
                .setPosition(parent.width - 225, 130)
                .setSize(100, 40)
                .setLabel("Borrar Estado")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("moverEstado")
                .setPosition(parent.width - 110, 130)
                .setSize(100, 40)
                .setLabel("Mover Estado")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("ConexionNormal")
                .setPosition(parent.width - 340, 290)
                .setSize(100, 40)
                .setLabel("Conexion Normal")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("ConexionBucle")
                .setPosition(parent.width - 225, 290)
                .setSize(100, 40)
                .setLabel("Conexion bucle")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("BorrarConexion")
                .setPosition(parent.width - 110, 290)
                .setSize(100, 40)
                .setLabel("Borrar Conexion" + (char) 162 + "n")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addToggle("PasoEjecucion")
                .setPosition(parent.width - 340, 520)
                .setSize(100, 40)
                .setLabel("Ejecutar Paso A Paso")
                .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER);

        b.addTextfield("Ingrese palabra")
                .setColorLabel(0)
                .setPosition(parent.width - 340, 450)
                .setSize(250, 35)
                .setAutoClear(true);

        b.addBang("Iniciar/Denetenr")
                .setPosition(parent.width - 80, 450)
                .setSize(70, 35)
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
