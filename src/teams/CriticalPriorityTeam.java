package src.teams;

import src.Ticket;
import src.TicketState;

public class CriticalPriorityTeam extends Team{
    @Override
    public void handleTicket(Ticket ticket) {
        ticket.setTicketState(TicketState.IN_PROGRESS);
        System.out.println("The Ticket is being handled by CriticalPriority Team");
        ticket.setTicketState(TicketState.RESOLVED);
    }
}
