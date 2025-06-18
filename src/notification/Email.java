package src.notification;

import src.TicketState;

public class Email extends NotificationMode{
    @Override
    public void onTicketStateUpdated(TicketState state) {
        System.out.println("You have received a mail saying the state of ticket is updated to: "+ state);
    }
}
