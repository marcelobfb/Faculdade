package model;

/**
 * MODEL — Representa uma carta do Super Trunfo Carros Pixar.
 *
 * Atributos comparáveis:
 *   velocidade   (km/h)  — maior vence
 *   potencia     (cv)    — maior vence
 *   peso         (kg)    — MENOR vence (carro mais leve é vantagem)
 *   tanque       (L)     — maior vence
 *   popularidade (1-10)  — maior vence
 *   vitorias     (n°)    — maior vence
 */
public class Carta {

    private int     id;
    private String  codigo;
    private String  nome;
    private String  tipo;
    private int     velocidade;
    private int     potencia;
    private int     peso;
    private int     tanque;
    private int     popularidade;
    private int     vitorias;
    private boolean superTrunfo;

    // ──────────── Construtores ────────────

    public Carta() {}

    public Carta(int id, String codigo, String nome, String tipo,
                 int velocidade, int potencia, int peso,
                 int tanque, int popularidade, int vitorias, boolean superTrunfo) {
        this.id           = id;
        this.codigo       = codigo;
        this.nome         = nome;
        this.tipo         = tipo;
        this.velocidade   = velocidade;
        this.potencia     = potencia;
        this.peso         = peso;
        this.tanque       = tanque;
        this.popularidade = popularidade;
        this.vitorias     = vitorias;
        this.superTrunfo  = superTrunfo;
    }

    // ──────────── Getters & Setters ────────────

    public int     getId()                          { return id; }
    public void    setId(int id)                    { this.id = id; }

    public String  getCodigo()                      { return codigo; }
    public void    setCodigo(String codigo)         { this.codigo = codigo; }

    public String  getNome()                        { return nome; }
    public void    setNome(String nome)             { this.nome = nome; }

    public String  getTipo()                        { return tipo; }
    public void    setTipo(String tipo)             { this.tipo = tipo; }

    public int     getVelocidade()                  { return velocidade; }
    public void    setVelocidade(int velocidade)    { this.velocidade = velocidade; }

    public int     getPotencia()                    { return potencia; }
    public void    setPotencia(int potencia)        { this.potencia = potencia; }

    public int     getPeso()                        { return peso; }
    public void    setPeso(int peso)                { this.peso = peso; }

    public int     getTanque()                      { return tanque; }
    public void    setTanque(int tanque)            { this.tanque = tanque; }

    public int     getPopularidade()                { return popularidade; }
    public void    setPopularidade(int popularidade){ this.popularidade = popularidade; }

    public int     getVitorias()                    { return vitorias; }
    public void    setVitorias(int vitorias)        { this.vitorias = vitorias; }

    public boolean isSuperTrunfo()                  { return superTrunfo; }
    public void    setSuperTrunfo(boolean st)       { this.superTrunfo = st; }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nome;
    }
}
