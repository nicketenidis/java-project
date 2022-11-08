package api;

import java.io.*;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {
        File file = null;
        Provider prov = new Provider();
        LogIn log;

        System.out.println("Hello, Welcome to our AirBnb App:");
        System.out.println("If you already have an account please, press L to log in,else press R to register");

        Scanner sc = new Scanner(System.in);
        String answer=sc.next();
        boolean is;
        if(answer.equals("L")) {
            do{
                System.out.print("Username: ");
                String name = sc.next();
                System.out.print("Password: ");
                String pass = sc.next();
                log = new LogIn(name, pass);
                log.addCredits();

                is = log.isUser(name,pass);
                if(is) {
                    System.out.println("Hi " + log.getUsername());
                }else{
                    System.out.println("Try again");
                }
            }while(!is);

        }



        if (answer.equals("1")){
             file = new File("src/api/Provider1");
        }
        else
            file = new File("C:\\Users\\keten\\OneDrive\\Υπολογιστής\\Provider2.txt");


        Scanner input = new Scanner(file);
        input.useDelimiter("-");
        String name,type,loc,descr;
        int count=1;
        while(input.hasNext()){
             name = input.next();
             type = input.next();
             loc = input.next();
             descr = input.nextLine();
            prov.addProperties(count,name,type,loc,descr);
            count++;
        }
        prov.printProps();


    }
}
