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
    private List<String> mNotes;

    Ticket(int id) {
        mId = id;
        mState = TicketState.OPEN;
        mNotes= new ArrayList<>();
        System.out.println("The ticket is created successfully and the state is: " + mState);
    }

    public void addNotes(String note) {
        mNotes.add(note);
    }
    
    public void setTicketState(TicketState state) {
        mState = state;
        System.out.println("The ticket state has been changed to "+ mState);
        notifyStateUpdate();
    }

    private void notifyStateUpdate() {
        NotificationMode email = new Email();
        NotificationMode slack = new Slack();

        email.onTicketStateUpdated(mState);
        slack.onTicketStateUpdated(mState);
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

    public String getDescription() {
        return mDescription;
    }
}
