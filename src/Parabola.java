class Parabola {
    double a, b, c;

    public Parabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean contains(Point p) {
        return p.y >= a * p.x * p.x + b * p.x + c;
    }
}