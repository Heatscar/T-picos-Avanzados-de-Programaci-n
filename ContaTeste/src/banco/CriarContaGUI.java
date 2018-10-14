package banco;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class CriarContaGUI extends JFrame {
    private JButton simplesButton, regresar;
    private JLabel label;
    
    public CriarContaGUI() {
        super("Crear cuenta");
        setLayout( new FlowLayout());
        
        //declarar novo label
        label = new JLabel("Crear cuenta");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP); 
        label.setToolTipText("label");
        add(label);
        
        simplesButton = new JButton("Cuenta nueva");
        simplesButton.setBounds(50, 10, 100, 60);
        add(simplesButton);
        
        
        
        regresar = new JButton("Regresar");
        regresar.setBounds(50, 10, 100, 60);
        add(regresar);
        
       ButtonHandler handler = new ButtonHandler();
       simplesButton.addActionListener(handler);
       regresar.addActionListener(handler);
        
    }
    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == simplesButton) {
                ContaSimplesGUI textField = new ContaSimplesGUI();
                textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                textField.setSize(260, 210);
                textField.setVisible(true);
                textField.setLocationRelativeTo(CriarContaGUI.this);
            }
            
             else {
                CriarContaGUI.this.dispose();
                MenuGUI GUI = new MenuGUI();
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setSize(260, 180);
                GUI.setVisible(true);
                GUI.setLocationRelativeTo(CriarContaGUI.this);
            }
            CriarContaGUI.this.dispose();
        }
    }
}
