package Classes;

public class CadastroConta {
    private int numero_conta;
    private String nome_titular;
    private double saldo;

    public CadastroConta(int numero_conta, String nome_titular, double saldo) {
        this.numero_conta = numero_conta;
        this.nome_titular = nome_titular;
        this.saldo = saldo;
    }

    public int getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(int numero_conta) {
        this.numero_conta = numero_conta;
    }

    public String getNome_titular() {
        return nome_titular;
    }

    public void setNome_titular(String nome_titular) {
        this.nome_titular = nome_titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }
}
