class Greet {
    public static void main(String[] args) {
        String name = System.console().readLine(); //read
        System.console().printf("Hello %s!\n", name); //print

        //in java
        System.out.println("Hello " + name + "!");
    }
}