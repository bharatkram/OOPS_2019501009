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
        // acc1();
        System.out.println(acc1.accountNumber);
        System.out.println(acc1.balance);
        System.out.println(acc1.limit);
        SavingsAccount acc2 = new SavingsAccount();
        // acc2();
        System.out.println(acc2.accountNumber);
        System.out.println(acc2.balance);
        System.out.println(acc2.maxTransactions);
        COD acc3 = new COD();
        // acc3();
        System.out.println(acc3.accountNumber);
        System.out.println(acc3.balance);
        System.out.println(acc3.time);
    }
}
