/**
 * Creature that encapsulates the turtle.
 */
public abstract class Creature implements Renderable {
    private final Turtle turtle;
    private String name;
    private final String colorName;

    /**
     * initializes a Creature at the canvas origin.
     * @param name      the name of the creature
     * @param colorName the SVG color name string for filling
     */
    public Creature(String name, String colorName) {
        this.turtle = new Turtle();
        this.name = name;
        this.colorName = colorName;
        initializeTurtle();
    }

    /**
     * Initializes a Creature at custom coordinates.
     */
    public Creature(String name, String colorName, double x, double y) {
        this.turtle = new Turtle(x, y);
        this.name = name;
        this.colorName = colorName;
        initializeTurtle();
    }

    private void initializeTurtle() {
        this.turtle.fillColor(this.colorName);
        this.turtle.outlineColor("black");
    }

    public final Turtle getTurtle() {
        return this.turtle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorName() {
        return colorName;
    }

    public void advance(double distance) {
        System.out.println("[Telemetry] " + this.name + " is moving forward by " + distance + " units.");
        this.turtle.forward(distance);
    }

    public void rotateLeft(double degrees) {
        this.turtle.left(degrees);
    }

    @Override
    public void resetPosition() {
        System.out.println("[Telemetry] Teleporting " + this.name + " back to coordinates (0, 0).");
        this.turtle.setPosition(0, 0);
    }

    public abstract void performSpecialAction();
}