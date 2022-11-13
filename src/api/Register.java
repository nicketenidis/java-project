package api;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Register {

    LogIn log;
    File file = new File("src/api/Credentials");
    Scanner scanner = new Scanner(file);

    private String fName,lName,username,password,type;

    public Register (String fName,String lName, String username, String password, String type) throws FileNotFoundException {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.type = type;
        log = new LogIn(username,password);

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType(){
        return type;
    }

    public boolean verifyAcc(String name){
        scanner.useDelimiter(",");
        //String name,pass;
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
