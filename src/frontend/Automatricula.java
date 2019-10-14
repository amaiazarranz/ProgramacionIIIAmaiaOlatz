package frontend;

import usuarios.Estudiante;
import usuarios.Trabajador;
import utilidades.Comprobaciones;
import utilidades.LecturaEscrituraFichero;
import utilidades.Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class Automatricula
{
    public static void Automatricula (ArrayList<Estudiante> diccionarioEstudiantes, ArrayList<Trabajador> diccionarioTrabajadores){

    System.out.println("Vamos a proceder a la automatrícula");

        System.out.println("¿Cuál es tu nombre de usuario?");
        System.out.println("Ten en cuenta que el nombre de usuario tiene que tener al menos 6 caracteres");
        String nombreUsuario;

        boolean comprobacionNombre;

        do {

            comprobacionNombre=false; //poner aqui dentro, sino si una vez es true siempre va a ser true
            nombreUsuario=Utilidades.leerCadena();

            while (nombreUsuario.length() <= 5) {

                System.out.println("Vuelve a introducir un nombre de usuario que al menos tenga 6 caraceteres ");
                nombreUsuario=Utilidades.leerCadena();

            }

            for (Estudiante a : diccionarioEstudiantes) {
                if (a.getUser().equals(nombreUsuario)) {

                    System.out.println("El usuario que estás creando ya es un estudiante");
                    System.out.println("Vuelve a introducir un nuevo nombre de usuario que no esté registrado previamente");
                    comprobacionNombre = true;
                    break;
                }
            }
            for (Trabajador b : diccionarioTrabajadores) {

                if (b.getUser().equals(nombreUsuario)) {

                    System.out.println("El usuario que estás creando es un trabajador de la plantilla");
                    System.out.println("Vuelve a introducir un nuevo nombre de usuario que no esté registrado previamente");
                    comprobacionNombre = true;
                    break;

                }
            }

        }while (comprobacionNombre==true || nombreUsuario.length()<=5);




        System.out.println("¿Cuál es tu contraseña de usuario?. Ten en cuenta que tiene que tener al menos 8 caracteres");
        String contrasena=Utilidades.leerCadena();

        while (contrasena.length()<=7){

            System.out.println("Vuelve a introducir una contraseña que al menos tenga 8 caraceteres ");
            contrasena=Utilidades.leerCadena();

        }



        System.out.println("¿Cuál es tu nombre real?");
        String nombre=Utilidades.leerCadena();

        boolean comprobar;

        do{

            while (nombre.length()<1){

                System.out.println("Es necesario que introduzcas tu nombre");
                nombre=Utilidades.leerCadena();
            }

            char [] arrayNom = new char [nombre.length()];
            arrayNom = nombre.toCharArray();


            comprobar = Comprobaciones.ValidarNom(arrayNom);

            while (comprobar == false)
            {
                System.out.println("Un nombre no puede contener digitos que no sean letras, introducelo correctamente con letras: ");
                nombre = Utilidades.leerCadena();
                arrayNom = new char [nombre.length()];
                arrayNom = nombre.toCharArray();

                comprobar = Comprobaciones.ValidarNom(arrayNom);
            }

        }while(nombre.length()<1 ||comprobar==false);



        System.out.println("¿Cuál es tu primer apellido?");
        String apellido1=Utilidades.leerCadena();
        boolean comprobarapellido;

        do{

            while (apellido1.length()<1){

                System.out.println("Es necesario que introduzcas tu apellido");
                apellido1=Utilidades.leerCadena();
            }

            char [] arrayApellido1 = new char [apellido1.length()];
            arrayApellido1 = apellido1.toCharArray();

            comprobar = Comprobaciones.ValidarNom(arrayApellido1);

            while (comprobar == false)
            {
                System.out.println("Un apellido no puede contener digitos que no sean letras, introducelo correctamente con letras: ");
                apellido1 = Utilidades.leerCadena();
                arrayApellido1 = new char [apellido1.length()];
                arrayApellido1 = apellido1.toCharArray();

                comprobar = Comprobaciones.ValidarNom(arrayApellido1);
            }

        }while(apellido1.length()<1 ||comprobar==false);




        System.out.println("¿Cuál es tu segundo apellido?");
        String apellido2=Utilidades.leerCadena();
        boolean comprobarapellido2;

        do{

            while (apellido2.length()<1){

                System.out.println("Es necesario que introduzcas tu apellido");
                apellido2=Utilidades.leerCadena();
            }

            char [] arrayApellido2 = new char [apellido2.length()];
            arrayApellido2 = apellido2.toCharArray();

            comprobar = Comprobaciones.ValidarNom(arrayApellido2);

            while (comprobar == false)
            {
                System.out.println("Un apellido no puede contener digitos que no sean letras, introdúcelo correctamente con letras: ");
                apellido2= Utilidades.leerCadena();
                arrayApellido2 = new char [apellido2.length()];
                arrayApellido2 = apellido2.toCharArray();

                comprobar = Comprobaciones.ValidarNom(arrayApellido2);
            }

        }while(apellido2.length()<1 ||comprobar==false);



        System.out.println("¿Cuál es tu DNI?");
        String dni;

        boolean comprobacion;
        do
        {
            dni=Utilidades.leerCadena();
            comprobacion=false;

            dni = dni.toUpperCase();
            char [] arrayDNI = new char [dni.length()];
            arrayDNI = dni.toCharArray();

            while (dni.length() != 9)
            {
                System.out.println("Introduzca 9 caracteres, 8 numeros al principio y una letra después ");
                dni = Utilidades.leerCadena();
                dni = dni.toUpperCase();
                arrayDNI = new char [dni.length()];
                arrayDNI = dni.toCharArray();

            }

            for (int i=0 ; i<diccionarioEstudiantes.size(); i++)
            {
                if (diccionarioEstudiantes.get(i).getDni().toUpperCase().compareTo(dni.toUpperCase()) == 0)
                {
                    System.out.println("El DNI que has introducido ya existe");
                    System.out.println("Introduzca un dni que no haya sido introducido anteriormente");
                    comprobacion = true;
                    break;
                }
            }

            boolean comprobarnum = Comprobaciones.comprobardninumeros(arrayDNI);
            boolean comprobarletra = Comprobaciones.comprobardniletra(arrayDNI);

            while (comprobarnum == false || comprobarletra == false)
            {
                System.out.println("Error, vuelva introducir el DNI correctamente, que contenga 8 numeros y 1 letra: ");
                dni = Utilidades.leerCadena();
                dni = dni.toUpperCase();
                arrayDNI = new char [dni.length()];
                arrayDNI = dni.toCharArray();
                comprobarnum = Comprobaciones.comprobardninumeros(arrayDNI);
                comprobarletra = Comprobaciones.comprobardniletra(arrayDNI);
            }


        } while(dni.length()!=9||comprobacion ==true);


        System.out.println("¿Cuál es tu fecha de nacimiento?");
        String fechaNacimiento;
        boolean correcto;
        boolean res;
        Date fechaDate = null;

        do {

            fechaNacimiento = Utilidades.leerCadena();
            res = Comprobaciones.validarFecha(fechaNacimiento);

            if (res == true) {
                System.out.println("La fecha es valida");
            } else{
                System.out.println("La fecha no es valida");
            }


            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

            try {

                fechaDate = formato.parse(fechaNacimiento);
                correcto = true;

            } catch (ParseException e) {
                System.out.println("El formato de la fecha lo has introducido mal");
                correcto = false;

                System.out.println("Introduzca un formato adecuado");

            }

        }while (correcto==false|| res==false); //poner dos iguales para comparar, sino asigna




        System.out.println("Introduzca tu correo");
        System.out.println("Tiene que acabar en @gmail.com");
        String correo=Utilidades.leerCadena();


        boolean patronbien;

        do{

            String patron1 = ".*@gmail\\.com";
            Pattern pat1 = Pattern.compile( patron1 );
            patronbien=false;

            if (pat1.matcher(correo).matches())
            {
                System.out.println("Bienvenido");
                patronbien=true;
            }
            else
            {
                System.out.println("El correo debe terminar @gmail.com");
                System.out.println("Introduzca otra vez el correo correctamente");
                correo=Utilidades.leerCadena();
            }
        }while (patronbien==false);






        System.out.println("Introduzca tu IBAN");
        System.out.println("Tienen que ser dos letras en mayúscula y 22 dígitos más");
        String iban;

        boolean comprobacionIban;
        do
        {
            iban=Utilidades.leerCadena();
            comprobacionIban=false;

            iban = iban.toUpperCase();
            char [] arrayIban = new char [iban.length()];
            arrayIban = iban.toCharArray();

            while (iban.length() != 24)
            {
                System.out.println("Introduzca 24 caracteres, dos letras y 22 números");
                iban = Utilidades.leerCadena();
                iban = iban.toUpperCase();
                arrayIban = new char [iban.length()];
                arrayIban = iban.toCharArray();

            }

            for (int i=0 ; i<diccionarioEstudiantes.size(); i++)
            {
                if (diccionarioEstudiantes.get(i).getIban().toUpperCase().compareTo(iban.toUpperCase()) == 0)
                {
                    System.out.println("El iban que has introducido ya existe");
                    System.out.println("Introduzca un iban que no haya sido introducido anteriormente");
                    comprobacionIban = true;
                    break;
                }
            }

            boolean comprobarnum = Comprobaciones.comprobaribannumeros(arrayIban);
            boolean comprobarletra = Comprobaciones.comprobaribanletra(arrayIban);

            while (comprobarnum == false || comprobarletra== false)
            {
                System.out.println("Error, vuelva introducir el iban correctamente, dos letras y 22 números ");
                iban = Utilidades.leerCadena();
                iban = iban.toUpperCase();
                arrayIban = new char [iban.length()];
                arrayIban = iban.toCharArray();
                comprobarnum = Comprobaciones.comprobaribannumeros(arrayIban);
                comprobarletra = Comprobaciones.comprobaribanletra(arrayIban);


            }

        } while(iban.length()!=24||comprobacionIban ==true);


        Estudiante user = new Estudiante(nombre,apellido1,apellido2,dni,fechaDate, nombreUsuario, contrasena, correo,
                iban, "estudiante", 0, 0, 0 );
        diccionarioEstudiantes.add(user);

        for (Estudiante a: diccionarioEstudiantes)
        {
            System.out.println(a);
        }

        LecturaEscrituraFichero.almacenarEstudiantes(diccionarioEstudiantes, "estudiantes.txt");

    }


}
