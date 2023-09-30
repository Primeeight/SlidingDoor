/**
 * Stop and Wait Sender
 */
public class sender2 extends Protocol {
    public static void main(String args[]) throws Exception {
        Frame r = new Frame(7777);
        Frame s = new Frame(6666); //buffer for outbound frame.
        String buffer; //buffer for outbound packet.
        int event;
        while (true) {
            buffer = from_network_layer(); //get something to send.
            s.info = buffer; //prepare for transmission.
            s.to_physical_layer("localhost", 8888); //send the frame.
            event = r.wait_for_event(); //wait for the go ahead from receiver.
        }
    }
}
