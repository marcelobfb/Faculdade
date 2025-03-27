package dominio;

public class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome,double nota){
        this.nome=nome;
        this.nota=nota;
    }
    public int validarNota(){
        if (nota>=0 && nota<=10){
            return 1;
        }
        return 0;
    }
    public void classificarAluno(){
        if (nota>=7){
            System.out.println("Aprovado com nota "+nota);
        }
        else if (nota>=5) {
            System.out.println("Recuperação com nota "+nota);
       }
        else{
           System.out.println("Reprovado com nota "+nota);
       }
    }

}
