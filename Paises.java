
package com.mycompany.practicaintermodular;

import java.util.ArrayList;


public class Paises extends ClavePrimaria{
    
    private ArrayList<ClavePrimaria> nombrePaises;
    private String capital;
    private int poblacion;
    private int superficie;

    public Paises(String nombre, int id, ArrayList<ClavePrimaria> nombrePaises) {
        super(nombre, id);
        this.nombrePaises = nombrePaises;
        this.capital = capital;
        this.poblacion = poblacion;
        this.superficie = superficie;
    }
    
    
    
    
    
    
}
