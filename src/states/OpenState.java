package src.states;

import src.Ticket;

public class OpenState extends TicketState {
    @Override
    public void updateState(Ticket ticket) {
        ticket.setTicketState(new InProgressState());
    }

    @Override
    public String toString() {
        return "OPEN";
    }

    @Override
    public void close(Ticket ticket) {
        System.out.println("Ticket can not be closed from open state.");
    }
}
