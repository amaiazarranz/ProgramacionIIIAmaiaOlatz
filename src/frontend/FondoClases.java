package frontend;

import javax.swing.*;
import java.awt.*;

public class FondoClases extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    public FondoClases()
    {
        this.setSize(700, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/camaras.jpg"));
        g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}

