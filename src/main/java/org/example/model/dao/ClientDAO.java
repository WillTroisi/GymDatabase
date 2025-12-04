package org.example.model.dao;

import org.example.model.entity.Client;
import java.sql.*;

public class ClientDAO extends AbstractDAO<Client>{
    @Override
    public void create(Client entity) throws SQLException {
        Connection con = getConnection();

        String sql = "INSERT INTO Client(name_client,email,dob) VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getName());
        pst.setString(2, entity.getEmail());
        pst.setDate(3, entity.getDob());
        pst.executeUpdate();

        ResultSet rs  = pst.getGeneratedKeys();
        if (rs.next()){
            entity.setID(rs.getInt(1));
        }

        con.close();
    }

    @Override
    public Client read(int ID) throws SQLException {
        Client readClient = new Client();

        Connection con = getConnection();

        String sql = "SELECT * FROM Client WHERE id_client = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ID);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            readClient.setID(rs.getInt("id_client"));
            readClient.setName(rs.getString("name_client"));
            readClient.setEmail(rs.getString("email"));
            readClient.setDob(rs.getDate("dob"));

        }
        con.close();
        return readClient;
    }

    @Override
    public void update(Client entity) throws SQLException {
        Connection con = getConnection();
        String sql = "";

        con.close();

    }

    @Override
    public void delete(int ID) throws SQLException {
        Connection con = getConnection();

        String sql = "DELETE FROM client WHERE id_client = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ID);
        pst.executeUpdate();


        con.close();
    }
}
