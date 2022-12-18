package gui;

import api.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.lang.*;
import java.io.*;

import java.sql.SQLOutput;
import java.util.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;


public class GUI implements ActionListener {

    ArrayList<JLabel> rateRevLabel;
    ArrayList<JLabel> propRevLabel;
    ArrayList<JLabel> namePropRevLabel;
    ArrayList<JLabel> userRevLabel;
    ArrayList<JLabel> stringRevLabel;
    ArrayList<JLabel> reviewLabel;
    ArrayList<JLabel> namePropLabel;
    ArrayList<JLabel> typePropLabel;
    ArrayList<JLabel> locPropLabel;
    ArrayList<JLabel> descrPropLabel;
    ArrayList<JLabel> propLabel;




    private int count;
    File fileP;
    File fileR;

    Register reg;

    Provider provider;
    User user;
    LogIn log;
    JFrame frame;
    JScrollPane scrollPane;
    JPanel panelIntro,loginPanel,regPanel,successPanelUser,successPanelProv,addProvPanel,userPanel,editPanel,changePanel,deletePanel,addUserPanel,addRevPanel,editUserPanel,editRevPanel;
    JButton loginButton,regButton,signInButton,signUpButton,addUser,editUser,search,deleteUser,dashboardUser,addProv,editProv,dashboardProv,deleteProv,propButton,submit,create,change,changeProp,deleteButton1,addRevButton,addAnsButton,editRevButton1,editRevButton2;
    JLabel uLabel,pLabel,userLabel,passLabel,failedReg1,failedReg2,labelIntro1,labelIntro2,fnameLabel,lnameLabel,typeLabel,successLabelUser,failedLabel,successLabelProv,nameProp,typeProp,locProp,descrProp,failedAdd,editAnsLabel,changeNameLabel,changeTypeLabel,changeLocLabel,changeDescrLabel,deleteAnsLabel,failedEdit,failedDelete,addRevLabel,addAnsLabel,rateLabel,editRevLabel1,editRevLabel2,editRateLabel,revsLabel;
    JTextField uText,userText,fnameText,lnameText,typeText,namePropText,typePropText,locPropText,descrPropText,editAnsText,changeNameText,changeTypeText,changeLocText,changeDescrText,deleteAnsText,addRevText,addAnsText,rateText,editRevText1,editRevText2,editRateText;
    JPasswordField passText,pText;

    public GUI() {

        namePropLabel = new ArrayList<>();
        typePropLabel = new ArrayList<>();
        locPropLabel = new ArrayList<>();
        descrPropLabel = new ArrayList<>();
        propLabel = new ArrayList<>();

        rateRevLabel = new ArrayList<>();
        propRevLabel = new ArrayList<>();
        reviewLabel = new ArrayList<>();
        userRevLabel = new ArrayList<>();
        namePropRevLabel = new ArrayList<>();
        stringRevLabel = new ArrayList<>();




        count=1;

        fileP = new File("src/api/Properties");
        fileR = new File("src/api/UserReviews");
        provider = new Provider();
        user = new User();

        frame = new JFrame();
        panelIntro = new JPanel();
        loginPanel = new JPanel();
        regPanel = new JPanel();
        successPanelUser = new JPanel();
        successPanelProv = new JPanel();
        addProvPanel = new JPanel();
        userPanel = new JPanel();
        editPanel = new JPanel();
        changePanel = new JPanel();
        deletePanel = new JPanel();
        addUserPanel = new JPanel();
        addRevPanel = new JPanel();
        editUserPanel = new JPanel();
        editRevPanel = new JPanel();

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
        deleteButton1 = new JButton();
        addRevButton = new JButton();
        addAnsButton = new JButton();
        editRevButton1 = new JButton();
        editRevButton2 = new JButton();

        labelIntro1 = new JLabel();
        labelIntro2 = new JLabel();
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
        uLabel = new JLabel();
        pLabel = new JLabel();
        deleteAnsLabel = new JLabel();
        failedAdd = new JLabel();
        failedEdit = new JLabel();
        failedDelete = new JLabel();
        failedReg1 = new JLabel();
        failedReg2 = new JLabel();
        addRevLabel = new JLabel();
        addAnsLabel = new JLabel();
        rateLabel = new JLabel();
        editRevLabel2 = new JLabel();
        editRevLabel1 = new JLabel();
        editRateLabel = new JLabel();
        revsLabel = new JLabel();

        fnameText = new JTextField();
        lnameText = new JTextField();
        typeText = new JTextField();
        uText = new JTextField();
        namePropText = new JTextField();
        typePropText = new JTextField();
        locPropText = new JTextField();
        descrPropText = new JTextField();
        editAnsText = new JTextField();
        changeNameText = new JTextField();
        changeTypeText = new JTextField();
        changeLocText = new JTextField();
        changeDescrText = new JTextField();
        deleteAnsText = new JTextField();
        addRevText = new JTextField();
        addAnsText = new JTextField();
        rateText = new JTextField();
        editRateText = new JTextField();
        editRevText1 = new JTextField();
        editRevText2 = new JTextField();

        userLabel = new JLabel();
        passLabel = new JLabel();
        userText = new JTextField();
        passText = new JPasswordField();
        pText = new JPasswordField();




        successPanelUser.add(addUser);
        successPanelUser.add(editUser);
        successPanelUser.add(search);
        successPanelUser.add(dashboardUser);
        successPanelUser.add(deleteUser);





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

        regPanel.setLayout(null);

        successPanelUser.setLayout(null);

        successPanelProv.setLayout(null);

        editUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successPanelUser.setVisible(false);
                editUserPanel.setVisible(true);
                editReviewSession();
            }
        });

        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successPanelUser.setVisible(false);
                addUserPanel.setVisible(true);
                addReviewSession();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelIntro.setVisible(false);
                //frame.add(loginPanel);
                loginPanel.setVisible(true);



                loginButton.setVisible(false);
                regButton.setVisible(false);
                //signInButton.setVisible(true);

                loginSession();


            }
        });
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.remove(panelIntro);
                panelIntro.setVisible(false);
                //frame.add(regPanel);


                loginButton.setVisible(false);
                regButton.setVisible(false);
                signInButton.setVisible(false);
                //loginPanel.setVisible(false);
                registerSession();




            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loginPanel.add(failedLabel);

                failedLabel.setText("Username and Password don't match. Please try again");
                failedLabel.setBounds(250, 350, 400, 100);
                failedLabel.setForeground(Color.red);
                try {
                    log = new LogIn(userText.getText(), passText.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                log.addCredits();
                boolean isUser = log.accCheck(userText.getText(),passText.getText());
                boolean flag = false;
                if (isUser) {
                    flag = true;
                }
                String whatUser = log.whatUser(log.getUsername(), log.getPassword(), "user");
                if(!flag){
                    failedLabel.setVisible(true);
                }
                else{
                    failedLabel.setVisible(false);
                    loggedIn(whatUser);

                }

            }
        });
        addProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                successPanelProv.setVisible(false);

                addProvPanel.setVisible(true);

                addProv.setSelected(false);
                failedEdit.setVisible(false);
                failedDelete.setVisible(false);


                addPropertySession();
            }
        });

        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                addProvPanel.add(failedAdd);
                failedAdd.setText("There is a already a property with this name. Try another one.");
                failedAdd.setBounds(280,600,350,30);
                failedAdd.setForeground(Color.red);
                boolean flag=false;
                for (int i=0;i<provider.getSize2();i++){
                    if(namePropText.getText().equals(provider.getProperties().get(i).getName())){
                        flag=true;
                    }
                }
                if(flag){
                    failedAdd.setVisible(true);

                }else{
                    failedAdd.setVisible(true);
                    provider.addProperties(provider.getSize()+1, namePropText.getText(),typePropText.getText(),locPropText.getText(),descrPropText.getText(),log.getUsername());
                    try {


                        provider.reNewFile2(fileP);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    count++;
                    addProvPanel.setVisible(false);
                    successPanelProv.setVisible(true);
                }


            }
        });


        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePanel.setVisible(false);

                System.out.println(namePropLabel.get(Integer.parseInt(deleteAnsText.getText())-1));
                namePropLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);

                typePropLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);
                locPropLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);
                descrPropLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);
                propLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);
                provider.deleteProp(Integer.parseInt(deleteAnsText.getText()));
                try {
                    provider.reNewFile2(fileP);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                frame.remove(deletePanel);
                namePropLabel.removeAll(namePropLabel);
                typePropLabel.removeAll(typePropLabel);
                locPropLabel.removeAll(locPropLabel);
                descrPropLabel.removeAll(descrPropLabel);
                propLabel.removeAll(propLabel);

                deletePanel.removeAll();
                successPanelProv.setVisible(true);

            }


        });
        deleteProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(provider.hasProps(log.getUsername())){
                    successPanelProv.setVisible(false);
                    addProvPanel.setVisible(false);
                    editPanel.setVisible(false);

                    deletePropertySession();
                }else{
                    successPanelProv.add(failedDelete);
                    failedDelete.setText("You don't have properties to delete.");
                    failedDelete.setBounds(380,350,250,40);
                    failedDelete.setForeground(Color.red);
                    failedDelete.setVisible(true);
                    failedEdit.setVisible(false);
                }

            }
        });
        editProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(provider.hasProps(log.getUsername())){
                    successPanelProv.setVisible(false);
                    addProvPanel.setVisible(false);
                    failedEdit.setVisible(false);
                    editPropertySession();
                }else{
                    successPanelProv.add(failedEdit);
                    failedEdit.setText("You don't have properties to edit.");
                    failedEdit.setBounds(380,350,250,40);
                    failedEdit.setForeground(Color.red);
                    failedDelete.setVisible(false);
                    failedEdit.setVisible(true);

                }



            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    reg = new Register(fnameText.getText(), lnameText.getText(), uText.getText(), pText.getText(), typeText.getText());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                boolean verify =  reg.verifyAcc(uText.getText());

                if(verify && (typeText.getText().equals("user") || typeText.equals("provider"))){
                   try {

                       reg.newAcc(uText.getText(), pText.getText(), typeText.getText());
                   } catch (IOException ex) {
                       throw new RuntimeException(ex);
                   }
                   regPanel.setVisible(false);
                   loginPanel.setVisible(true);
                   loginSession();
                }
                if(!(reg.getType().equals("user")) || !(reg.getType().equals("provider"))){
                   failedReg2.setVisible(true);
                   if(!verify){
                       failedReg1.setVisible(true);
                   }
                }
                if(!verify){
                    failedReg1.setVisible(true);
                    if(!(typeText.getText().equals("user")) || !(typeText.equals("provider"))){
                        failedReg2.setVisible(true);
                    }
                }

                //failedReg1.setVisible(false);
                //failedReg2.setVisible(false);


            }
        });

        addAnsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String propName = provider.getPropName2(Integer.parseInt(addAnsText.getText()));

                boolean has = user.hasRevs(propName,log.getUsername());

                if (has){
                    System.out.println("You already have a review for this property.Delete it or edit from the Menu below.");
                }else{
                    frame.add(addRevPanel);

                    addUserPanel.setVisible(false);
                    addRevPanel.setVisible(true);
                }


            }
        });
        editRevButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String propName = provider.getPropName2(Integer.parseInt(editRevText1.getText()));

                boolean has = user.hasRevs(propName,log.getUsername());
                if(!has){
                    System.out.println("You dont have review for this property");
                }else {
                    frame.add(editRevPanel);
                    editUserPanel.setVisible(false);
                    editRevPanel.setVisible(true);
                }
            }
        });

        editRevButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                //String propName = provider.getPropName2(Integer.parseInt(editRevText1.getText()));
                user.editRevGUI(editRevText2.getText(),editRateText.getText(),Integer.parseInt(editRevText1.getText()));
                System.out.println(editRevText1.getText());
                JLabel temp = new JLabel();
                temp.setText("Review for property "+editRevText1.getText()+" "+user.getProperties().get(Integer.parseInt(editRevText1.getText())-1)+" with rate "+editRateText.getText()+"/5 :"+editRevText2.getText());


                System.out.println(temp.getText());
                // reviews.get(Integer.parseInt(editRevText1.getText())-1).setText("Review for property "+editRevText1.getText()+" "+user.getProperties().get(Integer.parseInt(editRevText1.getText())-1)+" with rate "+editRateText.getText()+"/5 :"+editRevText2.getText());
                try {
                    user.reNewFile(fileR);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                successPanelUser.setVisible(true);
                editUserPanel.setVisible(false);
                editRevPanel.setVisible(false);*/

            }
        });

        addRevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String propName = provider.getPropName2(Integer.parseInt(addAnsText.getText()));

                user.addReviews(addRevText.getText(),propName,log.getUsername(),rateText.getText());
                try {
                    user.reNewFile(fileR);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }



                addRevPanel.setVisible(false);
                addUserPanel.setVisible(false);
                successPanelUser.setVisible(true);
            }
        });





    }

    public void Initialize() throws FileNotFoundException {
        Scanner input;

        input = new Scanner(fileR);
        String review,fromUser,forProp,rate;
        while(input.hasNextLine()){
            review = input.nextLine();
            forProp = input.nextLine();
            fromUser =input.nextLine();
            rate = input.nextLine();
            user.addReviews(review,forProp,fromUser,rate);
        }

        input = new Scanner(fileP);
        input.useDelimiter("-");
        String nameProp,typeProp,locProp,descrProp,whoProp;
        int count=1;
        while(input.hasNextLine()){
            nameProp = input.next();
            typeProp = input.next();
            locProp = input.next();
            input.skip("-");
            descrProp = input.nextLine();
            whoProp = input.nextLine();
            provider.addProperties(count,nameProp,typeProp,locProp,descrProp,whoProp);
            count++;
        }

    }
    public void Intro() {
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

        loginButton.setVisible(true);
        regButton.setVisible(true);


    }

    public void loginSession(){
        frame.add(loginPanel);
        loginPanel.add(userLabel);
        loginPanel.add(passLabel);
        loginPanel.add(userText);
        loginPanel.add(passText);
        loginPanel.add(signInButton);

        userLabel.setText("Username");
        userLabel.setBounds(220, 200, 100, 40);
        passLabel.setText("Password");
        passLabel.setBounds(220, 250, 100, 40);

        userText.setBounds(340, 210, 100, 20);

        passText.setBounds(340, 260, 100, 20);

        loginPanel.setVisible(true);


        userLabel.setVisible(true);
        passLabel.setVisible(true);

        userText.setVisible(true);
        passText.setVisible(true);
        signInButton.setVisible(true);


    }

    public void registerSession(){
        frame.add(regPanel);
        regPanel.add(fnameLabel);
        regPanel.add(lnameLabel);
        regPanel.add(uLabel);
        regPanel.add(pLabel);
        regPanel.add(typeLabel);
        regPanel.add(fnameText);
        regPanel.add(lnameText);
        regPanel.add(uText);
        regPanel.add(pText);
        regPanel.add(typeText);
        regPanel.add(create);
        regPanel.add(failedReg1);
        regPanel.add(failedReg2);

        fnameLabel.setText("First Name");
        fnameLabel.setBounds(350, 210, 100, 20);
        fnameText.setBounds(450, 210, 100, 20);

        lnameLabel.setText("Last Name");
        lnameLabel.setBounds(350, 250, 100, 20);
        lnameText.setBounds(450, 250, 100, 20);

        uLabel.setText("Username");
        uLabel.setBounds(350, 300, 100, 20);
        uText.setBounds(450, 300, 100, 20);

        pLabel.setText("Password");
        pLabel.setBounds(350, 350, 100, 20);
        pText.setBounds(450, 350, 100, 20);

        typeLabel.setText("Provider or User?");
        typeLabel.setBounds(320, 400, 120, 20);
        typeText.setBounds(450, 400, 100, 20);

        failedReg1.setText("There is already a user with this name.");
        failedReg1.setBounds(400,550,100,20);
        failedReg1.setForeground(Color.red);

        failedReg1.setText("Invalid User Type. Type 'provider' or 'user'");
        failedReg1.setBounds(400,600,100,20);
        failedReg1.setForeground(Color.red);

        create.setBounds(400, 450, 150, 30);





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

        failedReg1.setVisible(false);
        failedReg2.setVisible(false);


    }
    public void loggedIn(String type) {


        if (type.equals("user")) {
            loginPanel.setVisible(false);
            regPanel.setVisible(false);
            frame.add(successPanelUser);
            successPanelUser.setVisible(true);

            successPanelUser.add(successLabelUser);

            successLabelUser.setBounds(400, 50, 400, 100);
            successLabelUser.setVisible(true);
            successLabelUser.setText("Hi " + log.getUsername() + ". " + "You are " + type);

        } else if (type.equals("provider")) {
            loginPanel.setVisible(false);
            frame.add(successPanelProv);
            successPanelProv.setVisible(true);
            successPanelProv.add(successLabelProv);
            successPanelProv.add(addProv);
            successPanelProv.add(editProv);
            successPanelProv.add(deleteProv);
            successPanelProv.add(dashboardProv);

            addProvPanel.setLayout(null);

            changePanel.setLayout(null);
            addProvPanel.setVisible(false);
            editPanel.setVisible(false);

            successLabelProv.setBounds(400, 50, 400, 100);
            successLabelProv.setVisible(true);
            successLabelProv.setText("Hi " + log.getUsername() + ". " + "You are " + type);
        }

    }

    public void editReviewSession(){
        frame.add(editUserPanel);
        editUserPanel.setLayout(null);
        editRevPanel.setLayout(null);

        editRevText1.setText(null);
        editRevText2.setText(null);
        editRateText.setText(null);

        editUserPanel.add(editRevText1);
        editUserPanel.add(editRevLabel1);
        editUserPanel.add(editRevButton1);
        editUserPanel.add(revsLabel);

        editRevPanel.add(editRevText2);
        editRevPanel.add(editRevLabel2);
        editRevPanel.add(editRevButton2);
        editRevPanel.add(editRateLabel);
        editRevPanel.add(editRateText);

        revsLabel.setText("Your reviews are down below.");
        revsLabel.setBounds(400,20,250,30);

        editRevLabel2.setText("Edit your review below.");
        editRevLabel2.setBounds(380,150,200,30);

        editRateLabel.setText("Edit your rate below.");
        editRateLabel.setBounds(390,240,200,30);

        editRevText2.setBounds(350,200,200,30);
        editRateText.setBounds(350,280,200,30);

        editRevButton2.setText("Done");
        editRevButton2.setBounds(350,320,200,30);

        editUserPanel.setVisible(true);

        //System.out.println(user.getUsers().size());
        for(int i=0;i<user.getUsers().size();i++){
            JLabel tempRev = new JLabel();
            JLabel tempRate = new JLabel();
            JLabel tempUser = new JLabel();
            JLabel tempPropName = new JLabel();


            tempRev.setText(user.getRev().get(i));
            //System.out.println(tempRev.getText());
            stringRevLabel.add(tempRev);
            tempPropName.setText(user.getProperties().get(i));
            namePropRevLabel.add(tempPropName);
            tempUser.setText(user.getUsers().get(i));
            userRevLabel.add(tempUser);
            tempRate.setText(user.getRate().get(i));
            rateRevLabel.add(tempRate);
            //for(int j=0;j<provider.getSize2();j++){

               //if(provider.getProperties().get(i).getName().equals(tempPropName.getText())){
                   // tempProp.setText(String.valueOf(i+1));
                   // propRevLabel.add(tempProp);
           //     }
            //}
        }
        for(int i=0;i<user.getUsers().size();i++){

            for(int j=0;j<provider.getProperties().size();j++){

                //System.out.println(provider.getProperties().size());
                if(provider.getProperties().get(j).getName().equals(user.getProperties().get(i))){
                    JLabel tempProp = new JLabel();

                    //System.out.println(String.valueOf(i+1)+"--"+provider.getProperties().get(i).getName());
                    //System.out.println(provider.getProperties().get(i).getName()+"=="+user.getProperties().get(i));
                    tempProp.setText(""+String.valueOf(j+1));
                    propRevLabel.add(tempProp);
                }

            }

        }
        for(int i=0;i<stringRevLabel.size();i++){
            JLabel temp = new JLabel();
            temp.setText("Your review for property "+propRevLabel.get(i).getText()+" "+namePropRevLabel.get(i).getText()+" with rate "+rateRevLabel.get(i).getText()+"/5 : "+stringRevLabel.get(i).getText());
            reviewLabel.add(temp);
        }
        int width=0, height=50;
        for(int i=0;i<stringRevLabel.size();i++) {
            System.out.println(reviewLabel.get(i).getText());
            if(log.getUsername().equals(userRevLabel.get(i).getText())){
                reviewLabel.get(i).setBounds(width,height,500,30);
                height+=40;
                editUserPanel.add(reviewLabel.get(i));
                reviewLabel.get(i).setVisible(true);
            }
        }


        editRevLabel1.setText("For which property you want to edit your review?");
        editRevLabel1.setBounds(50,700,400,30);
        editRevText1.setBounds(400,700,100,30);
        editRevButton1.setText("Edit Review");
        editRevButton1.setBounds(520,700,120,30);

        editRevButton1.setVisible(true);
        editRevLabel1.setVisible(true);
        editRevText1.setVisible(true);



    }

    public void addReviewSession(){
        frame.add(addUserPanel);

        addUserPanel.setLayout(null);
        addRevPanel.setLayout(null);
        addRevText.setText(null);
        addAnsText.setText(null);
        rateText.setText(null);

        addUserPanel.add(addAnsLabel);
        addUserPanel.add(addAnsText);
        addUserPanel.add(addAnsButton);

        addRevPanel.add(addRevText);
        addRevPanel.add(addRevLabel);
        addRevPanel.add(addRevButton);
        addRevPanel.add(rateText);
        addRevPanel.add(rateLabel);

        addRevLabel.setText("Add new review below.");
        addRevLabel.setBounds(380,150,200,30);

        rateLabel.setText("Add your rate below.");
        rateLabel.setBounds(390,240,200,30);

        addRevText.setBounds(350,200,200,30);
        rateText.setBounds(350,280,200,30);

        addRevButton.setText("Done");
        addRevButton.setBounds(350,320,200,30);



        addUserPanel.setVisible(true);

        int width,height,widthN,widthT,widthL,widthD,heightP,temp=1;
        width=0;
        widthN =0;
        widthT =0;
        widthD =0;
        widthL =0;
        height = 0;
        heightP=20;
        int c=1;

        for(int i=0;i< provider.getSize2();i++){

            JLabel tempProp = new JLabel();
            JLabel tempName = new JLabel();
            JLabel tempType = new JLabel();
            JLabel tempLoc = new JLabel();
            JLabel tempDescr = new JLabel();

            tempName.setText("Name: "+provider.getProperties().get(i).getName());
            namePropLabel.add(tempName);
            tempType.setText("Type: "+provider.getProperties().get(i).getType());
            typePropLabel.add(tempType);
            tempLoc.setText("Location: "+provider.getProperties().get(i).getLocation());
            locPropLabel.add(tempLoc);
            tempDescr.setText("Description: "+provider.getProperties().get(i).getDescr());
            descrPropLabel.add(tempDescr);
            tempProp.setText("Property "+(i+1));
            propLabel.add(tempProp);
            //System.out.println(tempProp.getText()+"--"+tempName.getText());
            //System.out.println(propLabel.get(i).getText()+"--"+namePropLabel.get(i).getText());
            //System.out.println(propLabel.get(i).getText()+"---"+namePropLabel.get(i).getText());


            if(width==1000){
                width=0;
                widthN=0;
                widthL=0;
                widthD=0;
                widthT=0;
                height+=160;
               // temp++;
                heightP=height+20;
            }

            propLabel.get(i).setBounds(width,height,100,20);
            namePropLabel.get(i).setBounds(widthN,heightP,150,20);
            heightP+=20;
            typePropLabel.get(i).setBounds(widthT,heightP,150,20);
            heightP+=20;
            locPropLabel.get(i).setBounds(widthL,heightP,150,20);
            heightP+=20;
            descrPropLabel.get(i).setBounds(widthD,heightP,150,20);
            heightP =temp*height+20;
            width +=200;
            widthN +=200;
            widthT +=200;
            widthL +=200;
            widthD +=200;
            addUserPanel.add(propLabel.get(i));
            addUserPanel.add(namePropLabel.get(i));
            addUserPanel.add(typePropLabel.get(i));
            addUserPanel.add(locPropLabel.get(i));
            addUserPanel.add(descrPropLabel.get(i));
            propLabel.get(i).setVisible(true);
            namePropLabel.get(i).setVisible(true);
            typePropLabel.get(i).setVisible(true);
            locPropLabel.get(i).setVisible(true);
            descrPropLabel.get(i).setVisible(true);






            addAnsLabel.setText("For which property you want to add a review; ");
            addAnsLabel.setBounds(50,700,400,30);
            addAnsText.setBounds(400,700,100,30);
            addAnsButton.setText("Add a review");
            addAnsButton.setBounds(520,700,120,30);

            addAnsButton.setVisible(true);
            addAnsText.setVisible(true);
            addAnsLabel.setVisible(true);
            c++;

        }

    }

    public void deletePropertySession(){
        frame.add(deletePanel);
        deletePanel.setLayout(null);
        deletePanel.setVisible(true);
        deleteAnsText.setText(null);


        int width,height,widthN,widthT,widthL,widthD,heightP,temp=1;
        width=0;
        widthN =0;
        widthT =0;
        widthD =0;
        widthL =0;
        height = 0;
        heightP=20;
        int c=1;

        for(int i=0;i< provider.getSize2();i++){

            JLabel tempProp = new JLabel();
            JLabel tempName = new JLabel();
            JLabel tempType = new JLabel();
            JLabel tempLoc = new JLabel();
            JLabel tempDescr = new JLabel();

            tempName.setText("Name: "+provider.getProperties().get(i).getName());
            namePropLabel.add(tempName);
            tempType.setText("Type: "+provider.getProperties().get(i).getType());
            typePropLabel.add(tempType);
            tempLoc.setText("Location: "+provider.getProperties().get(i).getLocation());
            locPropLabel.add(tempLoc);
            tempDescr.setText("Description: "+provider.getProperties().get(i).getDescr());
            descrPropLabel.add(tempDescr);
            tempProp.setText("Property "+(i+1));
            propLabel.add(tempProp);
            System.out.println(tempProp.getText()+"--"+tempName.getText());
            System.out.println(propLabel.get(i).getText()+"--"+namePropLabel.get(i).getText());
            //System.out.println(propLabel.get(i).getText()+"---"+namePropLabel.get(i).getText());


            if(width==1000){
                width=0;
                widthN=0;
                widthL=0;
                widthD=0;
                widthT=0;
                height+=160;
               // temp++;
                heightP=height+20;
            }


            if(provider.getNames().get(i).equals(log.getUsername())){

                    propLabel.get(i).setBounds(width,height,100,20);
                    namePropLabel.get(i).setBounds(widthN,heightP,150,20);
                    heightP+=20;
                    typePropLabel.get(i).setBounds(widthT,heightP,150,20);
                    heightP+=20;
                    locPropLabel.get(i).setBounds(widthL,heightP,150,20);
                    heightP+=20;
                    descrPropLabel.get(i).setBounds(widthD,heightP,150,20);
                    heightP =temp*height+20;
                    width +=200;
                    widthN +=200;
                    widthT +=200;
                    widthL +=200;
                    widthD +=200;
                    deletePanel.add(propLabel.get(i));
                    deletePanel.add(namePropLabel.get(i));
                    deletePanel.add(typePropLabel.get(i));
                    deletePanel.add(locPropLabel.get(i));
                    deletePanel.add(descrPropLabel.get(i));
                    propLabel.get(i).setVisible(true);
                    namePropLabel.get(i).setVisible(true);
                    typePropLabel.get(i).setVisible(true);
                    locPropLabel.get(i).setVisible(true);
                    descrPropLabel.get(i).setVisible(true);


            }

            deletePanel.add(deleteAnsLabel);
            deletePanel.add(deleteAnsText);
            deletePanel.add(deleteButton1);

            deleteAnsLabel.setText("Type the number of property you want to delete: ");
            deleteAnsLabel.setBounds(50,700,400,30);
            deleteAnsText.setBounds(400,700,100,30);
            deleteButton1.setText("Delete");
            deleteButton1.setBounds(520,700,100,30);
            deleteButton1.setVisible(true);
            deleteAnsText.setVisible(true);
            deleteAnsLabel.setVisible(true);
            c++;

        }
    }


    public void editPropertySession(){
        frame.add(editPanel);
        editPanel.setLayout(null);
        editPanel.setVisible(true);
        changeNameText.setText(null);
        changeTypeText.setText(null);
        changeLocText.setText(null);
        changeDescrText.setText(null);
        editAnsText.setText(null);

        JLabel[] propLabel = new JLabel[provider.getSize2()];
        JLabel[] namePropLabel = new JLabel[provider.getSize2()];
        JLabel[] typePropLabel = new JLabel[provider.getSize2()];
        JLabel[] locPropLabel = new JLabel[provider.getSize2()];
        JLabel[] descrPropLabel = new JLabel[provider.getSize2()];

        System.out.println(propLabel.length);

        int width,height,widthN,widthT,widthL,widthD,heightP,temp=1;
        width=0;
        widthN =0;
        widthT =0;
        widthD =0;
        widthL =0;
        height = 0;
        heightP=20;
        for(int i=0;i<provider.getSize2();i++){
            propLabel[i] = new JLabel();
            namePropLabel[i] = new JLabel();
            typePropLabel[i] = new JLabel();
            locPropLabel[i] = new JLabel();
            descrPropLabel[i] = new JLabel();

            if(provider.getNames().get(i).equals(log.getUsername())){
                namePropLabel[i].setText("Name: "+provider.getProperties().get(i).getName());
                typePropLabel[i].setText("Type: "+provider.getProperties().get(i).getType());
                locPropLabel[i].setText("Location: "+provider.getProperties().get(i).getLocation());
                descrPropLabel[i].setText("Description: "+provider.getProperties().get(i).getDescr());
                propLabel[i].setText("Property "+String.valueOf(i+1));
                if(width==1000){
                    width=0;
                    widthN=0;
                    widthL=0;
                    widthD=0;
                    widthT=0;
                    height+=160;
                    //temp++;
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
                editPanel.add(propLabel[i]);
                editPanel.add(namePropLabel[i]);
                editPanel.add(typePropLabel[i]);
                editPanel.add(locPropLabel[i]);
                editPanel.add(descrPropLabel[i]);
                propLabel[i].setVisible(true);
                namePropLabel[i].setVisible(true);
                typePropLabel[i].setVisible(true);
                locPropLabel[i].setVisible(true);
                descrPropLabel[i].setVisible(true);
                //propLabel[i].revalidate();


            }

            editPanel.add(editAnsLabel);
            editPanel.add(editAnsText);
            editPanel.add(change);
            editAnsLabel.setText("Type the number of property you want to edit: ");
            editAnsLabel.setBounds(50,700,400,30);
            editAnsText.setBounds(400,700,100,30);
            change.setText("Change");
            change.setBounds(520,700,100,30);
            change.setVisible(true);
            editAnsText.setVisible(true);
            editAnsLabel.setVisible(true);

        }
        changeProp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPanel.setVisible(false);
                changePanel.setVisible(false);
                provider.editGUI(changeNameText.getText(),changeTypeText.getText(),changeLocText.getText(),changeDescrText.getText(),editAnsText.getText());
                namePropLabel[Integer.parseInt(editAnsText.getText())-1].setText("Name: "+changeNameText.getText());
                typePropLabel[Integer.parseInt(editAnsText.getText())-1].setText("Type: "+changeTypeText.getText());
                locPropLabel[Integer.parseInt(editAnsText.getText())-1].setText("Location: "+changeLocText.getText());
                descrPropLabel[Integer.parseInt(editAnsText.getText())-1].setText("Description: "+changeDescrText.getText());


                try {
                    provider.reNewFile2(fileP);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                successPanelProv.setVisible(true);

            }
        });

        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(changePanel);

                editPanel.setVisible(false);
                changePanel.setVisible(true);

                changePanel.add(changeNameLabel);
                changePanel.add(changeNameText);
                changePanel.add(changeTypeLabel);
                changePanel.add(changeTypeText);
                changePanel.add(changeLocLabel);
                changePanel.add(changeLocText);
                changePanel.add(changeDescrLabel);
                changePanel.add(changeDescrText);
                changePanel.add(changeProp);

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

    }

    public void addPropertySession(){
        frame.add(addProvPanel);
        addProvPanel.setLayout(null);

        addProvPanel.add(nameProp);
        addProvPanel.add(namePropText);
        addProvPanel.add(typeProp);
        addProvPanel.add(typePropText);
        addProvPanel.add(locProp);
        addProvPanel.add(locPropText);
        addProvPanel.add(descrProp);
        addProvPanel.add(descrPropText);
        addProvPanel.add(submit);
        namePropText.setText(null);
        typePropText.setText(null);
        locPropText.setText(null);
        descrPropText.setText(null);
        nameProp.setText("Name of property");
        nameProp.setBounds(400, 100, 100, 30);
        namePropText.setBounds(400, 150, 100, 30);

        typeProp.setText("Type of property");
        typeProp.setBounds(400, 200, 100, 30);
        typePropText.setBounds(400, 250, 100, 30);

        locProp.setText("Location of property");
        locProp.setBounds(400, 300, 150, 30);
        locPropText.setBounds(400, 350, 100, 30);

        descrProp.setText("Add a description");
        descrProp.setBounds(400, 400, 100, 30);
        descrPropText.setBounds(400, 450, 100, 30);

        nameProp.setVisible(true);
        namePropText.setVisible(true);

        typeProp.setVisible(true);
        typePropText.setVisible(true);

        locProp.setVisible(true);
        locPropText.setVisible(true);

        descrProp.setVisible(true);
        descrPropText.setVisible(true);

        submit.setText("Submit");
        submit.setBounds(400,500,100,30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}