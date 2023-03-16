public class Customer extends Bank {

    String name;
    int personnummer;
    private Account account;

    public Customer(String newName, int newPersonNum){
        name = newName;
        personnummer = newPersonNum;
        account = new Account(this, 0);
    };

    public String getName(){
        return this.name;
    };

    public Account getAccount(){
        return this.account;
    };

    public void setAccount(Account account) {
        this.account = account;
    }

    public String toStringCustomer(){
        return name + " " + personnummer;
    };


}
