
import java.util.Scanner;

class MyBank {

    Scanner scan = new Scanner(System.in);

    long amount = 2300L;
    int loanlimit = 100;
    int loan = 0;
    int myPin;

    void activate(int pin) {
        myPin = pin;
    }

    void deposit() {
        System.out.println("Enter Amount");
        long amt = scan.nextLong();
        System.out.println("Enter Pin");
        long pin = scan.nextInt();

        if (pin == myPin) {
            int ch;
            System.out.println("Deposit Ksh " + amt + " To KCB? \n Enter 1 to acccept, 2 to cancel");
            ch = scan.nextInt();

            switch (ch) {
                case 1:
                    amount = amount + amt;
                    System.out.println("Deposit of Ksh " + amt + " successful. Your new Balance is Ksh " + amount);
                    break;
                case 2:
                    System.out.println("Cancelled");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } else {
            System.out.println("Wrong pin....Try Again");
        }
    }

    void withdraw() {
        System.out.println("Enter Amount");
        long amt = scan.nextLong();
        System.out.println("Enter Pin");
        long pin = scan.nextInt();

        if (pin == myPin) {

            int ch;
            System.out.println("Withdraw Ksh " + amt + " from KCB  \n  Enter 1 to acccept, 2 to cancel");

            ch = scan.nextInt();

            switch (ch) {
                case 1:
                    if (amount >= amt) {
                        amount = amount - amt;
                        System.out.println("Withdrawal of " + amt + " Successful . Your new Balance is Ksh " + amount);
                    } else {
                        System.out.println("You have insufficient balance");
                    }
                    break;
                case 2:
                    System.out.println("Cancelled");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }

        } else {
            System.out.println("Wrong pin....Try Again");
        }

    }

    void requestLoan() {
        System.out.println("Enter Amount ");
        System.out.print("Your Choice::");
        int amt = scan.nextInt();
        System.out.println("Enter M-pesa PIN");
        System.out.print("Your Choice::");
        int pin = scan.nextInt();
        System.out.println("Request Loan of Ksh " + amt + " from KCB  \n  Enter 1 to acccept, 2 to cancel");

        int ch = scan.nextInt();

        switch (ch) {
            case 1:
                if (loanlimit >= amt) {
                    if (pin == myPin) {
                        loan = loan + amt;
                        System.out.println("Request accepted. You have received " + amt + " to your mpesa account.\nYou have an outstanding loan of ksh" + loan);
                    } else {
                        System.out.println("Wrong pin....Try Again");
                    }
                } else {
                    System.out.println("You have exceeded your loan limit...");
                }
                break;
            case 2:
                System.out.println("Cancelled");
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }

    void payLoan() {
        System.out.println("Enter Amount ");
        System.out.print("Your Choice::");
        int amt = scan.nextInt();
        System.out.println("Enter M-pesa PIN");
        System.out.print("Your Choice::");
        int pin = scan.nextInt();
        System.out.println("Pay Loan of Ksh " + amt + "\n  Enter 1 to acccept, 2 to cancel");
        int ch = scan.nextInt();
        if (pin == myPin) {
            switch (ch) {
                case 1:
                    if (loan >= amt) {
                            loan = loan - amt;
                            System.out.println("Loan payment of ksh " + amt + " successful..\nYour outstanding KCB loan is ksh" + loan);
                    }else if (amt> loan){
                        loan = 0;
                        
                        amount = amount - amt;
                        int excess = amt-loan;
                        amount = amount + excess;                           
                        System.out.println("Loan payment of ksh " + amt + 
                                ". Your outstanding KCB loan is ksh" + loan+ " Excess amount of "+excess+ " has been refunded to your mpesa account");

                    }else{
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("Cancelled");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } else {
            System.out.println("Wrong pin....Try Again");
        }
    }
    
    void checkLoanLimit(){
        System.out.println("Your KCB loan limit is ksh "+loanlimit);
    }

    void loan() {
        System.out.println("------------------Welcome to KCB Loan------------------");
        System.out.println("Menu \n\t1.Request Loan\n\t2.Pay Loan\n\t3.Check Loan Limit\n\t4.Cancel");
        System.out.print("Your Choice::");
        int ch = scan.nextInt();
        switch (ch) {
            case 1:
                requestLoan();
                break;
            case 2:
                payLoan();
                break;
            case 3:
                checkLoanLimit();
                break;
            case 4:
                System.out.println("Cancelled");
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }
    
    void checkBalance(){
        System.out.println("\n\tYour KCB balance is ksh "+amount+ ". \n\tYour KCB outstanding loan ksh "+loan);
    }
    
    void myAccount(){
        System.out.println("------------------ My Account ------------------");
        System.out.println("Menu \n\t1.Check Balance\n\t2.Cancel");
        System.out.print("Your Choice::");
        int ch = scan.nextInt();
        switch (ch) {
            case 1:
                checkBalance();
                break;
            default:
                System.out.println("Wrong  input");
                break;
        }
    }
    
}

class Bank {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyBank bnk = new MyBank();

        System.out.println("------------------Welcome to KCB Mpesa------------------");

        System.out.println("Your Account has not been activated. Enter mpesa pin to activate");
        int myPin = scan.nextInt();
        bnk.activate(myPin);

        System.out.println("Account successfully activated. Welcome");

        int ch;
        do {
            System.out.println("Menu \n\t1.Deposit to KCB\n\t2.Withdraw Ksh\n\t3.Loan\n\t4.My Account\n\t5.Exit");
            System.out.print("Your Choice::");
            ch = scan.nextInt();
            switch (ch) {
                case 1:

                    bnk.deposit();
                    break;
                case 2:
                    bnk.withdraw();
                    break;
                case 3:
                    bnk.loan();
                    break;
                case 4:
                    bnk.myAccount();
                    break;
                case 5:
                    System.out.println("Good Bye ");
                    break;
            }

        } while (ch != 5);
    }
}
