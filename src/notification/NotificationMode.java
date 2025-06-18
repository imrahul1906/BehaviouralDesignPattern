package src.notification;

import src.TicketState;

public abstract class NotificationMode {
    public abstract void onTicketStateUpdated(TicketState state);
}
