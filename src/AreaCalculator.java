class AreaCalculator {
    public static double calculateIntersectionArea(Parabola parabola, Circle circle, int numSamples) {
        int insideCount = 0;
        double minX = circle.center.x - circle.radius;
        double maxX = circle.center.x + circle.radius;
        double minY = circle.center.y - circle.radius;
        double maxY = circle.center.y + circle.radius;

        for (int i = 0; i < numSamples; i++) {
            double x = minX + Math.random() * (maxX - minX);
            double y = minY + Math.random() * (maxY - minY);
            Point p = new Point(x, y);

            if (circle.contains(p) && parabola.contains(p)) {
                insideCount++;
            }
        }

        double boundingBoxArea = (maxX - minX) * (maxY - minY);
        return boundingBoxArea * ((double) insideCount / numSamples);
    }
}
