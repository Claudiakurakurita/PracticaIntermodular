
package com.mycompany.practicaintermodular;

import java.util.ArrayList;


public class Monumentos extends ClavePrimaria {
    
    private ArrayList<ClavePrimaria>nombreMonumentos; 
    private String capital;
    private String poblacion;
    private String superficie;
    
    public Monumentos(String nombre, int id, ArrayList<ClavePrimaria>nombreMonumentos) {
        super(nombre, id);
        this.nombreMonumentos = nombreMonumentos;
    }
    
    
    
    
    
    
    
    
    
}
