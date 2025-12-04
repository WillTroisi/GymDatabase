package org.example.view;

import javax.swing.*;

public class MainFrame extends JFrame{
    public MainFrame() {
        super("CS485 - Music Store");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        createMenuBar();


    }

    public void createMenuBar() {
//        JMenuBar menuBar = new JMenuBar();
//
//        JMenu mnuFile = new JMenu("File");
//        JMenuItem mniExit =  new JMenuItem("Exit");
//        mniExit.addActionListener(e ->
//        {System.exit(0);});
//        menuBar.add(mniExit);
//
//        menuBar.add(mnuFile);
//        this.setJMenuBar(menuBar);
    }
}
