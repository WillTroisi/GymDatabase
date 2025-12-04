package org.example;
import org.example.controller.MemberService;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        MemberService memberService = new MemberService();
        memberService.createMember("Hello", "123@3.4", "123-456-765");

    }

}