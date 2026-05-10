import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

class Visualizer extends JPanel {
    private Parabola parabola;
    private Circle circle;
    private double scale = 30.0;

    public Visualizer(Parabola parabola, Circle circle) {
        this.parabola = parabola;
        this.circle = circle;
        setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.translate(getWidth() / 2, getHeight() / 2);
        g2d.scale(scale, -scale);
        g2d.setStroke(new BasicStroke((float) (1.0 / scale)));

        Path2D parabolaPath = new Path2D.Double();
        double startX = -100;
        parabolaPath.moveTo(startX, parabola.a * startX * startX + parabola.b * startX + parabola.c);
        for (double x = startX + 0.1; x <= 100; x += 0.1) {
            parabolaPath.lineTo(x, parabola.a * x * x + parabola.b * x + parabola.c);
        }
        parabolaPath.lineTo(100, 10000);
        parabolaPath.lineTo(-100, 10000);
        parabolaPath.closePath();

        Ellipse2D circleShape = new Ellipse2D.Double(
                circle.center.x - circle.radius,
                circle.center.y - circle.radius,
                circle.radius * 2,
                circle.radius * 2
        );

        Area parabolaArea = new Area(parabolaPath);
        Area circleArea = new Area(circleShape);

        Area intersection = new Area(parabolaArea);
        intersection.intersect(circleArea);

        g2d.setColor(new Color(0, 150, 255, 100));
        g2d.fill(intersection);

        g2d.setColor(Color.RED);
        g2d.draw(intersection);

        g2d.setColor(Color.BLACK);
        g2d.draw(circleShape);

        g2d.setColor(Color.GRAY);
        g2d.draw(parabolaPath);
    }
}