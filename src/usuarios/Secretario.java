package usuarios;

import utilidades.LecturaEscrituraFichero;
import utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Date;

public final class Secretario extends Trabajador
{
    ArrayList<String> diccionarioSecretarios= new ArrayList <String>();

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

    public static void darBaja(ArrayList<Estudiante> diccionarioEstudiantes) {

        System.out.println("Estos son los estudiantes que tienen 3 faltas leves o 1 falta grave");

        for (Estudiante a: diccionarioEstudiantes) {

            if (a.getFaltaleve()>=2 || a.getFaltagrave()>=1 ) {

                System.out.println("DNI " + a.dni + " Estudiante " + a.nombre + " " + a.apellido1 + " " + a.apellido2);
                //no poner diccionarioEstudiantes sino sale el primero siempre
            }

        }

        System.out.println("¿El profesorado ha decidido expulsar al alumno?");
        System.out.println("Escribe S si han decidido que sí y escribe N si han decidido que no");
        char respuesta=Utilidades.leerCaracter();

        if (respuesta == 's' || respuesta == 'S')
        {
            System.out.println("Escribe el dni del usuario que quieras dar de baja");
            String usuarioEliminado= Utilidades.leerCadena();

            for (Estudiante b: diccionarioEstudiantes){

                if(b.getDni().equals(usuarioEliminado)){

                    diccionarioEstudiantes.remove(b);
                    break;
                }

                System.out.println("Ahora los estudiantes que nos quedan son los siguientes");
                System.out.println("DNI " + b.dni + " Estudiante " + b.nombre + " " + b.apellido1 + " " + b.apellido2);

            }
        }

        LecturaEscrituraFichero.almacenarEstudiantes(diccionarioEstudiantes, "estudiantes.txt");
    }
}
