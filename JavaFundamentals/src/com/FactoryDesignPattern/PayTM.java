package com.FactoryDesignPattern;

public class PayTM extends UPI{
    @Override
    public double transactionCharges() {
        return 2;
    }

    @Override
    public double maxTransactionLimit() {
        return 20000;
    }
}
