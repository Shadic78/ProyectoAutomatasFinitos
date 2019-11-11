package modelo;

import processing.core.PApplet;
import processing.core.PFont;

public abstract  class Estado {
    private Punto coordenadas;   
    private String nombre;
    public PApplet parent;
    private int radio;
    // Variables para la estetica de los estados    
    private int grosorBorde;   
    private PFont fuenteTexto;
    private int colorTexto;
    private int colorBackground;
    private int colorBordes;

    public Estado(PApplet parent, Punto punto, String nombre) {
        this.parent = parent;
        this.coordenadas = punto;
        this.nombre = nombre;
        this.radio = 22;
        // Colores
        this.grosorBorde = 4;      
        this.fuenteTexto = parent.createFont("Fuentes/OpenSans-SemiBold.ttf", 14); 
        this.colorTexto = parent.color(0,0,0);
        //this.colorBackground = parent.color(243, 178, 176);
        //this.colorBordes = parent.color(254, 121, 122);
        this.colorBackground = parent.color(117, 230, 89);//79, 223, 115
        this.colorBordes = parent.color(9, 184, 62);        
    }

    public Punto getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Punto punto) {
        this.coordenadas = punto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PApplet getParent() {
        return parent;
    }

    public void setParent(PApplet parent) {
        this.parent = parent;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getGrosorBorde() {
        return grosorBorde;
    }

    public void setGrosorBorde(int grosorBorde) {
        this.grosorBorde = grosorBorde;
    }

    public PFont getFuenteTexto() {
        return fuenteTexto;
    }

    public void setFuenteTexto(PFont fuenteTexto) {
        this.fuenteTexto = fuenteTexto;
    }

    public int getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(int colorTexto) {
        this.colorTexto = colorTexto;
    }

    public int getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(int colorBackground) {
        this.colorBackground = colorBackground;
    }

    public int getColorBordes() {
        return colorBordes;
    }

    public void setColorBordes(int colorBordes) {
        this.colorBordes = colorBordes;
    }  
    
    // Metodo abstracto a sobreescribir en las subclases
    public abstract void show();

}
