import java.util.Scanner;

    class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient funds. Withdrawal failed.");
            } else {
                balance -= amount;
                System.out.println("Withdrawal of $" + amount + " successful.");
            }
        }
    }

    class ATM {
        private final BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public void displayMenu() {
            System.out.println("Welcome to the ATM. Please select an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        if (withdrawAmount > 0) {
                            account.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Invalid amount.");
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        if (depositAmount > 0) {
                            account.deposit(depositAmount);
                        } else {
                            System.out.println("Invalid amount.");
                        }
                    }
                    case 3 -> System.out.println("Your balance is: $" + account.getBalance());
                    case 4 -> System.out.println("Thank you for using the ATM. Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);

            scanner.close();
        }
    }

    public class AtmInterface {
        public static void main(String[] args) {
            BankAccount userAccount = new BankAccount(2000);
            ATM atm = new ATM(userAccount);
            atm.run();
        }
    }

