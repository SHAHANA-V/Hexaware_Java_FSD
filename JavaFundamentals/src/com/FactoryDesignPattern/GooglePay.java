package com.FactoryDesignPattern;

public class GooglePay extends  UPI{
    @Override
    public double transactionCharges() {
        return 1;
    }

    @Override
    public double maxTransactionLimit() {
        return 10000;
    }
}
