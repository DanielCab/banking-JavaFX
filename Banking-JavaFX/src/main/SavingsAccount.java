package src.main;

import java.util.ArrayList;

public class SavingsAccount extends Account{

    
    // Initializing Instance Variables 

    private double InterestRate;
    public double SavingsIntAmount;

    // Initializing Constructor 

    public SavingsAccount(String AccountName, String AccountNumber, double AccountBalance, ArrayList<Transaction> transactions, double InterestRate, Object object) {
        super(AccountName, AccountNumber, AccountBalance, transactions);

        this.InterestRate = InterestRate;
        
    }

    // Getter for interest Rate 

    public double getInterestRate() {
        return InterestRate;
    }

    // Setter for Interest Rate

    public void setInterestRate(double interestRate) {
        this.InterestRate = interestRate;
    }
    // Method to pay interest

    public void PayInterest() {
        double InterestAmount = getAccountBalance() * (InterestRate);
        Deposit(InterestAmount);
    }

// Method to deposit funds 
@Override
public void Deposit(double amount) {
    if (amount > 0) {
        setAccountBalance(amount + getAccountBalance());
      
    }
}

// Method to withdraw funds
@Override
public void Withdraw(double amount) {
    if (amount > 0 && amount <= getAccountBalance()) { 
        setAccountBalance(getAccountBalance() - amount);
    
    }
}

// Override toString() method to display account information and include interest rate.
       @Override
       public String toString() {
           return super.toString() + " | Interest Rate: " + getInterestRate() + "%";
       }

}

    
