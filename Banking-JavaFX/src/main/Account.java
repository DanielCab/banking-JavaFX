package src.main;

import java.util.ArrayList;


abstract class Account {

        private String AccountName;
        private String AccountNumber;
        private double AccountBalance;
        private ArrayList<Transaction> transactions;
        

public Account(String AccountName, String AccountNumber, double AccountBalance, ArrayList<Transaction> transactions) {
    this.AccountName = AccountName;
    this.AccountNumber = AccountNumber;
    this.AccountBalance = AccountBalance;
    this.transactions = new ArrayList<>();
}

 // Getters and Setters for Instance Variables 



public String getAccountName() { 
    return AccountName;
}

public void setAccountName(String AccountName) {
    this.AccountName = AccountName;
}

public String getAccountNumber() {
    return AccountNumber;
}

 public void setAccountNumber(String AccountNumber) {
    this.AccountNumber = AccountNumber;
}


 public double getAccountBalance() {
    return AccountBalance;
}


 public void setAccountBalance(double AccountBalance) {
    this.AccountBalance = AccountBalance;
}

public ArrayList<Transaction> getTransactions() {
    return transactions;
}


 public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
 }


// Method to deposit funds 

 public void Deposit(double amount) {
  
}

// Method to withdraw funds

public void Withdraw(double amount) {
  
}



// Override toString() method to display account information

@Override
public String toString() {
    return " \n Account Name: " + AccountName + " |  Account Number: " + AccountNumber + " |  Balance: $ " + AccountBalance;
    }
}

   
