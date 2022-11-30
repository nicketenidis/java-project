package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Display {

    User user;
    Provider provider;

    public Display(){
        user = new User();
        provider = new Provider();
    }

    public void dashboardProvider(String name, ArrayList<String> listProp, ArrayList<String> listRates, HashMap<Integer,Property> properties,ArrayList<String> names){
        int i;
        double avgTotal,avgProp;
        int totalReviews = 0,propReviews;
        double sumProp,sumTotal=0;
        i=0;
        for(Map.Entry<Integer,Property> e : properties.entrySet()){
            if( names.get(i).equals(name)){
                propReviews=0;
                sumProp =0;
                for (int j =0;j< listProp.size();j++){
                    if(e.getValue().getName().equals(listProp.get(j))){
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
                System.out.println("Property "+e.getKey());
                System.out.println("-----------");
                System.out.println("Name: "+e.getValue().getName());
                System.out.println("Type: "+e.getValue().getType());
                System.out.println("Location: "+e.getValue().getLocation());

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


    public void dashboardUser(String name, HashMap<Integer,Property> properties,ArrayList<String> listRates,ArrayList<String> listUsers,ArrayList<String> listProps){
        int revNum=0;
        double sumRev=0;
        double avgRev;
        for(Map.Entry<Integer,Property> e : properties.entrySet()){
            for(int i =0;i<listUsers.size();i++){
                if (listUsers.get(i).equals(name) && e.getValue().getName().equals(listProps.get(i))){
                    revNum++;
                    sumRev+= Double.parseDouble(listRates.get(i));
                    System.out.println();
                    System.out.println("Property "+e.getKey());
                    System.out.println("-----------");
                    System.out.println("Name: "+e.getValue().getName());
                    System.out.println("Type: "+e.getValue().getType());
                    System.out.println("Location: "+e.getValue().getLocation());
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


    public void displayProperty(String property,HashMap<Integer,Property> properties,ArrayList<String> listRates,ArrayList<String> listUsers,ArrayList<String> listReviews,ArrayList<String> listProp){
        int revNum=0;
        double avg,sumRev=0;


        for(Map.Entry<Integer,Property> e : properties.entrySet() ){
            if(property.equals(e.getValue().getName())){
                System.out.println();
                System.out.println("Property "+e.getKey());
                System.out.println("-----------");
                System.out.println("Name: "+e.getValue().getName());
                System.out.println("Type: "+e.getValue().getType());
                System.out.println("Location: "+e.getValue().getLocation());
                System.out.println("Description: "+e.getValue().getDescr());
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

    public void showReviews(String name,HashMap<Integer,Property> mapProps,ArrayList<String> listProps,ArrayList<String> listUsers,ArrayList<String> listRates,ArrayList<String> listReviews){
        System.out.println("Your reviews are down below.");
        System.out.println("--------------------");
        for (Map.Entry<Integer,Property> e : mapProps.entrySet()){
            for(int i=0;i<listProps.size();i++){
                if(listUsers.get(i).equals(name) && e.getValue().getName().equals(listProps.get(i))){
                    System.out.println("Review for property "+e.getKey()+" "+listProps.get(i)+" with rate "+listRates.get(i)+"/5 :"+listReviews.get(i));
                    System.out.println();
                }

            }
        }


    }

}
