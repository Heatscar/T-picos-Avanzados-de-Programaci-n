
package mycalcu;

/**
 *
 * @author heatscar
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MyCalcu extends JFrame implements ActionListener, KeyListener, WindowListener{

    public MyCalcu(){
       setTitle("Calculadora");
       n1 = new JLabel("Numero 1");
       n1.setBounds(10, 10, 100, 20);
       txtn1 = new JTextField("");
       txtn1.setBounds(120,10,100,20);
       
       n2 = new JLabel("Numero 2");
       n2.setBounds(10, 40, 100, 20);
       txtn2 = new JTextField("");
       txtn2.setBounds(120,40,100,20);
       
       res = new JLabel("Resultado");
       res.setBounds(10, 70, 100, 20);
       txtRes = new JTextField("");
       txtRes.setEditable(false);
       txtRes.setBounds(120,70,100,20);
       
       //btnSumar.setBounds(X, Y, anchura, altura);
       btnSumar = new JButton("Sumar");
       btnSumar.setBounds(10, 100, 90, 20);
       btnRestar = new JButton("Restar");
       btnRestar.setBounds(110, 100, 90, 20);
       btnMulti = new JButton("Multiplicar");
       btnMulti .setBounds(40, 140, 200, 20);
       btnDiv = new JButton("Dividir");
       btnDiv .setBounds(40, 180, 200, 20);
       btnSalir = new JButton("Salir");
       btnSalir.setBounds(210, 100, 90, 20);
       
       add(n1);
       add(txtn1);
       add(n2);
       add(txtn2);
       add(res);
       add(txtRes);
       add(btnSumar);
       add(btnMulti);
       add(btnDiv);
       add(btnRestar);
       add(btnSalir);
       
       //agregar el evento
       btnSumar.addActionListener(this);
       btnRestar.addActionListener(this);
       btnMulti.addActionListener(this);
       btnDiv.addActionListener(this);
       btnSalir.addActionListener(this);
       txtn1.addKeyListener(this);
       txtn2.addKeyListener(this);
       this.addWindowListener(this);
           
       //obligatorio
       setLayout(null);
       setSize(310,250);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
       setVisible(true);
    }
    public static void main(String[] args) {
       new  MyCalcu();    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int n1 = Integer.parseInt(txtn1.getText());
        int n2 = Integer.parseInt(txtn2.getText());
        
        if (e.getSource().equals(btnSumar)){
            txtRes.setText(Integer.toString((n1+n2)));
        } 
        else if (e.getSource().equals(btnRestar)){
             txtRes.setText(Integer.toString((n1-n2)));
        }
        else if (e.getSource().equals(btnMulti)){
             txtRes.setText(Integer.toString((n1*n2)));
        }
        else if (e.getSource().equals(btnDiv)){
             txtRes.setText(Integer.toString((n1/n2)));
        }
        else
            System.exit(0);
    }
    
    private JLabel n1, n2, res;
    private JButton btnSumar, btnRestar, btnMulti, btnDiv, btnSalir;
    private JTextField txtn1, txtn2, txtRes;
    
    
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
