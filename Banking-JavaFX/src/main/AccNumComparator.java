package src.main;

import java.util.Comparator;


public class AccNumComparator implements Comparator<Account>{
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getAccountNumber().compareTo(o2.getAccountNumber());
    }
    
}
