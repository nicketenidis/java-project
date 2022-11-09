package api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogIn {

    private ArrayList<String> type;

    File file = new File("src/api/Credentials");
    Scanner scanner = new Scanner(file);
    private HashMap<String,String> cred;

    private String username;
    private String password;

    public LogIn(String username,String password) throws FileNotFoundException {
        this.username = username;
        this.password = password;
        cred = new HashMap<>();
        type = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addCredits(){
        scanner.useDelimiter(",");
        String name,pass;
        while(scanner.hasNextLine()){
            name = scanner.next();
            scanner.skip(",");
            pass = scanner.nextLine();
            type.add(scanner.nextLine());
            cred.put(name,pass);
        }

    }

    public boolean accCheck(String u,String p){
        for(Map.Entry<String,String> entry : cred.entrySet()){
            if(entry.getKey().equals(u) && entry.getValue().equals(p)) {
                return true;
            }
        }
        return false;
    }

    public String whatUser(String n,String p,String t){
        int i=0;
        for(Map.Entry<String,String> entry : cred.entrySet()){
            if(entry.getKey().equals(n) && entry.getValue().equals(p) && type.get(i).equals(t)) {
                return "user";
            }
            i++;
        }
        return "provider";
    }







}
