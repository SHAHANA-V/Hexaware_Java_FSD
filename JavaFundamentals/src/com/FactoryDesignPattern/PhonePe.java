package com.FactoryDesignPattern;

public class PhonePe extends UPI{
    @Override
    public double transactionCharges() {
        return 3;
    }

    @Override
    public double maxTransactionLimit() {
        return 30000;
    }
}
