package frontend;

import usuarios.Estudiante;
import usuarios.Persona;
import usuarios.Secretario;
import usuarios.Trabajador;
import utilidades.LecturaEscrituraFichero;
import utilidades.Utilidades;

import java.util.ArrayList;

public class Login  { //AQUI HACER LA AUTOMATRICULA Y LUEGO LOS PROFESORES CALIFICAR

	public static void main (String[]args) {

		System.out.println("Bienvenidos a la gestión de la universidad de Deusto");

		ArrayList<Estudiante> diccionarioEstudiantes = LecturaEscrituraFichero.leerEstudiantes("estudiantes.txt");
		ArrayList<Trabajador> diccionarioTrabajadores = LecturaEscrituraFichero.leerTrabajadores("trabajadores.txt");

        Persona aux = new Estudiante(); //no hacer new persona porque es abstract

		System.out.println("¿Eres un nuevo alumno y quieres realizar la automatrícula?");
		System.out.println("Si eres nuevo escribe s y si ya eres alumno escribe n");
		char respuesta = Utilidades.leerCaracter();

		if (respuesta == 's') {

		    Automatricula.Automatricula(diccionarioEstudiantes, diccionarioTrabajadores);

		} else if (respuesta == 'n') {

            boolean existe;
            boolean correcto;

            do {

                System.out.println("Introduce usuario: ");
                String usuario = Utilidades.leerCadena();

                System.out.println("Introduce password: ");
                String password = Utilidades.leerCadena();

                existe = false;
                correcto = false;

                for (Persona a : diccionarioEstudiantes) {

                    if (usuario.equals(a.getUser())) {
                        existe = true;

                        if (password.equals(a.getPassword())) {
                            System.out.println("Bienvenido " + usuario);
                            aux = (Persona) a;
                            existe = true;
                            correcto = true;
                            break;
                        }
                    }

                }

                for (Persona a : diccionarioTrabajadores) {

                    if (usuario.equals(a.getUser())) {

                        existe = true;

                        if (password.equals(a.getPassword())) {
                            System.out.println("Bienvenido " + usuario);
                            aux = (Persona) a;
                            existe = true;
                            correcto = true;
                            break;
                        }
                    }

                }
                if (!existe) {
                    System.out.println("Usuario no existe");
                } else if (!correcto) {
                    System.out.println("Contraseña incorrecta");
                }


            } while (!existe || !correcto);

            if (aux.getTipopersona().equals("estudiante")) {

                System.out.println("Eres un estudiante");
                System.out.println("¿Qué quieres hacer?");

            } else if (aux.getTipopersona().equals("secretario")) {

                System.out.println("Eres un secretario");
                System.out.println("¿Qué quieres hacer?");

                int op;

                do {
                    System.out.println("1. Dar de baja a los usuarios antiguos");

                    System.out.println("Elige una operación");
                    op = Utilidades.leerEntero();

                    switch (op) {
                        case 1:
                            Secretario.darBaja(diccionarioEstudiantes);

                            break;

                        default:
                            System.out.println("No has metido una opción válida. Mete una opción del 1 al 1.");
                    }
                } while (op != 1);
            } else if (aux.getTipopersona().equals("profesor")) {

                System.out.println("Eres un profesor");
                System.out.println("¿Qué quieres hacer?");

            }
        }


	}



}



