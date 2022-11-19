package api;

import java.io.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws IOException {
        System.out.println("Hello, Welcome to our AirBnb App:");

        File fileP = new File("src/api/Properties");
        File fileR = new File("src/api/UserReviews");
        Scanner input;
        Provider prov = new Provider();
        User user = new User();
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
        String uname,type,loc,descr,who;
        int count=1;
        while(input.hasNextLine()){
            uname = input.next();
            type = input.next();
            loc = input.next();
            input.skip("-");
            descr = input.nextLine();
            who = input.nextLine();
            prov.addProperties(count,uname,type,loc,descr,who);
            //prov.printProps();
            count++;
        }
        boolean found = true;
        while(found) {
            System.out.println("If you already have an account please, press L to log in,else press R to register or EXIT to exit the application");
            //LOGIN ΔΙΑΔΙΚΑΣΙΑ
            Register reg = null;

            Scanner sc = new Scanner(System.in);
            String answer;
            answer = sc.next();
            boolean is;
            String name, pass, typeU, firstN, lastN;
            String isUser;

            if(answer.toUpperCase().equals("EXIT"))
                break;

            do {
                boolean flag = false;
                if (answer.equals("R")) {
                    do {
                        System.out.println("Create your account:");
                        System.out.print("Enter your First Name: ");
                        firstN = sc.next();
                        System.out.print("Enter your Last Name: ");
                        lastN = sc.next();
                        System.out.print("Enter your username Name: ");
                        name = sc.next();
                        System.out.print("Enter your password Name: ");
                        pass = sc.next();
                        System.out.print("Are you just a User or Provider? : ");
                        typeU = sc.next();
                        reg = new Register(firstN, lastN, name, pass, typeU);
                        boolean ver = reg.verifyAcc(name);
                        if (ver) {
                            flag = true;
                            reg.newAcc(name, pass, typeU);
                            System.out.println("Perfect! Your account has been created.");
                            System.out.println("If you want to exit the application type EXIT, else press L to log in or R to create a new account");
                            answer = sc.next();
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
                    name = sc.next();
                    System.out.print("Password: ");
                    pass = sc.next();
                    log = new LogIn(name, pass);
                    log.addCredits();

                    is = log.accCheck(name, pass);
                    if (is) {
                        System.out.println("Hi " + log.getUsername());
                    } else {
                        System.out.println("Username and password dont match.Please try again!");
                    }
                } while (!is);
                isUser = log.whatUser(name, pass, "user");
                if (isUser.equals("user")) {
                    System.out.println("You are user");
                } else if (isUser.equals("provider"))
                    System.out.println("You are provider");

                String ans;
                boolean has;
                if (isUser.equals("provider")) {
                    //String ans;
                    do {
                        ans = prov.menuProvider();


                        if (ans.equals("1")) {
                            prov.newProp(count, new File("src/api/Properties"), log.getUsername());
                            prov.reNewFile(fileP);
                            count++;
                        }
                        if (ans.equals("2")) {
                            has = prov.hasProps(log.getUsername());
                            if (has){
                                prov.showMyProps(log.getUsername());
                                System.out.println("Type the number of property above to edit.");
                                int p = sc.nextInt();
                                prov.editProps(p, fileP);
                                prov.reNewFile(fileP);
                                //prov.showMyProps(log.getUsername());

                            }
                            else
                                System.out.println("No properties to edit.");
                        }
                        if (ans.equals("3")) {
                             has = prov.hasProps(log.getUsername());
                            if(has){
                                prov.showMyProps(log.getUsername());
                                System.out.println(" Type the number of property above to delete");
                                int p = sc.nextInt();
                                prov.deleteProp(p, fileP);
                                user.deletePropRev(p);
                                prov.reNewFile(fileP);
                                user.reNewFile(fileR);

                            }
                            else
                                System.out.println("Nothing to show. No properties yet.");
                        }
                        if (ans.equals("4")) {
                            has = prov.hasProps(log.getUsername());
                            if(has)
                                prov.dashBoardProvider(log.getUsername(),user.getProperties(),user.getRate());
                            else
                                System.out.println("Nothing to show. No properties yet.");
                        }
                    } while (!ans.toUpperCase().equals("LOGOUT"));
                    System.out.println("Thank you for using our app. See you again " + log.getUsername());

                }
                if(isUser.equals("user")){
                    do{
                        ans= user.menuUser();
                        if(ans.equals("1")){
                            prov.searchProps();
                        }
                        if(ans.equals("2")){
                            prov.printProps();
                            System.out.println("For which property you want to add a review?");
                            String a = sc.next();
                            has = user.hasRevs(a,log.getUsername());
                            if (has){
                                System.out.println("You already have a review for this property.Delete it or edit from the Menu below.");
                            }else
                            {
                                user.newReview(a,log.getUsername());
                                user.reNewFile(fileR);
                            }

                        }
                        if(ans.equals("3")){
                            user.showMyReviews(log.getUsername());
                            System.out.println("For which property you want to edit your review?");
                            String prop = sc.next();
                            has = user.hasRevs(prop,log.getUsername());
                            if(has){
                                user.editReviews(prop,log.getUsername());
                                user.reNewFile(fileR);
                            }else {
                                System.out.println("You don't have a review for this property, so you cant edit.");
                            }

                            //user.printRevs();
                        }
                        if(ans.equals("4")){
                            System.out.println(" For which property you want to delete your review?");
                            user.showMyReviews(log.getUsername());
                            String prop = sc.next();
                            has = user.hasRevs(prop, log.getUsername());
                            if(has){
                                user.deleteRev(prop,log.getUsername());
                                user.reNewFile(fileR);
                            }else {
                                System.out.println("You don't have a review for this property, so you cant delete.");
                            }
                        }

                        if (ans.equals("5")){
                            user.dashboardUser(log.getUsername(),prov.getProps());
                        }
                    }while(!ans.toUpperCase().equals("LOGOUT"));

                }
            }


        }

    }
}