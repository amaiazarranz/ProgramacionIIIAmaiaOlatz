package frontend;

import sqlite.DBManager;

import java.sql.SQLException;

public class LoginBaseDeDatos {

    public static void main(String[] args) {

        DBManager myDBManager;

        try{

            // Step 1 - Instantiate the manager
            myDBManager= new DBManager("UniversidadDeusto.db");

            // Step 2 - Create database
            myDBManager.createLink();

            // Step 3 - Create table
            myDBManager.createNewTableEstudiante();
            myDBManager.createNewTableTrabajador();

            myDBManager.insertEstudiante("72608820M", "Amaia", "Zarranz", "Mendizabal", "amaiaz",
                           "amaia", "amaia@gmail.com", "ET0000000000000000000000", "estudiante", 9.2, 1, 2);

            myDBManager.insertTrabajador("72608830M", "Olatz", "Gonzalez", "Santiago", "olatz", "olatzg",
                    "olatz@gmail.com", "ES0000000000000000000000", "trabajador", 2300.0);


            // Last step - Close connection
            myDBManager.closeLink();
        }
        catch (SQLException e)
        {
            System.out.println("Process terminated with errors");
        }
        finally
        {
            System.out.println("Process terminated successfully");
        }
    }
}
