package api;

import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class User {

    Scanner scanner;

    private ArrayList<String> rev;
    private ArrayList<String> users;
    private ArrayList<String> properties;

    Provider provider;
    Reviews review;

    public User(){
        rev = new ArrayList<>();
        users = new ArrayList<>();
        properties = new ArrayList<>();
        scanner = new Scanner(System.in);
        provider = new Provider();
    }

    public void addReviews(String r,String p, String u){
        review = new Reviews(r);
        rev.add(r);
        properties.add(p);
        users.add(u);
    }

    public String menuUser(){
        System.out.println("Menu:");
        System.out.println("Press 1 for searching a property.");
        System.out.println("Press 2 for adding a new review for a property of your choice.");
        System.out.println("Press 3 for editing a review.");
        System.out.println("Press 4 for deleting a review.");
        System.out.println("Type LOGOUT, to logout from your account.");
        String answer = scanner.next();
        return answer;
    }

    public void newReview(String p,String name) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tell us about your experience : ");
        String review = sc.nextLine();
        BufferedWriter out = new BufferedWriter((new FileWriter("src/api/UserReviews",true)));
        out.newLine();
        out.write(review);
        out.newLine();
        out.write(p);
        out.newLine();
        out.write(name);
        out.close();
        addReviews(review,p,name);
    }

    public void showMyReviews(String name){
        System.out.println("Your reviews are down below.");
        System.out.println("--------------------");
        for(int i=0;i<rev.size();i++){
            if(users.get(i).equals(name)){
                System.out.println("Review for property "+properties.get(i)+": "+rev.get(i));
                System.out.println();
            }

        }

    }

    public void editReviews(String p, File f,String name){
        Scanner sc = new Scanner(System.in);
        System.out.print("Change your review to: ");
        String newRev = sc.nextLine();
        review = new Reviews(newRev);
        for (int i=0;i<rev.size();i++){
            if(properties.get(i).equals(p) && users.get(i).equals(name)){
                rev.set(i,newRev);
            }
        }
    }

    public void reNewFile(File f) throws IOException {
        //int i=0;
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        for(int i =0;i< rev.size();i++){
            writer.write(rev.get(i));
            writer.newLine();
            writer.write(properties.get(i));
            writer.newLine();
            writer.write(users.get(i));
            writer.newLine();
        }
        writer.close();


    }

    public void deleteRev(String p,File f,String n){
        for (int i=0;i< rev.size();i++){
            if(properties.get(i).equals(p) && users.get(i).equals(n)){
                rev.remove(i);
                properties.remove(i);
                users.remove(i);
            }

        }
    }




    public void printRevs(){
        for (int i=0;i< rev.size();i++){
            System.out.println();
            System.out.println("Review for property "+properties.get(i)+": "+rev.get(i));
            System.out.println("By - "+users.get(i));
            System.out.println("__________________");
        }
    }




}

