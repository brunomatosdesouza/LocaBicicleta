package br.ufscar.dc.dsw.domain;

import java.util.Date;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;

public class Locacao {

    private Long id;
    private String cpf;
    private String cnpj;
    private String data;

    public Locacao(Long id, String cpf, String cnpj, String data) {
        this.id = id;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.data = data;
    }

    public Locacao(String cpf, String cnpj, String data) {
        super();
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.data = data;
    }

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

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

}
