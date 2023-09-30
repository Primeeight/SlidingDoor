/**
 * Utopia Sender
 */
public class sender1 extends Protocol {
    public static void main(String args[]) throws Exception {
        Frame s = new Frame(6666); //buffer for outbound frame.
        String buffer; //buffer for outbound packet.
        while (true) {
            buffer = from_network_layer(); //get something to send.
            s.info = buffer; //prepare for transmission.
            s.to_physical_layer("localhost", 8888); //send the frame.
        }
    }
}
