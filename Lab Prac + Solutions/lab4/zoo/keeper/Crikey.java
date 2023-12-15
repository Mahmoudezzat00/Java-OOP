package zoo.keeper;
import zoo.animal.Panda;

public class Crikey {
    public static void main(String[] args) {
        Panda newbornPanda = new Panda("Bamboo", "USA");
        Panda foundlingPanda = new Panda(5, "France");

        newbornPanda.happyBirthday(3);
        foundlingPanda.happyBirthday(4);
    }
    
}