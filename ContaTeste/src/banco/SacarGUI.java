package banco;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class SacarGUI extends JFrame {
    private JLabel label;
    private JTextField numero, valor;
    private JButton sacar, sair;
    
    public SacarGUI() {
        super("Retirar");
        setLayout( new FlowLayout());
        
        label = new JLabel("Numero de cuenta");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        numero = new JTextField(20);
        add(numero);
        
        label = new JLabel("Cuanto va a sacar");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        valor = new JTextField(20);
        add(valor);
        
        sair = new JButton("regresar");
        sair.setBounds(50, 310, 100, 60);
        add(sair);
        
        sacar = new JButton("Registrar");
        sacar.setBounds(50, 310, 100, 60);
        add(sacar);
        
        TextFieldHandler handler = new TextFieldHandler();
        sacar.addActionListener(handler);
        sair.addActionListener(handler);
    }
    private class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == sacar) {
                String num;
                String sal;
                try {
                    num = numero.getText();
                } catch (NullPointerException e) {
                    num = "0";
                }
                try {
                    sal = valor.getText();
                } catch (NullPointerException e) {
                    sal = "0";
                }


                //guardado en el banco
                try {
                    Banco banco = Banco.getInstancia();

                    banco.sacarConta(Integer.parseInt(num), Float.parseFloat(sal));



                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "Formato incorreto de entrada"); 

                }
            }
                
            
            MenuGUI GUI = new MenuGUI();
            GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GUI.setSize(260, 180);
            GUI.setVisible(true);
            GUI.setLocationRelativeTo(SacarGUI.this);
            SacarGUI.this.dispose();
        }
    }
}
