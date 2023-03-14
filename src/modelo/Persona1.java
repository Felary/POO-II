package modelo;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import vista.Casino;

public class Persona1 extends Thread {

    private int tiempo;

    public Persona1(int milisegundos) {
        this.tiempo = milisegundos;
    }

    private void SetImagenLabel(JLabel LabelName, String root) {
        ImageIcon imagen = new ImageIcon(root);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(LabelName.getWidth(), LabelName.getHeight(), Image.SCALE_DEFAULT));
        LabelName.setIcon(icono);
        
    }

    public void run() {
        while (true) {
            int numero = (int) (Math.random() * (8) + 1);
            String ruta = "src\\Imagenes\\" + numero + ".png";
            ImageIcon imageIcon = new ImageIcon(ruta);
            SetImagenLabel(Casino.lbImg1, ruta);
            Casino.lbImg1.setText(""+numero);

            try {
                Thread.sleep(this.tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
