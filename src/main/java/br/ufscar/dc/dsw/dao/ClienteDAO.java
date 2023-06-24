package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Cliente;

public class ClienteDAO extends GenericDAO {
    public void insert (Cliente cliente){

        String sql = "INSERT INTO Cliente (email, senha, cnpj, nome, cidade) VALUES (?, ?, ?, ?, ?)";// errado

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement = conn.prepareStatement(sql);

            /////////////

            statement.close();
            conn.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Cliente> getAll() {

        List<Cliente> listaClientes = new ArrayList<>();
        
        String sql = "SELECT * FROM Cliente c";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ////////////
            }

            resultSet.close();
            statement.close();
            conn.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaClientes;
    }

    public void delete(Cliente cliente){
        String sql = "DELETE FROM Cliente where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, cliente.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    public void update(Cliente cliente){

        String sql = "UPDATE Cliente SET email = ?, senha = ?, cnpj = ?, nome = ?, cidade = ? WHERE id = ?";//errado tbm
        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement = conn.prepareStatement(sql);
            ///////////////////
            statement.executeUpdate();

            statement.close();
            conn.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
