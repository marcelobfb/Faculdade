package modelo;

public class Carta {
    private int id;
    private String nome;
    private int velocidade;
    private int aceleracao;
    private int potencia;
    private boolean superTrunfo;

    public Carta() {}

    public Carta(int id, String nome, int velocidade, int aceleracao, int potencia, boolean superTrunfo) {
        this.id = id;
        this.nome = nome;
        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.potencia = potencia;
        this.superTrunfo = superTrunfo;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getVelocidade() { return velocidade; }
    public void setVelocidade(int velocidade) { this.velocidade = velocidade; }

    public int getAceleracao() { return aceleracao; }
    public void setAceleracao(int aceleracao) { this.aceleracao = aceleracao; }

    public int getPotencia() { return potencia; }
    public void setPotencia(int potencia) { this.potencia = potencia; }

    public boolean isSuperTrunfo() { return superTrunfo; }
    public void setSuperTrunfo(boolean superTrunfo) { this.superTrunfo = superTrunfo; }
}