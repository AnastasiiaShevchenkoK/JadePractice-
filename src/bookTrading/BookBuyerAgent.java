
package bookTrading;

import jade.core.Agent;

import javax.swing.JOptionPane;

import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class BookBuyerAgent extends Agent {
    // The title of the book to buy
    private String targetBookTitle;
    // The list of known seller agents
    private AID[] sellerAgents = {new AID("seller1", AID.ISLOCALNAME),
            new AID("seller2", AID.ISLOCALNAME)};

    // Put agent initializations here
    @Override
    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello! Buyer-agent " + getAID().getName() + " is ready.");
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {

            }
        });


        Object[] args = getArguments();
        if (args != null && args.length > 0) {
            targetBookTitle = (String) args[0];
            System.out.println("Trying to buy " + targetBookTitle);
        } else {
            // Make the agent terminate immediately
            System.out.println("No book title specified");
            doDelete();
        }
    }

    // Put agent clean-up operations here
    protected void takeDown() {
        // Printout a dismissal message
        System.out.println("Buyer-agent " + getAID().getName() + " terminating.");
    }


}