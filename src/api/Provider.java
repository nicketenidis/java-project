package api;

import java.io.*;
import java.util.*;

public class Provider {

    private String type;

    private HashMap<Integer,Property> props;
    private ArrayList<String> names;
    Property prop;
    public Provider () throws FileNotFoundException {
        props = new HashMap<>();
        names = new ArrayList<>();
    }

    public void addProperties(int c,String n,String t,String l,String d,String w){
        prop = new Property(n,t,l,d);
        props.put(c,prop);
        names.add(w);
    }

    public void printProps(){
        int i =0;
        for (Map.Entry<Integer,Property> e : props.entrySet()){
            System.out.println();
            System.out.println("Property "+e.getKey());
            System.out.println("-----------");
            System.out.println("Name: "+e.getValue().getName());
            System.out.println("Type: "+e.getValue().getType());
            System.out.println("Location: "+e.getValue().getLocation());
            System.out.println("Description: "+e.getValue().getDescr());
            System.out.println(names.get(i));
            i++;
        }
    }


    public void showMyProps(String name){
        int i=0;
        for(Map.Entry<Integer,Property> e : props.entrySet()){
            if(names.get(i).equals(name)){
                System.out.println();
                System.out.println("Property "+e.getKey());
                System.out.println("-----------");
                System.out.println("Name: "+e.getValue().getName());
                System.out.println("Type: "+e.getValue().getType());
                System.out.println("Location: "+e.getValue().getLocation());
                System.out.println("Description: "+e.getValue().getDescr());
            }
            i++;
        }
    }


    public void newProp(int c,File f,String n) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The name of property");



        String name = scanner.nextLine();
        System.out.println("The Type of property");
        String type = scanner.nextLine();
        System.out.println("The Location of property");
        String loc = scanner.nextLine();
        System.out.println("The Description of property");
        String descr = scanner.nextLine();

        BufferedWriter out = new BufferedWriter((new FileWriter(f,true)));
        out.newLine();
        out.write(name+"-"+type+"-"+loc+"-"+descr);
        out.newLine();
        out.write(n);
        out.close();
        addProperties(c,name,type,loc,descr,n);
    }






}
