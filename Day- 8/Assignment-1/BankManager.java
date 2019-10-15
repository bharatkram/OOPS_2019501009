class BankAccount {
    final int accountNumber;
    double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {
    int limit;

    public CheckingAccount() {
        super(12345,5000);
        limit = 20000;
    }
}

class SavingsAccount extends BankAccount {
    int maxTransactions;

    public SavingsAccount() {
        super(23456,10000);
        maxTransactions = 5;
    }
}

class COD extends BankAccount {
    int time;

    public COD() {
        super(34567,15000);
        time = 12;
    }
}

final class BankManager {

    public static void main(String[] args) {

        CheckingAccount acc1 = new CheckingAccount();
        System.out.println("Checking Account");
        System.out.println("Account number: " + acc1.accountNumber);
        System.out.println("Balance: " + acc1.balance);
        System.out.println("Account limit: " + acc1.limit);
        System.out.println();
        SavingsAccount acc2 = new SavingsAccount();
        System.out.println("Savings Account");
        System.out.println("Account number: " + acc2.accountNumber);
        System.out.println("Balance: " + acc2.balance);
        System.out.println("No. of transactions: " + acc2.maxTransactions);
        System.out.println();
        COD acc3 = new COD();
        System.out.println("Certificate of Deposit Account");
        System.out.println("Account number: " + acc3.accountNumber);
        System.out.println("Balance: " + acc3.balance);
        System.out.println("Time period: " + acc3.time);
    }
}
