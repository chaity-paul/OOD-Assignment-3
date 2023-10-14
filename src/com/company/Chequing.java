package com.company;

import java.math.BigDecimal;

public class Chequing implements IAccount{
    private BigDecimal balance;
    private final int accountNumber;
    public Chequing(BigDecimal balance, int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;

    }

    @Override
    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if(this.balance.compareTo(amount) >= 0)
            this.balance = this.balance.subtract(amount);
        else System.out.println("Insufficient Funds");

    }

    @Override
    public void transfer(BigDecimal amount, IAccount account) {
        if(this.balance.compareTo(amount) >= 0) {
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
