package api;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class User {

    private ArrayList<String> rate;

    private ArrayList<String> rev;
    private ArrayList<String> users;
    private ArrayList<String> properties;

    Provider provider;
    Reviews review;

    public User()  {
        rev = new ArrayList<>();
        users = new ArrayList<>();
        properties = new ArrayList<>();
        rate = new ArrayList<>();
        provider = new Provider();
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public ArrayList<String> getRate() {
        return rate;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public ArrayList<String> getRev() {
        return rev;
    }

    public void addReviews(String userReview,String prop, String user,String userRate){
        review = new Reviews(userReview);
        rev.add(userReview);
        properties.add(prop);
        users.add(user);
        rate.add(userRate);
    }

    public String menuUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("Press 1 for searching a property.");
        System.out.println("Press 2 for adding a new review for a property of your choice.");
        System.out.println("Press 3 for editing a review.");
        System.out.println("Press 4 for deleting a review.");
        System.out.println("Press 5 for showing your Dashboard.");
        System.out.println("Type LOGOUT, to logout from your account.");
        String answer = sc.next();
        return answer;
    }

    public void newReview(String property,String user) throws IOException {
        String review,rate;
        Scanner sc = new Scanner(System.in);
        System.out.println("Tell us about your experience : ");
        review = sc.nextLine();
        do{
            System.out.print("Rate the property(up to 5 points) : ");
            rate = sc.nextLine();
            if(Double.parseDouble(rate)>5){
                System.out.println("This is not a valid rate. Your rate has to be up to 5 points or lower.");
            }
        }while(Double.parseDouble(rate)>5);

        BufferedWriter out = new BufferedWriter((new FileWriter("src/api/UserReviews",true)));
        out.newLine();
        out.write(review);
        out.newLine();
        out.write(property);
        out.newLine();
        out.write(user);
        out.newLine();
        out.write(rate);
        out.close();
        addReviews(review,property,user,rate);
    }


    public void editReviews(String property,String user){
        String newReview,newRate;
        Scanner sc = new Scanner(System.in);
        System.out.print("Change your review to: ");
        newReview = sc.nextLine();
        do{
            System.out.print("Change your rate to (up to 5 points): ");
            newRate = sc.nextLine();
            if(Double.parseDouble(newRate)>5){
                System.out.println("This is not a valid rate. Your rate has to be up to 5 points or lower.");
            }
        }while(Double.parseDouble(newRate)>5);

        review = new Reviews(newReview);
        for (int i=0;i<rev.size();i++){
            if(properties.get(i).equals(property) && users.get(i).equals(user)){
                rev.set(i,newReview);
                rate.set(i,newRate);
            }
        }
    }

    public void editRevName(String name1,String name2){
        for(int i =0;i<properties.size();i++){
            if(properties.get(i).equals(name1)){
                properties.set(i,name2);
            }
        }

    }

    public void deleteRev(String property,String user){
        for (int i=0;i< rev.size();i++){
            if(properties.get(i).equals(property) && users.get(i).equals(user)){
                rev.remove(i);
                properties.remove(i);
                users.remove(i);
                rate.remove(i);
            }

        }
    }

    public void deletePropRev(String property){

        for(int i=0;i<rev.size();i++){
            if(properties.get(i).equals(property)){
                rev.remove(i);
                properties.remove(i);
                users.remove(i);
                rate.remove(i);
            }
        }
    }




    public boolean hasRevs(String property,String user){
        for (int i =0;i<rev.size();i++){
            if(properties.get(i).equals(property) && users.get(i).equals(user)){
                return true;
            }
        }
        return false;
    }


    public void reNewFile(File f) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        for(int i =0;i< rev.size();i++){
            writer.write(rev.get(i));
            writer.newLine();
            writer.write(properties.get(i));
            writer.newLine();
            writer.write(users.get(i));
            writer.newLine();
            writer.write(rate.get(i));
            writer.newLine();
        }
        writer.close();


    }

    public void printRevs(){
        for (int i=0;i< rev.size();i++){
            System.out.println();
            System.out.println("Review for property "+properties.get(i)+": "+rev.get(i));
            System.out.println("By - "+users.get(i));
            System.out.println("____________________");
        }
    }


    public void showMyReviews(String name){
        System.out.println("Your reviews are down below.");
        System.out.println("--------------------");
        for(int i=0;i<rev.size();i++){
            if(users.get(i).equals(name)){
                System.out.println("Review for property "+properties.get(i)+" with rate "+rate.get(i)+"/5 :"+rev.get(i));
                System.out.println();
            }

        }

    }

}
