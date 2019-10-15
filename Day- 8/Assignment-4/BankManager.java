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
        limit = 2000;
    }

    public void interest(final int m) {
        double interest = this.balance * (m / 12) * (4.5 / 100);
        System.out.println("Interest: " + interest);
    }
}

class SavingsAccount extends BankAccount {
    int maxTransactions;

    public SavingsAccount() {
        super(12346,5000);
        maxTransactions = 5;
    }
}

class COD extends BankAccount {
    int time;

    public COD() {
        super(12347,5000);
        time = 10;
    }

    public void interest() {
        double interest = this.balance * this.time * (8.0 / 100);
        System.out.println("interest: " + interest);
    }
}

final class BankManager {

    public static void main(String[] args) {

        CheckingAccount acc1 = new CheckingAccount();
        System.out.println("Checking Account");
        System.out.println("Account number: " + acc1.accountNumber);
        System.out.println("Balance: " + acc1.balance);
        System.out.println("Account limit: " + acc1.limit);
        acc1.interest(12);
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
        acc3.interest();
    }
}
