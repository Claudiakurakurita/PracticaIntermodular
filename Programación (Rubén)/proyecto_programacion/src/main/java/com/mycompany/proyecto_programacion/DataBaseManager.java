package com.mycompany.proyecto_programacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
public class DataBaseManager {

    private String url = "jdbc:mysql://database-1.cxrphqa9nyzl.us-east-1.rds.amazonaws.com:3306/proyecto_intermodular";
    private String user = "admin";
    private String password = "Medac123";

    private Connection con;

    //Esta clase se conecta a la base de datos y se carg el programa para toda la informacion presente en ella
    public void conectarBBDD() throws SQLException {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos" + e.getMessage());
        }
    }

    //método para cargar y ejecutar la tabla continentes
    public ArrayList<Continente> getContinentes() throws SQLException {
        ArrayList<Continente> lista = new ArrayList();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM continentes");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_continente");
                String nombre = rs.getString("nombre");
                String superficie = rs.getString("superficie");
                Continente con = new Continente(id, nombre, superficie);
                lista.add(con);
            }
        } catch (SQLException e) {
            throw new SQLException ("Error al hacer la consulta" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<Pais> getPaises() throws SQLException {
        ArrayList<Pais> lista = new ArrayList();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM paises");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_pais");
                String nombre = rs.getString("nombre");
                String capital = rs.getString("capital");
                String poblacion = rs.getString("poblacion");
                String superficie = rs.getString("superficie");
                int id_continente = rs.getInt("id_continente");

                Pais pai = new Pais(id, nombre, capital, poblacion, superficie, id_continente);
                lista.add(pai);
            }
        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<Monumento> getMonumentos(ArrayList<Pais> paises, ArrayList<Continente> continentes) throws SQLException {
        ArrayList<Monumento> lista = new ArrayList();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM monumentos");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_monumentos");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                String patrimonio = rs.getString("patrimonio_unesco");
                int id_pais = rs.getInt("id_pais");
                Monumento monu = new Monumento(id, nombre, tipo, descripcion, patrimonio, id_pais);

                for (int i = 0; i < paises.size(); i++) {
                    if (id_pais == paises.get(i).getId_pais()) {
                        paises.get(i).añadirMonumentos(monu);
                    }

                }
                lista.add(monu);
            }

        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta" + e.getMessage());
        }

        for (int i = 0; i < continentes.size(); i++) {
            for (int j = 0; j < paises.size(); j++) {
                if (paises.get(j).getId_continente() == continentes.get(i).getId_continente()) {
                    continentes.get(i).añadirPais(paises.get(j));
                }
            }
        }
        return lista;
    }
}
