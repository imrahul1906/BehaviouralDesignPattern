package src.teams;

import src.Priority;
import src.Ticket;
import src.TicketState;

public class HighPriorityTeam extends Team {

    @Override
    boolean canHandle(Ticket ticket) {
        return ticket.getPriority() == Priority.HIGH;
    }

    @Override
    void process(Ticket ticket) {
        ticket.setTicketState(TicketState.IN_PROGRESS);
        System.out.println("The Ticket is being handled by HighPriority Team");
        ticket.setTicketState(TicketState.RESOLVED);
    }
}
