
package com.mycompany.proyectointermodular;

import java.util.ArrayList;


public class Paises{
    
    private int id_pais;
    private String nombre;
    private String capital;
    private int poblacion;
    private int superficie;
    private int id_continente;

    public Paises(int id_pais, String nombre, String capital, int poblacion, int superficie, int id_continente) {
        this.id_pais = id_pais;
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
        this.superficie = superficie;
        this.id_continente = id_continente;
    }

    @Override
    public String toString() {
        return "Paises{" + "id_pais=" + id_pais + ", nombre=" + nombre + ", capital=" + 
        capital + ", poblacion=" + poblacion + ", superficie=" + superficie + ", id_continente=" + id_continente + '}';
    }

    
    
    
    
    
    
    
}
