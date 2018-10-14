package banco;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class ConsultaContasGUI extends JFrame {
    private JLabel label1, label2, label3;
    private JButton ok;
    
    public ConsultaContasGUI(Conta c) {
        super("Consultar");
        setLayout( new FlowLayout());
        
        if (c instanceof ContaSimples) {
            label1 = new JLabel("Numero: " + c.getNumero());
            label1.setHorizontalTextPosition(SwingConstants.CENTER);
            label1.setVerticalTextPosition(SwingConstants.TOP); 
            label1.setToolTipText("Numero de cuenta");
            add(label1);
            
            label2 = new JLabel("Nombre: " + c.getNome());
            label2.setHorizontalTextPosition(SwingConstants.CENTER);
            label2.setVerticalTextPosition(SwingConstants.CENTER); 
            label2.setToolTipText("Nombre de la cuenta");
            add(label2);
            
            label3 = new JLabel("Saldo: " + c.getSaldo());
            label3.setHorizontalTextPosition(SwingConstants.CENTER);
            label3.setVerticalTextPosition(SwingConstants.BOTTOM); 
            label3.setToolTipText("Saldo de la cuenta");
            add(label3);
        }
         else {
            
            label1 = new JLabel("Numero: " + c.getNumero());
            label1.setHorizontalTextPosition(SwingConstants.CENTER);
            label1.setVerticalTextPosition(SwingConstants.TOP); 
            label1.setToolTipText("Numero de cuenta");
            add(label1);
            
            label2 = new JLabel("Nombre: " + c.getNome());
            label2.setHorizontalTextPosition(SwingConstants.CENTER);
            label2.setVerticalTextPosition(SwingConstants.TOP); 
            label2.setToolTipText("Nombre de la cuenta");
            add(label2);
            
            label3 = new JLabel("Saldo: " + c.getSaldo());
            label3.setHorizontalTextPosition(SwingConstants.CENTER);
            label3.setVerticalTextPosition(SwingConstants.CENTER); 
            label3.setToolTipText("Saldo de la cuenta");
            add(label3);
            
        }
                
        
        ok = new JButton("OK");
        ok.setBounds(50, 310, 100, 60);
        add(ok);
        
        TextFieldHandler handler = new TextFieldHandler();
        ok.addActionListener(handler);        
    }
    private class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event)
        {
                MenuGUI GUI = new MenuGUI();
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setSize(260, 180);
                GUI.setVisible(true);
                ConsultaContasGUI.this.dispose();
           
        }
    }
}
