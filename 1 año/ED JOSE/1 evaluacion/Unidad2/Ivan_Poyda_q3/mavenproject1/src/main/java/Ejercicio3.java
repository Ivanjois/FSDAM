import javax.swing.JFrame;
import javax.swing.JLabel;
public class Ejercicio3 extends JFrame{
public Ejercicio3(){
JLabel lblSaludo = new JLabel("Hola Mundo. Desde la ventana de Ivan Poyda.");
add(lblSaludo);
this.setSize(400,200);
this.setTitle("JFrame");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
}
public static void main(String[] args) {
Ejercicio3 main = new Ejercicio3();
}
}
