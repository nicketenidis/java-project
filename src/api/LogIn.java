package api;

import java.io.*;
import java.util.*;

/**
 * Κλάση που αναπαριστά τη φόρμα σύνδεσης του χρήστη(Πάροχος, Απλός χρήστης) με username και password
 */

public class LogIn {

    private ArrayList<String> type;

    File file = new File("src/api/Credentials");
    Scanner scanner = new Scanner(file);
    private LinkedHashMap<String,String> cred;

    private String username;
    private String password;

    /**
     *
     * @param username το όνομα του χρήστη για τη σύνδεση
     * @param password ο κωδικός του χρήστη για τη σύνδεση
     * @throws FileNotFoundException
     */

    public LogIn(String username,String password) throws FileNotFoundException {
        this.username = username;
        this.password = password;
        cred = new LinkedHashMap<>();
        type = new ArrayList<>();
    }

    /**
     *
     * @return το όνομα σύνδεσης του χρήστη
     */

    public String getUsername() {
        return username;
    }

    /**
     *
     * @return τον κωδικό σύνδεσης του χρήστη
     */

    public String getPassword() {
        return password;
    }

    /**
     * Η μέθοδος αυτή έχει πρόσβαση στο αρχείο με τα credentials του χρήστη, ώστε να πάρει τα username και password
     */

    public void addCredits(){
        scanner.useDelimiter(",");
        String userName,passWord,type;
        while(scanner.hasNextLine()){
            userName = scanner.next();
            scanner.skip(",");
            passWord = scanner.nextLine();
            type = scanner.nextLine();
            addAccount(userName,passWord,type);
        }


    }

    /**
     * Η μέθοδος αυτή προσθέτει τα username και password στα credentials του χρήστη.Και τον τύπο χρήστη σε μια λίστα
     * @param userName
     * @param passWord
     * @param t
     */

    public void addAccount(String userName,String passWord, String t){
        cred.put(userName,passWord);
        type.add(t);
    }

    /**
     *  Η μέθοδος αυτή ελέγχει έαν υπάρχει το username του χρήστη με το αντίστοιχο password
     * @param userName το όνομα σύνδεσης
     * @param passWord ο κωδικός σύνδεσης
     * @return true ή false ανάλογα με το αν υπάρχει ο συνδυασμός των παραπάνω
     */

    public boolean accCheck(String userName,String passWord){

        for(Map.Entry<String,String> entry : cred.entrySet()){
            if(entry.getKey().equals(userName) && entry.getValue().equals(passWord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Η μέθοδος αυτή επιστρέφει τον τύπο χρήστη ανάλογα με credentials σύνδεσης
     * @param userName το όνομα σύνδεσης
     * @param passWord ο κωδικός σύνδεσης
     * @param t τύπος χρήστη
     * @return provider ή user ανάλογα τον χρήστη
     */

    public String whatUser(String userName,String passWord,String t){
        int i=0;
        for(Map.Entry<String,String> entry : cred.entrySet()){
            if(entry.getKey().equals(userName) && entry.getValue().equals(passWord) && type.get(i).equals(t)) {

                return "user";
            }
            i++;
        }
        return "provider";
    }









}