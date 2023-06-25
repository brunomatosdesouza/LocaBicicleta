package br.ufscar.dc.dsw.domain;

public class Cliente extends Usuario{

    private String cpf;
    private String telefone;
    private String sexo;
    private String dataNascimento;

    public Cliente(Long id, String email, String senha, String nome, String cpf, String telefone, String sexo, String dataNascimento){
        super(id, email, senha, nome, "cliente");
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getSexo(){
        return sexo;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

}
