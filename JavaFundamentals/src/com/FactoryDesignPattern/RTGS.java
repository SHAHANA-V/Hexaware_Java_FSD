package com.FactoryDesignPattern;

public class RTGS implements Payment{
    @Override
    public double transactionCharges() {
        return 50;
    }

    @Override
    public double maxTransactionLimit() {
        return 10000000;
    }
}
