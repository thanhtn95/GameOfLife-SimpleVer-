import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        World w1 = new World();
        w1.setWorld();
        int[][] world = w1.getOriginalWorld();
        System.out.println("First GEneration: ");
        for (int i = 0; i < world.length; i++) {
            System.out.println();
            for (int j = 0; j < world.length; j++) {
                System.out.print(world[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println("Enter number of generation to evolve: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[][] next;
        for (int a = 0; a < input; a++) {
            System.out.println("Generation " + (a + 2) + ": ");
            next = w1.nextGeneration();
            for (int i = 0; i < world.length; i++) {
                System.out.println();
                for (int j = 0; j < world.length; j++) {
                    System.out.print(next[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}
