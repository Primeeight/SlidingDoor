/**
 * Stop and Wait Receiver
 */
public class receiver2 extends Protocol {
    public static void main(String args[]) throws Exception {
        Frame r = new Frame(8888);
        Frame s = new Frame(9999);
        int event; //frame arrival is the only event.
        while (true) {
            event = r.wait_for_event(); //wait for fram arrival.
            r.from_physical_layer();// get inbound frame.
            to_network_layer(r.info); //pass the data to network layer.
            s.to_physical_layer("192.168.0.10", 7777); //awaken the sender with a dummy frame.
        }
    }
}
