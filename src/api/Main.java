package api;

import java.io.*;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws IOException {
        File file = null;
        Provider prov = new Provider();

        //ΚΑΤΑΧΩΡΗΣΗ ΚΑΤΑΛΥΜΑΤΩΝ

        file = new File("src/api/Properties");
        Scanner input = new Scanner(file);
        input.useDelimiter("-");
        String uname,type,loc,descr,who;
        int count=1;
        while(input.hasNext()){
            uname = input.next();
            type = input.next();
            loc = input.next();
            descr = input.nextLine();
            who = input.nextLine();
            prov.addProperties(count,uname,type,loc,descr,who);
            count++;
        }




        LogIn log=null;

        System.out.println("Hello, Welcome to our AirBnb App:");
        System.out.println("If you already have an account please, press L to log in,else press R to register");

        Scanner sc = new Scanner(System.in);
        String answer;
        answer=sc.next();
        boolean is;
        String name,pass;
        String isUser ;
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
                    System.out.println("Try again");
                }
            } while (!is);
            isUser = log.whatUser(name, pass, "user");
            if (isUser.equals("user")) {
                System.out.println("You are user");
            } else if (isUser.equals("provider"))
                System.out.println("You are provider");


            if(isUser.equals("provider")) {
                System.out.println("Menu:");
                System.out.println("Press 1 for adding a new property.");
                System.out.println("Press 2 for editing your properties.");
                System.out.println("Press 3 for deleting the property you want.");
                System.out.println("Press 4 for showing your properties.");
                answer = sc.next();
                if (answer.equals("4")) {
                    // prov.showMyProps(log.getUsername());
                }
                if (answer.equals("1")) {
                    prov.newProp(count, new File("src/api/Properties"), log.getUsername());
                }
                prov.showMyProps(log.getUsername());
            }

        }
        //prov.printProps();


    }
}
