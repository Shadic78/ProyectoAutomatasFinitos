package modelo;

import processing.core.PApplet;

public abstract  class Estado
{
    private Punto vertice;
   
    private String nombre;
   
    PApplet parent;

    public Estado(PApplet parent, Punto vertice, String nombre)
    {
        this.parent = parent;
        this.vertice = vertice;
        this.nombre = nombre;
    }

    public Punto getVertice()
    {
        return vertice;
    }

    public void setVertice(Punto vertice)
    {
        this.vertice = vertice;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public PApplet getParent()
    {
        return parent;
    }

    public void setParent(PApplet parent)
    {
        this.parent = parent;
    }
    
    
	
    public abstract void show();

}
