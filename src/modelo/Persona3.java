package modelo;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import vista.Casino;

public class Persona3 extends Thread {

    private int tiempo;

    public Persona3(int milisegundos) {
        this.tiempo = milisegundos;
    }

    public void run() {
        while (true) {
            int numero = (int) (Math.random() * (8) + 1);
            String ruta = "src\\Imagenes\\" + numero + ".png";
            ImageIcon imageIcon = new ImageIcon(ruta);
            SetImagenLabel(Casino.lbImg3, ruta);
            Casino.lbImg2.setText("" + numero);
            try {
                Thread.sleep(this.tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void SetImagenLabel(JLabel LabelName, String root) {
        ImageIcon imagen = new ImageIcon(root);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(LabelName.getWidth(), LabelName.getHeight(), Image.SCALE_DEFAULT));
        LabelName.setIcon(icono);

    }
}
