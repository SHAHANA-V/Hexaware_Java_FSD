package com.FactoryDesignPattern;

public class Neft implements Payment{
    @Override
    public double transactionCharges() {
        return 10;
    }

    @Override
    public double maxTransactionLimit() {
        return 150000;
    }
}
