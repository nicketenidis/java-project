package gui;

import api.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.*;

import javax.swing.*;

public class GUI implements ActionListener {
    private LogIn log;
    JFrame frame;
    JPanel panelIntro,loginPanel,regPanel,successPanelUser,successPanelProv;
    JButton loginButton,regButton,signInButton,signUpButton,addUser,editUser,search,deleteUser,dashboardUser,addProv,editProv,dashboardProv,deleteProv;
    JLabel userLabel,passLabel,labelIntro1,labelIntro2,fnameLabel,lnameLabel,typeLabel,successLabelUser,failedLabel,successLabelProv;
    JTextField userText,fnameText,lnameText,typeText;
    JPasswordField passText;

    public GUI(){
        frame = new JFrame();
        panelIntro = new JPanel();
        loginPanel = new JPanel();
        regPanel = new JPanel();
        successPanelUser = new JPanel();
        successPanelProv = new JPanel();
        loginButton = new JButton();
        regButton = new JButton();
        signInButton = new JButton();
        signUpButton = new JButton();
        addUser = new JButton();
        editUser = new JButton();
        deleteUser = new JButton();
        search = new JButton();
        dashboardUser = new JButton();
        addProv = new JButton();
        editProv = new JButton();
        deleteProv = new JButton();
        dashboardProv = new JButton();
        labelIntro1 = new JLabel();
        labelIntro2 = new JLabel();
        userLabel = new JLabel();
        passLabel = new JLabel();
        fnameLabel = new JLabel();
        lnameLabel = new JLabel();
        typeLabel = new JLabel();
        successLabelUser = new JLabel();
        successLabelProv = new JLabel();
        failedLabel = new JLabel();
        userText = new JTextField();
        fnameText = new JTextField();
        lnameText = new JTextField();
        typeText = new JTextField();
        passText = new JPasswordField();

        frame.setSize(1000,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(panelIntro);

        panelIntro.setLayout(null);
        panelIntro.add(labelIntro1);
        panelIntro.add(labelIntro2);
        panelIntro.add(loginButton);
        panelIntro.add(regButton);

        successPanelUser.add(addUser);
        successPanelUser.add(editUser);
        successPanelUser.add(search);
        successPanelUser.add(dashboardUser);
        successPanelUser.add(deleteUser);

        successPanelProv.add(addProv);
        successPanelProv.add(editProv);
        successPanelProv.add(deleteProv);
        successPanelProv.add(dashboardProv);


        labelIntro1.setText("Welcome to My Reviews App");
        labelIntro1.setBounds(400,100,250,250);
        labelIntro2.setText("If you have an account press LogIn, else press Register.");
        labelIntro2.setBounds(325,120,400,400);



        loginButton.setText("Log In");
        loginButton.setBounds(350,350,90,30);

        regButton.setText("Register");
        regButton.setBounds(500,350,90,30);

        signInButton.setText("Sign In");
        signInButton.setBounds(400,320,100,30);

        signUpButton.setText("Sign Up");
        signUpButton.setBounds(400,500,100,30);

        addUser.setText("Add a review");
        addUser.setBounds(350,200,200,40);
        addUser.setVisible(true);

        editUser.setText("Edit a review");
        editUser.setBounds(350,250,200,40);
        editUser.setVisible(true);

        deleteUser.setText("Delete a review");
        deleteUser.setBounds(350,300,200,40);
        deleteUser.setVisible(true);

        search.setText("Search properties");
        search.setBounds(350,150,200,40);
        search.setVisible(true);

        dashboardUser.setText("View your dashboard");
        dashboardUser.setBounds(350,350,200,40);
        dashboardUser.setVisible(true);

        addProv.setText("Add a new Property");
        addProv.setBounds(380,150,200,40);
        addProv.setVisible(true);

        editProv.setText("Edit a property");
        editProv.setBounds(380,200,200,40);
        editProv.setVisible(true);

        deleteProv.setText("Delete a property");
        deleteProv.setBounds(380,250,200,40);
        deleteProv.setVisible(true);

        dashboardProv.setText("View your dashboard");
        dashboardProv.setBounds(380,300,200,40);
        dashboardProv.setVisible(true);


        loginPanel.setLayout(null);

        regPanel.setLayout(null);

        successPanelUser.setLayout(null);

        successPanelProv.setLayout(null);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelIntro);
                frame.add(loginPanel);

                loginPanel.add(userLabel);
                loginPanel.add(passLabel);
                loginPanel.add(userText);
                loginPanel.add(passText);
                loginPanel.add(signInButton);

                loginButton.setVisible(false);
                regButton.setVisible(false);
                signInButton.setVisible(true);

                userLabel.setText("Username");
                userLabel.setBounds(220,200,100,40);
                passLabel.setText("Password");
                passLabel.setBounds(220,250,100,40);

                userText.setBounds(340,210,100,20);
                passText.setBounds(340,260,100,20);

                userLabel.setVisible(true);
                passLabel.setVisible(true);

                userText.setVisible(true);
                passText.setVisible(true);

            }
        });

        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelIntro);
                frame.add(regPanel);
                regPanel.add(fnameLabel);
                regPanel.add(lnameLabel);
                regPanel.add(userLabel);
                regPanel.add(passLabel);
                regPanel.add(typeLabel);
                regPanel.add(fnameText);
                regPanel.add(lnameText);
                regPanel.add(userText);
                regPanel.add(passText);
                regPanel.add(typeText);
                regPanel.add(signUpButton);

                loginButton.setVisible(false);
                regButton.setVisible(false);
                signInButton.setVisible(true);

                fnameLabel.setText("First Name");
                fnameLabel.setBounds(350,210,100,20);
                fnameText.setBounds(450,210,100,20);

                lnameLabel.setText("Last Name");
                lnameLabel.setBounds(350,250,100,20);
                lnameText.setBounds(450,250,100,20);

                userLabel.setText("Username");
                userLabel.setBounds(350,300,100,20);
                userText.setBounds(450,300,100,20);

                passLabel.setText("Password");
                passLabel.setBounds(350,350,100,20);
                passText.setBounds(450,350,100,20);

                typeLabel.setText("Provider or User?");
                typeLabel.setBounds(320,400,120,20);
                typeText.setBounds(450,400,100,20);

                fnameLabel.setVisible(true);
                fnameText.setVisible(true);

                lnameLabel.setVisible(true);
                lnameText.setVisible(true);

                userLabel.setVisible(true);
                userText.setVisible(true);

                passLabel.setVisible(true);
                passText.setVisible(true);

                typeLabel.setVisible(true);
                typeText.setVisible(true);

                signUpButton.setVisible(true);

            }
        });

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel.add(failedLabel);
                successLabelUser.setBounds(400,50,400,100);
                successLabelProv.setBounds(400,50,400,100);
                failedLabel.setText("Username and Password don't match. Please try again");
                failedLabel.setBounds(250,350,400,100);
                failedLabel.setForeground(Color.red);
                try {
                    log = new LogIn(userText.getText(),passText.getText());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                log.addCredits();
                boolean isUser = log.accCheck(log.getUsername(),log.getPassword());
                boolean flag = false;
                if(isUser){
                    flag=true;
                }
                String whatUser = log.whatUser(log.getUsername(),log.getPassword(),"user");
                if(flag && whatUser.equals("user")){
                    frame.remove(loginPanel);
                    frame.add(successPanelUser);

                    successPanelUser.add(successLabelUser);

                    successLabelUser.setVisible(true);

                    successLabelUser.setText("Hi "+log.getUsername()+". "+"You are "+whatUser);
                }else if(flag && whatUser.equals("provider")){
                    frame.remove(loginPanel);
                    frame.add(successPanelProv);
                    successPanelProv.add(successLabelProv);
                    successLabelProv.setVisible(true);
                    successLabelProv.setText("Hi "+log.getUsername()+". "+"You are "+whatUser);


                } else{

                    failedLabel.setVisible(true);
                }
                //successLabelUser.setVisible(true);
            }
        });






    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

