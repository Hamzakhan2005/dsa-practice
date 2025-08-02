import java.util.*;

public class RottenOranges {
    static class Rotten {
        int i, j;

        public Rotten(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int mat[][] = {
            {2, 1, 0, 2, 1},
            {0, 0, 1, 2, 1},
            {1, 0, 0, 2, 1}
        };

        int result = minTimeToRot(mat);
        System.out.println(result);
    }

    public static int minTimeToRot(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Queue<Rotten> queue = new LinkedList<>();
        int fresh = 0, time = 0;

        // Initialize the queue with all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new Rotten(i, j));
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Direction vectors for adjacent cells (up, down, left, right)
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        // BFS to spread the rot
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            boolean hasRotten = false;

            for (int i = 0; i < size; i++) {
                Rotten current = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int newRow = current.i + dRow[d];
                    int newCol = current.j + dCol[d];

                    // Check bounds and if the cell contains a fresh orange
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && mat[newRow][newCol] == 1) {
                        mat[newRow][newCol] = 2; // Turn it rotten
                        fresh--;
                        hasRotten = true;
                        queue.add(new Rotten(newRow, newCol));
                    }
                }
            }

            if (hasRotten) {
                time++;
            }
        }

        return (fresh == 0) ? time : -1; // Return -1 if not all oranges can be rotted
    }
}
