package msg;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class First extends Agent {

    @Override
    protected void setup() {
        System.out.println("Here!");

        addBehaviour(new CyclicBehaviour() {

            @Override
            public void action() {





                    // Enter data using BufferReader

                        // send a message to the other agent
                        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                        msg.setContent("send");
                        msg.addReceiver(new AID("second", AID.ISLOCALNAME));
                        send(msg);

                    // Printing the read line
            }
        });
    }
}