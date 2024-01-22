package src.main;

import java.time.LocalDate;


public class Transaction {
    
    public LocalDate TransactionDate;
    public char TransactionType;
    public double TransactionAmount;
    public double UpdatedBalance;
    public String TransactionDetails;


    public Transaction(LocalDate TransactionDate, char TransactionType, double UpdatedBalance, double TransactionAmount, String TransactionDetails) {

        this.TransactionAmount = TransactionAmount;
        this.TransactionType = TransactionType;
        this.TransactionDate = TransactionDate;
        this.UpdatedBalance = UpdatedBalance;
        this.TransactionDetails = TransactionDetails;
    }


    // Getters and Setters for Transaction class.
    

    public LocalDate getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(LocalDate TransactionDate) {
        this.TransactionDate = TransactionDate;
    }
    public char getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType( char TransactionType){
        this.TransactionType = TransactionType;
    }

    public double getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(double TransactionAmount) {
        this.TransactionAmount = TransactionAmount;
    }

    public double getUpdatedBalance() {
        return UpdatedBalance;
    }

    public void setUpdatedBalance(double UpdatedBalance) {
        this.UpdatedBalance = UpdatedBalance;
    }

    public String getTransactionDetails() {
        return TransactionDetails;
    }

    public void setTransactionDetails(String TransactionDetails) {
        this.TransactionDetails = TransactionDetails;
    }

    // Override toString() method to display transaction information for chosen account type.

        @Override
            public String toString() {
                return "Transaction Date: " + LocalDate.now() +
                    "\nTransaction Type: " + getTransactionType() +
                    "\nTransaction Amount: " + getTransactionAmount() +
                    "\nUpdated Balance: " + getUpdatedBalance() +
                    "\nDescription: " + getTransactionDetails() +
                    "\n" +
                    "\n";
            }
        }

