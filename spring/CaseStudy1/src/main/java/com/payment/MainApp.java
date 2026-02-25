package com.payment;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentProcessor processor = context.getBean(PaymentProcessor.class);
        processor.pay(5000);

        System.out.println("Requesting UPI again (prototype)");
        PaymentService upi1 = context.getBean(UpiPayment.class);
        PaymentService upi2 = context.getBean(UpiPayment.class);

        System.out.println(upi1 == upi2); // false

        context.close();
    }
}