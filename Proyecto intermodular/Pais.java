
package com.mycompany.proyecto_intermodular;

import java.util.ArrayList;




public class Pais{
    
    private int id_pais;
    private String nombre;
    private String capital;
    private String poblacion;
    private String superficie;
    private int id_continente;
    private ArrayList<Monumento> monumentos;

    public Pais(int id_pais, String nombre, String capital, String poblacion, String superficie, int id_continente) {
        this.id_pais = id_pais;
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
        this.superficie = superficie;
        this.id_continente = id_continente;
        this.monumentos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Pais{" + "id_pais=" + id_pais + ", nombre=" + nombre + ", capital=" + capital + ", poblacion=" + poblacion + ", superficie=" + superficie + ", id_continente=" + id_continente + '}';
    }



    public int getId_pais() {
        return id_pais;
    }

    public int getId_continente() {
        return id_continente;
    }

    public ArrayList<Monumento> getMonumentos() {
        return monumentos;
    }
    
    
    


    public void añadirMonumentos(Monumento monu){
        monumentos.add(monu);
    }
    
    
    
    
    
    
}