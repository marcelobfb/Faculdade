package dominio;

public class pessoa {
    private int id;
    private String nome;
    private int idade;
    private double peso;
    private double altura;

    public pessoa(int id, String nome, int idade, double peso, double altura) {
        super();
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void listarPessoa(){
        System.out.println("\n"+id);
        System.out.println(nome);
        System.out.println(idade);
        System.out.println(peso);
        System.out.println(altura);
    }
    public double calcularimc(){
        return peso/(altura*altura);
    }
}
