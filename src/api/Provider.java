package api;

import java.io.*;
import java.util.*;

/**
 * Κλάση που αναπαριστά τις λειτουργίες των παρόχων. Προσθήκη, Επεξεργασία και Διαγραφή καταλύματος. Στην κλάση αυτή γίνεται η αναζήτηση καταλύματος
 */


public class Provider {



    ArrayList<String> names; // Λίστα με τα usernames των παρόχων
    ArrayList<Property> properties; // Λίστα με τα καταλύματα των παρόχων

    Property prop;

    /**
     * Κατασκευαστής / Constructor
     * Δημιουργία αντικειμένου Property
     * Αρχικοποίηση των παραπάνω λιστών
     */
    public Provider ()  {

        names = new ArrayList<>();
        properties = new ArrayList<>();

    }

    /**
     * Μέθοδος που επιστρέφει τον αριθμό όλων των καταλυμάτων που υπάρχουν
     */

    public int getSize2(){return properties.size();}

    /**
     * Μέθοδος που επιστρέφει τη λίστα με τα καταλύματα
     */


    public ArrayList<Property> getProperties(){return properties;}

    /**
     * Μέθοδος που επιστρέφει τη λίστα με τα usernames των παρόχων
     */

    public ArrayList<String> getNames() {
        return names;
    }

    /**
     * Μέθοδος που επιστρέφει το όνομα του καλύματος
     * @param x ο αριθμός του καταλύματος
     */

    public String getPropName2(int x){
        return properties.get(x-1).getName();
    }

    /**
     * Μέθοδος που δημιουργεί ένα αντικείμενο τύπου Property και προσθέτει το όνομα, τον τύπο, την τοποθεσία και την περιγραφή του καταλύματος στη λίστα με τα καταλύματα
     * Και προσθέτει στη λίστα με τα usernames των παρόχων το αντίστοιχο username
     * @param nameProp το όνομα του καταλύματος
     * @param typeProp ο τύπος του καταλύματος
     * @param locProp η τοποθεσία που βρίσκεται το κατάλυμα
     * @param descrProp περιγραφή του καταλύματος
     * @param provName το username του παρόχου
     */



    public void addProperties( String nameProp, String typeProp, String locProp, String descrProp, String provName){

        prop = new Property(nameProp,typeProp,locProp,descrProp);
        properties.add(prop);
        names.add(provName);

    }

    /**
     * Μέθοδος που εμφανίζει το μενού επιλογών ενός παρόχου. Προσθήκη, Επεξεργασία, Διαγραφή καταλύματος και προβολή Dashboard του παρόχου
     * @return την επιλογή του παρόχου
     */

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

    /**
     * Μέθοδος που προστίθεται ένα νέο κατάλυμα
     * @param provName το όνομα του παρόχου που θα προσθέσει το κατάλυμα
     */

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

    /**
     * Μέθοδος που επεξεργάζεται ένα ήδη υπάρχων κατάλυμα
     * @param property το κατάκυμα που θα επεξεργαστεί
     */

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

    /**
     * Μέθοδος για την επεξεργασία ενός ήδη υπάρχων καταλύματος μέσω της κλάσης GUI
     * @param nameProp το νέο όνομα του καταλύματος
     * @param typeProp ο νέος τύπος καταλύματος
     * @param locProp η νέα τοποθεσία του καταλύματος
     * @param descrProp νέα περιγραφή για το κατάλυμα
     * @param property το κατάλυμα, το οποίο θα επεξεργαστεί
     */


    public void editGUI(String nameProp,String typeProp,String locProp,String descrProp,String property){
        prop = new Property(nameProp,typeProp,locProp,descrProp);
        properties.set(Integer.parseInt(property)-1,prop);

    }

    /**
     * Μέθοδος που διαγράφει ένα κατάλυμα
     * @param property το κατάλυμα που θα διαγραφτεί
     */

    public void deleteProp(int property) {


        properties.remove(property-1);
        names.remove(property-1);

    }

    /**
     * Μέθοδος που ελέγχει εάν ο πάροχος που είναι συνδεδεμένος έχει καταλύματα
     * @param provName το username του παρόχου
     * @return true ή false ανάλογα με το άν ο πάροχος έχει καταλύματα ή οχι
     */


    public boolean hasProps(String provName){
        int c=0;
        for (String name : names) {
            if (name.equals(provName)) {
                c++;
            }
        }
        return c>0;
    }

    /**
     * Μέθοδος που επιστρέφει true ή false ανάλογα αν ο πάροχος δίνει έγκυρο αριθμό καταλύματος
     * @param property ο αιρθμός καταλύματος
     * @param name το username του παρόχου
     */

    public boolean isValid(int property,String name){
        for(int i=0;i<properties.size();i++){
            if(names.get(i).equals(name)){
                if (property == i+1){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Μέθοδος που ανανεώνει ένα αρχείο txt αν ο πάροχος κάνει αλλαγές
     * @param f το αρχέιο txt που περιέχει τα καταλύματα και τους αντίχτοιχους παρόχους
     */



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

    /**
     * Μέθοδος που εμφανίζει όλα τα καταλύματα
     */


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

    /**
     * Μέθοδος που εμφανίζει τα καταλύματα του παρόχου που είναι συνδεδεμένος
     * @param name το usernames του παρόχου
     */

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

    /**
     * Μέθοδος που γίνεται η αναζήτηση κάποιου καταλύματος, σύμφωνα με το όνομα, το τύπο, την τοποθεσία και την περιγραφή του καταλύματος
     */


    public void searchProps2(){
        int c=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can search a property via Name, Type, Location or Description");
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








