package src.main;

import java.util.ArrayList;

public class ChequingAccount extends Account {

        private double OverdraftLimit;

        public ChequingAccount(String AccountName, String AccountNumber, double AccountBalance, ArrayList<Transaction> transactions, 
                    double OverdraftLimit) {

            super(AccountName, AccountNumber, AccountBalance, transactions);

            
            this.OverdraftLimit = OverdraftLimit;
            
            }


       // Getter and Setter for Instance Variables 

        public double getOverdraftLimit() {
            return OverdraftLimit;
        }

        public void setOverdraftLimit(double OverdraftLimit) {
            this.OverdraftLimit = OverdraftLimit;
        }

    // Overrides the withdraw method to account for negative number withdrawals.

    @Override
        public void Withdraw(double amount) {
            double totalBalance = ( getAccountBalance() + getOverdraftLimit());
        if (amount > 0 && amount <= getAccountBalance()) { 
                setAccountBalance(getAccountBalance() - amount);
            }
        else if (amount >= getAccountBalance() && amount <= totalBalance) {
            setAccountBalance((totalBalance - amount) * -1);
        }
}

        // Method to deposit funds 
        @Override
        public void Deposit(double amount) {
            if (amount > 0) {
                setAccountBalance(amount + getAccountBalance());
            
            }
        }

    // Override toString() method to display account information and include overdraft limit.

    @Override
    public String toString() {
        return super.toString() + " | Overdraft Limit: " + getOverdraftLimit();
    }




}