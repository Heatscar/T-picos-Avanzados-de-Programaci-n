package banco;

import javax.swing.JFrame;

public class ContaTeste {
    
    public static void main(String[] args) {
        Banco banco = Banco.getInstancia();
        banco.carregarContas();
        
        MenuGUI labelFrame = new MenuGUI();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(260, 180);
        labelFrame.setVisible(true);
    
    }
}
