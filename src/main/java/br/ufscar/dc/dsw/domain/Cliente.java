package br.ufscar.dc.dsw.domain;

import java.util.Date;

public class Cliente extends Usuario{

    private Long id;
    private String email;
    private String senha;
    private String cpf;
    private String nome;
    private Long telefone;
    private char sexo;
    private Date dataNascimento;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Long getTelefone(){
        return telefone;
    }

    public void setTelefone(Long telefone){
        this.telefone = telefone;
    }

    public char getSexo(){
        return sexo;
    }

    public void setSexo(char sexo){
        this.sexo = sexo;
    }

    public Date getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

}
