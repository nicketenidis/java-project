package api;

import java.io.*;
import java.util.*;

public class LogIn {

    private ArrayList<String> type;

    File file = new File("src/api/Credentials");
    Scanner scanner = new Scanner(file);
    private LinkedHashMap<String,String> cred;

    private String username;
    private String password;

    public LogIn(String username,String password) throws FileNotFoundException {
        this.username = username;
        this.password = password;
        cred = new LinkedHashMap<>();
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
        String name,pass,t;
        while(scanner.hasNextLine()){
            name = scanner.next();
           scanner.skip(",");
            pass = scanner.nextLine();
            t = scanner.nextLine();
            addAccount(name,pass,t);
        }


    }

    public void addAccount(String name,String pass, String t){
        cred.put(name,pass);
        type.add(t);
    }

    public boolean accCheck(String u,String p){
       // System.out.println(cred.size());
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
                System.out.println(entry.getKey()+","+entry.getValue()+","+ type.get(i));
                return "user";
            }
            i++;
        }
        return "provider";
    }








}
