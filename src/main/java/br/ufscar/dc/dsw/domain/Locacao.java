package br.ufscar.dc.dsw.domain;

import java.util.Date;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;

public class Locacao {

    private Long id;
    private String cpf;
    private String cnpj;
    private Date dataLocacao;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public Date getDataLocacao(){
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao){
        this.dataLocacao = dataLocacao;
    }

}
