package org.examlpe.model.dao;

import com.mysql.cj.CancelQueryTask;
import org.example.model.dao.ClientDAO;
import org.example.model.entity.Client;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClientDAOTest {

    @Test
    public void testFake() {
        assertAll(
                () -> assertEquals(1,1)
        );
    }

    @Test
    public void testCreateClient() throws Exception {
        ClientDAO dao = new ClientDAO();
        dao.setTestDatabase();

        Client client = new Client();
        client.setName("Test Client");
        client.setEmail("test@email.com");

        dao.create(client);

        //clean up
        dao.delete(client.getID());

        assertAll (
                () -> assertNotNull(client.getID() )
        );
    }

    @Test
    public void testReadClient() throws Exception {
        ClientDAO dao = new ClientDAO();
        dao.setTestDatabase();

        Client client = new Client();
        client.setName("Test Client");
        client.setEmail("test@gmail.com");

        dao.create(client);
        Client found = dao.read(client.getID());
        dao.delete(client.getID());

        assertAll (
                () -> assertEquals(found.getID(), client.getID()),
                () -> assertEquals(found.getName(), client.getName()),
                () -> assertEquals(found.getEmail(), client.getEmail()),
                () -> assertEquals(found.getDob(), client.getDob())
        );

    }

    public void testUpdateClient() throws Exception {
        ClientDAO dao = new ClientDAO();
        dao.setTestDatabase();

        Client client = new Client();


    }

    @Test
    public void testDeleteClient() throws Exception {
        ClientDAO dao = new ClientDAO();
        dao.setTestDatabase();

        Client client = new Client();
        client.setName("Test Client");
        client.setEmail("test@email.com");

        dao.create(client);

        int testID = client.getID();

        dao.delete(client.getID());

    }
}
