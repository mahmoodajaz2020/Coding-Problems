import java.text.DecimalFormat;

public class GeneralRelativitySimulation {

    private static final int DELAY = 100; // Delay between updates in milliseconds
    private static final double G = 6.674e-11; // Gravitational constant

    private static final int WIDTH = 40; // Width of the console grid
    private static final int HEIGHT = 20; // Height of the console grid

    private double massA = 1e10; // Mass of object A
    private double massB = 1e10; // Mass of object B

    private double positionA = -1.5; // Initial position of object A
    private double positionB = 1.5; // Initial position of object B

    private double velocityA = 0; // Initial velocity of object A
    private double velocityB = 0; // Initial velocity of object B

    private char[][] grid = new char[HEIGHT][WIDTH]; // Console grid

    public void runSimulation() {
        for (int time = 0; time <= 10; time++) {
            clearGrid();

            // Update positions and velocities
            update();

            // Render the grid
            render();

            // Print the grid to the console
            printGrid();

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void clearGrid() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    private void update() {
        double accelerationA = computeAcceleration(positionA, massA, positionB, massB);
        double accelerationB = computeAcceleration(positionB, massB, positionA, massA);

        velocityA += accelerationA * DELAY / 1000.0;
        velocityB += accelerationB * DELAY / 1000.0;

        positionA += velocityA * DELAY / 1000.0;
        positionB += velocityB * DELAY / 1000.0;
    }

    private double computeAcceleration(double position1, double mass1, double position2, double mass2) {
        double separation = Math.abs(position2 - position1);
        double force = G * mass1 * mass2 / Math.pow(separation, 2);
        double acceleration = force / mass1;

        // Adjust acceleration based on general relativity effects
        double relativisticFactor = 1 + (2 * G * (mass1 + mass2) / (separation * Math.pow(299792458, 2)));
        acceleration *= relativisticFactor;

        // Account for direction of acceleration
        if (position2 < position1) {
            acceleration *= -1;
        }

        return acceleration;
    }

    private void render() {
        int xA = (int) Math.round(positionToGridX(positionA));
        int xB = (int) Math.round(positionToGridX(positionB));

        if (xA >= 0 && xA < WIDTH) {
            grid[HEIGHT / 2][xA] = 'A';
        }

        if (xB >= 0 && xB < WIDTH) {
            grid[HEIGHT / 2][xB] = 'B';
        }
    }
    private double positionToGridX(double position) {
        double minPosition = -3.0;
        double maxPosition = 3.0;

        double gridWidth = WIDTH - 1;
        return (position - minPosition) / (maxPosition - minPosition) * gridWidth;
    }

    private void printGrid() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GeneralRelativitySimulation simulation = new GeneralRelativitySimulation();
        simulation.runSimulation();
    }
}
