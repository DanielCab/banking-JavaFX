package src.main;


import java.util.Comparator;

public class BalanceComparator implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
       return Double.compare( o1.getAccountBalance(), o2.getAccountBalance() );
    }
    
      
}
