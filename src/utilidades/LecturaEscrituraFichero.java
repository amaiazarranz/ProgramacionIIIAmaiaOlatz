package utilidades;

import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Secretario;
import usuarios.Trabajador;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LecturaEscrituraFichero {

    public static ArrayList<Estudiante> leerEstudiantes (String path) {

        File aFile = new File(path);

        ArrayList<Estudiante> listaDevolucion = new ArrayList<Estudiante>();

        try {

            FileReader fr = new FileReader(aFile);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            while (linea != null) {

                String[] estudiantesLeidos = linea.split(";");

                DateFormat date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); // tiene que leerse con ese formato si o
                // si

                Date fecha = date.parse(estudiantesLeidos[4]); // para pasar de string a date
                Double notamedia=Double.parseDouble(estudiantesLeidos [10]); //en el fichero están en string
                Integer faltaleve=Integer.valueOf(estudiantesLeidos [11]);
                Integer faltagrave=Integer.valueOf(estudiantesLeidos[12]);


                Estudiante estudiante = new Estudiante (estudiantesLeidos[0], estudiantesLeidos[1], estudiantesLeidos[2],
                        estudiantesLeidos [3], fecha, estudiantesLeidos [5], estudiantesLeidos [6], estudiantesLeidos [7], estudiantesLeidos [8], estudiantesLeidos [9],
                        notamedia, faltaleve, faltagrave); // porque es fecha es date //tiene que ser igual que el constructor de estudiante

                listaDevolucion.add(estudiante);


                linea = br.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Fecha mal introducida");
        }

        return listaDevolucion;
    }

    public static void almacenarEstudiantes(ArrayList<Estudiante> todosEstudiantes, String path) {

        File aFile = new File(path);

        try {
            FileWriter fw = new FileWriter(aFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Estudiante a : todosEstudiantes) {

                DateFormat date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

                String fecha = date.format(a.getFechanacimiento()); // añadir la fecha de string a fecha

                String escribir = a.getNombre() + ";" + a.getApellido1() + ";" + a.getApellido2()+ ";" + a.getDni() + ";" +
                         fecha + ";" + a.getUser()+ ";"+ a.getPassword()+ ";"+ a.getEmail()+ ";" + a.getTipopersona() + ";"
                        + a.getIban() + ";" +a.getNotamedia() + ";"+ a.getFaltaleve() + ";" +a.getFaltagrave() +"\n";

                        bw.write(escribir);

            }

            bw.flush();
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Trabajador> leerTrabajadores (String path) {

        File aFile = new File(path);

        ArrayList<Trabajador> listaDevolucion = new ArrayList<Trabajador>();

        try {

            FileReader fr = new FileReader(aFile);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            while (linea != null) {

                String[] trabajadoresLeidos = linea.split(";");

                DateFormat date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

                Date fecha = date.parse(trabajadoresLeidos[4]);
                Double salario=Double.valueOf(trabajadoresLeidos[10]);

                if (trabajadoresLeidos [9].equals("secretario")) {

                    Secretario secretario = new Secretario (trabajadoresLeidos[0], trabajadoresLeidos[1], trabajadoresLeidos[2],
                            trabajadoresLeidos [3], fecha, trabajadoresLeidos [5], trabajadoresLeidos [6], trabajadoresLeidos [7], trabajadoresLeidos [8], trabajadoresLeidos [9],
                           salario);

                    listaDevolucion.add(secretario);
                }
                else if (trabajadoresLeidos [9].equals("profesor")){

                    Profesor profesor = new Profesor (trabajadoresLeidos[0], trabajadoresLeidos[1], trabajadoresLeidos[2],
                            trabajadoresLeidos [3], fecha, trabajadoresLeidos [5], trabajadoresLeidos [6], trabajadoresLeidos [7], trabajadoresLeidos [8], trabajadoresLeidos [9],
                            salario);

                    listaDevolucion.add(profesor);
                }
                linea = br.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Fecha mal introducida");
        }

        return listaDevolucion;
    }


}
