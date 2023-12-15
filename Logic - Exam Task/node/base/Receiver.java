package node.base;

import flow.Wire;

public interface Receiver
{
    public void setInput(int index, Wire wire);
    public void update();
}