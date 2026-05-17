import java.util.Objects;

/**
 * A concrete creature variant that renders symmetric multi-pointed stars on the canvas.
 * @Author Marko Etwaroo
 */
public class StarArtist extends Creature {
    private final int points;
    private final Complexity complexity;

    /**
     * Constructs a StarArtist with default positioning.
     * * @param name      the name of the artist
     * @param colorName geometric fill color name
     * @param points    number of stars points
     */
    public StarArtist(String name, String colorName, int points) {
        super(name, colorName);
        this.points = points < 3 ? 5 : points;
        this.complexity = this.points > 8 ? Complexity.COMPLEX : Complexity.MEDIUM;
        getTurtle().shape("triangle");
    }

    public StarArtist(String name, String colorName, double x, double y, int points) {
        super(name, colorName, x, y);
        this.points = points < 3 ? 5 : points;
        this.complexity = this.points > 8 ? Complexity.COMPLEX : Complexity.MEDIUM;
        getTurtle().shape("triangle");
    }

    public int getPoints() {
        return points;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    @Override
    public void performSpecialAction() {
        System.out.println(getName() + " is rendering a " + points + "-pointed star motif.");
        double angle = 180.0 - (180.0 / points);
        for (int i = 0; i < points; i++) {
            getTurtle().forward(100);
            getTurtle().left(angle);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StarArtist other = (StarArtist) obj;
        return this.points == other.points &&
               this.complexity == other.complexity &&
               Objects.equals(this.getName(), other.getName()) &&
               Objects.equals(this.getColorName(), other.getColorName());
    }

    @Override
    public String toString() {
        return String.format("StarArtist[Name='%s', Color='%s', Points=%d, Complexity=%s]", 
                getName(), getColorName(), points, complexity);
    }
}