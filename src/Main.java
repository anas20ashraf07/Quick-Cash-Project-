//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.


         //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.

import java.util.Scanner;



public class Main {
    // A method to help in printing the detailed information of a specific user by index
    static void printuserdata(int i) {
        System.out.println("========== User Found ==========");
        System.out.println("ID:" + ids[i]);
        System.out.println("USERNAME:" + USERNAME[i]);
        System.out.println("Balance:" + balance[i]);
        System.out.println("Email Adress:" + emails[i]);
        System.out.println("Status:" + (isblocked[i] ? "Blocked" : "Active"));

    }

    static void showStatistics() {
        //show overall statistics (total users,total balances,blocked accounts....)
        System.out.println("========== Show Statistics ==========");
        int totalusers = ids.length;
        int activeusers = 0;
        int blockredusers = 0;
        double totaltransurfferd = 0;
        for (int i = 0; i < USERNAME.length; i++) {
            if (isblocked[i]) {
                blockredusers++;
            } else {
                activeusers++;
            }
        }
        for (double j : amountofsuctran) {
            totaltransurfferd += j;

        }
        System.out.println("TOTAL Users:" + totalusers);
        System.out.println("Active Acounts:" + activeusers);
        System.out.println("Blocked Acounts:" + blockredusers);
        System.out.println("Successful Transactions:" + successfultransactions);
        System.out.println("Faild Transactions:" + faildtransactions);
        System.out.println("Tolal Amount of Successful Transactions:" + totaltransurfferd);

    }

    static void searchUser() {
        //Searches for a user using 4 options(ID,FULLNAME,EMAIL,PHONE)
        System.out.println("==========  Search User ==========");
        System.out.println("Chose from (1-4)");
        System.out.println("1.Search by ID");
        System.out.println("2.Search by FULL NAME");
        System.out.println("3.Search by phone number");
        System.out.println("4.Email adress");
        int methods = input.nextInt();
        input.nextLine();
        boolean isfound = false;

        switch (methods) {
            case 1://Search by user id
                System.out.println("Enter ID to search:");
                int idsearch = input.nextInt();
                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == idsearch) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            case 2://Search by fullname(case-insensitive)
                System.out.println("Enter full name to search");
                String namesearch = input.nextLine();
                for (int i = 0; i < USERNAME.length; i++) {
                    if (USERNAME[i].equalsIgnoreCase(namesearch)) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            case 3://Search by phone number
                System.out.println("Enter phone number to search:");
                String phonesearch = input.nextLine();
                for (int i = 0; i < phones.length; i++) {
                    if (phones[i].equalsIgnoreCase(phonesearch)) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            case 4://Search by email(case-insensitive)
                System.out.println("Enter Email addres to search:");
                String EMAILSEARCH = input.nextLine();
                for (int i = 0; i < emails.length; i++) {
                    if (emails[i].equalsIgnoreCase(EMAILSEARCH)) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            default:
                System.out.println("INVALID CHOICE");
        }

        if (!isfound) {
            System.out.println("USER IS NOT FOUND");
        }


    }

    static void viewAllUsers() {
        //Shows a list of all users registered in the system
        System.out.println("========== View All Users ==========");
        // Check for empty arrays
        if (ids.length == 0) {
            System.out.println("NO USER FOUND");
            return;
        }
//loop goes through all users and print thier data
        for (int i = 0; i < ids.length; i++) {
            System.out.println("User:" + (i + 1));
            printuserdata(i);
        }


    }

    static void updateUser() {
        //Updates specific information about a selected user by entering their IDs
        System.out.println("Enter user ID to update:");
        int idforuser = input.nextInt();
        input.nextLine();
        boolean isfound = false;
        for (int i = 0; i<ids.length; i++) {
            if (ids[i] == idforuser) {
                isfound = true;
                System.out.println("==========  USER IS FOUND ==========");
                printuserdata(i);
                System.out.println("Chosse what you want to update:");
                System.out.println("1.Update Username");
                System.out.println("2.Update Email");
                System.out.println("3.Update Phone Number");
                System.out.println("Enter choice (1-3):");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter new Username:");
                        String OLDNAME = USERNAME[i];
                        USERNAME[i] = input.nextLine();
                        String newName = USERNAME[i];
                        for (int j =0;j<transactionSenders.length;j++){
                            if (transactionSenders[j].equalsIgnoreCase(OLDNAME)){
                                transactionSenders[j]=newName;
                            }
                            if (transactionReceivers[j].equalsIgnoreCase(OLDNAME)){
                                transactionReceivers[j]=newName;
                            }
                        }
                        System.out.println("Username updated successfully");
                        break;
                    case 2:
                        System.out.println("Enter new Email");
                        emails[i] = input.nextLine();
                        System.out.println("Email updated successfully ");
                        break;
                    case 3:
                        System.out.println("Enter new phone number:");
                        phones[i] = input.nextLine();
                        System.out.println("Phone Number updated successfully");
                        break;
                    default:
                        System.out.println("INVALID CHOICE!");
                }
                break;

            }
        }
        if (!isfound){
            System.out.println("User not found");
        }
    }
static void  showTransactionHistory(){
        //shows all transactions history
        System.out.println("========== ALL TRANSACTIONS HISTROY ==========");
        if (transactionIDs.length==0){
            System.out.println("NO transactions found");
            return;
        }
        for (int i =0;i<transactionIDs.length;i++){
            System.out.println("Transaction ID :"+transactionIDs[i]);
            System.out.println("Sender :"+transactionSenders[i]);
            System.out.println("Recever :"+transactionReceivers[i]);
            System.out.println("Amount :"+amountofsuctran[i]);
            System.out.println("Status :"+transactionStatuses[i]);
            System.out.println("--------------------------------------------------");
        }


}
static void blockAccount() {
        //block accounts baisd on ID
        System.out.println("Enter user ID to block");
        int idtoblock=input.nextInt();
        input.nextLine();
        boolean isfound =false;
        for (int i =0;i<ids.length;i++) {
            if (ids[i] == idtoblock) {
                isfound = true;
                if (isblocked[i]) {
                    System.out.println("This Acount is Already blocked");
                } else {
                    isblocked[i] = true;
                    System.out.println("Acount For" +" "+ USERNAME[i] +" "+ "blocked successfully.");
                }
                break;
            }
        }
        if (!isfound){
            System.out.println("User not found");
        }


                }



    //Global variabls useing arrays to store database information
    static Scanner input = new Scanner(System.in);
    static int[] ids = {111, 222, 333};
    static String[] USERNAME = {"adham ahmed", "mariam yasser", "fatma ashraf"};
    static String[] emails = {"adham@mail.com", "mariam@mail.com", "fatma@mail.com"};
    static long[] balance = {20000, 90000, 300000};
    static boolean[] isblocked = {true, true, false};
    static int successfultransactions = 5;
    static int faildtransactions = 3;
    static double[] amountofsuctran = {50.0, 100.0, 300.0, 500.0, 40.0, 600.0,900.0,30.0};
    static String[] phones = {"01012345678", "01123456789", "01234567890"};
static int[]transactionIDs = {101,102,103,104,105,106,107,108};
static String[]transactionSenders = {"adham ahmed","mariam yasser","fatma ashraf","adham ahmed","mariam yasser","fatma ashraf","adham ahmed","mariam yasser"};
static String[]transactionReceivers = {"mariam yasser","fatma ashraf","adham ahmed","fatma ashraf","adham ahmed","mariam yasser","fatma ashraf","adham ahmed"};
static String[]transactionStatuses = {"SUCCESS","SUCCESS","SUCCESS","SUCCESS","SUCCESS","FAILED","FAILED","FAILED"};
static String[]passwords = {"12345","13430","3211145"};
    public static void main(String[] args) {
        //Handles the main admin panal options
        System.out.println("========== ADMIN PANEL ==========");
        int chose;
        do {
            System.out.println("1. Show Statistics");
            System.out.println("2. Search User");
            System.out.println("3. View All Users");
            System.out.println("4. Update User");
            System.out.println("5. View All Transactions");
            System.out.println("6. Block Account");
            System.out.println("7. Unblock Account");
            System.out.println("8. View User Details");
            System.out.println("9. Logout");
            System.out.println("Choose an option:");
            chose = input.nextInt();
            switch (chose) {
                case 1:
                    showStatistics();
                    break;
                case 2:
                    searchUser();
                    break;

                case 3:
                    viewAllUsers();
                    break;
                case 4:
updateUser();
break;
                case 5:
showTransactionHistory();
                case 6:
blockAccount();
break;
                case 7:

                case 8:

                case 9:

                default:
                    System.out.println("INVALID CHOISE!");


            }
        } while (chose != 9);


    }
}