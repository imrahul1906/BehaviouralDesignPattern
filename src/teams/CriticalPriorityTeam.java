package src.teams;

import src.Ticket;

public class CriticalPriorityTeam extends Team{
    @Override
    public void handleTicket(Ticket ticket) {
        System.out.println("The Ticket is being handled by CriticalPriority Team");
    }
}
