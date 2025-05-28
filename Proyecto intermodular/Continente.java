
package com.mycompany.proyecto_intermodular;

import java.util.ArrayList;



 

public class Continente{
    
    private int id_continente;
    private String nombre;
    private String superficie;
    private ArrayList<Pais> paises;

    public Continente(int id_continente, String nombre, String superficie) {
        this.id_continente = id_continente;
        this.nombre = nombre;
        this.superficie = superficie;
        this.paises = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Continente{" + "id_continente=" + id_continente + ", nombre=" + nombre + ", superficie=" + superficie + '}';
    }



    public int getId_continente() {
        return id_continente;
    }
    
    public void añadirPais(Pais pais){
        paises.add(pais);
    }
    
    
    
}