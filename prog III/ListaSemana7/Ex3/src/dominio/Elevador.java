package dominio;

public class Elevador {
    private int andarAtual;
    private int totalAndares;

    public Elevador(int andarAtual,int totalAndares){
        this.andarAtual=andarAtual;
        this.totalAndares=totalAndares;
    }
    public int subir(){
        if(andarAtual!=totalAndares){
            andarAtual+=1;
        }
        else {
            System.out.println("Você ja esta no ultimo andar.");
        }
        return andarAtual;
    }
    public int descer(){
        if(andarAtual>0){
            andarAtual-=1;
        }
        else{
            System.out.println("Você ja esta no terreo");
        }
        return andarAtual;
    }

    public void exibirAndar(){
        System.out.println("Voce esta no "+andarAtual+" andar");
    }


}
