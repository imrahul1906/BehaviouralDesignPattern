package src.teams;

import src.Priority;
import src.Ticket;
import src.TicketState;

public class CriticalPriorityTeam extends Team{
    @Override
    boolean canHandle(Ticket ticket) {
        return ticket.getPriority() == Priority.CRITICAL;
    }

    @Override
    void process(Ticket ticket) {
        ticket.setTicketState(TicketState.IN_PROGRESS);
        System.out.println("The Ticket is being handled by CriticalPriority Team");
        ticket.setTicketState(TicketState.RESOLVED);
    }
}
