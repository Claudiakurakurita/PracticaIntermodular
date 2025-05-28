
//package com.mycompany.proyectointermodular;

import com.mycompany.proyecto_intermodular.Continentes;
import com.mycompany.proyecto_intermodular.DataBaseManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Proyecto_Intermodular {

    public static void main(String[] args) throws SQLException {

        ArrayList<Continentes> cont = new ArrayList<>();
        
        DataBaseManager dbm = new DataBaseManager();

        dbm.conectarBBDD();

        cont = dbm.getContinentes();
        

    }
}