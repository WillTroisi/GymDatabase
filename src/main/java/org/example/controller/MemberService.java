package org.example.controller;

import org.example.model.dao.MemberDAO;
import org.example.model.entity.Member;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class MemberService {
    public Member createMember(String name, String email, String phoneNumber, Date dt_join) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        java.sql.Date date = new java.sql.Date(dt_join.getTime());

        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setPhoneNumber(phoneNumber);
        member.setDt_join(date);

        MemberDAO memberDAO = new MemberDAO();
        memberDAO.create(member);

        return member;
    }
}