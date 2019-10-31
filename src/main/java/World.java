import java.util.Scanner;

public class World {
    private int[][] world, originalWorld;
    private static final int[][] shiftpost = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public World() {

    }

    public int[][] getWorld() {
        return world;
    }

    public int[][] getOriginalWorld() {
        return originalWorld;
    }

    public void setWorld() {
        try {
            Scanner sc = new Scanner(System.in);
            int size = sc.nextInt();
            this.world = new int[size][size];
            for (int i = 0; i < size; i++) {
                System.out.println("Enter row " + (i + 1) + ": ");
                for (int j = 0; j < size; j++) {
                    world[i][j] = sc.nextInt();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        originalWorld = world;
    }

    public int[][] nextGeneration() {
        int[][] nextGen = new int[world.length][world.length];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world.length; j++) {
                int count = count(i, j);
                if (world[i][j] == 0) {
                    if (count == 3) {
                        nextGen[i][j] = 1;
                    } else nextGen[i][j] = 0;
                } else {
                    if (count < 2 || count > 3) {
                        nextGen[i][j] = 0;
                    } else nextGen[i][j] = 1;
                }
            }
        }
        this.world = nextGen;
        return nextGen;
    }

    private int count(int x, int y) {
        int count = 0;
        for (int[] pos : shiftpost) {
            int tmpX = x + pos[0];
            int tmpY = y + pos[1];
            if (tmpX >= 0 && tmpY >= 0 && tmpX < world.length && tmpY < world.length) {
                if (world[tmpX][tmpY] == 1) {
                    count++;
                }
                if (count>3) return count;
            }
        }
        return count;
    }
}
