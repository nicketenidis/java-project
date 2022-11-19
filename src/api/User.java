package api;



import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {

   // Scanner scanner;

    private ArrayList<String> rate;

    private ArrayList<String> rev;
    private ArrayList<String> users;
    private ArrayList<String> properties;

    Provider provider;
    Reviews review;

    public User(){
        rev = new ArrayList<>();
        users = new ArrayList<>();
        properties = new ArrayList<>();
        rate = new ArrayList<>();
        //scanner = new Scanner(System.in);
        provider = new Provider();
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public ArrayList<String> getRate() {
        return rate;
    }

    public void addReviews(String r,String p, String u,String g){
        review = new Reviews(r);
        rev.add(r);
        properties.add(p);
        users.add(u);
        rate.add(g);
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

    public void newReview(String p,String name) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tell us about your experience : ");
        String review = sc.nextLine();
        System.out.print("Rate the property(up to 5 points) : ");
        String rate = sc.nextLine();
        BufferedWriter out = new BufferedWriter((new FileWriter("src/api/UserReviews",true)));
        out.newLine();
        out.write(review);
        out.newLine();
        out.write(p);
        out.newLine();
        out.write(name);
        out.newLine();
        out.write(rate);
        out.close();
        addReviews(review,p,name,rate);
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

    public void editReviews(String p,String name){
        Scanner sc = new Scanner(System.in);
        System.out.print("Change your review to: ");
        String newRev = sc.nextLine();
        System.out.print("Change your rate to (up to 5 points): ");
        String newRate = sc.nextLine();
        review = new Reviews(newRev);
        for (int i=0;i<rev.size();i++){
            if(properties.get(i).equals(p) && users.get(i).equals(name)){
                rev.set(i,newRev);
                rate.set(i,newRate);
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
            writer.write(rate.get(i));
            writer.newLine();
        }
        writer.close();


    }

    public void deleteRev(String p,String n){
        for (int i=0;i< rev.size();i++){
            if(properties.get(i).equals(p) && users.get(i).equals(n)){
                rev.remove(i);
                properties.remove(i);
                users.remove(i);
                rate.remove(i);
            }

        }
    }




    public void printRevs(){
        for (int i=0;i< rev.size();i++){
            System.out.println();
            System.out.println("Review for property "+properties.get(i)+": "+rev.get(i));
            System.out.println("By - "+users.get(i));
            System.out.println("____________________");
        }
    }

    public boolean hasRevs(String p,String name){
        for (int i =0;i<rev.size();i++){
            if(properties.get(i).equals(p) && users.get(i).equals(name)){
                return true;
            }
        }
        return false;
    }


    public void deletePropRev(int p){

        for(int i=0;i<rev.size();i++){
            if(properties.get(i).equals(Integer.toString(p))){
                rev.remove(i);
                properties.remove(i);
                users.remove(i);
                rate.remove(i);
            }
        }
    }

    public void dashboardUser(String name, HashMap<Integer,Property> mapProps){
        int sumRev=0,revNum=0;
        double avgRev;
        for(Map.Entry<Integer,Property> e : mapProps.entrySet()){
                for(int i =0;i<rev.size();i++){
                    if (users.get(i).equals(name) && e.getKey() == Integer.parseInt(properties.get(i))){
                        revNum++;
                        sumRev+= Integer.parseInt(rate.get(i));
                        System.out.println();
                        System.out.println("Property "+e.getKey());
                        System.out.println("-----------");
                        System.out.println("Name: "+e.getValue().getName());
                        System.out.println("Type: "+e.getValue().getType());
                        System.out.println("Location: "+e.getValue().getLocation());
                        System.out.println("Description: "+e.getValue().getDescr());
                    }
                }
        }
        if(revNum == 0){
            avgRev =0;
            System.out.println("No reviews yet.");
        }
        else{
            avgRev = sumRev / (double) revNum;
        }

        System.out.println();
        System.out.println("Average Rate of properties that you wrote a review: "+avgRev);
        System.out.println(".......................................");
        System.out.println();
    }

}
