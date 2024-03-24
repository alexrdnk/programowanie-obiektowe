
public class BurningForestSimulation {

    private static String[][] forest;
    private final int size;
    private final double forestation;

    public BurningForestSimulation(int size, double forestation) {
        this.size = size;
        this.forestation = forestation;
        forest = new String[size][size];
    }

    public void forestInit() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                forest[i][j] = Math.random() < forestation ? "T" : "X";
            }
        }
    }

    public void fireInit() {
        for (int i = 0; i < size; i++) {
            if (forest[0][i].equals("T")) {
                forest[0][i] = "B";
            }
        }
    }


    public void simulation() {
        boolean fireSpreading = true;
        while (fireSpreading) {
            fireSpreading = false;

            for (int i = 1; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (forest[i][j].equals("T")) {
                        for (int x = i - 1; x <= i + 1; x++) {
                            for (int y = j - 1; y <= j + 1; y++) {
                                if (y > -1 && y < size && x < size && forest[x][y].equals("B")) {
                                    forest[i][j] = "B";
                                    fireSpreading = true;
                                    break;
                                }
                            }
                            if (fireSpreading) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void showForest() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(forest[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public double getRatioForest() {
        double burntTrees = 0;
        double plantedTrees = 0;
        double totalTrees;
        double ratioBurntToTotal;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (forest[i][j].equals("B")) {
                    burntTrees++;
                } else if (forest[i][j].equals("T")) {
                    plantedTrees++;
                }
            }
        }
        totalTrees = plantedTrees + burntTrees;
        ratioBurntToTotal = burntTrees / totalTrees;
        return ratioBurntToTotal;
    }

    public static void main(String[] args) {
        System.out.println("\nForest Simulation");
        int L = 100;
        double[] forestationValues = {0.0, 0.05, 0.1, 0.15, 0.20, 0.25, 0.30,
                0.35, 0.40, 0.45, 0.50, 0.55, 0.60,
                0.65, 0.70, 0.75, 0.80, 0.85, 0.90, 0.95, 1.0};

        for (double forestation : forestationValues) {
            BurningForestSimulation simulation = new BurningForestSimulation(L, forestation);
            simulation.forestInit();
            simulation.fireInit();
            simulation.simulation();
            simulation.getRatioForest();
            double proportion = simulation.getRatioForest();
            System.out.println("Proportion if forestation is equal to " + forestation + " will be " + proportion);
        }
    }
}
