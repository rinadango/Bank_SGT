import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bank{

    public static ArrayList<User> listOfPeople = new ArrayList<>();

    // Object of a Scanner used throughout the code
    public static Scanner scan = new Scanner(System.in);

    public static User createNewUser() {

        System.out.println("\n Welcome to the Registration window\n");

        System.out.println("Enter name, balance and password");

        String name = scan.next();
        int balance = scan.nextInt();
        String pws = scan.next();

        return new User(name, balance, pws);
    }

    public static void showUser(User user){
        System.out.println("Account number: " + user.getAccountNumber() + ", PWS: " + user.getPws() + "\n");
    }

    public static void toRegister(User user){

        listOfPeople.add(user);

    }

    public static void toDebit(String id, int amountToAdd){

        //int newNewBalance = 0;

        User gottenUser = getUserBasedOnId(id);

        try{
            assert gottenUser != null;
            if(gottenUser.getBalance() > 0){
                int currentBalance = gottenUser.getBalance();
                int newBalance = currentBalance + amountToAdd;

                gottenUser.setBalance(newBalance);

                //newNewBalance += newBalance;
            } else{
                System.out.println("Insufficient funds");}
        } catch(NullPointerException e){
            System.out.println("No such user exist!");
        }

        //return newNewBalance;
    }

    public static void toCredit(String id, int amountToRemove){

        //int newNewBalance = 0;

        User gottenUser = getUserBasedOnId(id);

        try{
            assert gottenUser != null;
            if(gottenUser.getBalance() >= 0){
                int currentBalance = gottenUser.getBalance();
                int newBalance = currentBalance - amountToRemove;

                gottenUser.setBalance(newBalance);

                //newNewBalance += newBalance;
            } else{
                System.out.println("Insufficient funds");}
        } catch(NullPointerException e){
            System.out.println("No such user exist!");
        }

        //return newNewBalance;
    }


    // Is user in systems based on ID
    public static void isUserInSystem(String id){

        String gottenID = null;
        for (User listOfPerson : listOfPeople) {
            if(Objects.equals(id, String.valueOf(listOfPerson.id))){
                gottenID = id;
            }
        }

        if(gottenID == id){
            System.out.println("User of ID: " + id + " EXIST in the system");
        } else {
            System.out.println("User of ID: " + id + " does NOT EXIST in the system");
        }

        //User user = getUserBasedOnId(id);

        //assert user != null;
        //if(listOfPeople.contains(user)){
        //    System.out.println("User of ID: " + user.id + " EXIST in the system");
        //} else {
        //    System.out.println("User of ID: " + user.id + " does NOT EXIST in the system");
        //}
    }

    public static void toRemoveAndReplaceUser(String id, User user){

        int indexOfPerson = 0;

        for (User listOfPerson : listOfPeople) {
            if (id.equals(String.valueOf(listOfPerson.id))){

                indexOfPerson = listOfPeople.indexOf(listOfPerson);

                //listOfPeople.remove(listOfPerson);
            }
        }

        //listOfPeople.remove(indexOfPerson);

        listOfPeople.set(indexOfPerson, user);

        //assertThat(aList).isEqualTo(EXPECTED);

    }

    // Get user based on ID
    public static User getUserBasedOnId(String userId){

        User foundUser = null;
        for (User listOfPerson : listOfPeople) {
            boolean equals = userId.equals(String.valueOf(listOfPerson.id));
            if(equals){
                foundUser = listOfPerson;
            }
        }
        return foundUser;
    }


    /**
     * Prints all the people from the list of User
     */
    public static void userPrinter() {
        System.out.println();
        System.out.println("Number of current USERS: " + listOfPeople.size());
        for (User user : listOfPeople) {
            System.out.println("ID: " + user.id + " | Account number: " + user.getAccountNumber() + " | User name: " + user.getName() +
                    " | User balance: " + user.getBalance());
        }
        System.out.println();

    }


}