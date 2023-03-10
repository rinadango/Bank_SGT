import javax.sound.midi.Soundbank;
import java.util.Objects;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {

        User premadeUser1 = new User("Eliot",5000,"123");
        User premadeUser2 = new User("Barbara",7050,"123");

        Bank.listOfPeople.add(premadeUser1);
        Bank.listOfPeople.add(premadeUser2);

        // For testing
        Bank.userPrinter();

        Scanner scanner = Bank.scan;

        System.out.println("Would you like to LOGIN (1) or REGISTER (2)");
        int selectionInput = scanner.nextInt();
        if(selectionInput == 1) {
            // LOGIN
            System.out.println("Enter ACCOUNT NUMBER and PWS");
            int selectionInputLOGIN_ACC = scanner.nextInt();
            String selectionInputLOGIN_pws = scanner.next();
            for (User user : Bank.listOfPeople) {
                if (selectionInputLOGIN_ACC == user.getAccountNumber() && Objects.equals(user.getPws(), selectionInputLOGIN_pws)) {
                    while(true){
                        System.out.println("For DEBIT - 11 | For CREDIT - 22 | For CHECKING BALANCE - 33 | LOG OUT - 00");
                        int selectionInputLOGIN_ACC_DEBIT_CREDIT = scanner.nextInt();
                        if(selectionInputLOGIN_ACC_DEBIT_CREDIT == 11){

                            System.out.println("Enter amount to ADD");
                            int amountADD = scanner.nextInt();

                            // Testing before
                            System.out.println("Your balance before: "+ user.getBalance());
                            Bank.toDebit(String.valueOf(user.id), amountADD);
                            // Testing after
                            System.out.println("Your balance after: "+ user.getBalance());
                        }
                        else if(selectionInputLOGIN_ACC_DEBIT_CREDIT == 22){

                            System.out.println("Enter amount to DEDUCT");
                            int amountREMOVE = scanner.nextInt();

                            // Testing before
                            System.out.println("Your balance before: "+ user.getBalance());
                            Bank.toCredit(String.valueOf(user.id), amountREMOVE);
                            // Testing after
                            System.out.println("Your balance after: "+ user.getBalance());
                        } else if(selectionInputLOGIN_ACC_DEBIT_CREDIT == 33){
                            System.out.println("Your CARD BALANCE is: " + user.getBalance());
                        }
                        else if(selectionInputLOGIN_ACC_DEBIT_CREDIT == 00){
                            System.out.println("EXITING");
                            break;
                        }
                    }
                }
           }
       } else if (selectionInput == 2) {
           // REGISTER

           // Create new User object from terminal input
           User newUser = Bank.createNewUser();
           // Show created user details
           Bank.showUser(newUser);
           // Add newly created User object to ArrayList called listOfPeople
           Bank.toRegister(newUser);

           // Print all users for testing
           Bank.userPrinter();

       } else {
           System.out.println("Invalid selection. EXITING");
       }


        // / FOR CHECKING OTHER FUNCTIONALITY
        Bank.userPrinter();

        // Dummy user
        User anotherUser = Bank.createNewUser();

        System.out.println("Enter user ID (NOT ACCOUNT NUMBER) to be replaced");
        String enterId = scanner.next();
        Bank.toRemoveAndReplaceUser(enterId, anotherUser);

        Bank.userPrinter();

        System.out.println("Check if user is in the SYSTEM based on ID");
        String idToCheck = scanner.next();
        Bank.isUserInSystem(idToCheck);


        // TESTER CODE BELOW

        /**
         *
         * // Create new User object from terminal input
         *         User newUser = Bank.createNewUser();
         *         // Show created user details
         *         Bank.showUser(newUser);
         *         // Add newly created User object to ArrayList called listOfPeople
         *         Bank.toRegister(newUser);
         *         // Print all users
         *         Bank.userPrinter();
         *
         *
         *         // For account number using ID checking
         *         String enterId = scanner.next();
         *
         *        // int gottenAccountNumber = 0;
         *         for (User user : Bank.listOfPeople) {
         *             System.out.println(user.getAccountNumber());
         *         }
         *
         *         Bank.toDebit(enterId, 20);
         *         Bank.toCredit(enterId, 15);
         *
         *         Bank.userPrinter();
         *
         *         User anotherUser = Bank.createNewUser();
         *         Bank.showUser(anotherUser);
         *         Bank.toRemoveAndReplaceUser(enterId, anotherUser);
         *
         *         Bank.userPrinter();
         *
         *         //Bank.isUserInSystem();
         *
         */


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
