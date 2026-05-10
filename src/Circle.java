class Circle {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public boolean contains(Point p) {
        return Math.pow(p.x - center.x, 2) + Math.pow(p.y - center.y, 2) <= radius * radius;
    }
}