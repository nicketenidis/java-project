package api;

import java.io.*;

import java.util.Scanner;

/**
 * Κλάση που αναπαριστά τη φόρμα εγγραφής νέων χρηστών(Πάροχοι και Απλοί Χρήστες) με το όνομα, το επίθετο, το username, τον κωδικό και τον τύπο τους.
 */

public class Register {

    LogIn log;
    File file = new File("src/api/Credentials");
    Scanner scanner = new Scanner(file);

    private String fName,lName,username,password,type;

    /**
     * Κατασκευαστής / Constructor
     * @param fName το όνομα του χρήστη
     * @param lName το επίθετο του χρήστη
     * @param username το όνομα σύνδεσης
     * @param password ο κωδικός σύνδεσης
     * @param type ο τύπος χρήστη
     * @throws FileNotFoundException
     */

    public Register (String fName,String lName, String username, String password, String type) throws FileNotFoundException {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.type = type;
        log = new LogIn(username,password);

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
     * @return τον τύπο του χρήστη
     */

    public String getType(){
        return type;
    }

    /**
     * Μέθοδος που ελέγχει έαν είναι εφικτό να δημιουργηθεί νέος λογαριασμός
     * @param name το username(όνομα σύνδεσης) του χρήστη
     * @return true αν δεν υπάρχει χρήστης με ίδιο username, false αν υπάρχει χρήστη με ίδιο username
     */

    public boolean verifyAcc(String name){
        scanner.useDelimiter(",");
        while(scanner.hasNextLine()){
            if(name.equals(scanner.next())){
                return false;
            }
            scanner.skip(",");
            scanner.nextLine();
            scanner.nextLine();
        }
        return true;
    }

    /**
     * Μέθοδος που δημιουργεί τον καινούργιο λογαριασμό του χρήστη
     * @param name το username του χρήστη
     * @param pass ο κωδικός του χρήστη
     * @param t ο τύπος του χρήστη
     * @throws IOException
     */

    public void newAcc(String name,String pass,String t) throws IOException {
        BufferedWriter out = new BufferedWriter((new FileWriter(file,true)));
        out.newLine();
        out.write(name+","+pass);
        out.newLine();
        out.write(t);
        out.close();
        log.addAccount(name,pass,t);
    }


}

