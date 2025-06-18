package src.states;

import src.Ticket;

public class InProgressState extends TicketState {
    @Override
    public void updateState(Ticket ticket) {
        ticket.setTicketState(new ResolvedState());
    }

    @Override
    public String toString() {
        return "IN_PROGRESS";
    }

    @Override
    public void close(Ticket ticket) {
        System.out.println("Ticket can not be closed from In-progress state.");
    }
}
