class Circle {
    private double x; //this.x
    private double y; //this.y
    private double radius; //this.radius

    public Circle() {
        // this.x = 12; 
        // this.y = 3;
        // this.radius = 2;
    }

    public Circle(double x, double y, double radius) {
        this.x = x; 
        this.y = y;
        if (radius <= 0) {
            throw new IllegalArgumentException("You should not assign a -ve value for the radius!");
        }
        this.radius = radius;
    }

    //read
    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }


    public double getArea() {
        return Math.PI*radius*radius;
    }
}

class CircleMain {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("The area of the 1st circle is: " + circle.getArea());
        Circle circle2 = new Circle(5,2,10);
        System.out.println("The area of the 2ed circle is: " + circle2.getArea());

        System.out.println("x value: " + circle2.getX()); //read

    }
}