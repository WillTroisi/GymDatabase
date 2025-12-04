package org.example;
import org.example.controller.MemberService;
import org.example.model.dao.ClientDAO;
import org.example.model.dao.MemberDAO;
import org.example.model.entity.Client;
import org.example.model.entity.Member;
import org.example.view.MainFrame;

import java.sql.*;
import java.time.LocalDate;
import java.util.SortedMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        MemberService memberService = new MemberService();
        memberService.createMember("Hello", "123@3.4", "123-456-765");

    }

}