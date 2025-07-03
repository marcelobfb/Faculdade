public class Livro extends ItemBiblioteca implements Exibivel {
    private String genero;

    public Livro(String titulo, String autor, int anoPublicacao, String genero) {
        super(titulo, autor, anoPublicacao);
        this.genero = genero;
    }

    @Override
    public void exibirDados() {
        System.out.println("Livro: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao + ", Gênero: " + genero);
    }
}
