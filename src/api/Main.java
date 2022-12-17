package api;

import gui.*;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String [] args) throws IOException {


        System.out.println("Hello, Welcome to our AirBnb App:");

        File fileP = new File("src/api/Properties");
        File fileR = new File("src/api/UserReviews");
        Scanner input,fromKeyboard;
        Provider prov = new Provider();
        User user = new User();
        Display display = new Display();
        LogIn log =null;

        //ΚΑΤΑΧΩΡΗΣΗ ΚΑΤΑΛΥΜΑΤΩΝ ΚΑΙ ΑΞΙΟΛΟΓΗΣΕΩΝ

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
        int countProp=1;
        while(input.hasNextLine()){
            nameProp = input.next();
            typeProp = input.next();
            locProp = input.next();
            input.skip("-");
            descrProp = input.nextLine();
            whoProp = input.nextLine();
            prov.addProperties(countProp,nameProp,typeProp,locProp,descrProp,whoProp);
            countProp++;
        }
        boolean found = true;
        fromKeyboard = new Scanner(System.in);

        GUI gui = new GUI();
        gui.Initialize();
        gui.Intro();

        //ΔΙΑΔΙΚΑΣΙΑ ΣΥΝΔΕΣΗΣ/ΕΓΓΡΑΦΗΣ
        while(found) {
            System.out.println("If you already have an account please, press L to log in,else press R to register or EXIT to exit the application");

            Register reg = null;


            String answer;
            answer = fromKeyboard.next();
            boolean isUser;
            String userName, userPass, userType, firstName, lastName;
            String whatUser;

            if(answer.toUpperCase().equals("EXIT"))
                break;

            do {
                boolean flag = false;
                if (answer.equals("R")) {
                    do {
                        System.out.println("Create your account:");
                        System.out.print("Enter your First Name: ");
                        firstName = fromKeyboard.next();
                        System.out.print("Enter your Last Name: ");
                        lastName = fromKeyboard.next();
                        System.out.print("Enter your username: ");
                        userName = fromKeyboard.next();
                        System.out.print("Enter your password: ");
                        userPass = fromKeyboard.next();
                        do{
                            System.out.print("Are you just a User or Provider? : ");
                            userType = fromKeyboard.next();
                            if(!userType.equals("user") && !userType.equals("provider"))
                                System.out.println("This is not a valid type of user. You can only be user or provider.");
                        }while(!userType.equals("user") && !userType.equals("provider"));


                        reg = new Register(firstName, lastName, userName, userPass, userType);
                        boolean ver = reg.verifyAcc(userName);
                        if (ver) {
                            flag = true;
                            reg.newAcc(userName, userPass, userType);
                            System.out.println("Perfect! Your account has been created.");
                            System.out.println("If you want to exit the application type EXIT, else press L to log in or R to create a new account");
                            answer = fromKeyboard.next();
                            if(answer.toUpperCase().equals("EXIT")) {
                                System.out.println("Thank you for using our application. See you soon " + reg.getUsername());
                                System.exit(0);
                            }
                        } else {
                            System.out.println("There is already an account with that username. Please try again");
                        }
                    } while (!flag);
                }


            } while (answer.equals("R"));

            if (answer.equals("L")) {
                do {
                    System.out.print("Username: ");
                    userName = fromKeyboard.next();
                    System.out.print("Password: ");
                    userPass = fromKeyboard.next();

                    log = new LogIn(userName, userPass);
                    log.addCredits();

                    isUser = log.accCheck(userName, userPass);
                    if (isUser) {
                        System.out.println("Hi " + log.getUsername());
                    } else {
                        System.out.println("Username and password don't match.Please try again!");
                    }
                } while (!isUser);
                whatUser = log.whatUser(userName, userPass, "user");
                if (whatUser.equals("user")) {
                    System.out.println("You are user");
                } else if (whatUser.equals("provider"))
                    System.out.println("You are provider");

                String choice,propName,newPropName;
                int key;
                boolean has;

                //Οταν ο χρήστης είναι provider

                if (whatUser.equals("provider")) {
                    do {
                        choice = prov.menuProvider();


                        if (choice.equals("1")) {
                            prov.newProp2(countProp, log.getUsername());
                            prov.reNewFile2(fileP);
                            countProp++;
                        }
                        if (choice.equals("2")) {
                            has = prov.hasProps(log.getUsername());
                            if (has){
                                prov.showMyProps2(log.getUsername());
                                System.out.println("Type the number of property above to edit.");
                                key = fromKeyboard.nextInt();
                                propName = prov.getPropName2(key);
                                System.out.println(propName);
                                prov.editProps2(key);
                                newPropName = prov.getPropName2(key);
                                System.out.println(newPropName);
                                user.editRevName(propName,newPropName);
                                prov.reNewFile2(fileP);
                                user.reNewFile(fileR);

                            }
                            else
                                System.out.println("No properties to edit.");
                        }
                        if (choice.equals("3")) {
                            has = prov.hasProps(log.getUsername());
                            if(has){
                                prov.showMyProps2(log.getUsername());
                                System.out.println(" Type the number of property above to delete");
                                key = fromKeyboard.nextInt();
                                propName = prov.getPropName2(key);
                                prov.deleteProp(key);
                                user.deletePropRev(propName);

                                prov.reNewFile2(fileP);
                                user.reNewFile(fileR);
                               /* input = new Scanner(fileP);
                                input.useDelimiter("-");
                                String name,type,loc,descr,who;
                                int count=1;
                                while(input.hasNextLine()){
                                    name = input.next();
                                    type = input.next();
                                    loc = input.next();
                                    input.skip("-");
                                    descr = input.nextLine();
                                    who = input.nextLine();
                                    prov.addProperties(count,name,type,loc,descr,who);
                                    count++;
                                }*/




                            }
                            else
                                System.out.println("No properties to delete.");
                        }
                        if (choice.equals("4")) {
                            has = prov.hasProps(log.getUsername());
                            if(has){
                                display.dashboardProvider(prov.getProperties(),log.getUsername(),user.getProperties(),user.getRate(),prov.getProps(),prov.getNames());
                                System.out.println("Type the number of property above to see all information, else press 0 to move to the menu.");

                                key = fromKeyboard.nextInt();
                                if (key != 0) {
                                    propName = prov.getPropName2(key);
                                    display.displayProperty(prov.getProperties(),propName,prov.getProps(),user.getRate(),user.getUsers(),user.getRev(),user.getProperties());
                                }

                            }
                            else
                                System.out.println("Nothing to show. No properties yet.");
                        }
                    } while (!choice.toUpperCase().equals("LOGOUT"));
                    System.out.println("Thank you for using our app. See you again " + log.getUsername());

                }

                //Οταν ο χρήστης είναι user

                if(whatUser.equals("user")){
                    do{
                        choice= user.menuUser();
                        if(choice.equals("1")){
                            prov.searchProps();
                        }
                        if(choice.equals("2")){
                            prov.printProps2();
                            System.out.println("For which property you want to add a review?");
                            key = fromKeyboard.nextInt();
                            propName = prov.getPropName2(key);
                            has = user.hasRevs(propName,log.getUsername());
                            if (has){
                                System.out.println("You already have a review for this property.Delete it or edit from the Menu below.");
                            }else
                            {
                                user.newReview(propName,log.getUsername());
                                user.reNewFile(fileR);
                            }

                        }
                        if(choice.equals("3")){
                            display.showReviews(prov.getProperties(),log.getUsername(),prov.getProps(),user.getProperties(),user.getUsers(),user.getRate(),user.getRev());
                            System.out.println("For which property you want to edit your review?");
                            key = fromKeyboard.nextInt();
                            propName = prov.getPropName2(key);
                            has = user.hasRevs(propName,log.getUsername());
                            if(has){
                                user.editReviews(propName,log.getUsername());
                                user.reNewFile(fileR);
                            }else {
                                System.out.println("You don't have a review for this property, so you cant edit.");
                            }

                        }
                        if(choice.equals("4")){
                            System.out.println(" For which property you want to delete your review?");
                            display.showReviews(prov.getProperties(),log.getUsername(),prov.getProps(),user.getProperties(),user.getUsers(),user.getRate(),user.getRev());
                            key = fromKeyboard.nextInt();

                            propName = prov.getPropName2(key);
                            has = user.hasRevs(propName, log.getUsername());

                            if(has){
                                user.deleteRev(propName,log.getUsername());
                                user.reNewFile(fileR);
                            }else {
                                System.out.println("You don't have a review for this property, so you cant delete.");
                            }
                        }

                        if (choice.equals("5")){
                            display.dashboardUser(prov.getProperties(),log.getUsername(),prov.getProps(),user.getRate(),user.getUsers(),user.getProperties());
                            System.out.println("Type the number of property above to see all information, else press 0 to move to the menu.");
                            key = fromKeyboard.nextInt();
                            if (key != 0) {
                                propName = prov.getPropName2(key);
                                display.displayProperty(prov.getProperties(),propName,prov.getProps(),user.getRate(),user.getUsers(),user.getRev(),user.getProperties());
                            }
                        }
                    }while(!choice.toUpperCase().equals("LOGOUT"));
                    System.out.println("Thank you for using our app. See you again " + log.getUsername());

                }
            }


        }

    }
}