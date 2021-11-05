package notifications;

public class Notifier implements Notification{
    public String email;
    public String telegramAlias;
    public String phoneNumber;
    public Notifier(String email, String phoneNumber, String telegramAlias){
        super();
        this.email = email;
        this.telegramAlias = telegramAlias;
        this.phoneNumber = phoneNumber;
    }
    Notifier(Notifier notifier){
        super();
        this.email = notifier.email;
        this.telegramAlias = notifier.telegramAlias;
        this.phoneNumber = notifier.phoneNumber;
    }
    public void sendCheck(){

    }
    public void sendOrderStatus(){

    }
}
