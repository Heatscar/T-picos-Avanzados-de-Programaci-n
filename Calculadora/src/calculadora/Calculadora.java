/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author heatscar
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frameCalculadora fc = new frameCalculadora();
        //fc.setSize(Ancho, Largo);
        fc.setSize(321, 420);
        fc.setLocationRelativeTo(null);
        fc.setDefaultCloseOperation(frameCalculadora.EXIT_ON_CLOSE);
        fc.setVisible(true);
        
    }
}
