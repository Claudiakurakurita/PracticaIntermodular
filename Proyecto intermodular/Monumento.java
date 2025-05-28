
package com.mycompany.proyecto_intermodular;
 



public class Monumento{
    
    private int id_monumento;
    private String nombre;
    private String tipo;
    private String descripcion;
    private String patrimonio;
    private int id_pais;

    public Monumento(int id_monumento, String nombre, String tipo, String descripcion, String patrimonio, int id_pais) {
        this.id_monumento = id_monumento;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.patrimonio = patrimonio;
        this.id_pais = id_pais;
    }

    @Override
    public String toString() {
        return "Monumento{" + "id_monumento=" + id_monumento + ", nombre=" + nombre + 
                ", tipo=" + tipo + ", descripcion=" + descripcion + ", patrimonio=" + patrimonio + ", id_pais=" + id_pais + '}';
    }

    public int getId_pais() {
        return id_pais;
    }
    
    
    
    
    
    
    
    
    
    
    
}
