package gui;

import api.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.io.*;

import java.util.*;

import javax.swing.*;


public class GUI implements ActionListener {

    File fileP ;

    private Display display;

    private HashMap<Integer,Property> map;

    Register reg;

    private int countProp;
    private Provider prov;
    private LogIn log;
    JFrame frame;
    JPanel panelIntro,loginPanel,regPanel,successPanelUser,successPanelProv,providerPanel,userPanel;
    JButton loginButton,regButton,signInButton,signUpButton,addUser,editUser,search,deleteUser,dashboardUser,addProv,editProv,dashboardProv,deleteProv,propButton,submit,create;
    JLabel userLabel,passLabel,labelIntro1,labelIntro2,fnameLabel,lnameLabel,typeLabel,successLabelUser,failedLabel,successLabelProv,propLabel,nameProp,typeProp,locProp,descrProp;
    JTextField userText,fnameText,lnameText,typeText,namePropText,typePropText,locPropText,descrPropText;
    JPasswordField passText;

    public GUI(int countProp,File fileP)  {
        this.fileP = fileP;
        this.countProp = countProp;

        display = new Display();

        prov = new Provider();
        map = prov.getProps();
        frame = new JFrame();
        panelIntro = new JPanel();
        loginPanel = new JPanel();
        regPanel = new JPanel();
        successPanelUser = new JPanel();
        successPanelProv = new JPanel();
        providerPanel = new JPanel();
        userPanel = new JPanel();
        loginButton = new JButton();
        regButton = new JButton();
        signInButton = new JButton();
        signUpButton = new JButton();
        create = new JButton("Create Account");
        propButton = new JButton();
        submit = new JButton("Submit");
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
        nameProp = new JLabel();
        typeProp = new JLabel();
        locProp = new JLabel();
        descrProp = new JLabel();
        userText = new JTextField();
        fnameText = new JTextField();
        lnameText = new JTextField();
        typeText = new JTextField();
        namePropText = new JTextField();
        typePropText = new JTextField();
        locPropText = new JTextField();
        descrPropText = new JTextField();
        passText = new JPasswordField();

        frame.setSize(1000,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(panelIntro);

        panelIntro.setLayout(null);
        panelIntro.setBackground(Color.BLACK);
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
        labelIntro1.setForeground(Color.magenta);
        labelIntro1.setBounds(400,100,250,250);
        labelIntro2.setText("If you have an account press LogIn, else press Register.");
        labelIntro2.setForeground(Color.magenta);
        labelIntro2.setBounds(325,120,400,400);



        loginButton.setText("Log In");
        loginButton.setBackground(Color.magenta);
        loginButton.setBounds(350,350,90,30);

        regButton.setText("Register");
        regButton.setBackground(Color.magenta);
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

        loginPanel.add(userLabel);
        loginPanel.add(passLabel);
        loginPanel.add(userText);
        loginPanel.add(passText);
        loginPanel.add(signInButton);

        regPanel.setLayout(null);

        successPanelUser.setLayout(null);

        successPanelProv.setLayout(null);

        providerPanel.setLayout(null);
        //frame.add(providerPanel);
        providerPanel.add(nameProp);
        providerPanel.add(namePropText);
        providerPanel.add(typeProp);
        providerPanel.add(typePropText);
        providerPanel.add(locProp);
        providerPanel.add(locPropText);
        providerPanel.add(descrProp);
        providerPanel.add(descrPropText);
        providerPanel.add(submit);

        userLabel.setText("Username");
        userLabel.setBounds(220,200,100,40);
        passLabel.setText("Password");
        passLabel.setBounds(220,250,100,40);

        userText.setBounds(340,210,100,20);

        passText.setBounds(340,260,100,20);


        nameProp.setText("Name of property");
        nameProp.setBounds(400,100,100,30);
        //nameProp.setVisible(true);
        namePropText.setBounds(400,150,100,30);
        //namePropText.setVisible(true);
        typeProp.setText("Type of property");
        typeProp.setBounds(400,200,100,30);
        //typeProp.setVisible(true);
        typePropText.setBounds(400,250,100,30);
        //typePropText.setVisible(true);
        locProp.setText("Location of property");
        locProp.setBounds(400,300,150,30);
        // locProp.setVisible(true);
        locPropText.setBounds(400,350,100,30);
        //locPropText.setVisible(true);
        descrProp.setText("Add a description");
        descrProp.setBounds(400,400,100,30);
        //descrProp.setVisible(true);
        descrPropText.setBounds(400,450,100,30);
        //descrPropText.setVisible(true);

        create.setBounds(400,500,150,30);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    reg = new Register(fnameText.getText(),lnameText.getText(),userText.getText(),passText.getText(),typeText.getText());
                    reg.newAcc(userText.getText(),passText.getText(),typeText.getText());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                regPanel.setVisible(false);
                frame.add(loginPanel);
                loginPanel.setVisible(true);


            }
        });



        submit.setBounds(400,550,100,30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // prov.showMyProps(log.getUsername());
                 int c = getCountProp();
                prov.addProperties(c,namePropText.getText(),typePropText.getText(),locPropText.getText(),descrPropText.getText(), log.getUsername());
                setCountProp(c);

                try {
                    prov.reNewFile(fileP);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }



            }
        });





        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.remove(panelIntro);
                panelIntro.setVisible(false);
                frame.add(loginPanel);


                loginButton.setVisible(false);
                regButton.setVisible(false);
                signInButton.setVisible(true);



                userLabel.setVisible(true);
                passLabel.setVisible(true);

                userText.setVisible(true);
                passText.setVisible(true);

            }
        });

        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //frame.remove(panelIntro);
                panelIntro.setVisible(false);
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
                //regPanel.add(signUpButton);
                regPanel.add(create);

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

                create.setVisible(true);

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

                //signUpButton.setVisible(true);



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
                    log = new LogIn(userText.getText(), passText.getText());
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
                    //frame.remove(loginPanel);
                    loginPanel.setVisible(false);
                    frame.add(successPanelUser);

                    successPanelUser.add(successLabelUser);

                    successLabelUser.setVisible(true);

                   successLabelUser.setText("Hi "+log.getUsername()+". "+"You are "+whatUser);
                }else if(flag && whatUser.equals("provider")){
                    //frame.remove(loginPanel);
                    loginPanel.setVisible(false);
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
        addProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //successPanelProv.add(name)
                successPanelProv.setVisible(false);

                frame.add(providerPanel);



                nameProp.setVisible(true);

                namePropText.setVisible(true);

                typeProp.setVisible(true);

                typePropText.setVisible(true);

                locProp.setVisible(true);

                locPropText.setVisible(true);

                descrProp.setVisible(true);

                descrPropText.setVisible(true);

            }
        });





    }

    public void setCountProp(int cProp){
        this.countProp = cProp+1;
    }

    public int getCountProp(){
        return countProp;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}