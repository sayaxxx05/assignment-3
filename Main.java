public enum TransactionType {
    DEPOSIT,
    WITHDRAWAL
}

public class Amount {
    private double amount;
    private TransactionType transactionType;

    public Amount(double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}


import java.util.ArrayList;
import java.util.List;

public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Amount> transactions;

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            Amount transaction = new Amount(amount, TransactionType.DEPOSIT);
            transactions.add(transaction);
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            Amount transaction = new Amount(amount, TransactionType.WITHDRAWAL);
            transactions.add(transaction);
            balance -= amount;
        } else if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for Account: " + accountNumber);
        for (Amount transaction : transactions) {
            System.out.println(transaction.getTransactionType() + ": $" + transaction.getAmount());
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}


public class Main {
    public static void main(String[] args) {
        PersonalAccount account = new PersonalAccount(12345, "John Doe");
        
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(100);
        
        System.out.println("Current Balance: $" + account.getBalance());
        account.printTransactionHistory();
    }
}


/**
 * Represents a personal bank account.
 */
public class PersonalAccount {
    // Account details
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Amount> transactions;

    /**
     * Initializes a new personal account.
     * 
     * @param accountNumber the unique account number
     * @param accountHolder the name of the account holder
     */
    public PersonalAccount(int accountNumber, String accountHolder) {
        // Implementation...
    }

    // Other methods with documentation...
}
