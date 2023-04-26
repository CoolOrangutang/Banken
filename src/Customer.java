import java.util.ArrayList;

public class Customer{

    String name;
    int personnummer;
    private ArrayList<Account> accounts;

    public Customer(String newName, int newPersonNum){
        name = newName;
        personnummer = newPersonNum;
        accounts = new ArrayList<>();
    };

    public String getName(){
        return this.name;
    };

    public ArrayList<Account> getAccounts(){
        return this.accounts;
    };

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void printAccountsInfo() {
        int i = 0;
        for (Account account : accounts) {
            i++;
            System.out.println( i + "." + account);
        }
    }

    @Override
    public String toString(){
        return name + " ; " + "Personnummer:" + personnummer;
    };
}
