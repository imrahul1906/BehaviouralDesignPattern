package src.states;

import src.Ticket;

public abstract class TicketState {
    public abstract void updateState(Ticket ticket) ;
    public abstract void close(Ticket ticket) ;
}
