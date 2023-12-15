import stringutils.IterLetter;

class MainStr {
    public static void main(String[] args) {
        IterLetter iter = new IterLetter("Java Language");
        iter.printNext(); //J
        iter.printNext(); //a

        iter.restart(); //counter = 0;
        iter.printNext(); //J

        while (iter.hasNext()) {
            iter.printNext();
        }

    }
}