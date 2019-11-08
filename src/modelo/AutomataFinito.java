package modelo;

import java.util.ArrayList;

import processing.core.PApplet;

public class AutomataFinito {

    public ArrayList<Estado> listaEstados = new ArrayList<Estado>();
    private ArrayList<Conexion> listaConexiones = new ArrayList<Conexion>();
    private PApplet parent;
    private String[][] matrizDeCondiciones;

    public AutomataFinito(PApplet p) {
        parent = p;
        matrizDeCondiciones = new String[50][50];
        inicializarMatriz(matrizDeCondiciones, 50, "-");
    }

    public void agregarEstado(Estado estado) {
        listaEstados.add(estado);
    }

    public void imprimirEstados() {
        for (int i = 0; i < listaEstados.size(); i++) {
            listaEstados.get(i).show();
        }
    }

    public void imprimirConexiones() {
        for (int i = 0; i < listaConexiones.size(); i++) {
            listaConexiones.get(i).show();
        }
    }

    public int getEstadoClickeado() {
        int estadoClickeado = -1;
        for (int i = 0; i < getListaEstados().size(); i++) {
            if (distanciaEntrePuntos(getListaEstados().get(i).getCoordenadas().getX(), getListaEstados().get(i).getCoordenadas().getY(),
                    parent.mouseX, parent.mouseY) <= getListaEstados().get(i).getRadio()) {
                estadoClickeado = i;
                break;
            }
        }
        return estadoClickeado;
    }

    public int distanciaEntrePuntos(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
    }

    public void agregarConexion(int estado1, int estado2, String condicion) {
        // Si la conexion ya existe
        if (!matrizDeCondiciones[estado1][estado2].equals("-")) {

        } else {
            matrizDeCondiciones[estado1][estado2] = condicion;
            // Conexion normal
            if(estado1 != estado2) {
                PApplet.println("Estado1: " + estado1 + " | Estado2: " + estado2);
                listaConexiones.add(new ConexionNormal(parent, listaEstados.get(estado1), listaEstados.get(estado2), condicion));                
            }
            // Conexion bucle
            else {
                parent.println("AutomataFinito agregar conexion bucle");
            }
            
        }
    }

    public void inicializarMatriz(String matriz[][], int tam, String x) {
        for (int fila = 0; fila < tam; fila++) {
            for (int columna = 0; columna < tam; columna++) {
                matriz[fila][columna] = x;
            }
        }
    }

    public ArrayList<Estado> getListaEstados() {
        return listaEstados;
    }

    public ArrayList<Conexion> getListaConexiones() {
        return listaConexiones;
    }

    public String[][] getMatrizDeCondiciones() {
        return matrizDeCondiciones;
    }

    public void setListaEstados(ArrayList<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public void setListaConexiones(ArrayList<Conexion> listaConexiones) {
        this.listaConexiones = listaConexiones;
    }

    public void setMatrizDeCondiciones(String[][] matrizDeCondiciones) {
        this.matrizDeCondiciones = matrizDeCondiciones;
    }
    

}
