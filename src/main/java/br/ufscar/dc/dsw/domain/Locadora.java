package br.ufscar.dc.dsw.domain;

public class Locadora extends Usuario{

    private String cnpj;
    private String cidade;

    public Locadora(Long id, String email, String senha, String nome, String cnpj, String cidade){
        super(id, email, senha, nome, "admin");
        this.cnpj = cnpj;
        this.cidade = cidade;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }
}
