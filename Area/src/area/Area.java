
package area;

/**
 *
 * @author heatscar
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
//import javax.swing.ButtonGroup;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import static java.lang.Math.PI;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


public class Area extends JFrame implements ActionListener, KeyListener, WindowListener{
    
    public Area(){
    setTitle("Calcular area");
    
       n1 = new JLabel("Base");
       n1.setBounds(10, 10, 100, 20);
       txtn1 = new JTextField("");
       txtn1.setBounds(120,10,100,20);
       
       n2 = new JLabel("Altura");
       n2.setBounds(10, 40, 100, 20);
       txtn2 = new JTextField("");
       txtn2.setBounds(120,40,100,20);
       
       n3 = new JLabel("Radio");
       n3.setBounds(10, 70, 100, 20);
       txtn3 = new JTextField("");
       txtn3.setBounds(120,70,100,20);
       
       res = new JLabel("Area");
       res.setBounds(10, 100, 100, 20);
       txtRes = new JTextField("");
       txtRes.setEditable(false);
       txtRes.setBounds(120,100,100,20);
       
       //btnSumar.setBounds(X, Y, anchura, altura);
       rect = new JRadioButton("Rectangulo");
       rect.setBounds(300, 10, 120, 20);
       circ = new JRadioButton("Circulo");
       circ.setBounds(300, 40, 110, 20);
       triang = new JRadioButton("Triangulo");
       triang.setBounds(300, 70, 130, 20);
       btnSalir = new JButton("Salir");
       btnSalir.setBounds(140, 140, 200, 20);
       
       add(n1);
       add(n2);
       add(n3);
       add(txtn1);
       add(txtn2);
       add(txtn3);
       add(res);
       add(txtRes);
       add(rect);
       add(circ);
       add(triang);
       add(btnSalir);
      
       //agregar el evento
       rect.addActionListener(this);
       circ.addActionListener(this);
       triang.addActionListener(this);
       btnSalir.addActionListener(this);
       txtn1.addKeyListener(this);
       this.addWindowListener(this);
           
       //obligatorio
       setLayout(null);
       setSize(510,270);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
       setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new Area();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int n1 = Integer.parseInt(txtn1.getText());
        int n2 = Integer.parseInt(txtn2.getText());
        int n3 = Integer.parseInt(txtn3.getText());
        
        if (e.getSource().equals(rect)){
             txtRes.setText(Integer.toString((n1*n2)));
        }
        else if (e.getSource().equals(circ)){
             txtRes.setText(Integer.toString((int) ((n3*n3)*PI)));
        }
        else if (e.getSource().equals(triang)){
             txtRes.setText(Integer.toString((n1*n2/2)));
        }
        else
            System.exit(0);
    }
    
    private JLabel n1, n2, n3, res;
    private JButton btnSalir;
    private JTextField txtn1, txtn2, txtn3, txtRes;
    private JRadioButton rect, circ, triang;
    
    @Override
    public void keyTyped(KeyEvent e) {     
        if (!(e.getKeyChar()>= '0' && e.getKeyChar() <='9') &&
                e.getKeyChar() != KeyEvent.VK_BACK_SPACE && 
                e.getKeyChar() != '-' ){
            e.consume();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {                   
    }
    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    @Override
    public void windowOpened(WindowEvent e) {
       
    }
    @Override
    public void windowClosing(WindowEvent e) {
     int x= JOptionPane.showConfirmDialog(this, "Realmente deseas salir?",
                                          "Salir",  JOptionPane.YES_NO_OPTION);
      if (x == JOptionPane.NO_OPTION)
      {
         this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
      }
      else{
         this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      }       
    }
    
    @Override
    public void windowClosed(WindowEvent e) {
        
    }
    @Override
    public void windowIconified(WindowEvent e) {
        
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
     
    }
    @Override
    public void windowActivated(WindowEvent e) {
        
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
    
    }
    
}
