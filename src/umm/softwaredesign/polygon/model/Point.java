package umm.softwaredesign.polygon.model;

import java.util.Random;


public class Point {
    private final double xCoord;
    private final double yCoord;
    
    public Point(final double xInput, final double yInput) {
        xCoord = xInput;
        yCoord = yInput;
    }
    
    public double getX() {
        return this.xCoord;
    }
    
    public double getY() {
        return this.yCoord;
    }
    
    static Point generateRandomPoint() {
        Random random = new Random();
        double coordX;
        double coordY;
        coordX = random.nextDouble() * 10;
        coordY = random.nextDouble() * 10;
        Point point = new Point(coordX, coordY);
        return point;
    }
}
