package src;

public class Ticket {
    private final int mId;
    private Priority mPriority;
    private String mDescription;
    private TicketState mState;

    Ticket(int id) {
        mId = id;
        mState = TicketState.OPEN;
        System.out.println("The ticket is created successfully and the state is: " + mState);
    }
    
    public void setTicketState(TicketState state) {
        mState = state;
        System.out.println("The ticket state has been changed to "+ mState);
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
