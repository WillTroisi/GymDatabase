package org.example.view;

import org.example.controller.MemberService;
import org.example.model.entity.Member;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class UpdateMember extends JDialog {
    private JPanel contentPane;
    private JButton buttonUpdate;
    private JButton buttonCancel;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextArea txtAreaName;
    private JTextArea txtAreaEmail;
    private JTextArea txtAreaPhone;
    private JTextArea txtAreaDtJoined;
    private JTextArea txtAreaID;



    public UpdateMember(Member m) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonUpdate);

        txtAreaID.append(String.valueOf(m.getID()));
        txtAreaName.append(m.getName());
        txtAreaEmail.append(m.getEmail());
        txtAreaPhone.append(m.getPhoneNumber());
        txtAreaDtJoined.append(String.valueOf(m.getDt_join()));

        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onUpdate(m);
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
    }

    private void onUpdate(Member m) {
        MemberService service = new MemberService();


        String name;
        String email;
        String phone;
        if (txtName.getText().equals("")) {
            name = m.getName();
        }else{
            name = txtName.getText();
        }
        if (txtEmail.getText().equals("")) {
            email = m.getEmail();

        }else{
            email = txtEmail.getText();
        }
        if (txtPhone.getText().equals("")) {
            phone = m.getPhoneNumber();
        }else{
            phone = txtPhone.getText();
        }

        try {
            service.updateMember(m.getID(),name,email,phone);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dispose();

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public static void main(String[] args) {
        Member m = new Member();
        UpdateMember dialog = new UpdateMember(m);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
