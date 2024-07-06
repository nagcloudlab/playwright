package com.example;


class AccountNotFoundException extends Throwable {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Throwable {
    public InsufficientBalanceException(String message) {
    }
}

//---------------------------------------------------------------------

class Account {
    private String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}

//---------------------------------------------------------------------
//Transfer module
//---------------------------------------------------------------------

class TransferService {
    public boolean transfer(int amount, String sourceAccount, String destinationAccount) throws AccountNotFoundException, InsufficientBalanceException {
        // load source account
        Account source = loadAccount(sourceAccount);
        if (source == null) {
            throw new AccountNotFoundException("Source account not found");
        }
        // check source account exists
        // load destination account
        // check destination account exists
        // check if source account has enough balance
        if (source.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        // debit source account
        // credit destination account
        // save source account
        // save destination account
        return true;
    }

    private Account loadAccount(String accountNumber) {
        // load account from database
        return new Account("123", 1000);
    }
}


//---------------------------------------------------------------------
//External resource , a object that has connection to outside world ( database, file, network , browser-drivers etc)
//----------------- ----------------------------------------------------

class Playwright implements AutoCloseable {
    public void init() {
        // connect to browser
    }
    public void useBrowser() {
        // use browser
        ///throw  new RuntimeException("Browser crashed");
    }
    public void close() {
        // close browser
        System.out.println("Browser closed");
    }
}

public class Exception {
    public static void main(String[] args) {

        TransferService transferService = new TransferService();
        try {
            transferService.transfer(100, "123", "456");
        }
        catch ( AccountNotFoundException | InsufficientBalanceException  e) {
            e.printStackTrace();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }


//        Playwright playwright = new Playwright();
//        try {
//            playwright.init();
//            playwright.useBrowser();
//        }
//        catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//        finally {
//            // cleanup
//            playwright.close();
//        }

        // try with resources (Java 7)

        try (Playwright playwright2 = new Playwright()) {
            playwright2.init();
            playwright2.useBrowser();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
