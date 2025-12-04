package org.example;
import org.example.controller.MemberService;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
//        MainFrame frame = new MainFrame();
//        frame.setVisible(true);

//        ClientDAO clientDAO = new ClientDAO();
//        clientDAO.setTestDatabase();
//
//        Client client = new Client();
//        client.setName("George");
//        client.setEmail("wn@j.edu");
//
//
//        clientDAO.create(client);

//        MemberDAO memberDAO = new MemberDAO();
//
//        Member member = new Member();
//        member.setName("Tom");
//        member.setEmail("tro@tr.tro");
//        member.setPhoneNumber("123-456-789");
//        member.setDt_join(Date .valueOf(LocalDate.now()));
//        memberDAO.create(member);
//
//        Member found = memberDAO.read(member.getID());
//        System.out.println(found);
        MemberService memberService = new MemberService();
        memberService.createMember("Hello", "123@3.4", "123-456-765", Date.valueOf(LocalDate.now()));
    }

}