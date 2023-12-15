package point2d;

class Point {
    public double x; //this.x
    public double y; //states, current values

    //behaviours
    void move(double dx, double dy ) { //
        x += dx;
        y += dy;
    }

    void mirror(double cx, double cy) { //(1,3)
        x = 2*cx - x;
        y = 2*cy - y;
    }

    void mirror(Point that) {
        x = 2*that.x - x;
        y = 2*that.y - y;
    }

    double distance(Point that) {
        double dx = x - that.x;
        double dy = y - that.y;
        return Math.sqrt(dx*dx + dy*dy);

    }
}