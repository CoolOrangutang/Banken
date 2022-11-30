import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    Customer hittadeKunden;

    Customer getCustomer(String name) {
        //Hitta kunden med namnet name
        return hittadeKunden;
    }

    public Bank(){};

     ArrayList<Account> konton = new ArrayList<Account>();
     ArrayList<Customer> kunder = new ArrayList<Customer>();

    //Denna metod tar hand om Menyn och skapar en UI som användaren kan använda.
    public void Menu(){

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Pick an option.");
        System.out.println("1. Create account.");
        System.out.println("2. Create customer.");
        System.out.println("3. Show user count.");
        System.out.println("4. Search after.");

        try {

            int choice = inputScanner.nextInt();
            switch(choice){
                case 1:
                    createAccount();
                    break;
                case 2:
                    createCustomer();
                    break;
                case 3:
                    printUserCount();
                    break;
                case 4:
                    searchingAcc();
                    break;
                case 5:
                    changeBalance();
                    break;
            }
        } catch (Exception e) {}
        inputScanner.next();
    }

     int GetIntInput(String prompt){
        return 0;
    }

    //Denna metod används för att skapa användarens bankkonto och sparar den.
     void createCustomer(){

         try {

             Scanner inputScanner = new Scanner(System.in);
             System.out.println("Name:");
             String newName = inputScanner.nextLine();
             System.out.println("Personnummer:");
             int newPersonNum = inputScanner.nextInt();
             Customer nyCustomer = new Customer(newName, newPersonNum);
             kunder.add(nyCustomer);
             System.out.println("Namn:" + nyCustomer.name +"; " + "Personnummer:" + nyCustomer.personnummer);
             System.out.println("Kund sparat!");

         } catch (Exception e) {}

        try {
            Thread.sleep(800);
        } catch (Exception e) {}
        Menu();
    }
    //Skapar en avändare för banken.
     void createAccount(){

         try {
             System.out.println();
             Scanner inputScanner = new Scanner(System.in);
             System.out.println("Account owner:");
             String ägarNamn = inputScanner.nextLine();
             Customer ägare = findCustomer(ägarNamn);

             if (ägare == null) {
                 System.out.println("EYo! du ljög han finns inte");
             }

             System.out.println("Saldo:");
             int newSaldo = inputScanner.nextInt();
             Account nyAccount = new Account(ägare, newSaldo);
             konton.add(nyAccount);
             System.out.println("Namn:" + ägare);
             System.out.println("Saldo:" + newSaldo);
             System.out.println("Konto sparad!");
         } catch (Exception e) {}

        try {
            Thread.sleep(800);
        } catch (Exception e) {}
        Menu();
    }

    //Print UserCount.
     void printUserCount(){
        System.out.println(konton.size());
    }

     Customer findCustomer(String ägarNamn){
        for(Customer customer : kunder) {
            if(customer.getName().equals(ägarNamn)){
                return customer;
            }
        }
        return null;
    };

     Customer findAccount(String ägarnNamn){
        for (Customer customer : kunder){
            if(customer.getName().equals(ägarnNamn)){
                return customer;
            }
        }
        return null;
    };
     void searchingAcc(){

         try {
             Scanner inputScanner = new Scanner(System.in);
             System.out.println("Sök efter konto:");
             String searchName = inputScanner.nextLine();
             Customer ägare = findCustomer(searchName);
             if (ägare == null) {
                 System.out.println("Användar namnet som du söker har inget konto.");
             }
             System.out.println(ägare.getAccount().toStringAccount());
         } catch (Exception e) {}
    };

    void changeBalance(){

        try {
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Sök efter konto:");
            String searchName = inputScanner.nextLine();
            Customer ägare = findCustomer(searchName);
            if (ägare == null) {
                System.out.println("Användar namnet som du söker har inget konto.");
            }
            System.out.println(ägare.getAccount().toStringAccount());

            System.out.println("Hur mycket vill du lägga till?");
            int totalaSaldo;
            int adderadePengar = inputScanner.nextInt();
            int nutidaSaldo = ägare.getAccount().getSaldo();
            totalaSaldo = adderadePengar + nutidaSaldo;
            ägare.account.setSaldo(totalaSaldo);
            System.out.println(ägare.getAccount().getSaldo());
            try {
                Thread.sleep(800);
            } catch (Exception e) {}
            Menu();

        } catch (Exception e) {}
    };
}


