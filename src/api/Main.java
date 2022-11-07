package api;

import java.io.*;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {
        File file = null;

        Provider prov = new Provider();

        System.out.println("Hello, Welcome to our AirBnb App:");
        System.out.println("Select which provider u want:");
        System.out.println("Provider1 or Provider2");
        Scanner sc = new Scanner(System.in);
        String answer=sc.next();
        if (answer.equals("1")){
             file = new File("C:\\Users\\keten\\OneDrive\\Υπολογιστής\\Provider1.txt");
        }
        else
            file = new File("C:\\Users\\keten\\OneDrive\\Υπολογιστής\\Provider2.txt");

        //File file = new File("C:\\Users\\keten\\OneDrive\\Υπολογιστής\\Provider1.txt");
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
