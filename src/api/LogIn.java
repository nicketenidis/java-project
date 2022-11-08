package api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogIn {

    File file = new File("C:\\Users\\keten\\OneDrive\\Υπολογιστής\\Credentials.txt");
    Scanner scanner = new Scanner(file);
    private HashMap<String,String> cred;

    private String username;
    private String password;

    public LogIn(String username,String password) throws FileNotFoundException {
        this.username = username;
        this.password = password;
        cred = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addCredits(){
        scanner.useDelimiter(",");
        String u,p;
        while(scanner.hasNextLine()){
            u = scanner.next();
            scanner.skip(",");
            p = scanner.nextLine();
            scanner.nextLine();
            cred.put(u,p);
        }

    }

    public boolean isUser(String u,String p){
        for(Map.Entry<String,String> entry : cred.entrySet()){
            if(entry.getKey().equals(u) && entry.getValue().equals(p)){
                return true;
            }
        }
        return false;


    }




}
