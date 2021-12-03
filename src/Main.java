import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import msg.First;

public class Main {

    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);
        AgentController ac;
        try {
            AgentController ttt = cc.createNewAgent("First", "msg.First", null);
            ttt.start();
            ac = cc.createNewAgent("BookSellerAgent1", "bookTrading.BookSellerAgent", null);
            ac.start();
            ac = cc.createNewAgent("BookSellerAgent2", "bookTrading.BookSellerAgent", null);
            ac.start();
            ac = cc.createNewAgent("BookSellerAgent3", "bookTrading.BookSellerAgent", null);
            ac.start();
        } catch (StaleProxyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //}
        }
    }
}
