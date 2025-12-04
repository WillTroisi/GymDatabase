package org.example.controller;

import org.example.model.dao.MemberDAO;
import org.example.model.entity.Member;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.List;


public class MemberService {
    public Member createMember(String name, String email, String phoneNumber) throws SQLException {

        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setPhoneNumber(phoneNumber);
        member.setDt_join(Date.valueOf(LocalDate.now()));

        MemberDAO memberDAO = new MemberDAO();
        memberDAO.create(member);

        return member;
    }

    public List<Member> getAllMembers() throws SQLException {
        MemberDAO memberDAO = new MemberDAO();
        return memberDAO.list();
    }

    public void deleteMember(int id) throws SQLException {
        MemberDAO memberDAO = new MemberDAO();
        memberDAO.delete(id);
    }
}