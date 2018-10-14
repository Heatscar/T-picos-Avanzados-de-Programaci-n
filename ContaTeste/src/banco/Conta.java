
package banco;

import java.io.Serializable;

public abstract class Conta implements Serializable{
    private String nombre;
    private int numero;
    private float saldo;
    
    
  

    public Conta() {
        this.nombre = "0";
        this.numero = 0;
        this.saldo = 0;
    }

    public Conta(int numero, String nome, float saldo) {
        this.nombre = nome;
        this.numero = numero;
        this.saldo = saldo;
    }
    //Metodos personalizados
    
    public void sacar(float valor) {
        this.setSaldo(this.getSaldo() - valor);
    }
    
    public void depositar(float valor) {
        this.setSaldo(this.getSaldo() + valor);
    }
    
    //Metodos especiais
    public String getNome() {
        return nombre;
    }

    public void setNome(String nome) {
        this.nombre = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
   
    
}
