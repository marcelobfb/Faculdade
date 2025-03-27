package dominio;

public class CaixaEletronico {
    private double saldo;

    public CaixaEletronico(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public int sacar(double valor) {
        // Verifica se o valor é múltiplo de 10
        if (valor % 10 != 0) {
            return -1; // Código de erro para valor não múltiplo de 10
        }

        // Verifica se há saldo suficiente
        if (valor > saldo) {
            return -2; // Código de erro para saldo insuficiente
        }

        // Realiza o saque
        saldo -= valor;
        return 1; // Código de sucesso
    }

    public void exibirSaldo() {
        System.out.printf("Saldo disponível: R$%.2f\n", saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}