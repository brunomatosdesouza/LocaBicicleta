package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;

public class LocacaoDAO extends GenericDAO{
    public void insert(Locacao locacao){

        String sql = "INSERT INTO Locacao (cpf, cnpj, data) VALUES (?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locacao.getCpf());
            statement.setString(2, locacao.getCnpj());
            statement.setString(3, locacao.getData());

            statement.close();
            conn.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Locacao> getAll(){
        
        List<Locacao> listaLocacoes = new ArrayList<>();

        String sql = "SELECT * FROM locacao l";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String cpf = resultSet.getString("cpf");
                String cnpj = resultSet.getString("cnpj");
                String data = resultSet.getString("data");
                Locacao locacao = new Locacao(id, cpf, cnpj, data);
                listaLocacoes.add(locacao);
            }

            statement.close();
            conn.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }



        return listaLocacoes;

    }
}
