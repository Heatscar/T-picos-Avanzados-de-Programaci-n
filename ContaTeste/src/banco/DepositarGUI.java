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


public class DepositarGUI extends JFrame {
    private JLabel label, label2;
    private JTextField numero, valor;
    private JButton depositar, sair;
    
    public DepositarGUI() {
        super("Depositar en una cuenta");
        setLayout( new FlowLayout());
        
        label = new JLabel("Digite numero de cuenta");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        numero = new JTextField(20);
        add(numero);
        
        label = new JLabel("Cuanto va a depositar");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        valor = new JTextField(20);
        add(valor);
        
        sair = new JButton("Regresar");
        sair.setBounds(50, 310, 100, 60);
        add(sair);
        
        depositar = new JButton("Depositar");
        depositar.setBounds(50, 310, 100, 60);
        add(depositar);
        
        TextFieldHandler handler = new TextFieldHandler();
        depositar.addActionListener(handler);
        sair.addActionListener(handler);
    }
    private class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == depositar) {
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


                //salva no banco
                try {
                    Banco banco = Banco.getInstancia();

                    banco.depositarConta(Integer.parseInt(num), Float.parseFloat(sal));



                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "Formato incorreto de entrada"); 

                }
            }
            
            MenuGUI GUI = new MenuGUI();
            GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GUI.setSize(260, 180);
            GUI.setVisible(true);
            GUI.setLocationRelativeTo(DepositarGUI.this);
            DepositarGUI.this.dispose();
        }
    }
}
