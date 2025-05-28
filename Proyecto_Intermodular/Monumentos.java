
package com.mycompany.proyecto_intermodular;

import java.util.ArrayList;


public class Monumentos{
    
    private int id_monumento;
    private String nombre;
    private String tipo;
    private String descripcion;
    private String patrimonio;
    private int id_pais;

    public Monumentos(int id_monumento, String nombre, String tipo, String descripcion, String patrimonio, int id_pais) {
        this.id_monumento = id_monumento;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.patrimonio = patrimonio;
        this.id_pais = id_pais;
    }

    @Override
    public String toString() {
        return "Monumentos{" + "id_monumento=" + id_monumento + ", nombre=" + nombre + 
                ", tipo=" + tipo + ", descripcion=" + descripcion + ", patrimonio=" + patrimonio + ", id_pais=" + id_pais + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
