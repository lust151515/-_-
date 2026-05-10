import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите коэффициенты параболы (a, b, c) для y = ax^2 + bx + c:");
    double a = scanner.nextDouble();
    double b = scanner.nextDouble();
    double c = scanner.nextDouble();
    Parabola parabola = new Parabola(a, b, c);

    List<Circle> circles = new ArrayList<>();
    System.out.println("Сколько окружностей вы хотите добавить?");
    int count = scanner.nextInt();

    for (int i = 0; i < count; i++) {
      System.out.println("Окружность" + (i + 1));
      System.out.print("Введите X центра: ");
      double x = scanner.nextDouble();
      System.out.print("Введите Y центра: ");
      double y = scanner.nextDouble();
      System.out.print("Введите радиус: ");
      double r = scanner.nextDouble();
      circles.add(new Circle(new Point(x, y), r));
    }

    if (circles.isEmpty()) {
      System.out.println("Список окружностей пуст. Выход.");
      return;
    }

    int monteCarloSamples = 200000;
    Circle bestCircle = TaskSolver.findBestCircle(parabola, circles, monteCarloSamples);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new Visualizer(parabola, bestCircle));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    scanner.close();
  }
}