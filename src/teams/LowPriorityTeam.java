package src.teams;

import src.Priority;
import src.Ticket;
import src.TicketState;

public class LowPriorityTeam extends Team {
    @Override
    boolean canHandle(Ticket ticket) {
        return ticket.getPriority() == Priority.LOW;
    }

    @Override
    void process(Ticket ticket) {
        ticket.setTicketState(TicketState.IN_PROGRESS);
        System.out.println("The Ticket is being handled by LOWPriority Team");
        ticket.setTicketState(TicketState.RESOLVED);
    }
}
