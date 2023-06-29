package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Cliente;

public class LocacaoDAO extends GenericDAO{
    public void insert(Locacao locacao){

        String sql = "INSERT INTO Locacao (cpf, cnpj, data, cliente_id) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locacao.getCpf());
            statement.setString(2, locacao.getCnpj());
            statement.setString(3, locacao.getData());
            statement.setLong(4, locacao.getCliente().getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Locacao> getAll(Cliente cliente){
        
        List<Locacao> listaLocacoes = new ArrayList<>();

        String sql = "SELECT * FROM Locacao l WHERE l.cliente_id = ? ORDER BY l.id";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, cliente.getId());
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String cpf = resultSet.getString("cpf");
                String cnpj = resultSet.getString("cnpj");
                String data = resultSet.getString("data");
                Locacao locacao = new Locacao(id, cpf, cnpj, data, cliente);
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
