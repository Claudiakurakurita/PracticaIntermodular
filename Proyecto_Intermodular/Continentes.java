
package com.mycompany.proyecto_intermodular;



public class Continentes{
    
    private int id_continente;
    private String nombre;
    private String superficie;

    public Continentes(int id_continente, String nombre, String superficie) {
        this.id_continente = id_continente;
        this.nombre = nombre;
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        return "Continentes{" + "id_continente=" + id_continente + ", nombre=" + nombre + ", superficie=" + superficie + '}';
    }
    
    

    
    

    
    
    
    
    
}