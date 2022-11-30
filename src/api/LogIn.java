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
        String userName,passWord,type;
        while(scanner.hasNextLine()){
            userName = scanner.next();
            scanner.skip(",");
            passWord = scanner.nextLine();
            type = scanner.nextLine();
            addAccount(userName,passWord,type);
        }


    }

    public void addAccount(String userName,String passWord, String t){
        cred.put(userName,passWord);
        type.add(t);
    }

    public boolean accCheck(String userName,String passWord){

        for(Map.Entry<String,String> entry : cred.entrySet()){
            if(entry.getKey().equals(userName) && entry.getValue().equals(passWord)) {
                return true;
            }
        }
        return false;
    }

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
