package dominio;

public class Funcionario {
    private String nome;
    private double salarioBase;
    private String categoria;

    public Funcionario(String nome,double salarioBase, String categoria){
        this.nome=nome;
        this.salarioBase=salarioBase;
        this.categoria=categoria.toUpperCase();
    }
    public double calcularSalarioFinal(){
        double salarioFinal=salarioBase;
        switch (categoria){
            case "A":
                salarioFinal+=salarioBase*0.20;
                break;
            case "B":
                salarioFinal+=salarioBase*0.10;
                break;
            case "C":
                break;
            default:
                System.out.println("Categoria Invalida.");
        }
        return salarioFinal;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public String getCategoria() {
        return categoria;
    }
}
