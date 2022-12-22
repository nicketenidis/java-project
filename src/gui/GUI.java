package gui;

import api.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.lang.*;
import java.io.*;


import java.util.*;

import javax.swing.*;



public class GUI implements ActionListener {

    ArrayList<JLabel> avg;
    ArrayList<JLabel> totalAvgProp;
    ArrayList<JLabel> freqRevProp;

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

    File fileP;
    File fileR;

    Register reg;

    Provider provider;
    User user;
    LogIn log;
    JFrame frame;

    JPanel panelIntro,loginPanel,regPanel,successPanelUser,successPanelProv,addProvPanel,userPanel,editPanel,changePanel,deletePanel,addUserPanel,addRevPanel,editUserPanel,editRevPanel,deleteUserPanel,dashboardProv1,dashboardProv2,dashboardUser1,dashboardUser2,searchPanel;
    JButton loginButton,regButton,signInButton,logout,addUser,editUser,search,deleteUser,dashboardUser,addProv,editProv,dashboardProv,deleteProv,propButton,submit,create,change,changeProp,deleteButton1,addRevButton,addAnsButton,editRevButton1,editRevButton2,deleteRevButton,viewPropProv,menuProv,menuUser,viewPropUser,searchButton;
    JLabel uLabel,pLabel,userLabel,passLabel,failedReg1,failedReg2,labelIntro1,labelIntro2,fnameLabel,lnameLabel,typeLabel,successLabelUser,failedLabel,successLabelProv,nameProp,typeProp,locProp,descrProp,failedAdd,editAnsLabel,changeNameLabel,changeTypeLabel,changeLocLabel,changeDescrLabel,deleteAnsLabel,failedEdit,failedDelete,addRevLabel,addAnsLabel,rateLabel,editRevLabel1,editRevLabel2,editRateLabel,revsLabel,deleteRevLabel,viewLabelProv,viewLabelUser,viewAvgRate,searchLabel;
    JTextField uText,userText,fnameText,lnameText,typeText,namePropText,typePropText,locPropText,descrPropText,editAnsText,changeNameText,changeTypeText,changeLocText,changeDescrText,deleteAnsText,addRevText,addAnsText,rateText,editRevText1,editRevText2,editRateText,deleteRevText,viewProvText,viewUserText,searchText;
    JPasswordField passText,pText;

    public GUI() {

        avg = new ArrayList<>();
        freqRevProp = new ArrayList<>();
        totalAvgProp = new ArrayList<>();

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
        deleteUserPanel = new JPanel();
        dashboardProv1= new JPanel();
        dashboardProv2 = new JPanel();
        dashboardUser1 = new JPanel();
        dashboardUser2 = new JPanel();
        searchPanel = new JPanel();

        loginButton = new JButton();
        regButton = new JButton();
        signInButton = new JButton();
        logout = new JButton();
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
        deleteRevButton = new JButton();
        viewPropProv= new JButton();
        menuProv = new JButton();
        menuUser = new JButton();
        viewPropUser = new JButton();
        searchButton = new JButton();

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
        deleteRevLabel = new JLabel();
        viewLabelProv = new JLabel();
        viewLabelUser = new JLabel();
        viewAvgRate = new JLabel();
        searchLabel = new JLabel();

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
        deleteRevText = new JTextField();
        viewProvText = new JTextField();
        viewUserText = new JTextField();
        searchText = new JTextField();

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
        signInButton.setBackground(Color.magenta);

        logout.setText("Log out");
        logout.setBounds(880,10,100,30);

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


        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.removeAll();
                successPanelProv.setVisible(false);
                successPanelUser.setVisible(false);
                panelIntro.setVisible(true);
                Intro();
            }
        });

        editUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successPanelUser.setVisible(false);
                editUserPanel.setVisible(true);
                editReviewSession();
            }
        });
        deleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean has = user.hasGenRevs(log.getUsername());
                if(!has){
                    System.out.println("You have not reviewed a property yet.");
                }else {
                    successPanelUser.setVisible(false);
                    deleteUserPanel.setVisible(true);
                    deleteReviewSession();
                }
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
                    provider.addProperties( namePropText.getText(),typePropText.getText(),locPropText.getText(),descrPropText.getText(),log.getUsername());
                    try {


                        provider.reNewFile2(fileP);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    addProvPanel.setVisible(false);
                    successPanelProv.setVisible(true);
                }


            }
        });


        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePanel.setVisible(false);
                String propName = provider.getPropName2(Integer.parseInt(deleteAnsText.getText()));


                namePropLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);

                typePropLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);
                locPropLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);
                descrPropLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);
                propLabel.remove(Integer.parseInt(deleteAnsText.getText())-1);
                provider.deleteProp(Integer.parseInt(deleteAnsText.getText()));
                user.deletePropRev(propName);
                try {
                    provider.reNewFile2(fileP);
                    user.reNewFile(fileR);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //frame.remove(deletePanel);
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

                if(verify && (typeText.getText().equals("user") || typeText.getText().equals("provider"))){
                    try {

                        reg.newAcc(uText.getText(), pText.getText(), typeText.getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    regPanel.setVisible(false);
                    loginPanel.setVisible(true);
                    loginSession();
                }
                if(!(typeText.getText().equals("user")) || !(typeText.getText().equals("provider"))){
                    failedReg1.setVisible(false);
                    failedReg2.setVisible(true);
                    if(!verify){
                        failedReg1.setVisible(true);
                    }
                }else if(!verify){
                    failedReg2.setVisible(false);
                    failedReg1.setVisible(true);
                    if(!(typeText.getText().equals("user")) || !(typeText.getText().equals("provider"))){
                        failedReg2.setVisible(true);
                    }
                }




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
                String propName;
                if(Integer.parseInt(editRevText1.getText()) > provider.getSize2()){
                    System.out.println("Invalid Property Number");
                }else{
                    propName = provider.getPropName2(Integer.parseInt(editRevText1.getText()));
                    boolean has = user.hasRevs(propName,log.getUsername());
                    if(!has){
                        System.out.println("You dont have review for this property");
                    }else {
                        frame.add(editRevPanel);
                        editUserPanel.setVisible(false);
                        editRevPanel.setVisible(true);
                    }
                }


            }
        });

        editRevButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<propRevLabel.size();i++){
                    if(reviewLabel.get(i).getText().equals("Your review for property "+editRevText1.getText()+" "+namePropRevLabel.get(i).getText()+" with rate "+rateRevLabel.get(i).getText()+"/5 : "+stringRevLabel.get(i).getText())){
                        user.editRevGUI(editRevText2.getText(),editRateText.getText(),namePropRevLabel.get(i).getText(),log.getUsername());
                    }
                }
                try {
                    user.reNewFile(fileR);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                editUserPanel.removeAll();
                reviewLabel.removeAll(reviewLabel);
                namePropRevLabel.removeAll(namePropRevLabel);
                propRevLabel.removeAll(propRevLabel);
                userRevLabel.removeAll(userRevLabel);
                rateRevLabel.removeAll(rateRevLabel);
                stringRevLabel.removeAll(stringRevLabel);

                successPanelUser.setVisible(true);
                editUserPanel.setVisible(false);
                editRevPanel.setVisible(false);


            }
        });
        deleteRevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("mpika");
                for(int i=0;i<propRevLabel.size();i++){
                    if(reviewLabel.get(i).getText().equals("Your review for property "+deleteRevText.getText()+" "+namePropRevLabel.get(i).getText()+" with rate "+rateRevLabel.get(i).getText()+"/5 : "+stringRevLabel.get(i).getText())){
                        //System.out.println(namePropRevLabel.get(i).getText());
                        //user.editRevGUI(editRevText2.getText(),editRateText.getText(),namePropRevLabel.get(i).getText(),log.getUsername());
                        user.deleteRev(namePropRevLabel.get(i).getText(),log.getUsername());
                    }
                }
                try {
                    user.reNewFile(fileR);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                deleteUserPanel.removeAll();
                reviewLabel.removeAll(reviewLabel);
                namePropRevLabel.removeAll(namePropRevLabel);
                propRevLabel.removeAll(propRevLabel);
                userRevLabel.removeAll(userRevLabel);
                rateRevLabel.removeAll(rateRevLabel);
                stringRevLabel.removeAll(stringRevLabel);





                successPanelUser.setVisible(true);
                deleteUserPanel.setVisible(false);
            }
        });
        changeProp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPanel.setVisible(false);
                changePanel.setVisible(false);
                provider.editGUI(changeNameText.getText(),changeTypeText.getText(),changeLocText.getText(),changeDescrText.getText(),editAnsText.getText());

                try {
                    provider.reNewFile2(fileP);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                namePropLabel.removeAll(namePropLabel);
                typePropLabel.removeAll(typePropLabel);
                locPropLabel.removeAll(locPropLabel);
                descrPropLabel.removeAll(descrPropLabel);
                propLabel.removeAll(propLabel);

                editPanel.removeAll();

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

        dashboardProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!provider.hasProps(log.getUsername())){
                    System.out.println("No properties to show.");
                }else {
                    successPanelProv.setVisible(false);
                    dashboardProvSession();
                }
            }
        });
        dashboardUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!user.hasGenRevs(log.getUsername())){
                    System.out.println("You haven't reviewed any proeprty");
                }else{
                    successPanelUser.setVisible(false);
                    dashboardUserSession();
                }
            }
        });

        viewPropProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                dashboardProv1.setVisible(false);
                successPanelProv.setVisible(false);

                viewPropertyProv(Integer.parseInt(viewProvText.getText()));
            }
        });
        viewPropUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardUser1.setVisible(false);
                successPanelUser.setVisible(false);
                viewPropertyUser(Integer.parseInt(viewUserText.getText()));
            }
        });
        menuUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successPanelUser.setVisible(true);
                //dashboardUser1.setVisible(false);
                dashboardUser2.setVisible(false);
                namePropLabel.removeAll(namePropLabel);
                typePropLabel.removeAll(typePropLabel);
                locPropLabel.removeAll(locPropLabel);
                descrPropLabel.removeAll(descrPropLabel);
                propLabel.removeAll(propLabel);
                rateRevLabel.removeAll(rateRevLabel);
                userRevLabel.removeAll(userRevLabel);
                stringRevLabel.removeAll(stringRevLabel);
                dashboardUser2.removeAll();
                dashboardUser1.removeAll();
            }
        });

        menuProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successPanelProv.setVisible(true);
                dashboardProv2.setVisible(false);
                namePropLabel.removeAll(namePropLabel);
                typePropLabel.removeAll(typePropLabel);
                locPropLabel.removeAll(locPropLabel);
                descrPropLabel.removeAll(descrPropLabel);
                propLabel.removeAll(propLabel);
                avg.removeAll(avg);
                freqRevProp.removeAll(freqRevProp);
                dashboardProv2.removeAll();
                dashboardProv1.removeAll();
                stringRevLabel.removeAll(stringRevLabel);
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successPanelUser.setVisible(false);
                searchSession();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

        public void searchSession(){
        frame.add(searchPanel);
        searchPanel.setLayout(null);
        searchPanel.add(searchLabel);
        searchPanel.add(searchButton);
        searchPanel.add(searchText);

        searchLabel.setText("You can search properties via Name,Type,Location and facilities");
        searchLabel.setBounds(230,50,500,30);
        searchLabel.setVisible(true);

        searchText.setText(null);
        searchText.setBounds(200,90,400,30);
        searchText.setVisible(true);

        searchButton.setText("Search");
        searchButton.setBounds(620,90,100,30);
        searchButton.setVisible(true);



        searchPanel.setVisible(true);
    }

    public void viewPropertyUser(int property){
        frame.add(dashboardUser2);

        dashboardUser2.setLayout(null);
        dashboardUser2.add(menuUser);
        menuUser.setText("Back to Menu");
        menuUser.setBounds(400,700,150,30);
        menuUser.setVisible(true);

        dashboardUser2.setVisible(true);

        dashboardUser2.add(namePropLabel.get(property-1));
        dashboardUser2.add(typePropLabel.get(property-1));
        dashboardUser2.add(locPropLabel.get(property-1));
        dashboardUser2.add(descrPropLabel.get(property-1));
        dashboardUser2.add(propLabel.get(property-1));
        dashboardUser2.add(avg.get(property-1));
        dashboardUser2.add(freqRevProp.get(property-1));


        propLabel.get(property-1).setBounds(400,10,400,30);
        namePropLabel.get(property-1).setBounds(400,40,400,30);
        typePropLabel.get(property-1).setBounds(400,70,400,30);
        locPropLabel.get(property-1).setBounds(400,100,400,30);
        descrPropLabel.get(property-1).setBounds(400,130,400,30);
        avg.get(property-1).setBounds(400,160,400,30);
        freqRevProp.get(property-1).setBounds(400,190,400,30);


        propLabel.get(property-1).setVisible(true);
        namePropLabel.get(property-1).setVisible(true);
        typePropLabel.get(property-1).setVisible(true);
        locPropLabel.get(property-1).setVisible(true);
        descrPropLabel.get(property-1).setVisible(true);
        JLabel revs = new JLabel();
        dashboardUser2.add(revs);
        revs.setText("Reviews for this property");
        revs.setBounds(400,220,400,30);
        revs.setVisible(true);
        int height =250;
        for(int i=0;i<user.getRev().size();i++){
            if(namePropLabel.get(property-1).getText().equals("Name: "+user.getProperties().get(i))){
                JLabel temp = new JLabel();
                temp.setText("    By "+user.getUsers().get(i)+": "+user.getRev().get(i)+"(Rate: "+user.getRate().get(i)+"/5)");
                stringRevLabel.add(temp);
            }
        }
        for(int i=0;i<stringRevLabel.size();i++){
            stringRevLabel.get(i).setBounds(400,height,400,30);
            dashboardUser2.add(stringRevLabel.get(i));
            stringRevLabel.get(i).setVisible(true);
            height+=30;
        }


    }
    public void dashboardUserSession(){
        int revNum=0;
        double sumRev=0;
        double avgRev;
        frame.add(dashboardUser1);
        // dashboardUser2.setVisible(false);
        dashboardUser1.setLayout(null);
        viewUserText.setText(null);

        dashboardUser1.add(viewPropUser);
        dashboardUser1.add(viewUserText);
        dashboardUser1.add(viewLabelUser);



        dashboardUser1.setVisible(true);

        for(int i=0;i<provider.getSize2();i++){
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
        }
        for(int i=0;i< provider.getSize2();i++){
            for(int j=0;j<user.getProperties().size();j++){
                if(provider.getProperties().get(i).getName().equals(user.getProperties().get(j)) && user.getUsers().get(j).equals(log.getUsername())){
                    revNum++;
                    sumRev += Double.parseDouble(user.getRate().get(j));
                    JLabel tempRate = new JLabel();
                    JLabel tempName = new JLabel();
                    tempRate.setText("Your rate: "+user.getRate().get(j));
                    tempName.setText(user.getProperties().get(j));
                    rateRevLabel.add(tempRate);
                    namePropRevLabel.add(tempName);
                }
            }
        }
        double avgProp;
        double sumProp;
        int propReviews;
        for(int i=0;i< provider.getSize2();i++){
            propReviews=0;
            sumProp=0;
            for(int j=0;j<user.getProperties().size();j++){
                if(provider.getProperties().get(i).getName().equals(user.getProperties().get(j))){
                    propReviews++;
                    sumProp+= Double.parseDouble(user.getRate().get(j));
                }
            }
            JLabel tempFreq = new JLabel();
            JLabel tempAvgProp = new JLabel();
            tempFreq.setText("Total reviews for this property: "+propReviews);
            freqRevProp.add(tempFreq);
            if(propReviews==0){
                avgProp=0;
            }else
                avgProp = sumProp /(double) propReviews;

            tempAvgProp.setText("Average rate:"+avgProp);
            avg.add(tempAvgProp);
        }




        int width,height,widthN,widthT,widthL,widthD,heightP,temp=1;
        width=0;
        widthN =0;
        widthT =0;
        widthD =0;
        widthL =0;
        height = 0;
        heightP=20;
        for (int i=0;i<provider.getSize2();i++){
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
            for(int j=0;j<rateRevLabel.size();j++){
                if(provider.getProperties().get(i).getName().equals(namePropRevLabel.get(j).getText())){
                    propLabel.get(i).setBounds(width,height,100,20);
                    namePropLabel.get(i).setBounds(widthN,heightP,150,20);
                    heightP+=20;
                    typePropLabel.get(i).setBounds(widthT,heightP,150,20);
                    heightP+=20;
                    locPropLabel.get(i).setBounds(widthL,heightP,150,20);
                    heightP+=20;
                    rateRevLabel.get(j).setBounds(widthD,heightP,150,20);
                    heightP =temp*height+20;
                    width +=200;
                    widthN +=200;
                    widthT +=200;
                    widthL +=200;
                    widthD +=200;
                    dashboardUser1.add(propLabel.get(i));
                    dashboardUser1.add(namePropLabel.get(i));
                    dashboardUser1.add(typePropLabel.get(i));
                    dashboardUser1.add(locPropLabel.get(i));
                    dashboardUser1.add(rateRevLabel.get(j));
                    propLabel.get(i).setVisible(true);
                    namePropLabel.get(i).setVisible(true);
                    typePropLabel.get(i).setVisible(true);
                    locPropLabel.get(i).setVisible(true);
                    rateRevLabel.get(j).setVisible(true);
                }
            }
        }
        avgRev = sumRev/(double) revNum;
        dashboardUser1.add(viewUserText);
        dashboardUser1.add(viewLabelUser);
        dashboardUser1.add(viewPropUser);
        dashboardUser1.add(viewAvgRate);


        viewAvgRate.setText("Average Rate of properties that you wrote a review: "+avgRev);
        viewAvgRate.setBounds(300,730,500,30);
        viewAvgRate.setVisible(true);

        viewLabelUser.setText("Type the number of property to see full details ");
        viewLabelUser.setBounds(50,700,400,30);
        viewUserText.setBounds(400,700,100,30);
        viewPropUser.setText("View Property");
        viewPropUser.setBounds(520,700,200,30);
        viewPropUser.setVisible(true);
        viewUserText.setVisible(true);
        viewLabelUser.setVisible(true);
    }
    public void dashboardProvSession(){

        double avgTotal,avgProp;
        int totalReviews = 0,propReviews;
        double sumProp,sumTotal=0;

        frame.add(dashboardProv1);
        dashboardProv1.setLayout(null);
        viewProvText.setText(null);

        dashboardProv1.add(viewProvText);
        dashboardProv1.add(viewLabelProv);
        dashboardProv1.add(viewPropProv);

        dashboardProv1.setVisible(true);

        for (int i=0;i<provider.getSize2();i++){

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
        }
        for(int i=0;i< provider.getSize2();i++){
            propReviews=0;
            sumProp=0;
            for(int j=0;j<user.getProperties().size();j++){
                if(provider.getProperties().get(i).getName().equals(user.getProperties().get(j))){
                    propReviews++;
                    sumProp+= Double.parseDouble(user.getRate().get(j));
                }
            }
            JLabel tempFreq = new JLabel();
            JLabel tempAvgProp = new JLabel();
            tempFreq.setText("Total reviews for this property: "+propReviews);
            freqRevProp.add(tempFreq);
            if(propReviews==0){
                avgProp=0;
            }else
                avgProp = sumProp /(double) propReviews;

            tempAvgProp.setText("Average rate:"+avgProp);
            avg.add(tempAvgProp);
        }

        for(int i=0;i< provider.getSize2();i++) {
            for (int j = 0; j < user.getProperties().size(); j++) {
                if (provider.getProperties().get(i).getName().equals(user.getProperties().get(j)) && log.getUsername().equals(provider.getNames().get(i))) {
                    totalReviews++;
                    sumTotal += Double.parseDouble(user.getRate().get(j));
                }
            }
        }

        JLabel totalPropRevs = new JLabel();
        JLabel totalAvg = new JLabel();
        dashboardProv1.add(totalPropRevs);
        totalPropRevs.setText("Total Reviews for "+log.getUsername()+": "+totalReviews);
        totalPropRevs.setBounds(50,730,400,30);
        totalPropRevs.setVisible(true);
        if(totalReviews==0)
            avgTotal=0;
        else
            avgTotal = sumTotal /(double) totalReviews;
        dashboardProv1.add(totalAvg);
        totalAvg.setText("Average rate of all properties: "+avgTotal);
        totalAvg.setBounds(450,730,400,30);
        totalAvg.setVisible(true);

        int width,height,widthN,widthT,widthL,widthD,heightP,temp=1;
        width=0;
        widthN =0;
        widthT =0;
        widthD =0;
        widthL =0;
        height = 0;
        heightP=20;

        for(int i=0;i< provider.getSize2();i++){

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
                avg.get(i).setBounds(widthD,heightP,150,20);
                heightP =temp*height+20;
                width +=200;
                widthN +=200;
                widthT +=200;
                widthL +=200;
                widthD +=200;
                dashboardProv1.add(propLabel.get(i));
                dashboardProv1.add(namePropLabel.get(i));
                dashboardProv1.add(typePropLabel.get(i));
                dashboardProv1.add(locPropLabel.get(i));
                dashboardProv1.add(avg.get(i));
                propLabel.get(i).setVisible(true);
                namePropLabel.get(i).setVisible(true);
                typePropLabel.get(i).setVisible(true);
                locPropLabel.get(i).setVisible(true);
                avg.get(i).setVisible(true);


            }

            dashboardProv1.add(viewProvText);
            dashboardProv1.add(viewLabelProv);
            dashboardProv1.add(viewPropProv);

            viewLabelProv.setText("Type the number of property to see full details ");
            viewLabelProv.setBounds(50,700,400,30);
            viewProvText.setBounds(400,700,100,30);
            viewPropProv.setText("View Property");
            viewPropProv.setBounds(520,700,200,30);
            viewPropProv.setVisible(true);
            viewProvText.setVisible(true);
            viewLabelProv.setVisible(true);

        }
    }

        public void viewPropertyProv(int property){


        frame.add(dashboardProv2);

        dashboardProv2.setLayout(null);
        dashboardProv2.add(menuProv);
        menuProv.setText("Back to Menu");
        menuProv.setBounds(400,700,150,30);
        menuProv.setVisible(true);

        dashboardProv2.setVisible(true);

        dashboardProv2.add(namePropLabel.get(property-1));
        dashboardProv2.add(typePropLabel.get(property-1));
        dashboardProv2.add(locPropLabel.get(property-1));
        dashboardProv2.add(descrPropLabel.get(property-1));
        dashboardProv2.add(propLabel.get(property-1));
        dashboardProv2.add(avg.get(property-1));
        dashboardProv2.add(freqRevProp.get(property-1));

        propLabel.get(property-1).setBounds(400,10,400,30);
        namePropLabel.get(property-1).setBounds(400,40,400,30);
        typePropLabel.get(property-1).setBounds(400,70,400,30);
        locPropLabel.get(property-1).setBounds(400,100,400,30);
        descrPropLabel.get(property-1).setBounds(400,130,400,30);
        avg.get(property-1).setBounds(400,160,400,30);
        freqRevProp.get(property-1).setBounds(400,190,400,30);

        propLabel.get(property-1).setVisible(true);
        namePropLabel.get(property-1).setVisible(true);
        typePropLabel.get(property-1).setVisible(true);
        locPropLabel.get(property-1).setVisible(true);
        descrPropLabel.get(property-1).setVisible(true);
        avg.get(property-1).setVisible(true);
        freqRevProp.get(property-1).setVisible(true);
        JLabel revs = new JLabel();
        dashboardProv2.add(revs);
        revs.setText("Reviews for this property");
        revs.setBounds(400,220,400,30);
        revs.setVisible(true);
        int height =250;

        for(int i=0;i<user.getRev().size();i++){
            if(namePropLabel.get(property-1).getText().equals("Name: "+user.getProperties().get(i))){
                JLabel temp = new JLabel();
                temp.setText("    By "+user.getUsers().get(i)+": "+user.getRev().get(i)+"(Rate: "+user.getRate().get(i)+"/5)");
                stringRevLabel.add(temp);
            }
        }
        for(int i=0;i<stringRevLabel.size();i++){
            stringRevLabel.get(i).setBounds(400,height,400,30);
            dashboardProv2.add(stringRevLabel.get(i));
            stringRevLabel.get(i).setVisible(true);
            height+=30;
        }

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
        while(input.hasNextLine()){
            nameProp = input.next();
            typeProp = input.next();
            locProp = input.next();
            input.skip("-");
            descrProp = input.nextLine();
            whoProp = input.nextLine();
            provider.addProperties(nameProp,typeProp,locProp,descrProp,whoProp);
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
        loginPanel.setBackground(Color.BLACK);
        loginPanel.add(userLabel);
        loginPanel.add(passLabel);
        loginPanel.add(userText);
        loginPanel.add(passText);
        loginPanel.add(signInButton);

        userLabel.setText("Username");
        userLabel.setBounds(220, 200, 100, 40);
        userLabel.setForeground(Color.magenta);

        passLabel.setText("Password");
        passLabel.setBounds(220, 250, 100, 40);
        passLabel.setForeground(Color.magenta);

        userText.setText(null);
        userText.setBounds(340, 210, 100, 20);
        userText.setBackground(Color.magenta);
        passText.setText(null);
        passText.setBounds(340, 260, 100, 20);
        passText.setBackground(Color.magenta);

        loginPanel.setVisible(true);


        userLabel.setVisible(true);
        passLabel.setVisible(true);

        userText.setVisible(true);
        passText.setVisible(true);
        signInButton.setVisible(true);


    }

    public void registerSession(){
        frame.add(regPanel);
        regPanel.setBackground(Color.BLACK);
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
        regPanel.setVisible(true);

        fnameLabel.setText("First Name");
        fnameLabel.setBounds(350, 210, 100, 20);
        fnameLabel.setForeground(Color.magenta);
        fnameText.setText(null);
        fnameText.setBounds(450, 210, 100, 20);
        fnameText.setBackground(Color.magenta);

        lnameLabel.setText("Last Name");
        lnameLabel.setBounds(350, 250, 100, 20);
        lnameLabel.setForeground(Color.magenta);
        lnameText.setText(null);
        lnameText.setBounds(450, 250, 100, 20);
        lnameText.setBackground(Color.magenta);

        uLabel.setText("Username");
        uLabel.setBounds(350, 300, 100, 20);
        uLabel.setForeground(Color.magenta);
        uText.setText(null);
        uText.setBounds(450, 300, 100, 20);
        uText.setBackground(Color.magenta);

        pLabel.setText("Password");
        pLabel.setBounds(350, 350, 100, 20);
        pLabel.setForeground(Color.magenta);
        pText.setText(null);
        pText.setBounds(450, 350, 100, 20);
        pText.setBackground(Color.magenta);

        typeLabel.setText("Provider or User?");
        typeLabel.setBounds(320, 400, 120, 20);
        typeLabel.setForeground(Color.magenta);
        typeText.setText(null);
        typeText.setBounds(450, 400, 100, 20);
        typeText.setBackground(Color.magenta);

        failedReg1.setText("There is already a user with this name.");
        failedReg1.setBounds(360,580,400,20);
        failedReg1.setForeground(Color.red);

        failedReg2.setText("Invalid User Type. Type 'provider' or 'user'");
        failedReg2.setBounds(350,600,400,20);
        failedReg2.setForeground(Color.red);

        create.setBounds(400, 450, 150, 30);
        create.setBackground(Color.magenta);





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
            successPanelUser.add(logout);
            logout.setVisible(true);

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
            successPanelProv.add(logout);
            logout.setVisible(true);

            addProvPanel.setLayout(null);

            changePanel.setLayout(null);
            addProvPanel.setVisible(false);
            editPanel.setVisible(false);

            successLabelProv.setBounds(400, 50, 400, 100);
            successLabelProv.setVisible(true);
            successLabelProv.setText("Hi " + log.getUsername() + ". " + "You are " + type);
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

        }
    }


    public void deleteReviewSession(){
        frame.add(deleteUserPanel);
        deleteUserPanel.setLayout(null);

        deleteRevText.setText(null);

        deleteUserPanel.add(deleteRevButton);
        deleteUserPanel.add(deleteRevLabel);
        deleteUserPanel.add(deleteRevText);
        deleteUserPanel.add(revsLabel);

        revsLabel.setText("Your reviews are down below.");
        revsLabel.setBounds(400,20,250,30);

        for(int i=0;i<user.getUsers().size();i++){
            JLabel tempRev = new JLabel();
            JLabel tempRate = new JLabel();
            JLabel tempUser = new JLabel();
            JLabel tempPropName = new JLabel();


            tempRev.setText(user.getRev().get(i));
            stringRevLabel.add(tempRev);
            tempPropName.setText(user.getProperties().get(i));
            namePropRevLabel.add(tempPropName);
            tempUser.setText(user.getUsers().get(i));
            userRevLabel.add(tempUser);
            tempRate.setText(user.getRate().get(i));
            rateRevLabel.add(tempRate);

        }
        for(int i=0;i<user.getUsers().size();i++){

            for(int j=0;j<provider.getProperties().size();j++){

                if(provider.getProperties().get(j).getName().equals(user.getProperties().get(i))){
                    JLabel tempProp = new JLabel();

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
            if(log.getUsername().equals(userRevLabel.get(i).getText())){
                reviewLabel.get(i).setBounds(width,height,1000,30);
                height+=40;
                deleteUserPanel.add(reviewLabel.get(i));
                reviewLabel.get(i).setVisible(true);
            }
        }


        deleteRevLabel.setText("For which property you want to delete your review?");
        deleteRevLabel.setBounds(50,700,400,30);
        deleteRevText.setBounds(400,700,100,30);
        deleteRevButton.setText("Delete Review");
        deleteRevButton.setBounds(520,700,120,30);

        deleteRevButton.setVisible(true);
        deleteRevLabel.setVisible(true);
        deleteRevText.setVisible(true);

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
            System.out.println(temp.getText());
            reviewLabel.add(temp);
        }
        int width=0, height=50;
        for(int i=0;i<stringRevLabel.size();i++) {
            //System.out.println(reviewLabel.get(i).getText());
            if(log.getUsername().equals(userRevLabel.get(i).getText())){
                // System.out.println(reviewLabel.get(i).getText());
                reviewLabel.get(i).setBounds(width,height,1000,30);
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






        int width,height,widthN,widthT,widthL,widthD,heightP,temp=1;
        width=0;
        widthN =0;
        widthT =0;
        widthD =0;
        widthL =0;
        height = 0;
        heightP=20;
        for(int i=0;i<provider.getSize2();i++){
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
                editPanel.add(propLabel.get(i));
                editPanel.add(namePropLabel.get(i));
                editPanel.add(typePropLabel.get(i));
                editPanel.add(locPropLabel.get(i));
                editPanel.add(descrPropLabel.get(i));
                propLabel.get(i).setVisible(true);
                namePropLabel.get(i).setVisible(true);
                typePropLabel.get(i).setVisible(true);
                locPropLabel.get(i).setVisible(true);
                descrPropLabel.get(i).setVisible(true);


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
        addProvPanel.add(failedAdd);

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

        failedAdd.setText("There is a already a property with this name. Try another one.");
        failedAdd.setBounds(280,600,350,30);
        failedAdd.setForeground(Color.red);
        failedAdd.setVisible(false);

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

