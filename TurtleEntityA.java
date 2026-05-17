public abstract class AbstractTurtleEntity {

    private final Turtle turtle;
    private String name;
    private int speed;

    public AbstractTurtleEntity(String name) {
        this(name, 5);
    }

    public AbstractTurtleEntity(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.turtle = new Turtle();
    }

    public Turtle getTurtle() {
        return turtle;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public void moveForward() {
        turtle.forward(speed);
    }

    public void turnLeft(int angle) {
        turtle.left(angle);
    }

    public void turnRight(int angle) {
        turtle.right(angle);
    }

    public abstract void performBehavior();

    public abstract void setupAppearance();
}