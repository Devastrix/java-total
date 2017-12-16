package matrix;

import java.util.Random;

public class MatrixGen {

    public static void main(String[] args) {
    }

    private static double[][] RandomArray() {
        int n = 5, m = 10, count; //5 guards, 10 locks
        boolean[] guardFill = new boolean[11];
        Random rand = new Random();
        while (true) {
            int[][] randomMatrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                count = 0;
                resetB(guardFill, 11);
                for (int j = 0; j < m; j++) {
                    int r = rand.nextInt(10);
                    if (r < 5) {
                        int randFill = rand.nextInt(10 - 1) + 1;
                        if (!guardFill[randFill]) {
                            randomMatrix[i][j] = randFill;
                            count++;
                            guardFill[randFill] = true;
                        }
                    }
                }
            }
            if (verifyMatrix(randomMatrix, n, m))
                break;
            ;
        }
        return null;
    }

    static void resetB(boolean b[], int n) {
        for (int i = 0; i <= n; i++) {
            b[i] = false;
        }
    }

    static boolean verifyMatrix(int[][] mat, int n, int m) {
        int size = 10;
        boolean b[] = new boolean[size + 1];
        resetB(b, size);
        return false;
    }

    public void printGraph(int[][] array, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(array[i][j]);
            }
        }
    }

    public void printGraph1(int[][] array, int n, int m) {
        for (int i = 0; i < n; i++) {
            System.out.print(" [ ");
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]);
            }
            //Put println instead of print here to have each row in a new line
            System.out.print(" ]");
        }
    }
}
