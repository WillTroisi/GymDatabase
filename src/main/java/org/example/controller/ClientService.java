package org.example.controller;

import org.example.model.entity.Client;
import org.example.model.dao.ClientDAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ClientService {
    public Client createClient(String name, String email, String dob) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

        Client client = new Client();
        client.setName(name);
        client.setEmail(email);

        ClientDAO dao = new ClientDAO();
        dao.create(client);

        return client;




    }
}
