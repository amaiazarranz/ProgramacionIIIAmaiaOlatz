package usuarios;

import utilidades.LecturaEscrituraFichero;
import utilidades.Utilidades;
import java.util.ArrayList;

public final class Secretario extends Trabajador
{
    ArrayList<String> diccionarioSecretarios= new ArrayList <String>();

    public Secretario(String nombre, String apellido1, String apellido2, String dni,
                      String user, String password, String email, String iban, String tipopersona,
                      double salario) {
        super(nombre, apellido1, apellido2, dni,  user, password, email, iban, tipopersona, salario);
    }

    public Secretario(){
        super();
    }

    @Override
    public String toString() {
        return "Secretario{" +
                ", nombre='" + this.getNombre() + '\'' +
                ", apellido1='" + this.getApellido1() + '\'' +
                ", apellido2='" + this.getApellido2() + '\'' +
                ", dni='" + this.getDni() + '\'' +
                ", user='" + this.getUser() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", iban='" + this.getIban() + '\'' +
                ", tipopersona='" + this.getTipopersona() + '\'' +
                "salario=" + this.getSalario() +
                '}';
    }

    public static void darBaja(ArrayList<Estudiante> diccionarioEstudiantes) {

        System.out.println("Estos son los estudiantes que tienen 3 faltas leves o 1 falta grave");

        for (Estudiante a: diccionarioEstudiantes) {

            if (a.getFaltaleve()>=2 || a.getFaltagrave()>=1 ) {

                System.out.println("DNI " + a.getDni() + " Estudiante " + a.getNombre() + " " + a.getApellido1() + " " + a.getApellido2());
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
                System.out.println("DNI " + b.getDni() + " Estudiante " + b.getNombre() + " " + b.getApellido1() + " " + b.getApellido2());

            }
        }

        LecturaEscrituraFichero.almacenarEstudiantes(diccionarioEstudiantes, "estudiantes.txt");
    }
}
