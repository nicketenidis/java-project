package api;

import java.io.*;
import java.util.*;


public class Provider {


    public LinkedHashMap<Integer,Property> props;
    private ArrayList<String> names;
    private ArrayList<Property> properties;

    Property prop;
    public Provider ()  {
        props = new LinkedHashMap<>();
        names = new ArrayList<>();
        properties = new ArrayList<>();


    }

    public int getSize(){
        return props.size();
    }


    public LinkedHashMap<Integer, Property> getProps() {
        return props;
    }

    public ArrayList<Property> getProperties(){return properties;}

    public ArrayList<String> getNames() {
        return names;
    }

    public String getPropName(int x){
        return props.get(x).getName();
    }

    public String getPropName2(int x){
        return properties.get(x-1).getName();
    }



    public void addProperties(int c, String nameProp, String typeProp, String locProp, String descrProp, String provName){

            prop = new Property(nameProp,typeProp,locProp,descrProp);
            props.put(c,prop);
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
        String answer = scanner.next();
        return answer;

    }

    public void newProp2(int c, String provName){
        boolean flag;
        String nameProp,typeProp,locProp,descrProp;
        Scanner scanner = new Scanner(System.in);
        do{
            flag=true;
            System.out.println("The name of property(This field is required!)");
            nameProp = scanner.nextLine();
            for(int i=0;i< properties.size();i++){
                if(properties.get(i).getName().equals(nameProp)){
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

    public void editProps2(int property){
        boolean flag;
        Scanner scanner = new Scanner(System.in);
        String nameProp,typeProp,locProp,descrProp;
        do{
            flag =true;
            System.out.print("Change name to: ");
            nameProp = scanner.nextLine();
            for(int i=0;i<properties.size();i++){
                if(properties.get(i).getName().equals(nameProp)){
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

    public void editGUI(String nameProp,String typeProp,String locProp,String descrProp,String property){
        prop = new Property(nameProp,typeProp,locProp,descrProp);
        props.replace(Integer.parseInt(property),prop);

    }

    public void deleteProp(int property) {

        props.remove(property);
        properties.remove(property-1);
        names.remove(property-1);






    }


    public boolean hasProps(String provName){
        int c=0;
        for(int i=0;i<names.size();i++){
            if(names.get(i).equals(provName)){
                c++;
            }
        }
        return c>0;
    }



    public void reNewFile2(File f) throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        for(int i=0;i<properties.size();i++){
            //writer.newLine();
            writer.write(properties.get(i).getName()+"-"+properties.get(i).getType()+"-"+properties.get(i).getLocation()+"-"+properties.get(i).getDescr());
            writer.newLine();
            writer.write(names.get(i));
            writer.newLine();
        }
        writer.close();
    }
    public void reNewFile(File f) throws IOException {
        int i=0;
        for (i=0;i< names.size();i++){
            System.out.println(i+"+"+names.get(i));
        }
        i=0;
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        for(Map.Entry<Integer,Property> entry : props.entrySet()){
            //writer.newLine();
            writer.write(entry.getValue().getName()+"-"+entry.getValue().getType()+"-"+entry.getValue().getLocation()+"-"+entry.getValue().getDescr());
            writer.newLine();
            writer.write(names.get(i));
            writer.newLine();

            i++;
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

    public void searchProps2(){
        int c=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can search a property via Name, Type or Location");
        String n=scanner.next();

        for(int i=0;i<properties.size();i++){
            if(properties.get(i).getName().contains(n) || properties.get(i).getType().contains(n) || properties.get(i).getLocation().contains(n)){
                System.out.println();
                System.out.println("Property "+(i+1));
                System.out.println("-----------");
                System.out.println("Name: "+properties.get(i).getName());
                System.out.println("Type: "+properties.get(i).getType());
                System.out.println("Location: "+properties.get(i).getLocation());
                System.out.println("Description: "+properties.get(i).getDescr());
                System.out.println("______________________");
                c++;

            }
        }
        System.out.println(c+" results for "+n);
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

