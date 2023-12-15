package node.base;

import flow.Wire;
import flow.Bit;
import exception.LogicException;

//javac exception\LogicException.java flow\Bit.java flow\Wire.java node\And.java node\base\Gate.java node\base\Receiver.java node\base\Sender.java node\Led.java node\Source.java

public abstract class Gate implements Sender, Receiver
{
    Wire[] inputs;
    Wire[] outputs;
    public Gate(int numInputs, int numOutputs)
    {
        if (numInputs < 0) throw new LogicException("Invalid number of inputs: " + numInputs);
        if (numOutputs < 0) throw new LogicException("Invalid number of outputs: " + numOutputs);
        inputs = new Wire[numInputs];
        outputs = new Wire[numOutputs];
        for (int i = 0; i < numOutputs; i++)
        {
            outputs[i] = new Wire();
        }
    }
    public void setInput(int index, Wire wire)
    {
        if (index < 0 || index >= inputs.length) throw new LogicException("Invalid index: " + index);
        inputs[index] = wire;
    }
    public Wire getOutput(int index)
    {
        if (index < 0 || index >= outputs.length) throw new LogicException("Invalid index: " + index);
        return outputs[index];
    }
    abstract protected Bit calculateResult(Bit[] bits);
    public void update()
    {
        Bit[] bits = new Bit[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            bits[i] = inputs[i].getBit();
        }
        Bit bit = calculateResult(bits);
        for (int i = 0; i < outputs.length; i++) {
            outputs[i].setBit(bit);
        }
    }
}