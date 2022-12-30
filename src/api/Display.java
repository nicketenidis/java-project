package api;

import java.util.*;

/**
 * Κλάση που αναπαριστά την προβολή καταχώρησης ενός καταλύματος ανάλογα με το άν ο χρήστης είναι Πάροχος ή Απλός Χρήστης
 */

public class Display {

    User user;
    Provider provider;

    /**
     * Κατασκευαστής / Constructor
     * Δημιουργία αντικειμένων των κλάσεων User και Provider
     */

    public Display(){
        user = new User();
        provider = new Provider();
    }

    /**
     * Μέθοδος που εμφανίζει την καρτέλα (Dashboard) του παρόχου που είναι συνδεδεμένος
     * Εμφανίζει τον συνολικό αριθμό αξιολογήσεων που έχουν δεχθεί τα καταλύματα τους.
     * Εμφανίζει τον μέσο όρο όλων των αξιολογήσεων των καταλυμάτων τους.
     * Εμφανίζει όλες τις καταχώρησεις καταλυμάτων που έχει κάνει με το όνομα, τον τύπο, την τοποθεσία και τον μέσο όρο κάθε καταχώρησης.
     * @param props η λίστα με τα καταλύματα
     * @param name το όνομα του χρήστη(Πάροχος)
     * @param listProp η λίστα με τα καταλύματα του αντίστοιχου παρόχου που έχουν αξιολογήσει απλοί χρήστες
     * @param listRates η λίστα με τις βαθμολογίες που έχουν δώσει απλοί χρήστες στα καταλύματα του παρόχου
     * @param names η λίστα με τα ονόματα σύνδεσης(usernames) των παρόχων
     */



    public void dashboardProvider(ArrayList<Property> props,String name, ArrayList<String> listProp, ArrayList<String> listRates, ArrayList<String> names){
        double avgTotal,avgProp;
        int totalReviews = 0,propReviews;
        double sumProp,sumTotal=0;
        //i=0;
        for(int i=0;i<props.size();i++){
            if( names.get(i).equals(name)){
                propReviews=0;
                sumProp =0;
                for (int j =0;j< listProp.size();j++){
                    if(props.get(i).getName().equals(listProp.get(j))){
                        propReviews++;
                        sumProp += Double.parseDouble(listRates.get(j));
                        totalReviews++;
                        sumTotal += Double.parseDouble(listRates.get(j));
                    }
                }
                if(propReviews == 0)
                    avgProp =0;
                else
                    avgProp = sumProp/ (double) propReviews;
                System.out.println();
                System.out.println("Property "+(i+1));
                System.out.println("-----------");
                System.out.println("Name: "+props.get(i).getName());
                System.out.println("Type: "+props.get(i).getType());
                System.out.println("Location: "+props.get(i).getLocation());

                System.out.println("Average Rate: "+avgProp+"/5");
            }
        }
        if(totalReviews == 0)
            avgTotal =0;
        else
            avgTotal = sumTotal / (double) totalReviews;

        System.out.println();
        System.out.println("Total Reviews for "+name+" : "+totalReviews);
        System.out.println("Average Rate for all properties: "+avgTotal);
    }

    /**
     * Μέθοδος που εμφανίζει την καρτέλα(Dashboard) του απλού χρήστη που είναι συνδεδεμένος.
     * Εμφανίζει όλα τα καταλύματα που έχουν αξιολογήσει με το όνομα, τον τύπο, την τοποθεσία και τον βαθμό που έχουν δώσει στο συγκεκριμένο κατάλυμα
     * Εμφανίζει τον μέσο όρο βαθμολογίας που έχουν δώσει συνολικά στα καταλύματα που έχουν αξιολογήσει
     * @param props η λίστα με τα καταλύματα
     * @param name το όνομα του χρήστη(Απλός Χρήστης)
     * @param listRates η λίστα με τις βαθμολογίες όλων των χρηστών
     * @param listUsers η λίστα με τα usernames όλων των χρηστών
     * @param listProps η λίστα με τα καταλύματα που έχουν αξιολογήσει όλοι οι χρήστες
     */



    public void dashboardUser(ArrayList<Property> props,String name,ArrayList<String> listRates,ArrayList<String> listUsers,ArrayList<String> listProps){
        int revNum=0;
        double sumRev=0;
        double avgRev;
        for(int j=0;j<props.size();j++){
            for(int i =0;i<listUsers.size();i++){
                if (listUsers.get(i).equals(name) && props.get(j).getName().equals(listProps.get(i))){
                    revNum++;
                    sumRev+= Double.parseDouble(listRates.get(i));
                    System.out.println();
                    System.out.println("Property "+(j+1));
                    System.out.println("-----------");
                    System.out.println("Name: "+props.get(j).getName());
                    System.out.println("Type: "+props.get(j).getType());
                    System.out.println("Location: "+props.get(j).getLocation());
                    //System.out.println("Description: "+e.getValue().getDescr());
                    System.out.println("Your rate: "+listRates.get(i));
                }
            }
        }
        if(revNum == 0){
            avgRev =0;
            System.out.println("No reviews yet.");
        }
        else{
            avgRev = sumRev / (double) revNum;
        }

        System.out.println();
        System.out.println("Average Rate of properties that you wrote a review: "+avgRev);
        System.out.println(".......................................");
        System.out.println();
    }

    /**
     * Μέθοδος που εμφανίζει αναλυτικά όλες τις πληροφορίες του καταλύματος που επέλεξε ο χρήστης
     * Εμφανίζει το όνομα του καταλύματος, τον τύπο, την τοποθεσία, την περιγραφή του,
     * τον αριθμό αξιολογήσεων που έχει δεχθεί το συγκεκριμένο κατάλυμα και την κάθε αξιολόγηση του κάθε χρήστη που αξιολόγησε το συγκεκριμένο κατάλυμα με τη βαθμολογία του
     * @param props η λίστα με τα καταλύματα
     * @param property το κάταλυμα που επιλέχθηκε για προβολή
     * @param listRates η λίστα με τις βαθμολογίες των χρηστών
     * @param listUsers η λίστα με τα usernames των χρηστών
     * @param listReviews η λίστα με τις αξιολογήσεις των χρηστών
     * @param listProp η λίστα με τα καταλύματα που έχουν αξιολογήσει οι χρήστες
     */


    public void displayProperty(ArrayList<Property> props,String property,ArrayList<String> listRates,ArrayList<String> listUsers,ArrayList<String> listReviews,ArrayList<String> listProp){
        int revNum=0;
        double avg,sumRev=0;


        for(int i=0;i<props.size();i++){
            if(property.equals(props.get(i).getName())){
                System.out.println();
                System.out.println("Property "+(i+1));
                System.out.println("-----------");
                System.out.println("Name: "+props.get(i).getName());
                System.out.println("Type: "+props.get(i).getType());
                System.out.println("Location: "+props.get(i).getLocation());
                System.out.println("Description: "+props.get(i).getDescr());
                System.out.println();
            }
        }

        for(int i=0;i<listReviews.size();i++){
            if(property .equals(listProp.get(i))){
                revNum++;
                sumRev += Double.parseDouble(listRates.get(i));
            }
        }
        if(revNum==0){
            avg =0;
        }else
            avg = sumRev / (double) revNum;

        System.out.println("Total reviews for this property: "+revNum);
        System.out.println("Average Rate for this property: "+avg);
        System.out.println("Reviews for this property:");

        for(int i=0;i<listReviews.size();i++){
            if (property.equals(listProp.get(i))){
                System.out.println("    By "+listUsers.get(i)+": "+listReviews.get(i)+"(Rate: "+listRates.get(i)+"/5)");
                System.out.println();

            }
        }

    }

    /**
     * Μέθοδος που εμφανίζει όλες τις αξιολογήσεις που έχει κάνει ο χρήστης που είναι συνδεδεμένος
     * @param props η λίστα με τα καταλύματα
     * @param name το username του Απλού Χρήστη
     * @param listProps η λίστα με τα καταλύματα που έχουν αξιολογήσει οι χρήστες
     * @param listUsers η λίστα με τα usernames των χρηστών
     * @param listRates η λίστα με τις βαθμολογίες των χρηστών
     * @param listReviews η λίστα με τις αξιολογήσεις των χρηστών
     */

    public void showReviews(ArrayList<Property> props,String name,ArrayList<String> listProps,ArrayList<String> listUsers,ArrayList<String> listRates,ArrayList<String> listReviews){
        System.out.println("Your reviews are down below.");
        System.out.println("--------------------");
        for (int j=0;j<props.size();j++){
            for(int i=0;i<listProps.size();i++){
                if(listUsers.get(i).equals(name) && props.get(j).getName().equals(listProps.get(i))){
                    System.out.println("Review for property "+(j+1)+" "+listProps.get(i)+" with rate "+listRates.get(i)+"/5 :"+listReviews.get(i));
                    System.out.println();
                }

            }
        }


    }

}

