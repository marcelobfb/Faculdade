import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    private List<ItemBiblioteca> itens = new ArrayList<>();

    public void adicionarItem(ItemBiblioteca item) {
        itens.add(item);
    }

    public void listarItens() {
        for (ItemBiblioteca item : itens) {
            item.exibirDados();
        }
    }

    public ItemBiblioteca buscarItem(String titulo) {
        for (ItemBiblioteca item : itens) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }
        throw new ItemNaoEncontradoException("Item não encontrado.");
    }

    public void removerItem(String titulo) {
        ItemBiblioteca item = buscarItem(titulo);
        itens.remove(item);
    }
}
