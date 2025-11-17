
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountingRoomsBFS {
    static int[][] directions = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int column = sc.nextInt();
        sc.nextLine();

        char[][] matrix = new char[rows][column];
        for (int i = 0; i < rows; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < column; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        int count = 0;
        boolean[][] visit = new boolean[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '.' && !visit[i][j]) {
                    bfs(i, j, matrix, visit);
                    count++;
                }
            }
        }
        System.out.println(count);
        sc.close();

    }

    static void bfs(int row, int column, char[][] matrix, boolean[][] visit) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, column });
        visit[row][column] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];
            for (int[] dirs : directions) {
                int newRow = r + dirs[0];
                int newColumn = c + dirs[1];
                if (isValid(newRow, newColumn, matrix.length, matrix[0].length) &&
                        matrix[newRow][newColumn] == '.' &&
                        !visit[newRow][newColumn]) {
                    queue.add(new int[] { newRow, newColumn });
                    visit[newRow][newColumn] = true;
                }
            }
        }
    }

    static boolean isValid(int i, int j, int rows, int column) {
        return i >= 0 && j >= 0 && i < rows && j < column;
    }
}
