public class Account extends Bank{

    Customer ägare;
    int saldo;

    public Account(Customer newÄgare, int newSaldo){
        ägare = newÄgare;
        saldo = newSaldo;
    };

    public String toStringAccount(){
        return ägare.getName() + " " + saldo;
    };

    public int getSaldo(){
        return saldo;
    };

    public void setSaldo(int nySaldo){
          this.saldo = nySaldo;
    };

}



