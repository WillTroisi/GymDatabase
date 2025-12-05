package org.examlpe.model.dao;
import org.example.model.dao.MemberDAO;
import org.example.model.entity.Member;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MemberDAOTest {

    @Test
    public void testFake(){
        assertAll(
                () -> assertEquals(1,1)
        );
    }

    @Test
    public void testCreateMember() throws Exception{
        MemberDAO dao = new MemberDAO();

        Member member = new Member();
        member.setName("Test Member");
        member.setEmail("test@email.com");
        member.setPhoneNumber("1234567890");
        member.setDt_join(Date.valueOf(LocalDate.now()));

        dao.create(member); // Method Under Test

        //clean up
        dao.delete(member.getID() );

        assertAll(
                () -> assertNotNull(member.getID() )
        );
    }

    @Test
    public void testReadMember() throws Exception{
        MemberDAO dao = new MemberDAO();

        Member member = new Member();
        member.setName("Test Member");
        member.setEmail("test@email.com");
        member.setPhoneNumber("123456789");
        member.setDt_join(Date.valueOf(LocalDate.now()));

        dao.create(member);
        Member found = dao.read(member.getID()); //Function under test

        //clean up
        dao.delete(member.getID() );

        assertAll(
                () -> assertEquals(found.getID(), member.getID()),
                () -> assertEquals(found.getName(), member.getName()),
                () -> assertEquals(found.getEmail(), member.getEmail()),
                () -> assertEquals(found.getPhoneNumber(), member.getPhoneNumber()),
                () -> assertEquals(found.getDt_join(), member.getDt_join())

        );

    }

    @Test
    public void testReadMemberDoesNotExist() throws Exception{
        MemberDAO dao = new MemberDAO();

        Member found = dao.read(10);
        assertAll(
                () -> assertNull( found.getID() ),
                () -> assertNull( found.getName() )
        );
    }


    //For this test, we had 9 entries in our database so the test does not work on our end, if you use a test database it should assert 0 entires.
    @Test
    public void testListMember() throws Exception{
        MemberDAO dao = new MemberDAO();

        List<Member> lst = dao.list();
        assertAll(
                () -> assertEquals(0, lst.size())
        );

    }
}