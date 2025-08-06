package dominio;

public class PessoaJuridica extends Cliente {
    private String cnpj,razaosocial;

    public PessoaJuridica(String endereco, String telefone, String cnpj, String razaosocial) {
        super(endereco, telefone);
        this.cnpj = cnpj;
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String formatarRegistro(){
        String cnpjFormatado=cnpj.substring(0,3)+"."+cnpj.substring(3,5)+"."+cnpj.substring(5,8)+"/"+cnpj.substring(8,12)+"-"+cnpj.substring(12,14);
        return cnpjFormatado;
    }
}
