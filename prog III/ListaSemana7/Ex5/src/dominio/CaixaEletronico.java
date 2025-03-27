package dominio;

public class CaixaEletronico {
    private double saldo;

    public CaixaEletronico(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public int sacar(double valor) {
        if (valor % 10 != 0) {
            return -1;
        }

        if (valor > saldo) {
            return -2;
        }

        saldo -= valor;
        return 1;
    }

    public void exibirSaldo() {
        System.out.printf("Saldo disponível: R$%.2f\n", saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
