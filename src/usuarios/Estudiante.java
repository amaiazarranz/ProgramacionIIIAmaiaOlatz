package usuarios;

import usuarios.Persona;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Estudiante extends Persona
{

    ArrayList<String> diccionarioEstudiantes= new ArrayList <String>();

    private double notamedia;
    private int faltaleve;
    private int faltagrave;

    public Estudiante(String nombre, String apellido1, String apellido2, String dni, Date fechanacimiento,
                      String user, String password, String email, String iban, String tipopersona,
                      double notamedia, int faltaleve, int faltagrave) {
        super(nombre, apellido1, apellido2, dni, fechanacimiento, user, password, email, iban, tipopersona);

        this.notamedia = notamedia;
        this.faltaleve = faltaleve;
        this.faltagrave = faltagrave;
    }

    public Estudiante() {
        super();
    }

    public ArrayList<String> getDiccionarioEstudiantes() {
        return diccionarioEstudiantes;
    }

    public void setDiccionarioEstudiantes(ArrayList<String> diccionarioEstudiantes) {
        this.diccionarioEstudiantes = diccionarioEstudiantes;
    }

    public double getNotamedia() {
        return notamedia;
    }

    public void setNotamedia(double notamedia) {
        this.notamedia = notamedia;
    }

    public int getFaltaleve() {
        return faltaleve;
    }

    public void setFaltaleve(int faltaleve) {
        this.faltaleve = faltaleve;
    }

    public int getFaltagrave() {
        return faltagrave;
    }

    public void setFaltagrave(int faltagrave) {
        this.faltagrave = faltagrave;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "notamedia=" + notamedia +
                ", faltaleve=" + faltaleve +
                ", faltagrave=" + faltagrave +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", dni='" + dni + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                ", email='" + email + '\'' +
                '}';
    }
}
