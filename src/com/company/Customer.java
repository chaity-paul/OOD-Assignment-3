package com.company;

import java.math.BigDecimal;

public class Customer {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        int mySavingAccount = bankService.createAccount("saving", new BigDecimal(5000));
        int myInvestmentAccount = bankService.createAccount("investment", new BigDecimal(7000));
        int myChequingAccount = bankService.createAccount("chequing", new BigDecimal(2000));
        bankService.transferMoney(mySavingAccount, myInvestmentAccount, new BigDecimal(1000));
        System.out.println("My current savings account balance is " + bankService.getBalance(mySavingAccount));
        System.out.println("My current investment account balance is " + bankService.getBalance(myInvestmentAccount));
        System.out.println("My current chequing account balance is " + bankService.getBalance(myChequingAccount));

    }
}
