package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Principio extends JFrame {

	public static void main(String[] args) {

		Principio p= new Principio();
	}

	public Principio (){

		// Create and set up a frame window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Universidad De Deusto");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Define new buttons with different width on help of the ---

		JButton jb4 = new JButton("Realizar la automatrícula");
		jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Automatricula ventana = new Automatricula();
				Principio.this.dispose();
			}
		});

		JButton jb5 = new JButton("Ya soy usuario de la universidad");
		jb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				LoginVisual ventana = new LoginVisual();
				Principio.this.dispose();
			}
		});

		JButton jb6 = new JButton("Salir");

		jb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principio.this.dispose();
			}
		});


		// Define the panel to hold the buttons
		JPanel panel1 = new JPanel();
		JPanel panel3 = new JPanel();

		// Set up the title for different panels
		panel1.setBorder(BorderFactory.createTitledBorder("FOTO"));

		// Set up the BoxLayout
		BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
		BoxLayout layout3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);

		panel1.setLayout(layout1);
		panel3.setLayout(layout3);

        JLabel foto = new JLabel("");
        foto.setIcon(new ImageIcon("src/images/Deusto.jpg"));
        foto.setBounds(15, 16, 500, 176);
        panel1.add(foto);


        // Add the buttons into the panel with three different alignment options

		jb4.setAlignmentX(Component.RIGHT_ALIGNMENT);
		jb5.setAlignmentX(Component.RIGHT_ALIGNMENT);
		jb6.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel3.add(jb4);
		panel3.add(jb5);
		panel3.add(jb6);

		// Add the three panels into the frame
		frame.setLayout(new FlowLayout());
		frame.add(panel1);
		frame.add(panel3);

		// Set the window to be visible as the default to be false
		frame.pack();
		frame.setVisible(true);
	}

}
