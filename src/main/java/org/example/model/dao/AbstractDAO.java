package org.example.model.dao;

import org.example.model.entity.AbstractEntity;

import java.sql.*;

public abstract class AbstractDAO<E extends AbstractEntity> {
    private String ConUrl = "jdbc:mysql://localhost"; //protocol + url
    private String Port = "3306"; //default MySQL port
    private String Database = "gym_schema"; // database/schema name
    private String Username = "root"; //read this from a local file
    private String Password = "password123!"; //Also read this from a file

    //private String url = ConUrl+":"+Port+"/"+Database+ "?user="+Username+"&password="+Password;

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ConUrl+":"+Port+"/"+Database+ "?user="+Username+"&password="+Password);
    }


    public void setTestDatabase() {
        this.Database = "music_schema_test";
    }

    public abstract void create(E entity) throws SQLException;
    public abstract E read(int ID) throws SQLException;
    public abstract void update(E entity) throws SQLException;
    public abstract void delete(int ID) throws SQLException;

}

