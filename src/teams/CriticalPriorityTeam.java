package src.teams;

import src.Ticket;

public class CriticalPriorityTeam extends Team{
    @Override
    public void handleTicket(Ticket ticket) {
        ticket.updateState();
        System.out.println("The Ticket is being handled by CriticalPriority Team");
        ticket.updateState();
    }
}
