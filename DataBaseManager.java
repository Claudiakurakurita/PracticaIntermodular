package com.mycompany.proyectointermodular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseManager {

    private String url = "jdbc:mysql://localhost:3306...";
    private String user = "root";
    private String password = "1234";

    private Connection con;

    //esta clase se conecta a la bbdd, y además carga en el programa toda la información presente en ella
    public void conectarBBDD() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error al conectarse: " + e.getMessage());
        }
    }

    public ArrayList<Continentes> getContinentes() {
        ArrayList<Continentes> lista = new ArrayList<>();
        try {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM continentes");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_continente");
                String nombre = rs.getString("nombre");
                String superficie = rs.getString("superficie");
                Continentes cont = new Continentes(id, nombre, superficie);
                lista.add(cont);
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }
        return lista;
    }

    public ArrayList<Paises> getPaises() throws SQLException {

        ArrayList<Paises> lista = new ArrayList<>();
        
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
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }
        return lista;
        }
    }
