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
     int antalKunder = kunder.toArray().length;

    //Denna metod tar hand om Menyn och skapar en UI som användaren kan använda.
    public void Menu(){

            Scanner inputScanner = new Scanner(System.in);

            System.out.println();
            System.out.println("Pick an option.");
            System.out.println("------------------------");
            System.out.println("1. Register customer");
            System.out.println("2. Create account.");
            System.out.println("3. Show user count.");
            System.out.println("4. Search after.");
            System.out.println("5. Change balance. ");
            System.out.println("6. Print customers. ");
            //Fixa så att Create acc är avstängt tills man gör en customer

            try {
                int choice = inputScanner.nextInt();

                if(choice > 6){
                    System.out.println("Please pick a valid option.");
                    try {
                        Thread.sleep(800);
                    } catch (Exception u) {}
                    Menu();
                }

                switch(choice){
                    case 1:
                        createCustomer();
                        break;
                    case 2:
                        createAccount();
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
                    case 6:
                        printCustomers();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Please pick a valid option.");
                try {
                    Thread.sleep(2000);
                } catch (Exception u) {}
                Menu();
            }
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

         } catch (Exception e) {
             createCustomer();
         }

        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        Menu();
    }
    //Skapar en avändare för banken.
     void createAccount(){

        if(konton.size() == 0){
            System.out.println("Sorry, du måste göra ett registrera dig innan du gör ett konto!");
            try {Thread.sleep(2000);} catch
            (InterruptedException e) {throw new RuntimeException(e);}
            Menu();
        }

         try {
             System.out.println();
             Scanner inputScanner = new Scanner(System.in);
             System.out.println("Account owner:");
             String ägarNamn = inputScanner.nextLine();
             Customer ägare = findCustomer(ägarNamn);

             if (ägare == null) {
                 System.out.println("EYo! du ljög han finns inte");
                 createAccount();
             }

             System.out.println("Saldo:");
             int newSaldo = inputScanner.nextInt();
             int id = konton.size() + 1;
             Account nyAccount = new Account(ägare, newSaldo, id);

             ägare.addAccount(nyAccount); //fix
             konton.add(nyAccount);

             System.out.println("Namn:" + ägare);
             System.out.println("Saldo:" + newSaldo);
             System.out.println("Konto sparad!");
         } catch (Exception e) {
             createAccount();
         }


        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        Menu();
    }

    //Print UserCount.
     void printUserCount(){
        System.out.println("Antal användare: " + konton.size());
        Menu();
    }

     Customer findCustomer(String ägarNamn){
        for(Customer customer : kunder) {
            if(customer.getName().equals(ägarNamn)) {
                return customer;
            }
        }
        return null;
    };

     Customer findAccount(String ägarNamn){
        for (Customer customer : kunder){
            if(customer.getName().equals(ägarNamn)){
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

                 try {Thread.sleep(2000);} catch
                 (InterruptedException e) {throw new RuntimeException(e);}
             }
             ägare.printAccountsInfo();

         } catch (Exception e) {}
         Menu();
    };


    void changeBalance(){

        try {
            Scanner inputScanner = new Scanner(System.in);

            System.out.println("Sök efter Användare:");
            String searchName = inputScanner.nextLine();
            Customer ägare = findCustomer(searchName);
            if (ägare == null) {
                System.out.println("Användar namnet som du söker har inget konto.");
            }
            System.out.println(ägare.getAccounts());




            /*
            int adderadePengar = inputScanner.nextInt();

            ArrayList<Account> konton = ägare.getAccounts();
            Account konton;

            int nutidaSaldo = ägare.getAccounts().getSaldo();
            int totalaSaldo = adderadePengar + nutidaSaldo;

            konton.setSaldo(totalaSaldo);
            System.out.println(konton.getSaldo());


            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
            Menu();
             */

        } catch (Exception e) {
            System.out.println("Det gick inte försök igen!");
            try {Thread.sleep(2000);} catch
            (InterruptedException b) {throw new RuntimeException(e);}
            changeBalance();
        }
    };


    void printCustomers(){
        int index = 1;
        for (Customer customer : kunder) {
            System.out.println( index + " : " + customer);
            index++;

        }
        try {Thread.sleep(2000);} catch
        (InterruptedException e) {throw new RuntimeException(e);}

        Menu();
    };

    void findIdAccount(){

        int id = Account.getId();
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Sök efter Användare:");
        String searchName = inputScanner.nextLine();
        Customer ägare = findCustomer(searchName);
        if (ägare == null) {
            System.out.println("Användar namnet som du söker har inget konto.");
        }

        System.out.println(ägare.getAccounts());




    }
}


