package com.company;

import java.math.BigDecimal;

public class Investment implements IAccount{
    private BigDecimal balance;
    private final int accountNumber;

    public Investment(BigDecimal balance, int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if(balance.compareTo(amount) >= 0)
            balance = balance.subtract(amount);
        else System.out.println("Insufficient Funds");

    }

    @Override
    public void transfer(BigDecimal amount, IAccount account) {
        if(balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            account.deposit(amount);
            System.out.println("Transfer Successful");
        }else System.out.println("Insufficient Funds");
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}
