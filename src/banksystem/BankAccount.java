package banksystem;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    //instance variables
    private int number;
    private double amount;
    private String name;
    private boolean active;
    private List<String> transactions;
    //static or class variable
    private static int accountsOpened;
    
    public BankAccount() {
        active = true;
        transactions = new ArrayList();
        transactions.add("Account created, Balance:$0");
        accountsOpened++;
    }
    
    public BankAccount(String name, int number){
        this();//Must be placed first
        this.name = name;
        this.number = number;
    }

    public BankAccount(String name, int number, double amount){
        this(name, number);
        this.amount = amount;
    }
    
    public BankAccount(BankAccount account){
        accountsOpened++;
        this.name = account.name;
        this.number = account.number;
        this.active = account.active;
        this.amount = account.amount;
        this.transactions = new ArrayList(account.transactions);
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        transactions.add("Changed name to:"+name);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    private void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public static int getAccountsOpened() {
        return accountsOpened;
    }

    public void withdraw(double withdraw) {
        if (withdraw > 0) {
            if (withdraw < amount) {
                this.amount = this.amount - withdraw;
                transactions.add("Withdrew $"+withdraw+", Balance:$"+this.amount);
            } else {
                transactions.add("Withdrew $"+amount+", Balance:$0");
                this.amount = 0;
            }
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.amount = this.amount + amount;
            transactions.add("Added $"+amount+", Balance:$"+this.amount);
        }
    }

    public void printTransactions(){
        //for-enhanced
//        for(String transaction:transactions){
//            System.out.println(transaction);
//        }
        //for-traditional
        for(int i = 0;i<transactions.size();i++){
            System.out.println(transactions.get(i));
        }
    }
    
    @Override
    public String toString() {
        return "BankAccount{" + "number=" + number + ", amount=" + amount + ", name=" + name + ", active=" + active + '}';
    }

}
