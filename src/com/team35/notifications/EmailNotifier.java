package com.team35.notifications;

public class EmailNotifier extends NotificationDecorator{
    public String email;
    EmailNotifier(Notifier notifier){
        super(notifier);
        this.email = notifier.email;
    }
    public void sendCheck(){
        System.out.print("The check was sent to your email: ");
        System.out.println(email);
    }
   public  void sendOrderStatus(){
        System.out.print("The order status was sent to your email: ");
       System.out.println(email);
    }

}
