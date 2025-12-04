package org.example.view;

import org.example.controller.MemberService;
import org.example.model.entity.Member;

import javax.swing.*;
import java.awt.event.*;

public class CreateMember extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;

    public CreateMember() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
    }

    private void onCreate() {

        MemberService service = new MemberService();
        //service.createMember(txtName.getText(),txtEmail.getText(),txtPhone.getText());
        System.out.println(txtName.getText());
        System.out.println(txtEmail.getText());
        System.out.println(txtPhone.getText());
        //coment


    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CreateMember dialog = new CreateMember();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
