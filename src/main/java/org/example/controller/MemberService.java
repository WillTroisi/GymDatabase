package org.example.controller;

import org.example.model.dao.MemberDAO;
import org.example.model.entity.Member;

import java.sql.Date;
import java.sql.SQLException;

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

    public boolean updateMember(int id, String newName, String newEmail, String newPhoneNumber) throws SQLException {
        MemberDAO memberDAO = new MemberDAO();

        Member updatedMember = memberDAO.read(id);
        if (updatedMember == null) {
            return false;
        }

        updatedMember.setName(newName);
        updatedMember.setEmail(newEmail);
        updatedMember.setPhoneNumber(newPhoneNumber);

        memberDAO.update(updatedMember);

        return true;
    }
}