package src.main;



import java.util.Comparator;


public class NameComparator implements Comparator<Account> {

    public int compare(Account o1, Account o2) {
        return o1.getAccountName().compareTo(o2.getAccountName());
    } 
        
}


