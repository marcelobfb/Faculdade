package modelo;

public class Cliente {
    private String cpf, nome;
    private Animal[] animais;
    private int i = 0;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        animais = new Animal[3];
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addAnimal(Animal novoAnimal) {
        if (i < animais.length) {
            animais[i] = novoAnimal;
            i++;
            novoAnimal.setCliente(this);
        }
    }

    public void removerAnimal(Animal exAnimal) {
        for (int j = 0; j < animais.length; j++) {
            if (animais[j] == exAnimal) {
                animais[j] = null;
                exAnimal.setCliente(null);
            }
        }
    }

    public Animal[] getAnimais() {
        return animais;
    }

}
