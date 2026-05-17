import java.util.Scanner;

/**
 * Uses the terminal to take inputs.
 */
public class App {
    public static void main(String[] args) {
        Turtle.maximize();

        StarArtist square = new StarArtist("Triangle", "gold", -160, 0, 5);
        SpiralArtist triangle = new SpiralArtist("Square", "deeppink", 160, 0, 55);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=================================================");
        System.out.println("                 Turtle Controller               ");
        System.out.println("=================================================");

        while (running) {
            System.out.println("\n-------------------------------------------------");
            System.out.println("Select a control option code from the list:");
            System.out.println("1 -> Command Triangle to Draw Star");
            System.out.println("2 -> Command Square to Paint Spiral");
            System.out.println("3 -> Advance Triangle Forward manually");
            System.out.println("4 -> Advance Square Forward manually");
            System.out.println("5 -> View Object Data Diagnostics (toString/equals)");
            System.out.println("6 -> Teleport All Artists Back to Center (0, 0)");
            System.out.println("7 -> Exit Program");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    square.performSpecialAction();
                    System.out.println("[Success] Star motif compilation finalized.");
                    break;

                case "2":
                    triangle.performSpecialAction();
                    System.out.println("[Success] Concentric spiral calculation completed.");
                    break;

                case "3":
                    System.out.print("Enter forward step distance for Square: ");
                    double squareDist = getValidDouble(scanner);
                    square.advance(squareDist);
                    break;

                case "4":
                    System.out.print("Enter forward step distance for Triangle: ");
                    double triangleDist = getValidDouble(scanner);
                    triangle.advance(triangleDist);
                    break;

                case "5":
                    System.out.println("\n====== RUNTIME MEMORY LOG OBJECT DUMP ======");
                    System.out.println(square.toString());
                    System.out.println(triangle.toString());
                    System.out.println("Are instance metrics identical (equals)? " + square.equals(triangle));
                    System.out.println("============================================");
                    break;

                case "6":
                    System.out.println("\n[Action] Forcing spatial tracking system resets...");
                    square.resetPosition();
                    triangle.resetPosition();
                    System.out.println("[Telemetry] Reset operational anchors to canvas center indices.");
                    break;

                case "7":
                    System.out.println("\n[Shutdown] Shutting down controller and cleaning engine stacks...");
                    running = false;
                    break;

                default:
                    System.out.println("[Error] Invalid option code. Please enter a valid code between 1 and 7.");
            }
        }

        // Clean up resources cleanly
        scanner.close();
        Turtle.exit();
        System.exit(0);
    }

    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("[Error] Invalid numeric format. Please input a numerical double: ");
            }
        }
    }
}