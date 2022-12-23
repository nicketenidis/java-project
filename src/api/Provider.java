package api;

import java.io.*;
import java.util.*;


public class Provider {



    ArrayList<String> names;
    ArrayList<Property> properties;

    Property prop;
    public Provider ()  {

        names = new ArrayList<>();
        properties = new ArrayList<>();

    }



    public int getSize2(){return properties.size();}


    public ArrayList<Property> getProperties(){return properties;}

    public ArrayList<String> getNames() {
        return names;
    }

    public String getPropName2(int x){
        return properties.get(x-1).getName();
    }



    public void addProperties( String nameProp, String typeProp, String locProp, String descrProp, String provName){

        prop = new Property(nameProp,typeProp,locProp,descrProp);
        properties.add(prop);
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
        return scanner.next();

    }

    public void newProp2( String provName){
        boolean flag;
        String nameProp,typeProp,locProp,descrProp;
        Scanner scanner = new Scanner(System.in);
        do{
            flag=true;
            System.out.println("The name of property(This field is required!)");
            nameProp = scanner.nextLine();
            for (Property property : properties) {
                if (property.getName().equals(nameProp)) {
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


        addProperties(nameProp,typeProp,locProp,descrProp,provName);

    }


    public void editProps2(int property){
        boolean flag;
        Scanner scanner = new Scanner(System.in);
        String nameProp,typeProp,locProp,descrProp;
        do{
            flag =true;
            System.out.print("Change name to: ");
            nameProp = scanner.nextLine();
            for (Property value : properties) {
                if (value.getName().equals(nameProp)) {
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
        properties.set(property-1,prop);
    }


    public void editGUI(String nameProp,String typeProp,String locProp,String descrProp,String property){
        prop = new Property(nameProp,typeProp,locProp,descrProp);
        properties.set(Integer.parseInt(property)-1,prop);

    }

    public void deleteProp(int property) {


        properties.remove(property-1);
        names.remove(property-1);

    }


    public boolean hasProps(String provName){
        int c=0;
        for (String name : names) {
            if (name.equals(provName)) {
                c++;
            }
        }
        return c>0;
    }



    public void reNewFile2(File f) throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        for(int i=0;i<properties.size();i++){
            writer.write(properties.get(i).getName()+"-"+properties.get(i).getType()+"-"+properties.get(i).getLocation()+"-"+properties.get(i).getDescr());
            writer.newLine();
            writer.write(names.get(i));
            writer.newLine();
        }
        writer.close();
    }


    public void printProps2(){
        for (int i=0;i< properties.size();i++){
            System.out.println();
            System.out.println("Property "+(i+1));
            System.out.println("-----------");
            System.out.println("Name: "+properties.get(i).getName());
            System.out.println("Type: "+properties.get(i).getType());
            System.out.println("Location: "+properties.get(i).getLocation());
            System.out.println("Description: "+properties.get(i).getDescr());
            System.out.println("By- "+names.get(i));
        }
    }

    public void showMyProps2(String name){


        for(int i=0;i<properties.size();i++){
            if(names.get(i).equals(name)){
                System.out.println();
                System.out.println("Property "+(i+1));
                System.out.println("-----------");
                System.out.println("Name: "+properties.get(i).getName());
                System.out.println("Type: "+properties.get(i).getType());
                System.out.println("Location: "+properties.get(i).getLocation());
                System.out.println("Description: "+properties.get(i).getDescr());
            }

        }


    }


    public void searchProps2(){
        int c=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can search a property via Name, Type or Location");
        String n=scanner.nextLine();

        for(int i=0;i<properties.size();i++){
            if(properties.get(i).getName().toLowerCase().contains(n.toLowerCase()) || properties.get(i).getType().toLowerCase().contains(n.toLowerCase()) || properties.get(i).getLocation().toLowerCase().contains(n.toLowerCase())){
                System.out.println();
                System.out.println("Property "+(i+1));
                System.out.println("-----------");
                System.out.println("Name: "+properties.get(i).getName());
                System.out.println("Type: "+properties.get(i).getType());
                System.out.println("Location: "+properties.get(i).getLocation());
                System.out.println("Description: "+properties.get(i).getDescr());
                System.out.println("____________________");
                c++;

            }
        }
        System.out.println(c+" results for "+n);
    }









}








