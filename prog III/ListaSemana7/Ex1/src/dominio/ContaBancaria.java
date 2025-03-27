package dominio;

public class ContaBancaria
{
    private String titular;
    private double saldo;

    public ContaBancaria(String titular){
        this.titular=titular;
        this.saldo=0.0;
    }
    public void depositar(double valor){
        if (valor>0){
            saldo+=valor;
            System.out.println("Depósito de R$"+valor+" realizado com sucesso.");
        }
        else{
            System.out.println("Valor de depósito inválido.");
        }
    }
    public void sacar(double valor) {
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque.");
            }
        } else {
            System.out.println("Valor de saque inválido.");
        }
    }
    public void exibirSaldo(){
        System.out.println("Saldo atual da conta de "+titular+": R$"+saldo);
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
