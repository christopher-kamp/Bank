package banksystem;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {

    public static List<String> lista;
    
    public static void main(String[] args) {
//        List<String> lista = fereLista();
//        System.out.println("Size of list:"+lista.size());
//        String thesi0 = lista.get(0);
//        System.out.println(thesi0);

/* This is the way to call method printLista if the method is an instance method
//BankSystem b = new  BankSystem();
//b.printLista(lista);
*/
//        printLista(lista);
        
        BankAccount account1 = new BankAccount();
        account1.setName("Ethniki");
        account1.deposit(400);
        account1.withdraw(50);
        account1.withdraw(50);
        BankAccount account3 = new BankAccount(account1);
        account3.deposit(400);
        System.out.println("Account1===="+account1);
        System.out.println("Account3===="+account3);
//        System.out.println(account1);
//List<String> names = new ArrayList();
//names.add("Nick");
//names.add("Kathrine");
        BankAccount account2 = new BankAccount("Peiraios", 100);
        System.out.println("Account2===="+account2);
        account2.deposit(100);
        System.out.println("Accounts created:"+BankAccount.getAccountsOpened());
        
        System.out.println("\n***Printing Account1 Transactions***");
        account1.printTransactions();
        System.out.println();
        //Creating a new Person with BankAccount
        Person p1 = new Person("Jack", 30);
        p1.addBankAccount(account1);
        System.out.println(p1);//This line prints the toString() method of Person class
        Person p2 = new Person("Mary", 25);
        //Add Jack's account to Mary's
        p2.addBankAccount(p1.getBankAccounts().get(0));
        //Mary deposits 100$
        p2.getBankAccounts().get(0).deposit(100);
        //Jack withdraws 50$
        p1.getBankAccounts().get(0).withdraw(50);
        //Print all the transactions of Mary's account
        System.out.println("\n****Printing Mary's transactions from BandAccount 0****");
        p2.getBankAccounts().get(0).printTransactions();
        p1.printBankAccounts();
        p1.printTotalAmount();
        
        /*
        Find the sum of all the BankAccounts of one person
        */
        
    }
    
    
    
    
    
    
    public static void printLista(){
        for(int i = 0;i<lista.size();i++){
            System.out.println((i+1) + ". "+lista.get(i));
        }
    }
    public static void printLista(List<String> inputList){
        for(int i = 0;i<inputList.size();i++){
            //System.out.printf("index [%d]: [%s]\n", i+1, lista.get(i));    
//            String thesi = lista.get(i);
            System.out.println((i+1) + ". "+inputList.get(i));
        }
    }
    public static List<String> fereLista(){
        List<String> myList = new ArrayList();
        
        myList.add("stoixeio 1");
        myList.add("stoixeio 2");
        myList.add("stoixeio 3");
        return myList;
    }
    
}
