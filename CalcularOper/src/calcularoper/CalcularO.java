
package calcularoper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CalcularO extends JFrame implements ActionListener, KeyListener, WindowListener, ItemListener {

    public CalcularO(){
     setTitle("Operaciones");
     
     Num1 = new JLabel("Num1");
     Num1.setBounds(10, 40, 100, 20);
     Num2 = new JLabel("Num2");
     Num2.setBounds(10, 70, 100, 20);
     Res = new JLabel("Res");
     Res.setBounds(10, 130, 100, 20);
     Numeros = new JLabel("Numeros");
     Numeros.setBounds(10, 15, 100, 20);
     Oper = new JLabel("Operacion");
     Oper.setBounds(210, 15, 100, 20);
     
     txtNum1 = new JTextField("");
     txtNum1.setBounds(50, 40, 100, 20);
     txtNum2 = new JTextField("");
     txtNum2.setBounds(50, 70, 100, 20);
     txtRes = new JTextField("0");
     txtRes.setBounds(50, 130, 100, 20);
     
     btnCalcular = new JButton ("Calcular");
     btnCalcular.setBounds(50, 170, 100, 30);
     btnLimpiar = new JButton ("Limpiar");
     btnLimpiar.setBounds(180, 170, 100, 30);
     btnSalir = new JButton ("Salir");
     btnSalir.setBounds(110, 210, 100, 30);
  
     RbtnSuma = new JRadioButton("Suma");
     RbtnSuma.setBounds(200,40,100,20);
     RbtnResta = new JRadioButton("Resta");
     RbtnResta.setBounds(200,70,100,20);
     RbtnMultiplicacion = new JRadioButton("Multiplicacion");
     RbtnMultiplicacion.setBounds(200,100,100,20);
     RbtnDivision = new JRadioButton("Division");
     RbtnDivision.setBounds(200,130,100,20);
    
     
     add(Num1);
     add(Num2);
     add(Res);
     add(Numeros);
     add(Oper);
     add(txtNum1);
     add(txtNum2);
     add(txtRes);
     add(btnCalcular);
     add(btnLimpiar);
     add(btnSalir);
     add(RbtnResta);
     add(RbtnSuma);
     add(RbtnMultiplicacion);
     add(RbtnDivision);
     
     
     //Agregar el evento
     btnCalcular.addActionListener(this);
     btnLimpiar.addActionListener(this);
     btnSalir.addActionListener(this);
     txtRes.addKeyListener(this);
     txtNum2.addKeyListener(this);
     txtNum1.addKeyListener(this);
     this.addWindowListener(this);
     
     //Obligatorio
     setLayout(null);
     setSize(310,280);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setResizable(false);
     setVisible(true);
     
     //Agrupar RadioButtons para que solo se seleccione uno
     ButtonGroup bg = new ButtonGroup();
     bg.add(RbtnSuma);
     bg.add(RbtnResta);
     bg.add(RbtnMultiplicacion);
     bg.add(RbtnDivision);
     
     //No poder editar el resultado 
     txtRes.setEditable(false);
    }
    
    public static void main(String[] args) {
       
        new CalcularO(); 
    }

    public void panel (){
    
        plFiguras.add(RbtnResta);
        plFiguras.add(RbtnSuma);
        plFiguras.add(RbtnMultiplicacion);
        plFiguras.add(RbtnDivision);
        getContentPane().add(RbtnResta);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Float Num1 = Float.parseFloat(txtNum1.getText());
        Float Num2 = Float.parseFloat(txtNum2.getText());
        //Calcular el Area de las Figuras
        if(e.getSource().equals(btnCalcular)){
            if(RbtnResta.isSelected()==true){
              txtRes.setText(Float.toString(Num1 - Num2));
            }
            else if(RbtnMultiplicacion.isSelected()){
            txtRes.setText(Float.toString(Num1 * Num2));
        }
            else if(RbtnDivision.isSelected()){
            txtRes.setText(Float.toString(Num1 / Num2));
        }
        else if(RbtnSuma.isSelected()){
            txtRes.setText(Float.toString(Num1 + Num2));
            }
        }
        //Limpiar Datos Ingresados
      if  (e.getSource().equals(btnLimpiar)){
          txtNum1.setText("");
          txtNum2.setText("");
          txtRes.setText("");
      }
      //Salir
      if (e.getSource().equals(btnSalir)){
          System.exit(0);
      }
    }
 
    
    private JLabel Num1, Num2, Res, Numeros, Oper;
    private JTextField txtNum1, txtNum2, txtRadio, txtRes;
    private JButton btnCalcular, btnLimpiar, btnSalir;
    private JRadioButton RbtnResta, RbtnSuma, RbtnMultiplicacion, RbtnDivision;
    private JPanel plFiguras;

    @Override
    public void keyTyped(KeyEvent e) {

        char key = e.getKeyChar();

        if(Character.isLetter(key)){
            getToolkit().beep();

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
         int x = JOptionPane.showConfirmDialog(this, "Realmente desea salir?",
                                              "salir", JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.NO_OPTION){
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }
}

