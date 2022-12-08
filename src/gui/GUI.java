package gui;

import api.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.io.*;

import java.lang.reflect.Array;
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
    JPanel panelIntro,loginPanel,regPanel,successPanelUser,successPanelProv,providerPanel,userPanel,editPanel;
    JButton loginButton,regButton,signInButton,signUpButton,addUser,editUser,search,deleteUser,dashboardUser,addProv,editProv,dashboardProv,deleteProv,propButton,submit,create,change,changeProp;
    JLabel userLabel,passLabel,labelIntro1,labelIntro2,fnameLabel,lnameLabel,typeLabel,successLabelUser,failedLabel,successLabelProv,propLabel,nameProp,typeProp,locProp,descrProp,namePropLabel,typePropLabel,locPropLabel,descrPropLabel,editAnsLabel,changeNameLabel,changeTypeLabel,changeLocLabel,changeDescrLabel;
    JTextField userText,fnameText,lnameText,typeText,namePropText,typePropText,locPropText,descrPropText,editAnsText,changeNameText,changeTypeText,changeLocText,changeDescrText;
    JPasswordField passText;

    public GUI(int countProp,File fileP) {
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
        editPanel = new JPanel();
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
        change = new JButton();
        changeProp = new JButton();

        labelIntro1 = new JLabel();
        labelIntro2 = new JLabel();
        userLabel = new JLabel();
        passLabel = new JLabel();
        fnameLabel = new JLabel();
        lnameLabel = new JLabel();
        typeLabel = new JLabel();
        editAnsLabel = new JLabel();


        successLabelUser = new JLabel();
        successLabelProv = new JLabel();
        failedLabel = new JLabel();
        nameProp = new JLabel();
        typeProp = new JLabel();
        locProp = new JLabel();
        descrProp = new JLabel();
        changeNameLabel = new JLabel();
        changeTypeLabel = new JLabel();
        changeLocLabel = new JLabel();
        changeDescrLabel = new JLabel();

        userText = new JTextField();
        fnameText = new JTextField();
        lnameText = new JTextField();
        typeText = new JTextField();
        passText = new JPasswordField();
        namePropText = new JTextField();
        typePropText = new JTextField();
        locPropText = new JTextField();
        descrPropText = new JTextField();
        editAnsText = new JTextField();
        changeNameText = new JTextField();
        changeTypeText = new JTextField();
        changeLocText = new JTextField();
        changeDescrText = new JTextField();


        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
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
        labelIntro1.setBounds(400, 100, 250, 250);
        labelIntro2.setText("If you have an account press LogIn, else press Register.");
        labelIntro2.setForeground(Color.magenta);
        labelIntro2.setBounds(325, 120, 400, 400);


        loginButton.setText("Log In");
        loginButton.setBackground(Color.magenta);
        loginButton.setBounds(350, 350, 90, 30);

        regButton.setText("Register");
        regButton.setBackground(Color.magenta);
        regButton.setBounds(500, 350, 90, 30);

        signInButton.setText("Sign In");
        signInButton.setBounds(400, 320, 100, 30);

        signUpButton.setText("Sign Up");
        signUpButton.setBounds(400, 500, 100, 30);

        addUser.setText("Add a review");
        addUser.setBounds(350, 200, 200, 40);
        addUser.setVisible(true);

        editUser.setText("Edit a review");
        editUser.setBounds(350, 250, 200, 40);
        editUser.setVisible(true);

        deleteUser.setText("Delete a review");
        deleteUser.setBounds(350, 300, 200, 40);
        deleteUser.setVisible(true);

        search.setText("Search properties");
        search.setBounds(350, 150, 200, 40);
        search.setVisible(true);

        dashboardUser.setText("View your dashboard");
        dashboardUser.setBounds(350, 350, 200, 40);
        dashboardUser.setVisible(true);

        addProv.setText("Add a new Property");
        addProv.setBounds(380, 150, 200, 40);
        addProv.setVisible(true);

        editProv.setText("Edit a property");
        editProv.setBounds(380, 200, 200, 40);
        editProv.setVisible(true);

        deleteProv.setText("Delete a property");
        deleteProv.setBounds(380, 250, 200, 40);
        deleteProv.setVisible(true);

        dashboardProv.setText("View your dashboard");
        dashboardProv.setBounds(380, 300, 200, 40);
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
        /*

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
        providerPanel.add(submit);*/

        userLabel.setText("Username");
        userLabel.setBounds(220, 200, 100, 40);
        passLabel.setText("Password");
        passLabel.setBounds(220, 250, 100, 40);

        userText.setBounds(340, 210, 100, 20);

        passText.setBounds(340, 260, 100, 20);





    }

        public void buildFrame(HashMap<Integer,Property> map, int count, ArrayList<String> listNames) throws IOException {

        changeProp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                providerPanel.setVisible(false);
                editPanel.setVisible(false);
                successPanelProv.setVisible(true);
                try {
                    prov.editGui(changeNameText.getText(),changeTypeText.getText(),changeLocText.getText(),changeDescrText.getText(),Integer.parseInt(editAnsText.getText()),fileP);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPanel.setLayout(null);
                providerPanel.setVisible(false);
                frame.add(editPanel);
                editPanel.add(changeNameLabel);
                editPanel.add(changeNameText);
                editPanel.add(changeTypeLabel);
                editPanel.add(changeTypeText);
                editPanel.add(changeLocLabel);
                editPanel.add(changeLocText);
                editPanel.add(changeDescrLabel);
                editPanel.add(changeDescrText);
                editPanel.add(changeProp);

                changeNameLabel.setText("Change name to:");
                changeNameLabel.setBounds(450,100,200,40);
                changeNameText.setBounds(400,150,200,40);
                changeTypeLabel.setText("Change Type to:");
                changeTypeLabel.setBounds(450,200,200,40);
                changeTypeText.setBounds(400,250,200,40);
                changeLocLabel.setText("Change Location to:");
                changeLocLabel.setBounds(450,300,200,40);
                changeLocText.setBounds(400,350,200,40);
                changeDescrLabel.setText("Change the description:");
                changeDescrLabel.setBounds(450,400,200,40);
                changeDescrText.setBounds(400,450,200,40);
                changeProp.setText("Done");
                changeProp.setBounds(420,500,150,40);

                changeNameLabel.setVisible(true);
                changeNameText.setVisible(true);
                changeTypeLabel.setVisible(true);
                changeTypeText.setVisible(true);
                changeLocLabel.setVisible(true);
                changeLocText.setVisible(true);
                changeDescrLabel.setVisible(true);
                changeDescrText.setVisible(true);
                changeProp.setVisible(true);


            }
        });


        editProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel[] propLabel = new JLabel[countProp];
                JLabel[] namePropLabel = new JLabel[countProp];
                JLabel[] typePropLabel = new JLabel[countProp];
                JLabel[] locPropLabel = new JLabel[countProp];
                JLabel[] descrPropLabel = new JLabel[countProp];
                successPanelProv.setVisible(false);
                providerPanel.setLayout(null);
                providerPanel.add(editAnsLabel);
                providerPanel.add(editAnsText);
                providerPanel.add(change);
                frame.add(providerPanel);

                int width,height,widthN,widthT,widthL,widthD,heightP,temp=0;
                width=0;
                widthN =0;
                widthT =0;
                widthD =0;
                widthL =0;
                height = 0;
                heightP=20;
                int i=0;
                for(Map.Entry<Integer,Property> entry : map.entrySet()){
                    propLabel[i] = new JLabel();
                    namePropLabel[i] = new JLabel();
                    typePropLabel[i] = new JLabel();
                    locPropLabel[i] = new JLabel();
                    descrPropLabel[i] = new JLabel();
                    if(listNames.get(i).equals(log.getUsername())){
                        namePropLabel[i].setText("Name: "+entry.getValue().getName());
                        typePropLabel[i].setText("Type: "+entry.getValue().getType());
                        locPropLabel[i].setText("Location: "+entry.getValue().getLocation());
                        descrPropLabel[i].setText("Description: "+entry.getValue().getDescr());
                        propLabel[i].setText("Property "+String.valueOf(entry.getKey()));
                        if(width==1000){
                            width=0;
                            widthN=0;
                            widthL=0;
                            widthD=0;
                            widthT=0;
                            height+=160;
                            temp++;
                            heightP=height+20;
                        }
                        propLabel[i].setBounds(width,height,100,20);
                        namePropLabel[i].setBounds(widthN,heightP,150,20);
                        heightP+=20;
                        typePropLabel[i].setBounds(widthT,heightP,150,20);
                        heightP+=20;
                        locPropLabel[i].setBounds(widthL,heightP,150,20);
                        heightP+=20;
                        descrPropLabel[i].setBounds(widthD,heightP,150,20);
                        heightP =temp*height+20;
                        width +=200;
                        widthN +=200;
                        widthT +=200;
                        widthL +=200;
                        widthD +=200;
                        providerPanel.add(propLabel[i]);
                        providerPanel.add(namePropLabel[i]);
                        providerPanel.add(typePropLabel[i]);
                        providerPanel.add(locPropLabel[i]);
                        providerPanel.add(descrPropLabel[i]);
                        propLabel[i].setVisible(true);
                        namePropLabel[i].setVisible(true);
                        typePropLabel[i].setVisible(true);
                        locPropLabel[i].setVisible(true);
                        descrPropLabel[i].setVisible(true);
                        propLabel[i].revalidate();


                    }
                    i++;
                    editAnsLabel.setText("Type the number of property you want to edit: ");
                    editAnsLabel.setBounds(50,700,400,30);
                    editAnsText.setBounds(400,700,100,30);
                    change.setText("Change");
                    change.setBounds(520,700,100,30);
                    change.setVisible(true);
                    editAnsText.setVisible(true);
                    editAnsLabel.setVisible(true);


                }
                nameProp.setVisible(false);
                namePropText.setVisible(false);
                typeProp.setVisible(false);
                typePropText.setVisible(false);
                locProp.setVisible(false);
                locPropText.setVisible(false);
                descrProp.setVisible(false);
                descrPropText.setVisible(false);
                submit.setVisible(false);

            }
        });

            create.setBounds(400, 500, 150, 30);
            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        reg = new Register(fnameText.getText(), lnameText.getText(), userText.getText(), passText.getText(), typeText.getText());
                        reg.newAcc(userText.getText(), passText.getText(), typeText.getText());
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


            submit.setBounds(400, 550, 100, 30);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    prov.addProperties(countProp, namePropText.getText(), typePropText.getText(), locPropText.getText(), descrPropText.getText(), log.getUsername());

                    try {
                        prov.reNewFile(fileP);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }


                    frame.remove(providerPanel);
                    successPanelProv.setVisible(true);







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
                    fnameLabel.setBounds(350, 210, 100, 20);
                    fnameText.setBounds(450, 210, 100, 20);

                    lnameLabel.setText("Last Name");
                    lnameLabel.setBounds(350, 250, 100, 20);
                    lnameText.setBounds(450, 250, 100, 20);

                    userLabel.setText("Username");
                    userLabel.setBounds(350, 300, 100, 20);
                    userText.setBounds(450, 300, 100, 20);

                    passLabel.setText("Password");
                    passLabel.setBounds(350, 350, 100, 20);
                    passText.setBounds(450, 350, 100, 20);

                    typeLabel.setText("Provider or User?");
                    typeLabel.setBounds(320, 400, 120, 20);
                    typeText.setBounds(450, 400, 100, 20);

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
                    successLabelUser.setBounds(400, 50, 400, 100);
                    successLabelProv.setBounds(400, 50, 400, 100);
                    failedLabel.setText("Username and Password don't match. Please try again");
                    failedLabel.setBounds(250, 350, 400, 100);
                    failedLabel.setForeground(Color.red);
                    try {
                        log = new LogIn(userText.getText(), passText.getText());
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    log.addCredits();
                    boolean isUser = log.accCheck(log.getUsername(), log.getPassword());
                    boolean flag = false;
                    if (isUser) {
                        flag = true;
                    }
                    String whatUser = log.whatUser(log.getUsername(), log.getPassword(), "user");
                    if (flag && whatUser.equals("user")) {
                        //frame.remove(loginPanel);
                        loginPanel.setVisible(false);
                        frame.add(successPanelUser);

                        successPanelUser.add(successLabelUser);

                        successLabelUser.setVisible(true);

                        successLabelUser.setText("Hi " + log.getUsername() + ". " + "You are " + whatUser);
                    } else if (flag && whatUser.equals("provider")) {
                        //frame.remove(loginPanel);
                        loginPanel.setVisible(false);
                        frame.add(successPanelProv);
                        successPanelProv.add(successLabelProv);
                        successLabelProv.setVisible(true);
                        successLabelProv.setText("Hi " + log.getUsername() + ". " + "You are " + whatUser);


                    } else {

                        failedLabel.setVisible(true);
                    }
                    //successLabelUser.setVisible(true);
                }
            });
            addProv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {



                    frame.add(providerPanel);

                    providerPanel.setLayout(null);

                    nameProp.setText("Name of property");
                    nameProp.setBounds(400, 100, 100, 30);
                    //nameProp.setVisible(true);
                    namePropText.setText("");
                    namePropText.setBounds(400, 150, 100, 30);
                    //namePropText.setVisible(true);
                    typeProp.setText("Type of property");
                    typeProp.setBounds(400, 200, 100, 30);
                    //typeProp.setVisible(true);
                    typePropText.setText("");
                    typePropText.setBounds(400, 250, 100, 30);
                    //typePropText.setVisible(true);
                    locProp.setText("Location of property");
                    locProp.setBounds(400, 300, 150, 30);
                    // locProp.setVisible(true);
                    locPropText.setText("");
                    locPropText.setBounds(400, 350, 100, 30);
                    //locPropText.setVisible(true);
                    descrProp.setText("Add a description");
                    descrProp.setBounds(400, 400, 100, 30);
                    //descrProp.setVisible(true);
                    descrPropText.setText("");
                    descrPropText.setBounds(400, 450, 100, 30);
                    //descrPropText.setVisible(true);
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
                    //successPanelProv.add(name)
                    successPanelProv.setVisible(false);

                   // frame.add(providerPanel);
                    providerPanel.setVisible(true);


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
        this.countProp = cProp;
    }

    public int getCountProp(int t){
        return 1+t;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}