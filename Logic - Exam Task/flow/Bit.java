package flow;

public enum Bit
{
    ZERO,
    ONE;
    public Bit invert()
    {
        if (this == ONE) return ZERO;
        else return ONE;
    }
}
