package com.team35.notifications;

public class TelegramNotifier extends NotificationDecorator{
    String telegramAlias;
   TelegramNotifier(Notifier notifier) {
        super(notifier);
        this.telegramAlias = notifier.telegramAlias;
    }
    public void sendCheck(){
        System.out.print("The check was sent to your telegram: ");
        System.out.println(telegramAlias);
    }
    public void sendOrderStatus(){
        System.out.print("The order status was sent to your telegram: ");
        System.out.println(telegramAlias);
    }
}
