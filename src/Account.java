public class Account{

    Customer ägare;
    int saldo;
    static int id;

    public Account(Customer newÄgare, int newSaldo, int newId){
        ägare = newÄgare;
        saldo = newSaldo;
        id = newId;
    };

    public String toStringAccount(){
        return ägare.getName() + " " + saldo;
    };

    public int getSaldo(){
        return saldo;
    };

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Account.id = id;
    }

    public void setSaldo(int nySaldo){
          this.saldo = nySaldo;
    };

    @Override
    public String toString() {
        return "Pengar: " + saldo + "; Ägare " + ägare;
    }
}



