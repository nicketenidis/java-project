package api;

import java.io.*;
import java.util.*;


public class Provider {

    public HashMap<Integer,Property> props;
    private ArrayList<String> names;
    Property prop;
    public Provider ()  {
        props = new HashMap<>();
        names = new ArrayList<>();
        //scanner = new Scanner(System.in);
    }


    public HashMap<Integer, Property> getProps() {
        return props;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public String getPropName(int x){
        return props.get(x).getName();
    }


    public void addProperties(int c, String nameProp, String typeProp, String locProp, String descrProp, String provName){
        prop = new Property(nameProp,typeProp,locProp,descrProp);
        props.put(c,prop);
        names.add(provName);
    }

    public String menuProvider(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("Press 1 for adding a new property.");
        System.out.println("Press 2 for editing your properties.");
        System.out.println("Press 3 for deleting the property you want.");
        System.out.println("Press 4 for showing your Dashboard.");
        System.out.println("Type LOGOUT, to logout from your account.");
        String answer = scanner.next();
        return answer;

    }

    public void newProp(int c,String provName) {
        boolean flag ;
        String nameProp,typeProp,locProp,descrProp;
        Scanner scanner = new Scanner(System.in);

        do{
            flag=true;
            System.out.println("The name of property(This field is required!)");
            nameProp = scanner.nextLine();
            for(Map.Entry<Integer,Property> e : props.entrySet()){
                if(e.getValue().getName().equals(nameProp)){
                    System.out.println("There is already a property with ths name. Try another name.");
                    flag = false;
                    break;
                }
            }
        }while(!flag);

        System.out.println("The Type of property(This field is required!)");
        typeProp = scanner.nextLine();
        System.out.println("The Location of property(This field is required!)[Address,City,Postal Code]");
        locProp = scanner.nextLine();
        System.out.println("The Description of property(This field is required!)");
        descrProp = scanner.nextLine();


        addProperties(c,nameProp,typeProp,locProp,descrProp,provName);
    }

    public void editProps(int property){
        boolean flag;
        Scanner scanner = new Scanner(System.in);
        String nameProp,typeProp,locProp,descrProp;
        do{
            flag=true;
            System.out.print("Change name to: ");
            nameProp = scanner.nextLine();
            for(Map.Entry<Integer,Property> e : props.entrySet()){
                if(e.getValue().getName().equals(nameProp)){
                    System.out.println("There is already a property with ths name. Try another name.");
                    flag = false;
                    break;
                }
            }
        }while(!flag);

        System.out.print("Change type to: ");
        typeProp = scanner.nextLine();
        System.out.print("Enter the new location(Address,City,Postal Code): ");
        locProp = scanner.nextLine();
        System.out.print("Add a description: ");
        descrProp = scanner.nextLine();
        prop = new Property(nameProp,typeProp,locProp,descrProp);

        for (Map.Entry<Integer,Property> e : props.entrySet()){
            if(e.getKey() == property){
                props.replace(property,e.getValue(),prop);

            }
        }
    }

    public void deleteProp(int property) {
        props.remove(property);
        names.remove(property-1);

    }


    public boolean hasProps(String provName){
        int i=0,c=0;
        for(Map.Entry<Integer,Property> e : props.entrySet()){
            if(names.get(i).equals(provName)){
                c++;
            }
            i++;
        }
        return c > 0;
    }

    public void reNewFile(File f) throws IOException {
        int i=0;
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        for(Map.Entry<Integer,Property> entry : props.entrySet()){
            writer.write(entry.getValue().getName()+"-"+entry.getValue().getType()+"-"+entry.getValue().getLocation()+"-"+entry.getValue().getDescr());
            writer.newLine();
            writer.write(names.get(i));
            writer.newLine();

            i++;
        }
        writer.close();

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
            System.out.println("By- "+names.get(i));
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

    public void searchProps(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can search a property via Name, Type or Location");
        String n=scanner.next();
        int i=0;
        for(Map.Entry<Integer,Property> entry : props.entrySet()){
            if(entry.getValue().getName().contains(n) || entry.getValue().getType().contains(n) || entry.getValue().getLocation().contains(n)){
                System.out.println();
                System.out.println("Property "+entry.getKey());
                System.out.println("-----------");
                System.out.println("Name: "+entry.getValue().getName());
                System.out.println("Type: "+entry.getValue().getType());
                System.out.println("Location: "+entry.getValue().getLocation());
                System.out.println("Description: "+entry.getValue().getDescr());
                System.out.println("______________________");
                i++;
            }
        }
        System.out.println(i+" results for "+n);
    }







}

