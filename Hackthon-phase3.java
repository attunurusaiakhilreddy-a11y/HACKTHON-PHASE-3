class BankAccount {
    String accountHolder;
    String accountNumber;
    double initialBalance;
    double balance;
    double totalDeposits = 0;
    double totalWithdrawals = 0;

    BankAccount(String name, String number, double amount) {
        accountHolder = name.trim().toUpperCase();
        accountNumber = number;
        initialBalance = amount;
        balance = amount;
    }

    void deposit(double amount) {
        deposit(amount, "Cash Deposit");
    }

    void deposit(double amount, String description) {
        if (amount > 0) {
            balance += amount;
            totalDeposits += amount;
            System.out.println("\nDeposit Amount      : Rs. " +
                    String.format("%.2f", amount));
            System.out.println("Transaction Status  : Deposit Successful");
            System.out.println("Description         : " + description);
            System.out.println("Updated Balance     : Rs. " +
                    String.format("%.2f", balance));
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(double amount) {
        withdraw(amount, "Cash Withdrawal");
    }

    void withdraw(double amount, String description) {
        System.out.println("\nWithdrawal Amount   : Rs. " +
                String.format("%.2f", amount));

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            totalWithdrawals += amount;
            System.out.println("Transaction Status  : Withdrawal Successful");
            System.out.println("Description         : " + description);
            System.out.println("Updated Balance     : Rs. " +
                    String.format("%.2f", balance));
        } else if (amount > balance && amount > 0) {
            System.out.println("Transaction Status  : Insufficient Balance");
            System.out.println("Available Balance   : Rs. " +
                    String.format("%.2f", balance));
        } else {
            System.out.println("Transaction Status  : Invalid Amount");
        }
    }

    boolean verifyHolder(String name) {
        return accountHolder.equalsIgnoreCase(name.trim());
    }

    void displaySummary() {
        System.out.println("\n========== PERSONAL BANKING LEDGER ==========");
        System.out.println("Account Holder Name : " + accountHolder);
        System.out.println("Account Number      : " + accountNumber);
        System.out.printf("Initial Balance     : Rs. %.2f%n",
                initialBalance);

        System.out.println("\n---------- TRANSACTION DETAILS ----------");

        System.out.println("\n---------- ACCOUNT SUMMARY ----------");
        System.out.println("Account Holder      : " + accountHolder);
        System.out.println("Account Number      : " + accountNumber);
        System.out.printf("Total Deposits      : Rs. %.2f%n",
                totalDeposits);
        System.out.printf("Total Withdrawals   : Rs. %.2f%n",
                totalWithdrawals);
        System.out.printf("Final Balance       : Rs. %.2f%n",
                balance);

        System.out.print("\nAccount Holder Verification: ");
        System.out.println(verifyHolder("Ravi Kumar")
                ? "Names Match" : "Names Do Not Match");

        System.out.println("=============================================");
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(
                " Ravi Kumar ", "1234567890", 10000.00);

        account.displaySummary();

        account.deposit(5000.00, "Salary Deposit");
        account.withdraw(2000.00, "ATM Withdrawal");
        account.withdraw(20000.00, "Large Withdrawal");

        account.displaySummary();
    }
}