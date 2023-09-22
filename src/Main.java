
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    private static int width = 1000;
    private static  int height = 1000;

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Solar System");
        frame.setSize(getWidth(), getHeight());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Добавляем планеты
        Planet planet1 = new Planet(6, 200, 40, new Color(0x0100FF));
        Planet planet2 = new Planet(1, 400, 60, new Color(0xFF0000));
        //Заполняем ими лист
        ArrayList<Planet> listPlanet = new ArrayList<>();
        listPlanet.add(planet1);
        listPlanet.add(planet2);

        DrawPanel panel = new DrawPanel(listPlanet);
        frame.add(panel);
        frame.setVisible(true);
    }
}
