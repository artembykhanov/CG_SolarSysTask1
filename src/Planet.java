import java.awt.*;
public class Planet {
    private double earthX = 0;
    private double earthY = 0;
    private double earthAngle = 0;
    private int speed;
    private int radiusSun;
    private int diameter;
    private Color color;
    public Planet(int speed, int radiusSun, int diameter, Color color) {
        this.setSpeed(speed);
        this.setRadiusSun(radiusSun);
        this.setDiameter(diameter);
        this.setColor(color);
    }
    public void updatePosition() {
        //Параметр скорости влияет на угол поворота
        earthAngle += getSpeed();
        earthX = getRadiusSun() * Math.cos(Math.toRadians(earthAngle));
        earthY = getRadiusSun() * Math.sin(Math.toRadians(earthAngle));
    }
    public void draw(Graphics g) {
        //Отрисовка планет
        g.setColor(getColor());
        g.fillOval((int) earthX + Main.getWidth()/2, (int) earthY + Main.getHeight()/2, getDiameter(), getDiameter());
    }
    public int getSpeed() {
        return speed;
    }
    public int getRadiusSun() {
        return radiusSun;
    }
    public int getDiameter() {
        return diameter;
    }
    public void setSpeed(int speed) {
        if (speed > 0) {
            this.speed = speed;
        }
        else throw new IllegalArgumentException();
    }
    public void setRadiusSun(int radiusSun) {
        if (radiusSun > 0) {
            this.radiusSun = radiusSun;
        }
        else throw new IllegalArgumentException();
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setDiameter(int diameter) {
        if (diameter > 0) {
            this.diameter = diameter;
        }
    }
}