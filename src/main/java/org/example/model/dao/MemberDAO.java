package org.example.model.dao;

import org.example.model.entity.Member;

import java.sql.*;

public class MemberDAO extends AbstractDAO<Member>{
    @Override
    public void create(Member entity) throws SQLException {
        Connection con = getConnection();

        String sql = "INSERT INTO Member(name,email,phone_number,dt_join) VALUES(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getName());
        pst.setString(2, entity.getEmail());
        pst.setString(3, entity.getPhoneNumber());
        pst.setDate(4, entity.getDt_join());
        pst.executeUpdate();

        ResultSet rs  = pst.getGeneratedKeys();
        if (rs.next()){
            entity.setID(rs.getInt(1));
        }

        con.close();
    }

    @Override
    public Member read(int ID) throws SQLException {
        Member readMember = new Member();

        Connection con = getConnection();

        String sql = "SELECT * FROM Member WHERE id_member = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ID);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            readMember.setID(rs.getInt("id_member"));
            readMember.setName(rs.getString("name"));
            readMember.setEmail(rs.getString("email"));
            readMember.setPhoneNumber(rs.getString("phone_number"));
            readMember.setDt_join(rs.getDate("dt_join"));
        }
        con.close();
        return readMember;
    }

    @Override
    public void update(Member entity) throws SQLException {
        Connection con = getConnection();
        String sql = "";

        con.close();

    }

    @Override
    public void delete(int ID) throws SQLException {
        Connection con = getConnection();

        String sql = "DELETE FROM Member WHERE id_member = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ID);
        pst.executeUpdate();


        con.close();
    }
}
