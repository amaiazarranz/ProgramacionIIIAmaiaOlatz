package usuarios;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public final class Secretario extends Trabajador
{
    ArrayList<String> diccionarioSecretarios= new ArrayList <String>();

    public void darBaja() {

    }

    public Secretario(String nombre, String apellido1, String apellido2, String dni, Date fechanacimiento,
                      String user, String password, String email, String iban, String tipopersona,
                      double salario) {
        super(nombre, apellido1, apellido2, dni, fechanacimiento, user, password, email, iban, tipopersona, salario);
    }

    public Secretario(){
        super();
    }

    @Override
    public String toString() {
        return "Secretario{" +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", dni='" + dni + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", iban='" + iban + '\'' +
                ", tipopersona='" + tipopersona + '\'' +
                "salario=" + salario +
                '}';
    }
}
