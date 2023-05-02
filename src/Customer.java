import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("Hittade dessa konton kopplade till bitchen '" + this.name + "': ");
        for (Account account : accounts) {
            System.out.println(account);
        }
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }

    @Override
    public String toString(){
        return name + " ; " + "Personnummer:" + personnummer;
    };
}
