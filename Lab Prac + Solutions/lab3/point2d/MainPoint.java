package point2d;

class MainPoint {
    public static void main(String[] args) {
        Point point = new Point();
        point.x = 3;
        point.y = 3;
        point.move(1,1);
        System.out.println("The values of x and y after moving by (1,1) are: "+ point.x + "  " + point.y);
        point.mirror(1,3);
        System.out.println("The values of x and y after mirror around (1,3) are: "+ point.x + "  " + point.y);
        point.mirror(0,0);
        System.out.println("The values of x and y after mirror around (0,0) are: "+ point.x + "  " + point.y);

        Point origin = new Point();
        origin.x = origin.y = 0;

        point.mirror(origin);
        System.out.println("The values of x and y after mirror around origin point are: "+ point.x + "  " + point.y); //changes
        System.out.println("The values of x and y of origin point are same: "+ origin.x + "  " + origin.y); //(0,0)

        System.out.println("The distance between these two points is: " + point.distance(origin));




    }
}