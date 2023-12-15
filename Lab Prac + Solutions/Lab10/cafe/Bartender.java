package cafe;

public class Bartender {
    private int legalAge;

    public Bartender(int legalAge) {
        this.legalAge = legalAge;
    }

    public boolean order(Guest guest) {
        return !(guest instanceof Minor minor && minor.getAge() < legalAge);
    }
}
