import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class DrawPanel extends JPanel {

    private final ArrayList<Planet> list;
    private final BufferedImage background;
    private static final int SunSize = 160;

    private static final int CenterSun = Main.getWidth() / 2 - getSunSize() / 2;

    public static int getCenterSun() {
        return CenterSun;
    }

    public static int getSunSize() {
        return SunSize;
    }

    public DrawPanel(ArrayList<Planet> listArr) throws IOException {
        list = listArr;
        //Считываем изображение бэка
        background = ImageIO.read(new File("galaxy.jpg"));

        Timer t = new Timer(16, new MoveListener());
        t.start();
    }

    public class MoveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //По средству таймера, изменение позиций планет
            for (Planet planet : list) {
                planet.updatePosition();
            }
            repaint();
        }

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        //Отрисовка бекграунда
        graphics2D.drawImage(background, 0, 0, this);

        //Цвета для градиента
        Color[] colors = {
                new Color(250, 255, 0),
                new Color(229, 114, 32)
        };

        float[] fractions = {0.0f, 1.0f};
        //Создание градиента и отрисовка солнца
        Point2D center = new Point2D.Float(Main.getWidth() / 2, Main.getHeight() / 2);
        RadialGradientPaint gradient = new RadialGradientPaint(
                center, getSunSize(), fractions, colors);
        graphics2D.setPaint(gradient);
        g.fillOval(getCenterSun(), getCenterSun(), getSunSize(), getSunSize());


        //Отрисовка планет
        for (Planet planet : list) {
            planet.draw(g);
        }
    }

}
