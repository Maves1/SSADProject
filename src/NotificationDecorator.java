public class NotificationDecorator implements Notification {

    private Notification wrappee,dynamicWrappee;
    protected int mask;

    NotificationDecorator(int mask, Notifier notifier){
        this.mask = mask;
        wrappee = new Notifier(notifier);
    }
    NotificationDecorator(Notifier notifier){
        wrappee = notifier;
    }
    NotificationDecorator(){

    }
    public void sendCheck(){
        if( (mask&1) == 1){
            dynamicWrappee = new EmailNotifier((Notifier) wrappee);
            dynamicWrappee.sendCheck();
        }
        if((mask&(1<<1)) == (1<<1)){
            dynamicWrappee = new SmsNotifier((Notifier) wrappee);
            dynamicWrappee.sendCheck();
        }
        if( (mask&(1<<2))==(1<<2)){
            dynamicWrappee = new TelegramNotifier((Notifier) wrappee);
            dynamicWrappee.sendCheck();
        }
    }
    public void sendOrderStatus(){
        if( (mask&1) == 1){
            dynamicWrappee = new EmailNotifier((Notifier) wrappee);
            dynamicWrappee.sendOrderStatus();
        }
        if((mask&(1<<1)) == (1<<1)){
            dynamicWrappee = new SmsNotifier((Notifier) wrappee);
            dynamicWrappee.sendOrderStatus();
        }
        if( (mask&(1<<2))==(1<<2)){
            dynamicWrappee = new TelegramNotifier((Notifier) wrappee);
            dynamicWrappee.sendOrderStatus();
        }
    }
}

