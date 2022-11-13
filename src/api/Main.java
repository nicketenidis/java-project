package api;

import java.io.*;


import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws IOException {
        System.out.println("Hello, Welcome to our AirBnb App:");

        File file = new File("src/api/Properties");
        File fileCred = null;
        Provider prov = new Provider();
        LogIn log =null;

        //ΚΑΤΑΧΩΡΗΣΗ ΚΑΤΑΛΥΜΑΤΩΝ


        Scanner input = new Scanner(file);
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


        System.out.println("If you already have an account please, press L to log in,else press R to register");
        //LOGIN ΔΙΑΔΙΚΑΣΙΑ
        Register reg = null;

        Scanner sc = new Scanner(System.in);
        String answer;
        answer=sc.next();
        boolean is;
        String name,pass,typeU,firstN,lastN;
        String isUser ;

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

                        } else {
                            System.out.println("There is already an account with that username. Please try again");
                        }
                    }while(!flag);
                }


        }while(answer.equals("R"));

        if(answer.equals("L")) {
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


            if(isUser.equals("provider")) {
                int ans = prov.menuProvider();
                if (ans==4) {
                    prov.showMyProps(log.getUsername());
                }
                if (ans == 1) {
                    prov.newProp(count, new File("src/api/Properties"), log.getUsername());
                }
                if(ans == 2){
                    prov.showMyProps(log.getUsername());
                    System.out.println("Type the number of property above to edit.");
                    int p = sc.nextInt();
                    prov.editProps(p,file);
                    prov.reNewFile(file);
                    prov.showMyProps(log.getUsername());
                }
                if (ans == 3){
                    prov.showMyProps(log.getUsername());
                    System.out.println(" Type the number of property above to delete");
                    int p = sc.nextInt();
                    prov.deleteProp(p,file);
                    prov.showMyProps(log.getUsername());
                }

            }
        }




    }
}