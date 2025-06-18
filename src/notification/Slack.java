package src.notification;

import src.TicketState;

public class Slack extends NotificationMode {

    @Override
    public void onTicketStateUpdated(TicketState state) {
        System.out.println("You have received a slack message saying the state of ticket is updated to: "+ state);
    }
}
