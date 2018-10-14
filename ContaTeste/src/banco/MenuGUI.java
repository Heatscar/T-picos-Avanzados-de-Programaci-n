package banco;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MenuGUI extends JFrame {
    private JLabel label;
    private JButton CriarContaButton, ConsultaButton, SairButton;
    private JButton SaqueButton, DepositarButton;
    
    public MenuGUI() {
        super("Menu");
        setLayout( new FlowLayout());
        
        //declarar novo label
        label = new JLabel("Elija la opcion deseada");
        
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        CriarContaButton = new JButton("Crear cuenta");
        CriarContaButton.setBounds(50, 10, 100, 60);
        add(CriarContaButton);
        
        ConsultaButton = new JButton("Consultar");
        ConsultaButton.setBounds(50, 70, 100, 60);
        add(ConsultaButton);
        
        SaqueButton = new JButton("Sacar");
        SaqueButton.setBounds(50, 130, 100, 60);
        add(SaqueButton);
        
        DepositarButton = new JButton("Deposito");
        DepositarButton.setBounds(50, 190, 100, 60);
        add(DepositarButton);
        
        SairButton = new JButton("Salir");
        SairButton.setBounds(50, 310, 100, 60);
        add(SairButton);
        
        
        ButtonHandler handler = new ButtonHandler();
        CriarContaButton.addActionListener(handler);
        ConsultaButton.addActionListener(handler);
        SaqueButton.addActionListener(handler);
        DepositarButton.addActionListener(handler);
        SairButton.addActionListener(handler);
       
    }
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == CriarContaButton) {
                CriarContaGUI textField = new CriarContaGUI();
                
                textField.setVisible(true);
                textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                textField.setSize(260, 180);
                textField.setLocationRelativeTo(MenuGUI.this);
                
            }
            
            else if (event.getSource() == ConsultaButton){
                ConsultaGUI textField = new ConsultaGUI();
                textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                textField.setSize(260, 180);
                textField.setVisible(true);
                textField.setLocationRelativeTo(MenuGUI.this);
            }
            
            else if (event.getSource() == SaqueButton){
                SacarGUI textField = new SacarGUI();
                textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                textField.setSize(260, 180);
                textField.setVisible(true);
                textField.setLocationRelativeTo(MenuGUI.this);
            }
            
            else if (event.getSource() == DepositarButton){
                DepositarGUI textField = new DepositarGUI();
                textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                textField.setSize(260, 180);
                textField.setVisible(true);
                textField.setLocationRelativeTo(MenuGUI.this);
            }
            
            else if (event.getSource() == SairButton){
                Banco banco = Banco.getInstancia();
                
                banco.salvarContas();
                
                System.exit(0);
            }
            MenuGUI.this.dispose();
          
        }
    }
   
    
}
