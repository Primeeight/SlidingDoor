/**
 * Utopia Receiver
 */
public class receiver1 extends Protocol {
    public static void main(String args[]) throws Exception {
        Frame r = new Frame(8888);
        int event; //frame arrival is the only event.
        while (true) {
            event = r.wait_for_event(); //wait for frame arrival.
            r.from_physical_layer();// get inbound frame.
            to_network_layer(r.info); //pass the data to network layer.
        }
    }
}
