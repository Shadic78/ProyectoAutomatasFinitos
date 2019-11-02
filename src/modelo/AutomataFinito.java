package modelo;

import java.util.ArrayList;
import processing.core.PApplet;

public class AutomataFinito
{

    ArrayList<Estado> listaEstados = new ArrayList<>();
    PApplet parent;

    public AutomataFinito(PApplet p)
    {
        parent = p;
    }

    public void agregarEstado(Estado estado)
    {
        listaEstados.add(estado);
    }

    public void imprimirEstados()
    {
        for (int i = 0; i < listaEstados.size(); i++)
        {
            listaEstados.get(i).show();
        }
    }

}
