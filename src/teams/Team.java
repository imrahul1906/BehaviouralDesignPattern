package src.teams;

import src.Ticket;

public abstract class Team {
    Team mNext;

    public void handleTicket(Ticket ticket) {
        if (canHandle(ticket)) {
            process(ticket);
        } else {
            mNext.handleTicket(ticket);
        }
    }

    public void setNext(Team next) {
        mNext = next;
    }

    abstract boolean canHandle(Ticket ticket);

    abstract void process(Ticket ticket);
}
