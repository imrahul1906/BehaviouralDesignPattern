package src;

import src.notification.Email;
import src.notification.NotificationMode;
import src.notification.Slack;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private final int mId;
    private Priority mPriority;
    private String mDescription;
    private TicketState mState;
    private List<NotificationMode> mObservers;

    Ticket(int id) {
        mId = id;
        mState = TicketState.OPEN;
        mObservers = new ArrayList<>();
        System.out.println("The ticket is created successfully and the state is: " + mState);
    }

    public void addObserver(NotificationMode mode) {
        if (!mObservers.contains(mode)) {
            mObservers.add(mode);
        }
    }

    public void removeObserver(NotificationMode mode) {
        if (mObservers.contains(mode)) {
            mObservers.remove(mode);
        }
    }

    public void setTicketState(TicketState state) {
        mState = state;
        System.out.println("The ticket state has been changed to " + mState);
        notifyStateUpdate();
    }

    private void notifyStateUpdate() {
        for (NotificationMode mode : mObservers) {
            mode.onTicketStateUpdated(mState);
        }
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void setPriority(Priority priority) {
        mPriority = priority;
    }

    public Priority getPriority() {
        return mPriority;
    }

    public TicketState getState() {
        return mState;
    }
}
