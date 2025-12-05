package org.example;
import org.example.controller.MemberService;
import org.example.model.dao.MemberDAO;
import org.example.model.entity.Member;
import org.example.view.MainFrame;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);

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
        System.out.println(memberService.updateMember(14, "Tom", "the@the.fs", "912-453-6546"));



    }

}