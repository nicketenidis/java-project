package api;

import java.io.*;
import java.util.*;


public class Provider {

    //private String type;
    private Scanner scanner ;
    public HashMap<Integer,Property> props;
    private ArrayList<String> names;
    Property prop;
    public Provider ()  {
        props = new HashMap<>();
        names = new ArrayList<>();
        scanner = new Scanner(System.in);
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
            System.out.println("By- "+names.get(i));
            i++;
        }


    }


    public void showMyProps(String name){
        int i=0;
        //System.out.println(names.size());
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
        System.out.println("The name of property(This field is required!)");
        String name = scanner.nextLine();
        System.out.println("The Type of property(This field is required!)");
        String type = scanner.nextLine();
        System.out.println("The Location of property(This field is required!)");
        String loc = scanner.nextLine();
        System.out.println("The Description of property(This field is required!)");
        String descr = scanner.nextLine();


        addProperties(c,name,type,loc,descr,n);
    }

    public String menuProvider(){
        System.out.println("Menu:");
        System.out.println("Press 1 for adding a new property.");
        System.out.println("Press 2 for editing your properties.");
        System.out.println("Press 3 for deleting the property you want.");
        System.out.println("Press 4 for showing your Dashboard.");
        System.out.println("Type LOGOUT, to logout from your account.");
        String answer = scanner.next();
        return answer;

    }

    public void deleteProp(int property,File f) {
        props.remove(property);
        names.remove(property-1);

    }

    public void editProps(int property,File f){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Change name to: ");
        String name = scanner.nextLine();
        System.out.print("Change type to: ");
        String type = scanner.nextLine();
        System.out.print("Enter the new location: ");
        String loc = scanner.nextLine();
        System.out.print("Add a description: ");
        String descr = scanner.nextLine();
        prop = new Property(name,type,loc,descr);

        for (Map.Entry<Integer,Property> e : props.entrySet()){
            if(e.getKey() == property){
                props.replace(property,e.getValue(),prop);

            }
        }
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

    public void searchProps(){
        System.out.println("You can search a property via Name, Type or Location");
        String n=scanner.next();
        int i=0;
        for(Map.Entry<Integer,Property> entry : props.entrySet()){
            if(entry.getValue().getName().toLowerCase().contains(n) || entry.getValue().getType().toLowerCase().contains(n) || entry.getValue().getLocation().toLowerCase().contains(n)){
                System.out.println();
                System.out.println("Property "+entry.getKey());
                System.out.println("-----------");
                System.out.println("Name: "+entry.getValue().getName());
                System.out.println("Type: "+entry.getValue().getType());
                System.out.println("Location: "+entry.getValue().getLocation());
                System.out.println("Description: "+entry.getValue().getDescr());
                System.out.println("________________________");
                i++;
            }

        }
        System.out.println(i+" results for "+n);
    }

    public boolean hasProps(String name){
        int i=0,c=0;
        for(Map.Entry<Integer,Property> e : props.entrySet()){
            if(names.get(i).equals(name)){
                c++;
            }
            i++;
        }
        if(c>0)
            return true;
        else
            return false;


    }

    public void dashBoardProvider(String name,ArrayList<String> listP,ArrayList<String> listR){
        int i;
        double avgTotal,avgProp;
        int totalReviews = 0,propReviews,sumProp,sumTotal=0;
        i=0;
        for(Map.Entry<Integer,Property> e : props.entrySet()){
            if( names.get(i).equals(name)){
                propReviews=0;
                sumProp =0;
                for (int j =0;j< listP.size();j++){
                    if(e.getKey() == Integer.parseInt(listP.get(j))){
                        propReviews++;
                        sumProp += Integer.parseInt(listR.get(j));
                        totalReviews++;
                        sumTotal += Integer.parseInt(listR.get(j));
                    }
                }
                if(propReviews == 0)
                    avgProp =0;
                else
                    avgProp = sumProp/ (double) propReviews;
                System.out.println();
                System.out.println("Property "+e.getKey());
                System.out.println("-----------");
                System.out.println("Name: "+e.getValue().getName());
                System.out.println("Type: "+e.getValue().getType());
                System.out.println("Location: "+e.getValue().getLocation());
                System.out.println("Description: "+e.getValue().getDescr());
                System.out.println("Average Rate: "+avgProp+"/5");
            }
            i++;
        }
        if(totalReviews == 0)
            avgTotal =0;
        else
            avgTotal = sumTotal / (double) totalReviews;

        System.out.println();
        System.out.println("Total Reviews for "+name+" : "+totalReviews);
        System.out.println("Average Rate for all properties: "+avgTotal);

    }

    public HashMap<Integer, Property> getProps() {
        return props;
    }
}
