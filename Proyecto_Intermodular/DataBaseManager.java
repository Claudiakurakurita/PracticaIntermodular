
package com.mycompany.proyecto_intermodular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DataBaseManager {
    
    private String url = "jdbc:mysql://localhost:3306/Secretaria_Medac";
    private String user = "root";
    private String password = "1234";
    
    private Connection con;
    
    
    //Esta clase se conecta a la base de datos y se carg el programa para toda la informacion presente en ella
    public void conectarBBDD() throws SQLException{
        try{
            con = DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            System.out.println("Error de conexión a la base de datos" + e.getMessage());
        }
    }
    
    //método para cargar y ejecutar la tabla continentes
    public ArrayList<Continentes> getContinentes() throws SQLException{
        ArrayList<Continentes> lista = new ArrayList();
        
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM continentes");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id_continente");
                String nombre = rs.getString("nombre");
                String superficie = rs.getString("superficie");
                Continentes con = new Continentes(id, nombre, superficie);
                lista.add(con);
            }
        } catch(SQLException e){
            System.out.println("Error al hacer la consulta" + e.getMessage());
        }
        return lista;
    }
    
        public ArrayList<Paises> getPaises() throws SQLException{
        ArrayList<Paises> lista = new ArrayList();
        
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM paises");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id_pais");
                String nombre = rs.getString("nombre");
                String capital = rs.getString("capital");
                int poblacion = rs.getInt("poblacion");
                int superficie = rs.getInt("superficie");
                int id_continente = rs.getInt("id_continente");
                Paises pai = new Paises(id, nombre, capital, poblacion, superficie, id_continente);
                lista.add(pai);
            }
        } catch(SQLException e){
            System.out.println("Error al hacer la consulta" + e.getMessage());
        }
        return lista;
    }
        
    
            public ArrayList<Monumentos> getMonumentos() throws SQLException{
        ArrayList<Monumentos> lista = new ArrayList();
        
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM monumentos");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id_monumento");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                String patrimonio = rs.getString("patrimonio");
                int id_pais = rs.getInt("id_pais");
                Monumentos monu = new Monumentos(id, nombre, tipo, descripcion, patrimonio, id_pais);
                lista.add(monu);
            }
        } catch(SQLException e){
            System.out.println("Error al hacer la consulta" + e.getMessage());
        }
        return lista;
    }
        
    
    
    
    
    
}
