package banco;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Banco {
    private static Banco instancia;
    private static Collection<Conta> contas;
    
    
    private Banco(){
        contas = new ArrayList();
    }
    
    public static Banco getInstancia() {
        if (instancia == null){
            instancia = new Banco();
        }
        return instancia;
    }
    
    public void criarContaSimples(int numero, String nombre, float saldo) {
        for (Conta c : contas){
            if (c.getNumero() == numero){
                JOptionPane.showMessageDialog(null, "Numero de cuenta ya usado!");
                return;
            }
        }
        contas.add(new ContaSimples(numero, nombre, saldo));
    }
    public Conta consultaConta(int numero) {
        for (Conta c : contas){
            if (c.getNumero() == numero){
                return c;
            }
        }
       return null;
    }
    public void sacarConta(int numero, float valor) {
        for (Conta c : contas){
            if (c.getNumero() == numero){
                contas.remove(c);
                if ( 0 <= c.getSaldo() - valor ) {
                        c.sacar(valor);
                        JOptionPane.showMessageDialog(null, "Monto sacado con exito!"); 
                    }   else {
                        JOptionPane.showMessageDialog(null, "Imposible sacar, saldo insuficiente!"); 
                    }
               contas.add(c);
               return;
           }
       }
       JOptionPane.showMessageDialog(null, "Cuenta no encontrada!");
   }
    public void depositarConta(int numero, float valor) {
        for (Conta c : contas){
            if (c.getNumero() == numero){
               contas.remove(c);
               c.depositar(valor);
               contas.add(c);
               JOptionPane.showMessageDialog(null, "Monto depositado con exito!");
               return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
    }
    public int incrementar(){
        int qtd = 0;
        return qtd;
    }
    public void salvarContas() {
        int qtd = 0;
        try {
            ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients.ser")));
            for (Conta c : contas){
                output.writeObject(c);
                qtd++;
            }
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null,"ErrR!");
        }
            JOptionPane.showMessageDialog(null,qtd + " cuenta(s) guardada(s) en la memoria!");
    }
    public void carregarContas() {
        int qtd = 0;
        try {
            ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("clients.ser")));
            while (true) {
                contas.add((Conta) input.readObject());
                qtd++;
            }
        } catch (EOFException endOfFileException) {
            JOptionPane.showMessageDialog(null,qtd + " cuenta(s) cargadas(s) en la memoria!");
        } catch(ClassNotFoundException classNotFoundException) {
            JOptionPane.showMessageDialog(null,"Tipo de clase invalida del archivo!");
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null,"ErrR!");
        }

    }
}
