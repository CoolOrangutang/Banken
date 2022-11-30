public class Customer extends Bank {

    String name;
    int personnummer;
    Account account;

    public Customer(String newName, int newPersonnum){
        name = newName;
        personnummer = newPersonnum;
        account = new Account(this, 0);
    };

    public String getName(){
        return this.name;
    };

    public Account getAccount(){return this.account;};

    public String toStringCustomer(){
        return name + " " + personnummer;
    };

}
