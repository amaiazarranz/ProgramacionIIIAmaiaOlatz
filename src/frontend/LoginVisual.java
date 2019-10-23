package frontend;

import sqlite.SelectData;
import usuarios.Estudiante;
import usuarios.Trabajador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class LoginVisual {

    private JTextField textUsuario;
    private JPasswordField textContrasena;
    private String usuario;
    private String password;
    FondoClases f;
    ArrayList<Estudiante> diccionarioEstudiantes;
    ArrayList <Trabajador> diccionarioTrabajadores;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginVisual() {

        diccionarioEstudiantes= SelectData.selectAllEstudiantes();
        diccionarioTrabajadores= SelectData.selectAllTrabajadores();

        JFrame frame = new JFrame("Log In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 700, 400);
        f=new FondoClases();
        f.setBorder(new EmptyBorder(5, 5, 5, 5));
        f.setLayout(null);

        frame.setContentPane(f);

        JLabel lblUsuario = new JLabel("Usuario:" );
        lblUsuario.setBounds(20, 100, 300, 30);
        lblUsuario.setForeground(Color.WHITE);
        f.add(lblUsuario);

        textUsuario = new JTextField (20);
        textUsuario.setBounds(100, 100, 300, 30);
        f.add(textUsuario);

        JLabel lblContrasena = new JLabel("Contrasena:" );
        lblContrasena.setBounds(20, 140, 300, 30);
        lblContrasena.setForeground(Color.WHITE);
        f.add(lblContrasena);

        textContrasena = new JPasswordField (20);
        textContrasena.setToolTipText("Contrasena");
        textContrasena.setBounds(100, 140, 300, 30);
        f.add(textContrasena);

        JButton boton1 = new JButton("Entrar");
        boton1.setBounds(150, 180, 200, 30);
        f.add(boton1);
        f.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        frame.setVisible(true);
    }




}
