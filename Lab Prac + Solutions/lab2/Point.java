class Point {
    double x,y; //(3,3) state

    void move(double dx, double dy) { // (1,1) -> (4,4) 
        x += dx;
        y += dy;
    }

    void mirror(double cx, double cy) {
        x = 2*cx - x;
        y = 2*cy - y;
    }

    void mirror(Point center) {
         x = 2*center.x - x;
        y = 2*center.y - y;
    }

    double distance(Point that) {
        double dx = x - that.x;
        double dy = y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}