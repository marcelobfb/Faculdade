public abstract class ItemBiblioteca {
    protected String titulo;
    protected String autor;
    protected int anoPublicacao;

    public ItemBiblioteca(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public abstract void exibirDados();

    public String getTitulo() {
        return titulo;
    }
}
