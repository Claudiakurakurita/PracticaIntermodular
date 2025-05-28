package com.mycompany.proyecto_intermodular;

import java.sql.SQLException;
import java.util.ArrayList;

public class Proyecto_Intermodular {

    public static void main(String[] args) throws SQLException {

        ArrayList<Continente> cont;
        ArrayList<Pais> pai;
        ArrayList<Monumento> monu;

        DataBaseManager dbm = new DataBaseManager();

        dbm.conectarBBDD();

        cont = dbm.getContinentes();
        pai = dbm.getPaises();
        monu = dbm.getMonumentos(pai, cont);

    }
}
