package sqlite;


import usuarios.Estudiante;
import usuarios.Trabajador;

import java.sql.*;



public class DBManager {

    private Connection conn;
    private String BDname;
    private final String URL = "jdbc:sqlite:";



    // Constructor
    public DBManager(String BDname)
    {
        this.BDname = this.URL + BDname;

    }


    public void createLink() throws SQLException
    {
        try
        {
            this.conn = DriverManager.getConnection(this.BDname);
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating connection. " + e.getMessage());
        }
    }

        public void createNewTableEstudiante() throws SQLException
    {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS estudiante (\n"
                + "    dni text PRIMARY KEY,\n"
                + "    nombre text NOT NULL,\n"
                + "    apellido1 text NOT NULL,\n"
                + "    apellido2 text NOT NULL,\n"
                + "    user text NOT NULL,\n"
                + "    password text NOT NULL,\n"
                + "    email text NOT NULL,\n"
                + "    iban text NOT NULL,\n"
                + "    tipopersona text NOT NULL,\n"
                + "    notamedia real NOT NULL,\n"
                + "    faltaleve integer NOT NULL,\n"
                + "    faltagrave integer NOT NULL\n"
                + ");";

        try
                (
                        Statement stmt = this.conn.createStatement()
                )
        {
            //create a table

            stmt.execute(sql);

        } catch (SQLException e)
        {
            System.out.println("BadAss error creating table" + e.getMessage());
            System.out.println(sql);
        }
    }

    public void createNewTableTrabajador() throws SQLException
    {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS trabajador (\n"
                + "    dni text PRIMARY KEY,\n"
                + "    nombre text NOT NULL,\n"
                + "    apellido1 text NOT NULL,\n"
                + "    apellido2 text NOT NULL,\n"
                + "    user text NOT NULL,\n"
                + "    password text NOT NULL,\n"
                + "    email text NOT NULL,\n"
                + "    iban text NOT NULL,\n"
                + "    tipopersona text NOT NULL,\n"
                + "    salario real NOT NULL check(salario>=0)\n"
                + ");";

        try
                (
                        Statement stmt = this.conn.createStatement()
                )
        {

            boolean result=stmt.execute(sql);

        } catch (SQLException e)
        {
            System.out.println("BadAss error creating table "+e.getMessage());
            System.out.println(sql);
        }
    }


    public static void insertEstudiante(String dni, String nombre, String apellido1, String apellido2,
                                 String user, String password, String email, String iban, String tipopersona,
                                 double notamedia, int faltaleve, int faltagrave) throws SQLException{

        String sql = "INSERT INTO estudiante(dni,nombre, apellido1, apellido2, user, password, email," +
                "iban, tipopersona, notamedia, faltaleve, faltagrave) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql) //
                )
        {
            pstmt.setString(1, dni);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido1);
            pstmt.setString(4, apellido2);
            pstmt.setString(5, user);
            pstmt.setString(6, password);
            pstmt.setString(7, email);
            pstmt.setString(8, iban);
            pstmt.setString(9, tipopersona);
            pstmt.setDouble(10, notamedia);
            pstmt.setInt(11, faltaleve);
            pstmt.setInt(12, faltagrave);

            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public static void insertTrabajador(String dni, String nombre, String apellido1, String apellido2,
                                        String user, String password, String email, String iban, String tipopersona,
                                        double salario) throws SQLException{

        String sql = "INSERT INTO trabajador(dni,nombre, apellido1, apellido2, user, password, email," +
                "iban, tipopersona, salario) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql) //
                )
        {
            pstmt.setString(1, dni);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido1);
            pstmt.setString(4, apellido2);
            pstmt.setString(5, user);
            pstmt.setString(6, password);
            pstmt.setString(7, email);
            pstmt.setString(8, iban);
            pstmt.setString(9, tipopersona);
            pstmt.setDouble(10, salario);

            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void closeLink()throws SQLException{

        try{

            if(this.conn != null){

                this.conn.close();
            }
        }
        catch (SQLException ex){

            System.out.println("BadAss error closing connection" +ex.getMessage());

        }


    }



    private static Connection connect() //tiene que ser estático
    {
        // SQLite connection string
        String name = "UniversidadDeusto.db";
        String url = "jdbc:sqlite:" + name;
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }



}
