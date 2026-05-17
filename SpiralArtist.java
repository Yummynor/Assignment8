import java.util.Objects;

/**
 * builds an outward expanding spiral.
 */
public class SpiralArtist extends Creature {
    private final int totalSteps;
    private final Complexity complexity;

    /**
     * Constructs a SpiralArtist with default placement coordinates.
     * * @param name       the name of the artist
     * @param colorName  geometric outline color name
     * @param totalSteps number of concentric segments to form the spiral
     */
    public SpiralArtist(String name, String colorName, int totalSteps) {
        super(name, colorName);
        this.totalSteps = totalSteps <= 0 ? 40 : totalSteps;
        this.complexity = this.totalSteps > 60 ? Complexity.COMPLEX : Complexity.MEDIUM;
        getTurtle().shape("circle");
    }

    public SpiralArtist(String name, String colorName, double x, double y, int totalSteps) {
        super(name, colorName, x, y);
        this.totalSteps = totalSteps <= 0 ? 40 : totalSteps;
        this.complexity = this.totalSteps > 60 ? Complexity.COMPLEX : Complexity.MEDIUM;
        getTurtle().shape("circle");
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    @Override
    public void performSpecialAction() {
        System.out.println(getName() + " is painting an expanding spiral formation.");
        double currentLength = 4;
        for (int i = 0; i < totalSteps; i++) {
            getTurtle().forward(currentLength);
            getTurtle().left(90);
            currentLength += 3; // Steadily expand outwards
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SpiralArtist other = (SpiralArtist) obj;
        return this.totalSteps == other.totalSteps &&
               this.complexity == other.complexity &&
               Objects.equals(this.getName(), other.getName()) &&
               Objects.equals(this.getColorName(), other.getColorName());
    }

    @Override
    public String toString() {
        return String.format("SpiralArtist[Name='%s', Color='%s', TotalSteps=%d, Complexity=%s]", 
                getName(), getColorName(), totalSteps, complexity);
    }
}