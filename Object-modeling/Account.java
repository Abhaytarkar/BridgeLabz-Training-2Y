class Account {
    int accountNumber;
    double balance;
    Bank bank;
    Account(int accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }
}

class Customer {
    String name;
    List<Account> accounts = new ArrayList<>();
    Customer(String name) {
        this.name = name;
    }
    void viewBalance() {
        for (Account acc : accounts) {
            System.out.println("Account " + acc.accountNumber + ": " + acc.balance);
        }
    }
}

class Bank {
    String name;
    Bank(String name) {
        this.name = name;
    }
    Account openAccount(Customer customer, int accountNumber, double balance) {
        Account account = new Account(accountNumber, balance, this);
        customer.accounts.add(account);
        return account;
    }
}