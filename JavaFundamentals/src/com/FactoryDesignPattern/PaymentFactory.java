package com.FactoryDesignPattern;

public class PaymentFactory {

    public static Payment getInstance(PaymentMode paymentMode) {
        return
                switch (paymentMode){
            case NEFT -> new Neft();
            case PayTM -> new PayTM();
            case PhonePay -> new PhonePe();
            case RTGS -> new RTGS();
            case GooglePay -> new GooglePay();
            default -> null;
        };

    }
}
