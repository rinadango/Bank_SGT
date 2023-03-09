import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank{

    public static ArrayList<User> listOfPeople = new ArrayList<>();

    // Object of a Scanner used throughout the code
    public static Scanner scan = new Scanner(System.in);

    public static User createNewUser() {

        System.out.println("\n Welcome to the Registration window\n");

        System.out.println("Enter name and then balance");

        String name = scan.next();
        int balance = scan.nextInt();
        String pws = scan.next();

        return new User(name, balance, pws);
    }

    public static void showUser(User user){
        System.out.println("ID: " + user.id + ", PWS: " + user.getPws());
    }

    public static void toRegister(User user){

        listOfPeople.add(user);

    }

    public static void toDebit(String id, int amountToAdd){

        //int newNewBalance = 0;

        User gottenUser = null;
        for (User user : listOfPeople) {
            if(id.equals(String.valueOf(user.id))){
                gottenUser = user;
            }
        }

        try{
            assert gottenUser != null;
            if(gottenUser.getBalance() < 0){
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

        User gottenUser = null;
        for (User user : listOfPeople) {
            if(id.equals(String.valueOf(user.id))){
                gottenUser = user;
            }
        }

        try{
            assert gottenUser != null;
            if(gottenUser.getBalance() < 0){
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


    public static void isUserInSystem(){

        User user = getUserBasedOnId();

        if(listOfPeople.contains(user)){
            System.out.println("User of ID: " + user.id + " EXIST in the system");
        } else{
            System.out.println("User of ID: " + user.id + " does NOT EXIST in the system");
        }

    }

    public static User getUserBasedOnId(){

        System.out.println("Enter a user ID to search");
        String userIdToSearch = scan.next();

        User foundUser = null;
        for (User listOfPerson : listOfPeople) {
            boolean equals = userIdToSearch.equals(String.valueOf(listOfPerson.id));
            if(equals){
                foundUser = listOfPerson;
            }
        }
        return foundUser;
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