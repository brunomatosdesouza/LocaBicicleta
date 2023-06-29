package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Usuario;

public class ClienteDAO extends GenericDAO {
    public void insert (Cliente cliente){

        String sql = "INSERT INTO Cliente (email, senha, nome, papel, cpf, telefone, sexo, dataNascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getEmail());
            statement.setString(2, cliente.getSenha());
            statement.setString(3, cliente.getNome());
            statement.setString(4, cliente.getPapel());
            statement.setString(5, cliente.getCpf());
            statement.setString(6, cliente.getTelefone());
            statement.setString(7, cliente.getSexo());
            statement.setString(8, cliente.getDataNascimento());
            statement.executeUpdate();


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
                long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String papel = resultSet.getString("papel");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                String dataNascimento = resultSet.getString("dataNascimento");

                Cliente cliente = new Cliente(id, email, senha, nome, papel, cpf, telefone, sexo, dataNascimento);

                listaClientes.add(cliente);

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

        String sql = "UPDATE Cliente SET email = ?, senha = ?, nome = ?, papel = ?, cpf = ?, telefone = ?, sexo = ?, dataNascimento = ? WHERE id = ?";
        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, cliente.getEmail());
            statement.setString(2, cliente.getSenha());
            statement.setString(3, cliente.getNome());
            statement.setString(4, cliente.getPapel());
            statement.setString(5, cliente.getCpf());
            statement.setString(6, cliente.getTelefone());
            statement.setString(7, cliente.getSexo());
            statement.setString(8, cliente.getDataNascimento());
            statement.setLong(9, cliente.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Cliente get(Long id) {
        Cliente cliente = null;

        String sql = "SELECT * from Usuario WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");                
                String papel = resultSet.getString("papel");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                String dataNascimento = resultSet.getString("dataNascimento");

                cliente = new Cliente(id, email, nome, senha, papel, cpf, telefone, sexo, dataNascimento);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
}
