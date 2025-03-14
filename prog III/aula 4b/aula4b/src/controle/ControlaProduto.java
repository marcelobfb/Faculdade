package controle;
import dominio.produto;

public class ControlaProduto {
    public static void main(String[] args)
    {
        produto prod = new produto();
        prod.codigo=1234;
        prod.descricao="Peixe";
        prod.valor=150;
        prod.listarProduto();

        produto prod2 = new produto(4567,"Frango",50);
        prod2.listarProduto();
    }

}
