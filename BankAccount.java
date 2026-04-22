class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    // Constructor
    BankAccount(String name, int accNo, double bal) {
        accountHolder = name;
        accountNumber = accNo;
        balance = bal;
    }

    // Deposit method
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Display details
    void display() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    // Main method (no user input)
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Mohan", 12345, 1000);

        acc.display();

        acc.deposit(500);
        acc.withdraw(300);

        acc.display();
    }
}


FROM openjdk:17

WORKDIR /app

COPY BankAccount.java .

RUN javac BankAccount.java

CMD ["java", "BankAccount"]
