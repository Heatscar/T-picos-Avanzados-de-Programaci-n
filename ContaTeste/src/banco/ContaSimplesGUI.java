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


public class ContaSimplesGUI extends JFrame {
    private JLabel label;
    private JTextField numero, nombre, saldo;
    private JButton registrar, regresar;
    
    public ContaSimplesGUI() {
        super("CRear cuenta");
        setLayout( new FlowLayout());
        
        label = new JLabel("Numero de cuenta");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        numero = new JTextField(20);
        add(numero);
        
        label = new JLabel("Nombre");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        nombre = new JTextField(20);
        add(nombre);
        
        label = new JLabel("Saldo inicial");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        saldo = new JTextField(20);
        add(saldo);
        
        registrar = new JButton("Registrar");
        registrar.setBounds(50, 310, 100, 60);
        add(registrar);
        
        regresar = new JButton("Regresar");
        regresar.setBounds(50, 310, 100, 60);
        add(regresar);
        
        TextFieldHandler handler = new TextFieldHandler();
        registrar.addActionListener(handler);
        regresar.addActionListener(handler);
    }
    private class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == registrar) {
                String num;
                String nom;
                String sal;
                try {
                    num = numero.getText();
                } catch (NullPointerException e) {
                    num = "0";
                }
                try {
                    nom = nombre.getText();
                } catch (NullPointerException e) {
                    nom = "0";
                }
                try {
                    sal = saldo.getText();
                } catch (NullPointerException e) {
                    sal = "0";
                }


                //salva no banco
                try {
                    Banco banco = Banco.getInstancia();

                    banco.criarContaSimples(Integer.parseInt(num), nom, Float.parseFloat(sal));

                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "Formato incorreto de entrada"); 

                }
            }
            
            MenuGUI GUI = new MenuGUI();
            GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GUI.setSize(260, 180);
            GUI.setVisible(true);
            GUI.setLocationRelativeTo(ContaSimplesGUI.this);
            ContaSimplesGUI.this.dispose();
        
        }
    }
}
