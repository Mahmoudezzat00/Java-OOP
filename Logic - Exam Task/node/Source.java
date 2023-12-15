package node;

import node.base.Sender;
import flow.Wire;
import flow.Bit;
import exception.LogicException;

public class Source implements Sender
{
    private Wire output;
    public Wire getOutput(int index)
    {
        if (index != 0) throw new LogicException("Invalid index: " + index);
        return output;
    }
    public void switchOn()
    {
        output.setBit(Bit.ONE);
    }
    public void switchOff()
    {
        output.setBit(Bit.ZERO);
    }
}