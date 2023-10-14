package com.company;

import java.math.BigDecimal;

public interface IAccount {
    public void deposit(BigDecimal amount);
    public void withdraw(BigDecimal amount);
    public void transfer(BigDecimal amount, IAccount account);
    public int getAccountNumber();
    public BigDecimal getBalance();
}
