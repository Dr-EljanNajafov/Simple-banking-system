import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {

    static int password;
    static int id;
    static String name;
    static String surname;
    static int newPassword;
    static int balance;
    static int newBalanceOfSender;
    static int newBalanceOfRecipient;

    public static void main(String[] args) throws SQLException, NullPointerException, ClassNotFoundException {


        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println();
        System.out.println("===================================================");
        System.out.println("\t----------HELLO DEAR USER!----------\t");
        System.out.println("\t---Please, select your next step.---\t");
        System.out.println("===================================================");
        System.out.println();
        System.out.println();
        System.out.println("===================================================");
        System.out.println("A) Create a new account");
        System.out.println("B) Show my information");
        System.out.println("C) Change my password");
        System.out.println("D) Make a transaction");
        System.out.println("E) Exit");
        System.out.println("===================================================");
        System.out.println();
        String step;


        do {
            System.out.println("===================================================");
            System.out.println("Select command");
            System.out.println("===================================================");
            step = in.next();


            switch (step) {
                case "A":
                    System.out.println("===================================================");
                    AddingNewUser addingNewUser = new AddingNewUser();
                    System.out.println("Add your name");
                    name = in.next();
                    System.out.println("Add your surname");
                    surname = in.next();
                    System.out.println("Create a password");
                    System.out.println("It will be with only decimal numbers");
                    try {
                        password = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please use only decimal numbers");
                    }

                    addingNewUser.addUser();
                    System.out.println("===================================================");
                    break;
                case "B":
                    System.out.println("===================================================");
                    System.out.println("Do next steps for connecting to your account");
                    System.out.println();
                    ShowingInformation showingInformation = new ShowingInformation();
                    System.out.println("Write your password");
                    try {
                        password = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please use only decimal numbers");
                    }

                    showingInformation.showInformation();
                    System.out.println("===================================================");
                    break;
                case "C":
                    System.out.println("===================================================");
                    System.out.println("Do next steps for changing your password");
                    ChangingPassword changingPassword = new ChangingPassword();
                    System.out.println("Write your password");
                    try {
                        password = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please use only decimal numbers");
                    }
                    System.out.println("Write your new password");
                    try {
                        newPassword = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please use only decimal numbers");
                    }
                    changingPassword.changePassword();
                    System.out.println("===================================================");
                    break;
                case "D":
                    System.out.println("===================================================");
                    System.out.println("Write  your password");
                    try {
                        password = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please use only decimal numbers");
                    }
                    System.out.println("How much you want to transact?");
                    try {
                        balance = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please use only decimal numbers");
                    }
                    if (CheckingBalanceOfSender.checkingBalanceOfSender() >= balance) {
                        System.out.println("Write id of person to whom you want to transact");
                        id = in.nextInt();
                        newBalanceOfSender = CheckingBalanceOfSender.checkingBalanceOfSender() - balance;
                        ChangingBalance.changeBalance();
                        newBalanceOfRecipient = CheckingBalanceOfRecipient.checkingBalanceOfRecipient() + balance;
                        Transactions transactions = new Transactions();
                        transactions.showTransaction();
                    } else {
                        System.out.println("You don't have enough money for transaction");
                    }
                    System.out.println("===================================================");
                    break;
                case "E":
                    System.out.println("===================================================");
                    System.out.println("Logging out from account...");
                    System.out.println("===================================================");
                    break;
                default:
                    System.out.println("===================================================");
                    System.out.println("Invalid action");
                    System.out.println("===================================================");
            }
        } while (!step.equals("E"));
    }
}
