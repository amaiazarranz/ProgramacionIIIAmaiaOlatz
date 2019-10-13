package frontend;

import usuarios.Estudiante;
import usuarios.Persona;
import usuarios.Trabajador;
import utilidades.LecturaEscrituraFichero;
import utilidades.Utilidades;

import java.util.ArrayList;

public class Login  {

	public static void main (String[]args){

		System.out.println ("Bienvenidos a la gestión de la universidad de Deusto");

		ArrayList<Estudiante> diccionarioEstudiantes= LecturaEscrituraFichero.leerEstudiantes("estudiantes.txt");
		ArrayList<Trabajador> diccionarioTrabajadores= LecturaEscrituraFichero.leerTrabajadores("trabajadores.txt");

		Persona aux= new Estudiante ();

		boolean existe;
		boolean correcto;

		do {

			System.out.println("Introduce usuario: ");
			String usuario = Utilidades.leerCadena();

			System.out.println("Introduce password: ");
			String password = Utilidades.leerCadena();

			existe=false;
			correcto=false;

			for (Persona a : diccionarioEstudiantes)
			{

				if (usuario.equals(a.getUser()))
				{
					existe=true;
					if (password.equals(a.getPassword()))
					{
						System.out.println("Bienvenido " + usuario);
						aux=(Persona) a;
						existe=true;
						correcto=true;
						break;
					}
				}

			}

			for (Persona a : diccionarioTrabajadores)
			{

				if (usuario.equals(a.getUser()))
				{

					existe=true;

					if (password.equals(a.getPassword()))
					{
						System.out.println("Bienvenido " + usuario);
						aux=(Persona) a;
						existe=true;
						correcto=true;
						break;
					}
				}

			}
			if(!existe) {
				System.out.println("Usuario no existe");
			}
			else if(!correcto){
				System.out.println("Contraseña incorrecta");
			}


		}while (!existe||!correcto);


		if (aux.getTipopersona().equals("estudiante")) {

			System.out.println("Eres un estudiante");
			System.out.println("¿Qué quieres hacer?");
		}

		else if (aux.getTipopersona().equals("secretario")){

			System.out.println("Eres un secretario");
			System.out.println("¿Qué quieres hacer?");

		}

		else if (aux.getTipopersona().equals("profesor")){

			System.out.println("Eres un profesor");
			System.out.println("¿Qué quieres hacer?");

		}

	}

}


