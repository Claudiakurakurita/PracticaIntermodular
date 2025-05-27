package com.mycompany.proyectointermodular;

import java.util.ArrayList;

public class Proyecto_Intermodular {

    public static void main(String[] args) {

        ArrayList<Continentes> cont = new ArrayList<>();

        DataBaseManager dbm = new DataBaseManager();

        dbm.conectarBBDD();

        cont = dbm.getContinentes();
        

    }
}
