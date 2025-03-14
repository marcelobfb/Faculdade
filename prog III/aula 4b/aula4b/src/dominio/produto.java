package dominio;

public class produto {
    public int codigo;
    public String descricao;
    public double valor;

    public produto(){

    }
    public produto(int codigo,String descricao, double valor){
        this.codigo=codigo;
        this.descricao=descricao;
        this.valor=valor;
    }
    public void listarProduto(){
        System.out.println(codigo);
        System.out.println(descricao);
        System.out.println(valor);
    }

}
