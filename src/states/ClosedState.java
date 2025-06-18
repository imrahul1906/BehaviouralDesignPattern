package src.states;

import src.Ticket;

public class ClosedState extends TicketState {
    @Override
    public void updateState(Ticket ticket) {
        System.out.println("The ticket is closed hence it can not be updated.");
    }

    @Override
    public void close(Ticket ticket) {
        System.out.println("Ticket is already Closed");
    }

    @Override
    public String toString() {
        return "CLOSED";
    }
}
