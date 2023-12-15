package node;

import flow.Wire;
import flow.Bit;
import node.base.Receiver;
import exception.LogicException;

public class Led implements Receiver
{
    private Wire wire;
    private boolean isOn;
    public boolean isOn() { return isOn; }
    public void setInput(int index, Wire wire)
    {
        if (index != 0) throw new LogicException("Invalid index: " + index);
        this.wire = wire;
    }
    public void update()
    {
        isOn = wire.getBit() == Bit.ONE;
    }
}