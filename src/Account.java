public class Account{

    Customer ägare;
    int saldo;
    int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSaldo(int nySaldo){
          this.saldo = nySaldo;
    };

    @Override
    public String toString() {
        return "ID: " + id + "; Pengar: " + saldo + "; Ägare " + ägare;
    }
}



