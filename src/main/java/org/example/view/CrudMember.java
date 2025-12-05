package org.example.view;

import org.example.controller.MemberService;
import org.example.model.entity.Member;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class CrudMember extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton deleteButton;
    private JButton updateButton;
    private JList lstMembersUI;

    public CrudMember() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        populateUI();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCreate();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUpdate();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDelete();
            }
        });
    }

    private void onCreate() {
        CreateMember member = new CreateMember();
        member.pack();
        member.setVisible(true);
    }

    private void onCancel() {
        dispose();
    }
    private void onDelete() {
        MemberService service = new MemberService();
        Member m = (Member) lstMembersUI.getSelectedValue();
        if (m != null){
            try {
                service.deleteMember(m.getID());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void onUpdate() {
        // add your code here if necessary
        dispose();
    }

    public void populateUI(){
        MemberService service = new MemberService();
        try{
            List<Member> lst = service.getAllMembers();
            lstMembersUI.setListData(lst.toArray());

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CrudMember dialog = new CrudMember();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
