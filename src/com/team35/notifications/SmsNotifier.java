package com.team35.notifications;

public class SmsNotifier extends NotificationDecorator{

    String phoneNumber;
    SmsNotifier(Notifier notifier){
        super(notifier);
        this.phoneNumber = notifier.phoneNumber;
    }
    public void sendCheck(){
        System.out.print("The check was sent via SMS to the number: ");
        System.out.println(phoneNumber);
    }
    public void sendOrderStatus(){
        System.out.print("The order status was sent via SMS to the number: ");
        System.out.println(phoneNumber);
    }
}
