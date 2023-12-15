class PointMain {
    public static void main(String[] args) {
        Point point = new Point();
        point.x = 2;
        point.y = 3;
        point.move(1,2);
        System.out.println(point.x + " " + point.y);
        point.mirror(0,0);
        System.out.println(point.x + " " + point.y);

        Point origin = new Point();
        origin.x = origin.y = 0;
        point.mirror(origin); //changes on point
        System.out.println(point.x + " " + point.y);
        System.out.println("origin x and y values: " + origin.x + " " + origin.y);
        System.out.println("The distance between my point and the origin is: " + point.distance(origin));


    }
}