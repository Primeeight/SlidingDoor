/**
 * SlidingWindow
 */
public class protocol4B extends Protocol {
    public static void main(String args[]) throws Exception {
        int next_frame_to_send= 0;
        int frame_expected= 0;
        Frame r = new Frame(5555);
        Frame s = new Frame(4444);
        String buffer;
        int event;

        buffer = from_network_layer();
        s.info = buffer;
        s.seq = next_frame_to_send;
        s.ack = 1 - frame_expected;
        s.to_physical_layer("10.0.2.15", 7777);
        r.start_timer(r.seq);
        while (true) {
            event = r.wait_for_event();
            if (event != frame_arrival) System.out.println("timeout");
            if (event == frame_arrival) {
                r.from_physical_layer();
                if (r.seq == frame_expected) {
                    to_network_layer(r.info);
                    next_frame_to_send = (next_frame_to_send + 1) % 2; //does this invert frame?
                    if (r.ack == next_frame_to_send) {
                        r.stop_timer(r.ack);
                        buffer = from_network_layer();
                        next_frame_to_send = (next_frame_to_send + 1) % 2; //does this invert frame?

                    }
                }
            }
            s.info = buffer;
            s.seq = next_frame_to_send;
            s.ack = 1 - frame_expected;
            s.to_physical_layer("10.0.2.15", 7777);
            s.start_timer(s.seq);
        }
    }
}
