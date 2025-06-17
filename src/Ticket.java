package src;

public class Ticket {
    private final int mId;
    private Priority mPriority;
    private String mDescription;

    Ticket(int id) {
        mId = id;
    }

    public void setDescription(String description) {
        mDescription = mDescription;
    }

    public void setPriority(Priority priority) {
        mPriority = priority;
    }

    public Priority getPriority() {
        return mPriority;
    }
}
