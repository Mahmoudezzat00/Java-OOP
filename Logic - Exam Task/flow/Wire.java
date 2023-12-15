package flow;

import node.base.Sender;
import node.base.Receiver;

public class Wire
{
    private Receiver receiver;
    private Bit bit = Bit.ZERO;
    public Bit getBit() { return bit; }
    public void setBit(Bit bit) {
        if (this.bit != bit) {
            this.bit = bit;
            if (receiver != null) receiver.update();
        }
    }
    public Receiver getEnd() { return receiver; }
    public static void connect(Sender sender, int outIdx, Receiver receiver, int inpIdx) {
        Wire w = sender.getOutput(outIdx);
        w.receiver = receiver;
        receiver.setInput(inpIdx, w);
        receiver.update();
    }
}