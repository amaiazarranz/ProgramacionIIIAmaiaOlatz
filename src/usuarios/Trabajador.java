package usuarios;

import usuarios.Persona;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Trabajador extends Persona
{
    double salario;

    ArrayList<String> diccionarioTrabajdores= new ArrayList <String>();

    public Trabajador(String nombre, String apellido1, String apellido2, String dni, Date fechanacimiento,
                      String user, String password, String email, String iban, String tipopersona,
                      double salario) {
        super(nombre, apellido1, apellido2, dni, fechanacimiento, user, password, email, iban, tipopersona);
        this.salario = salario;
    }

    public Trabajador (){
        super();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
