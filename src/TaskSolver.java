import java.util.List;
class TaskSolver {
    public static Circle findBestCircle(Parabola parabola, List<Circle> circles, int samples) {
        Circle bestCircle = null;
        double maxArea = -1;

        for (Circle circle : circles) {
            double area = AreaCalculator.calculateIntersectionArea(parabola, circle, samples);
            if (area > maxArea) {
                maxArea = area;
                bestCircle = circle;
            }
        }
        return bestCircle;
    }
}