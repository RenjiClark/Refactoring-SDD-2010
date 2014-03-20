package umm.softwaredesign.polygon.model;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private final List<Point> points;
    private int numPoints;

    public Polygon() {
        points = new ArrayList<Point>();
        numPoints = 0;
    }

    public boolean checkIntersects(final Point first, final Point second, final Point third, final Point fourth) {
        return Line2D.linesIntersect(first.getX(), first.getY(), second.getX(), second.getY(), third.getX(), third.getY(), fourth.getX(), fourth.getY());
    }


    void addPoint(final Point newPoint, final int position) {
        Point twoBefore = points.get(((position - 1) + numPoints) % numPoints);
        Point oneBefore = points.get(position);
        Point oneAfter = points.get((position + 1) % numPoints);
        Point twoAfter = points.get((position + 2) % numPoints);

        //This checks if the new point would be counterclockwise with the other points nearby where it is being added.
        if (counterClockWise(oneBefore, oneAfter, newPoint) && counterClockWise(twoBefore, newPoint, oneBefore) && counterClockWise(newPoint, twoAfter, oneAfter)) {
            points.add(position + 1, newPoint);
            numPoints++;
        }
    }

    public List<Point> getPointList() {
        return points;
    }

    public void addInitialPoint(final Point point) {
        points.add(point);
        numPoints++;
    }

    boolean counterClockWise(final Point point1, final Point point2, final Point point3) {
        double TwoOneXDiff = point2.getX() - point1.getX();
        double ThreeTwoYDiff = point3.getY() - point2.getY();
        double TwoOneYDiff = point2.getY() - point1.getY();
        double ThreeTwoXDiff = point3.getX() - point2.getX();
        return ((TwoOneXDiff * ThreeTwoYDiff) - (TwoOneYDiff * ThreeTwoXDiff)) < 0;
    }

    public boolean contains(final Point point) {
        Point[] bounds = {new Point(0.0, 0.0), new Point(0.0, 10.0), new Point(10.0, 0.0), new Point(10.0, 10.0)};      
        boolean intersected;
        for (int i = 0; i < bounds.length; i++) {
            intersected = false;
            //This loop checks that a line drawn from point to one of the bounds intersects with at least one edge of the polygon.
            //If it does not then the point must be on the outside. Note that false positives are possible with strange shapes that
            //surround the point like Pacman eating a power pellet.
            for (int j = 0; j < numPoints && !intersected; j++) {
                if (checkIntersects(point, bounds[i], points.get(j), points.get((j + 1) % numPoints))) {
                    intersected = true;
                }
            }
            if (!intersected) {
                return false;
            }
        }
        return true;
    }



    public boolean isConvex() {
        for (int i = 0; i < numPoints; i++) {
            Point previousPoint = points.get((i-1+numPoints) % numPoints);
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i+1) % numPoints);
            if (!counterClockWise(previousPoint, nextPoint, currentPoint)) {
                return false;
            }
        }
        return true;
    }

    public double getArea() {
        return Math.abs(signedArea());
    }

    double signedArea() {
        double sum = 0.0;
        for (int i = 0; i < numPoints; i++) {
            double currentX = points.get(i).getX();
            double currentY = points.get(i).getY();
            double nextX = points.get((i + 1) % numPoints).getX();
            double nextY = points.get((i + 1) % numPoints).getY();
            sum += (currentX * nextY) - (currentY * nextX);
        }
        return sum/2;
    }

    public int getNumPoints() {
        return numPoints;
    }

}