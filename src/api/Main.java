package api;

import gui.*;

import java.io.*;
import java.util.Scanner;

/**
 * Η βασική κλάση Main στην οποία διατρέχονται οι λειτουργίες των υπόλοιπων κλάσεων
 */


public class Main {

    public static void main(String [] args) throws IOException {


        System.out.println("Hello, Welcome to My Reviews App:");

        File fileP = new File("src/api/Properties");
        File fileR = new File("src/api/UserReviews");
        Scanner input,fromKeyboard;
        Provider prov = new Provider();
        User user = new User();
        Display display = new Display();
        LogIn log =null;

        /**
         * ΑΡΧΙΚΟΠΟΙΗΣΗ ΑΞΙΟΛΟΓΗΣΕΩΝ ΠΟΥ ΓΊΝΕΤΑΙ ΜΈΣΩ ΤΟΥ ΑΡΧΕΙΟΥ "UserReviews"
         */

        input = new Scanner(fileR);
        String review,fromUser,forProp,rate;
        while(input.hasNextLine()){
            review = input.nextLine(); // Η αξιολόγηση του χρήστη
            forProp = input.nextLine(); // Το κατάλυμα που έχει δεχθεί αξιολόγηση
            fromUser =input.nextLine(); // Ο χρήστης που κάνει την αξιολόγηση
            rate = input.nextLine(); // Η βαθμολογία που δίνει ο χρήστης
            user.addReviews(review,forProp,fromUser,rate);
        }
        /**
         * ΑΡΧΙΚΟΠΟΊΗΣΗ ΚΑΤΑΛΥΜΆΤΩΝ ΠΟΥ ΓΊΝΕΤΑΙ ΜΈΣΩ ΤΟΥ ΑΡΧΕΊΟΥ "Properties"
         */

        input = new Scanner(fileP);
        input.useDelimiter("-");
        String nameProp,typeProp,locProp,descrProp,whoProp;
        int countProp=1;
        while(input.hasNextLine()){
            nameProp = input.next(); // Το όνομα του καταλύματος
            typeProp = input.next(); // Ο τύπος του καταλύματος
            locProp = input.next(); // Η τοποθεσία του καταλύματος
            input.skip("-");
            descrProp = input.nextLine(); // Η περιγραφή του καταλύματος
            whoProp = input.nextLine(); // Ο πάροχος του καταλύματος
            prov.addProperties(nameProp,typeProp,locProp,descrProp,whoProp);
            countProp++;
        }
        boolean found = true;
        fromKeyboard = new Scanner(System.in);

        GUI gui = new GUI(); // Δημιουργία αντικειμένου τύπου GUI

        //ΕΚΚΙΝΗΣΗ GUI

        gui.Initialize();
        gui.Intro();

        /**
         * ΔΙΑΔΙΚΑΣΙΑ ΣΥΝΔΕΣΗΣ / ΕΓΓΡΑΦΗΣ
         */
        while(found) {
            System.out.println("If you already have an account please, press L to log in,else press R to register or EXIT to exit the application");

            Register reg = null;


            String answer;
            answer = fromKeyboard.next(); // Απάντηση χρήστη στο αν θέλει να συνδεθεί, να κάνει εγγραφή ή να βγεί απο την εφαρμογή
            boolean isUser;
            String userName, userPass, userType, firstName, lastName;
            String whatUser;

            if(answer.toUpperCase().equals("EXIT"))
                break;

            do {
                boolean flag = false;
                //Όταν έχει επιλεχθεί να γίνει εγγραφή
                if (answer.equals("R")) {
                    do {
                        System.out.println("Create your account:");
                        System.out.print("Enter your First Name: ");
                        firstName = fromKeyboard.next(); // Το όνομα του χρήστη
                        System.out.print("Enter your Last Name: ");
                        lastName = fromKeyboard.next(); // Το επίθετο του χρήστη
                        System.out.print("Enter your username: ");
                        userName = fromKeyboard.next(); //Το username του χρήστη
                        System.out.print("Enter your password: ");
                        userPass = fromKeyboard.next(); //Ο κωδικός σύνδεσης του χρήστη
                        do{
                            System.out.print("Are you just a User or Provider? : ");
                            userType = fromKeyboard.next(); //Ο τύπος του χρήστη (Πάροχος ή Απλός χρήστης)
                            if(!userType.equals("user") && !userType.equals("provider"))
                                System.out.println("This is not a valid type of user. You can only be user or provider.");
                        }while(!userType.equals("user") && !userType.equals("provider"));


                        reg = new Register(firstName, lastName, userName, userPass, userType); //Δημιουργία αντικειμένου τύπου Register
                        boolean ver = reg.verifyAcc(userName);
                        if (ver) {
                            flag = true;
                            reg.newAcc(userName, userPass, userType);
                            System.out.println("Perfect! Your account has been created.");
                            System.out.println("If you want to exit the application type EXIT, else press L to log in or R to create a new account");
                            answer = fromKeyboard.next(); //Απάντηση του χρήστη για το αν θέλει να συνδεθεί, να εγγραφεί ή να βγει από την εφαρμογή
                            if(answer.toUpperCase().equals("EXIT")) {
                                System.out.println("Thank you for using our application. See you soon " + reg.getUsername());
                                System.exit(0);
                            }
                        } else {
                            System.out.println("There is already an account with that username. Please try again");
                        }
                    } while (!flag);
                }


            } while (answer.equals("R"));

            //Όταν έχει επιλεχθεί να γίνει σύνδεση στον λογαριασμό
            if (answer.equals("L")) {
                do {
                    System.out.print("Username: ");
                    userName = fromKeyboard.next(); //Το username με το οποίο θα συνδεθεί ο χρήστης
                    System.out.print("Password: ");
                    userPass = fromKeyboard.next(); // Το password με το οποίο θα συνδεθεί ο χρήστης

                    log = new LogIn(userName, userPass); //Δημιουργία αντικειμένου τύπου LogIn
                    log.addCredits();

                    isUser = log.accCheck(userName, userPass);
                    if (isUser) {
                        System.out.println("Hi " + log.getUsername());
                    } else {
                        System.out.println("Username and password don't match.Please try again!");
                    }
                } while (!isUser);
                whatUser = log.whatUser(userName, userPass, "user");
                if (whatUser.equals("user")) {
                    System.out.println("You are user");
                } else if (whatUser.equals("provider"))
                    System.out.println("You are provider");

                String choice,propName,newPropName;
                int key;
                boolean has;

                /**
                 * ΟΤΑΝ Ο ΧΡΗΣΤΗΣ ΕΙΝΑΙ ΠΑΡΟΧΟΣ(PROVIDER)
                 */

                if (whatUser.equals("provider")) {
                    do {
                        choice = prov.menuProvider(); //Η επιλογή του παρόχου από του μενού

                        //Όταν η επιλογή του παρόχου είναι η προσθήκη καταλύματος
                        if (choice.equals("1")) {
                            prov.newProp2(log.getUsername());
                            prov.reNewFile2(fileP);
                            countProp++;
                        }
                        //Όταν η επιλογή του παρόχου είναι η επεξεργασία καταλύματος
                        if (choice.equals("2")) {
                            has = prov.hasProps(log.getUsername());
                            if (has){
                                prov.showMyProps2(log.getUsername());
                                System.out.println("Type the number of property above to edit.");
                                key = fromKeyboard.nextInt();
                                propName = prov.getPropName2(key);
                                System.out.println(propName);
                                prov.editProps2(key);
                                newPropName = prov.getPropName2(key);
                                System.out.println(newPropName);
                                user.editRevName(propName,newPropName);
                                prov.reNewFile2(fileP);
                                user.reNewFile(fileR);

                            }
                            else
                                System.out.println("No properties to edit.");
                        }
                        //Όταν η επιλογή του παρόχου είναι η διαγραφή καταλύματος
                        if (choice.equals("3")) {
                            has = prov.hasProps(log.getUsername());
                            if(has){
                                prov.showMyProps2(log.getUsername());
                                System.out.println(" Type the number of property above to delete");
                                key = fromKeyboard.nextInt();
                                propName = prov.getPropName2(key);
                                prov.deleteProp(key);
                                user.deletePropRev(propName);

                                prov.reNewFile2(fileP);
                                user.reNewFile(fileR);




                            }
                            else
                                System.out.println("No properties to delete.");
                        }
                        //Όταν η επιλογή του παρόχου είναι η προβολή Dashboard
                        if (choice.equals("4")) {
                            has = prov.hasProps(log.getUsername());
                            if(has){
                                display.dashboardProvider(prov.getProperties(),log.getUsername(),user.getProperties(),user.getRate(),prov.getNames());
                                System.out.println("Type the number of property above to see all information, else press 0 to move to the menu.");

                                key = fromKeyboard.nextInt();
                                if (key != 0) {
                                    propName = prov.getPropName2(key);
                                    display.displayProperty(prov.getProperties(),propName,user.getRate(),user.getUsers(),user.getRev(),user.getProperties());
                                }

                            }
                            else
                                System.out.println("Nothing to show. No properties yet.");
                        }
                    } while (!choice.toUpperCase().equals("LOGOUT"));
                    System.out.println("Thank you for using our app. See you again " + log.getUsername());

                }

                /**
                 * ΟΤΑΝ Ο ΧΡΗΣΤΗΣ ΕΙΝΑΙ ΑΠΛΟΣ ΧΡΗΣΤΗΣ (USER)
                 */

                if(whatUser.equals("user")){
                    do{
                        choice= user.menuUser(); //Η επιλογή του χρήστη από το μενού

                        //Όταν η επιλογή του χρήστη είναι αναζήτηση καταλύματος
                        if(choice.equals("1")){
                            prov.searchProps2();
                        }
                        //Όταν η επιλογή του χρήστη είναι εισαγωγή νέας αξιολόγησης
                        if(choice.equals("2")){
                            prov.printProps2();
                            System.out.println("For which property you want to add a review?");
                            key = fromKeyboard.nextInt();
                            propName = prov.getPropName2(key);
                            has = user.hasRevs(propName,log.getUsername());
                            if (has){
                                System.out.println("You already have a review for this property.Delete it or edit from the Menu below.");
                            }else
                            {
                                user.newReview(propName,log.getUsername());
                                user.reNewFile(fileR);
                            }

                        }
                        //Όταν η επιλογή του χρήστη είναι επεξεργασία κάποιας αξιολόγησης
                        if(choice.equals("3")){
                            display.showReviews(prov.getProperties(),log.getUsername(),user.getProperties(),user.getUsers(),user.getRate(),user.getRev());
                            System.out.println("For which property you want to edit your review?");
                            key = fromKeyboard.nextInt();
                            propName = prov.getPropName2(key);
                            has = user.hasRevs(propName,log.getUsername());
                            if(has){
                                user.editReviews(propName,log.getUsername());
                                user.reNewFile(fileR);
                            }else {
                                System.out.println("You don't have a review for this property, so you cant edit.");
                            }

                        }
                        //Όταν η επιλογή του χρήστη είναι διαγραφή κάποιας αξιολόγησης
                        if(choice.equals("4")){
                            System.out.println(" For which property you want to delete your review?");
                            display.showReviews(prov.getProperties(),log.getUsername(),user.getProperties(),user.getUsers(),user.getRate(),user.getRev());
                            key = fromKeyboard.nextInt();

                            propName = prov.getPropName2(key);
                            has = user.hasRevs(propName, log.getUsername());

                            if(has){
                                user.deleteRev(propName,log.getUsername());
                                user.reNewFile(fileR);
                            }else {
                                System.out.println("You don't have a review for this property, so you cant delete.");
                            }
                        }
                        //Όταν η επιλογή του χρήστη είναι η προβολή Dashboard
                        if (choice.equals("5")){
                            display.dashboardUser(prov.getProperties(),log.getUsername(),user.getRate(),user.getUsers(),user.getProperties());
                            System.out.println("Type the number of property above to see all information, else press 0 to move to the menu.");
                            key = fromKeyboard.nextInt();
                            if (key != 0) {
                                propName = prov.getPropName2(key);
                                display.displayProperty(prov.getProperties(),propName,user.getRate(),user.getUsers(),user.getRev(),user.getProperties());
                            }
                        }
                    }while(!choice.toUpperCase().equals("LOGOUT"));
                    //Οταν γίνεται αποσύνδεση από τον λοαγαριασμό
                    System.out.println("Thank you for using our app. See you again " + log.getUsername());

                }
            }


        }

    }
}