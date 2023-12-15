package music.recording;

public class RecordLabel {
    private final String name;
    private int cash;

    public RecordLabel(String name, int netWorth) {
        this.name = name;
        this.cash = netWorth;
    }

    public String getName() {
        return name;
    }

    public int getCash() {
        return cash;
    }

    public void gotIncome(int sum) {
        cash += sum;
    }
}
