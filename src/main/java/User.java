import java.util.Random;
import java.util.UUID;

public class User {

    private String name;
    private int balance;
    public final UUID id;
    private String pws;

    // Instance of random class
    Random rand = new Random();
    private int accountNumber;

    public User(String name, int balance, String pws) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.accountNumber = (new Random()).nextInt(900000) + 100000;
        this.pws = pws;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }
}
