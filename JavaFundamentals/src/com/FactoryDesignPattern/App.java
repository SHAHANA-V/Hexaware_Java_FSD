package com.FactoryDesignPattern;

public class App {

    public static void main(String[] args) {
        try {
            Payment payment=PaymentFactory.getInstance(PaymentMode.NEFT);
            //assert payment !=null
            System.out.println(payment.maxTransactionLimit());
            System.out.println(payment.transactionCharges());
        }

        catch (Exception e) {
            System.out.println("Payment Failed!!!!!");
        }
    }


}
