package api;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

/**
 * Κλάση που αναπαριστά τις λειτουργίες ενός απλού χρήστη(Αναζήτηση καταλύματος, Εισαγωγή, Επεξεργασία και Διαγραφή αξιολόγησης
 */

public class User {

    ArrayList<String> rate; // Λίστα με τις βαθμολογίες των χρηστών

    ArrayList<String> rev; // Λίστα με τις αξιολογήσεις των χρηστών
    ArrayList<String> users; // Λίστα με τα usernames των χρηστών που έχουν κάνει κάποια αξιολόγηση
    ArrayList<String> properties; // Λίστα με τα καταλύματα που έχουν αξιολογήσει οι χρήστες

    Provider provider;
    Reviews review;

    /**
     * Κατασκευαστής / Constructor
     * Δημιουργία αντικειμένου provider και αρχικοποίηση των παραπάνω λιστών
     */

    public User()  {
        rev = new ArrayList<>();
        users = new ArrayList<>();
        properties = new ArrayList<>();
        rate = new ArrayList<>();
        provider = new Provider();
    }

    /**
     * Μέθοδος που επιστρέφει τη λίστα με τα καταλύματα που έχουν αξιολογήθει
     */

    public ArrayList<String> getProperties() {
        return properties;
    }

    /**
     *
     * Μέθοδος που επιστρέφει τη λίστα με τις βαθμολογίες του κάθε χρήστη
     */

    public ArrayList<String> getRate() {
        return rate;
    }

    /**
     * Μέθοδος που επιστρέφει τη λίστα με τα usernames των χρηστών που έχουν κάνει κάποια αξιολόγηση
     */

    public ArrayList<String> getUsers() {
        return users;
    }

    /**
     * Μέθοδος που επιστρέφει τη λίστα με τις αξιολογήσεις που έχουν κάνει οι χρήστες
     */

    public ArrayList<String> getRev() {
        return rev;
    }

    /**
     * Μέθοδος που προσθέτει στις αντίστοιχες λίστες την αξιολογήση, τη βαθμολογία, το username του χρήστη και το κατάλυμα που κάνει την αξιολόγηση
     * @param userReview η αξιολόγηση του χρήστη
     * @param prop το κατάλυμα που αξιολογεί
     * @param user ο χρήστης που κάνει την αξιολόγηση
     * @param userRate τη βαθμολογία που δίνει στο κατάλυμα
     */

    public void addReviews(String userReview,String prop, String user,String userRate){
        review = new Reviews(userReview);
        rev.add(userReview);
        properties.add(prop);
        users.add(user);
        rate.add(userRate);
    }

    /**
     * Μέθοδος που εμφανίζει το μενού επιλογών του χρήστη. Αναζήτηση καταλύματος, Εισαγωγλη, Επεξεργασία, Διαγραφή αξιολόγησης και προβολή DashBoard
     * @return την επιλογή του χρήστη
     */

    public String menuUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("Press 1 for searching a property.");
        System.out.println("Press 2 for adding a new review for a property of your choice.");
        System.out.println("Press 3 for editing a review.");
        System.out.println("Press 4 for deleting a review.");
        System.out.println("Press 5 for showing your Dashboard.");
        System.out.println("Type LOGOUT, to logout from your account.");
        return sc.next();
    }

    /**
     * Μέθοδος που προσθέτει μια νές αξιολόγηση απο έναν χρήστη
     * @param property το κατάλυμα που κάνει την αξιολόγηση
     * @param user ο χρήστης που κάνει την αξιολόγηση
     */

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

    /**
     * Μέθοδος που επεξεργάζεται μια ήδη υπάρχων αξιολόγηση, αλλάζοντας την αξιολόγηση και τη βαθμολογία του
     * @param property το κατάλυμα που θα αλλάξει την αξιολόγηση του
     * @param user ο χρήστης που αλλάζει την αξιολόγηση του
     */


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

    /**
     * Μέθοδος που κάνει επεξεργασία αξιολόγησης μέσω της κλάσης GUI
     * @param newReview η νεα αξιολόγηση που θα αντικαταστήσει την παλαιά
     * @param newRate η νεα βαθμολογία που θα αντικαταστήσει την παλαιά
     * @param property το κατάλυμα που θα αλλάξει την αξιολόγηση του
     *      * @param user ο χρήστης που αλλάζει την αξιολόγηση του
     */

    public void editRevGUI(String newReview,String newRate,String property,String user){
        review = new Reviews(newReview);
        for (int i=0;i<rev.size();i++){
            if(properties.get(i).equals(property) && users.get(i).equals(user)){
                rev.set(i,newReview);
                rate.set(i,newRate);
            }
        }
    }

    /**
     * Μέθοδος που αν αλλάξει το όνομα ενός καταλύματος και υπάρχουν αξιολόγησεις σε αυτό, αλλάζει και το όνομα στη λίστα των καταλυμάτων που έχουν δεχθεί αξιολογήσεις
     * @param prop1 το όνομα του παλαιού καταλύματος
     * @param prop2 το όνομα που θα αντικαταστήσει το παλαιό
     */

    public void editRevName(String prop1,String prop2){
        for(int i =0;i<properties.size();i++){
            if(properties.get(i).equals(prop1)){
                properties.set(i,prop2);
            }
        }

    }

    /**
     * Μέθοδος που διαγράφει μια αξιολόγηση
     * @param property το κατάλυμα για το οποίο θα διαγραφεί η αξιολόγηση του
     * @param user ο χρήστης που θα διαγράψει την αξιολόγηση του
     */

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

    /**
     * Μέθοδος που αν διαγραφεί ένα κατάλυμα που έχει αξιολογήσεις, τότε διαγράφονται και οι αξιολογήσεις αυτού του καταλύματος
     * @param property το κατάλυμα που θα διαγραφεί
     */

    public void deletePropRev(String property) {
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).equals(property)) {
                rev.remove(i);
                properties.remove(i);
                users.remove(i);
                rate.remove(i);
                i=0;
            }
        }

    }

    /**
     * Μέθοδος που ελέγχει εάν ο χρήστης έχει κάνει γενικά κάποια αξιολόγηση σε κάποιο κατάλυμα
     * @param name το username του χρήστη
     * @return true ή false ανάλογα με το αν ο χρήστης έχει κάνει αξιολόγηση ή όχι
     */

    public boolean hasGenRevs(String name){
        int c=0;
        for (int i=0;i< users.size();i++){
            if(name.equals(users.get(i))){
                c++;
            }
        }
        return c>0;
    }

    /**
     * Μέθοδος που ελέγχει έαν ο χρήστης έχει αξιολογήσει ενα συγκεκριμένο κατάλυμα
     * @param property το κατάλυμα που ελέγχεται άν έχει αξιολογηθεί απο τον συγκεκριμένο χρήστη
     * @param user το username του χρήστη
     * @return true ή false ανάλογα με το εάν ο χρήστης έχει αξιολογήσει το συγκεκριμένο κατάλυμα ή οχι
     */
    public boolean hasRevs(String property,String user){
        for (int i =0;i<rev.size();i++){
            if(properties.get(i).equals(property) && users.get(i).equals(user)){
                return true;
            }
        }
        return false;
    }

    /**
     * Μέθοδος που ανανεώνει το αρχείο txt όταν γίνονται αλλαγές απο τον χρήστη που είναι συνδεδεμένος
     * @param f το αρχείο που θα ανανεωθεί και περιέχει τις αξιολογήσεις, τις βαθμολογίες, τα usernames των χρηστών και τα καταλύματα που αυτοί έχουν αξιολογήσει
     */

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

}