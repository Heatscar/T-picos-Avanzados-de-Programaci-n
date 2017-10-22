import javax.swing.JFrame;
import java.awt.Color;

/**
 *
 * @author heatscar
 */

public class PingPong extends JFrame {
	public static void main(String[] args) {
		JFrame aux = new JFrame();
		aux.setSize(600, 400);
		aux.setLocation(200, 100);
		aux.setTitle("Ping-Pong");
		aux.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Controlador c = new Controlador();
		aux.add(c);
		aux.addKeyListener(c);
		c.setBackground(Color.WHITE);
		Thread t = new Thread(c);
		t.start();
		aux.setVisible(true);
		aux.setResizable(false);
		return;
	}
}