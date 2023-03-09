import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {

        User premadeUser1 = new User("Eliot",5000,"123");
        User premadeUser2 = new User("Barbara",7050,"123");

        Bank.listOfPeople.add(premadeUser1);
        Bank.listOfPeople.add(premadeUser2);

        // Create new User object from terminal input
        User newUser = Bank.createNewUser();
        // Show created user details
        Bank.showUser(newUser);
        // Add newly created User object to ArrayList called listOfPeople
        Bank.toRegister(newUser);
        // Print all users
        Bank.userPrinter();

        Scanner scanner = Bank.scan;

        // For account number using ID checking
        String enterId = scanner.next();

       // int gottenAccountNumber = 0;
        for (User user : Bank.listOfPeople) {
            System.out.println(user.getAccountNumber());
        }
        //System.out.println(gottenAccountNumber);


       // if (enterId.equals(String.valueOf(user.id))) {
        //    gottenAccountNumber += user.getAccountNumber();
       // } else {
        //    System.out.println("Bad");
        //}

        Bank.toDebit(enterId, 20);

        Bank.toCredit(enterId, 15);

        Bank.userPrinter();

        User anotherUser = Bank.createNewUser();
        Bank.showUser(anotherUser);
        Bank.toRemoveAndReplaceUser(enterId, anotherUser);

        Bank.userPrinter();

        //Bank.isUserInSystem();

    }

        /**
         *  while(true) {
         *
         *             // For ID checking
         *             String enterId = scanner.next();
         *
         *             for (User user : Bank.listOfPeople) {
         *                 System.out.println(user.id);
         *
         *                 if (enterId.equals(String.valueOf(user.id))) {
         *                     System.out.println(user.getName());
         *                 } else {
         *                     System.out.println("Bad");
         *                     break;
         *                 }
         *             }
         *         }
         */


}
