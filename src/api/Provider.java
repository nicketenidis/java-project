package api;

import java.util.*;

public class Provider {

    private HashMap<Integer,Property> props;

    Property prop;
    public Provider ()  {
        props = new HashMap<>();
    }

    public void addProperties(int c,String n,String t,String l,String d){
        prop = new Property(n,t,l,d);
        props.put(c,prop);
    }

    public void printProps(){
        for (Map.Entry<Integer,Property> e : props.entrySet()){
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
