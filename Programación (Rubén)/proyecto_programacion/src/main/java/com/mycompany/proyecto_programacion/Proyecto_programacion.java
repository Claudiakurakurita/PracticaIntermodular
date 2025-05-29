
package com.mycompany.proyecto_programacion;

import static java.nio.file.Files.size;
import java.sql.SQLException;
import java.util.ArrayList;

public class Proyecto_programacion {

    public static void main(String[] args) throws SQLException {

        ArrayList<Continente> cont;
        ArrayList<Pais> pai;
        ArrayList<Monumento> monu;

        DataBaseManager dbm = new DataBaseManager();

        dbm.conectarBBDD();

        cont = dbm.getContinentes();
        pai = dbm.getPaises();
        monu = dbm.getMonumentos(pai, cont);
        

        boolean continuar = true;
        int opcion_1 = 1;
        int opcion_2 = 2;
        int opcion_3 = 3;
        
        while (continuar) {
            int eligeOpcion = Integer.parseInt(System.console().readLine("Elige una opción: "
                                                                         + "1- Categoría Principal, "
                                                                         + "2- Entidades Principales, "
                                                                         + "3- Entidades Secundarias "));
            switch (eligeOpcion) {
                case 1:

                        System.out.println(cont);
                    break;

                case 2:
                    System.out.println(dbm.getPaises());
                    int elige = Integer.parseInt(System.console().readLine("Elige el número de un país: "
                                                                                    + "1- Francia, "
                                                                                    + "2- Portugal, "
                                                                                    + "3- Japón, "
                                                                                    + "4- China, "
                                                                                    + "5- Ghana,"
                                                                                    + "6- Marruecos, "
                                                                                    + "7- Estados Unidos, "
                                                                                    + "8- Canadá, "
                                                                                    + "9- Australia, "
                                                                                    + "10- Nueva Zelanda"));	
                        System.out.println("Lista de países");
                        
                    switch (elige) {
                        case 1:
                            if(elige >= 0 && elige <= 10){
                                for (int i = 0; i < pai.size(); i++) {
                                    System.out.println(pai.get(i));
                                }
                            }
                        break;
                        
                        default:
                            break;
                    }
                    break;
                case 3:
                    if(eligeOpcion == opcion_3){
                        System.out.println(monu);
                    }
                        break;
                default:
                    System.out.println("Saliendo del programa.");
                    continuar = false;
                        break;  
                        

                    }
        }
        

        }
    }

