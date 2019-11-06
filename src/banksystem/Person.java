package banksystem;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<BankAccount> bankAccounts;//Aggregation because Person HAS-A bankAccount.

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public void addBankAccount(BankAccount account){
        if(bankAccounts == null){
            bankAccounts = new ArrayList();
        }
        //this.bankAccounts is a list of BankAccounts
        this.bankAccounts.add(account);
    }
    public BankAccount getBankAccountByName(String nameOfAccount){
        /*
        Ψάξε τους λογαριασμούς του instance που σε κάλεσε
        Αν το όνομα κάποιου λογαριασμού ισούται με nameOfAccount
        τότε επέστρεψε αυτόν τον λογαριασμό
        */
        List<BankAccount> tempList = new ArrayList<>();
        int i = 0;
        while(!bankAccounts.get(i).toString().contains(nameOfAccount)){
        tempList.add(bankAccounts.get(i));
        i++;
        }
        return bankAccounts.get(i);
    }
    
    public void printBankAccounts(){
        System.out.println("\n******Printing Details of Bank Accounts*****");
        int numberOfAccounts = bankAccounts.size();
        System.out.println(name + " has " + numberOfAccounts + " bankAccounts ");
       for(int i= 0;i<numberOfAccounts;i++){
           System.out.println((i+1) 
                   + ". BankAccount:name=" + bankAccounts.get(i).getName() 
                   + ", amount=$" + bankAccounts.get(i).getAmount());
       }
        System.out.println("1. details of bank account 1");
        System.out.println("2. details of bank account 2");
        System.out.println("******Finished Printing Details of Bank Accounts*****");
    }
    
    public void printTotalAmount(){
        double totalAmount = 0.0;
        for(BankAccount b: bankAccounts){
            totalAmount = totalAmount + b.getAmount();
        }
        System.out.println("The total amount is: " + totalAmount);
    }
    
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }
    
}
