package umm.softwaredesign.testrunner.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import umm.softwaredesign.polygon.model.Point;
import umm.softwaredesign.polygon.model.Polygon;
import umm.softwaredesign.polygon.model.PolygonModel;


public class ConvexityTest {

    @Test
    public final void randomConvexTest() {
        PolygonModel model = new PolygonModel();
        Polygon polygon = model.getPoly();
        model.createRandomPolygon();
        assertTrue("Polygon is not convex", polygon.isConvex());
    }

    @Test
    public final void convexTest() {
        PolygonModel model = new PolygonModel();
        Polygon polygon = model.getPoly();
        polygon.addInitialPoint(new Point(2, 2));
        polygon.addInitialPoint(new Point(7, 2));
        polygon.addInitialPoint(new Point(7, 7));
        polygon.addInitialPoint(new Point(2, 7));
        assertTrue("Polygon is not convex", polygon.isConvex());
    }

    @Test
    public final void failedConvexTest() {
        PolygonModel model = new PolygonModel();
        Polygon polygon = model.getPoly();
        polygon.addInitialPoint(new Point(7, 7));
        polygon.addInitialPoint(new Point(2, 2));
        polygon.addInitialPoint(new Point(7, 2));      
        polygon.addInitialPoint(new Point(2, 7));
        assertFalse("Polygon is not convex", polygon.isConvex());
    }

}
