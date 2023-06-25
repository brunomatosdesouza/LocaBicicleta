package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Locadora;

public class LocadoraDAO extends GenericDAO{
    public void insert(Locadora locadora){

        String sql = "INSERT INTO Locadora (email, senha, cnpj, nome, cidade) VALUES (?, ?, ?, ?, ?)";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getEmail());
            statement.setString(2, locadora.getSenha());
            statement.setString(3, locadora.getCnpj());
            statement.setString(4, locadora.getNome());
            statement.setString(5, locadora.getCidade());

            statement.close();
            conn.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Locadora> getAll() {

        List<Locadora> listaLocadoras = new ArrayList<>();
        
        String sql = "SELECT * FROM Locadora l";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");
                Locadora locadora = new Locadora(id, email, senha, nome, cnpj, cidade);
                listaLocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaLocadoras;
    }

    public void delete(Locadora locadora){
        String sql = "DELETE FROM Locadora where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, locadora.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    public void update(Locadora locadora){

        String sql = "UPDATE Locadora SET email = ?, senha = ?, nome = ?, cnpj = ?, cidade = ? WHERE id = ?";
        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, locadora.getEmail());
            statement.setString(2, locadora.getSenha());
            statement.setString(3, locadora.getNome());
            statement.setString(4, locadora.getCnpj());
            statement.setString(5, locadora.getCidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}   

