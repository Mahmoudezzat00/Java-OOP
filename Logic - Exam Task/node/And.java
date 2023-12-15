package node;

import flow.Bit;
import node.base.Gate;

public class And extends Gate
{
    public And(int numInputs) {
        super(numInputs, 1);
    }
    protected Bit calculateResult(Bit[] bits)
    {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == Bit.ZERO) return Bit.ZERO;
        }
        return Bit.ONE;
    }
}