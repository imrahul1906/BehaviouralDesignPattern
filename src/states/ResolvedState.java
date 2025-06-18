package src.states;

import src.Ticket;

public class ResolvedState extends TicketState {
    @Override
    public void updateState(Ticket ticket) {
        System.out.println("Can not update ticket. It is already resolved.");
    }

    @Override
    public void close(Ticket ticket) {
        ticket.setTicketState(new ClosedState());
    }

    @Override
    public String toString() {
        return "RESOLVED";
    }
}
