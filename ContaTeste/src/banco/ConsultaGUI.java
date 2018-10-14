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


public class ConsultaGUI extends JFrame {
    private JLabel label;
    private JTextField numeroField;
    private JButton consultar, sair;
    
    public ConsultaGUI() {
        super("Consultar");
        setLayout( new FlowLayout());
        
        label = new JLabel("Digite el numero de cuenta");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        
        //declarar novo label
        numeroField = new JTextField(10);
        add(numeroField);
        
        consultar = new JButton("Consultar");
        consultar.setBounds(50, 310, 100, 60);
        add(consultar);
        
        sair = new JButton("Regresar");
        sair.setBounds(50, 310, 100, 60);
        add(sair);
        
        TextFieldHandler handler = new TextFieldHandler();
        consultar.addActionListener(handler);        
        sair.addActionListener(handler); 
    }
    private class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event)
        {
            try {
                
                if (event.getSource() == consultar) {
                    Conta c;
                    String numero;
                    try {
                        numero = numeroField.getText();
                    } catch (NullPointerException e) {
                        numero = null;
                    }

                        Banco banco = Banco.getInstancia();

                        c = banco.consultaConta(Integer.parseInt(numero));

                    if (c == null) {
                            JOptionPane.showMessageDialog(null, "Cuenta no encontrada"); 
                    } else {
                        ConsultaContasGUI GUI = new ConsultaContasGUI(c);
                        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        GUI.setSize(260, 180);
                        GUI.setVisible(true);
                        GUI.setLocationRelativeTo(ConsultaGUI.this);
                        ConsultaGUI.this.dispose();
                    }
                } else {
                        MenuGUI GUI = new MenuGUI();
                        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        GUI.setSize(260, 180);
                        GUI.setVisible(true);
                        GUI.setLocationRelativeTo(ConsultaGUI.this);
                        ConsultaGUI.this.dispose();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Numero invalido"); 
                MenuGUI GUI = new MenuGUI();
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setSize(260, 180);
                GUI.setVisible(true);
                GUI.setLocationRelativeTo(ConsultaGUI.this);
                ConsultaGUI.this.dispose();
            }
        }
    }
}
