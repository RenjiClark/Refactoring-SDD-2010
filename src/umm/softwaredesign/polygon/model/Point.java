package umm.softwaredesign.polygon.model;


public class Point {
    private final double xCoord;
    private final double yCoord;
    
    public Point(){
    	xCoord = PolygonModel.getRandom().nextDouble() * 10;
        yCoord = PolygonModel.getRandom().nextDouble() * 10;   
    }
    
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
}
