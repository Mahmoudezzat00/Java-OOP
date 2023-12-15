package zoo.animal;

public class Panda {
    private String name;
    private int age;
    private String country;

    // Newborn Constructor 
    public Panda(String name, String country) {
        this.name = name;
        this.age = 0;
        this.country = country;
    }

    // Second Constructor
    public Panda(int age, String country) {
        this.age = age;
        this.country = country;
        this.name = age + " years old foundling from " + country;
    }

    public void happyBirthday(int limitYear) {
        age++;
        System.out.println("Happy Birthday, " + name + "! You are now " + age + " years old and living in " + country + ".");

        if (age > limitYear) {
            country = "People's Republic of China";
            System.out.println("You are now repatriated to the " + country + ".");
        }
    }
}
