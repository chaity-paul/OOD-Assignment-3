package com.company;

import java.math.BigDecimal;
import java.util.Hashtable;

public class BankService {
    private final Hashtable<Integer, IAccount> bankAccounts;
    static int accountNumber = 0;
    public BankService() {
        bankAccounts = new Hashtable<>();
    }
    public int createAccount(String accountType, BigDecimal initialAmount) {
        IAccount account = null;
        switch (accountType) {
            case "chequing" -> {
                account = new Chequing(initialAmount, accountNumber);
                accountNumber++;
                bankAccounts.put(account.getAccountNumber(), account);
                System.out.println("New chequing account created");
                return account.getAccountNumber();
            }
            case "saving" -> {
                account = new Saving(initialAmount, accountNumber);
                accountNumber++;
                bankAccounts.put(account.getAccountNumber(), account);
                System.out.println("New saving account created");
                return account.getAccountNumber();
            }
            case "investment" -> {
                account = new Investment(initialAmount, accountNumber);
                accountNumber++;
                bankAccounts.put(account.getAccountNumber(), account);
                System.out.println("New investment account created");
                return account.getAccountNumber();
            }
        }
        return -1;
    }
    public void transferMoney(int fromAccount, int toAccount, BigDecimal amount) {
        IAccount from = bankAccounts.get(fromAccount);
        IAccount to = bankAccounts.get(toAccount);
        if (from == null || to == null) {
            System.out.println("Account not found");
            return;
        }
        from.transfer(amount, to);
    }

    public BigDecimal getBalance(int mySavingAccount) {
        IAccount account = bankAccounts.get(mySavingAccount);
        if (account == null) {
            System.out.println("Account not found");
            return BigDecimal.ZERO;
        }
        return account.getBalance();
    }
}
