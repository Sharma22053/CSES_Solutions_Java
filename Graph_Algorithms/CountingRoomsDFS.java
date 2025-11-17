import java.util.Scanner;

public class CountingRoomsDFS {
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
                    dfs(i, j, matrix, visit);
                    count++;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }

    static void dfs(int row, int column, char[][] matrix, boolean[][] visit) {
        if(visit[row][column]) return;
        visit[row][column] = true;
        for (int[] dirs : directions) {
            int newRow = row + dirs[0];
            int newColumn = column + dirs[1];
            if (isValid(newRow, newColumn, matrix.length, matrix[0].length) &&
                    !visit[newRow][newColumn] && matrix[newRow][newColumn] == '.') {
                dfs(newRow, newColumn, matrix, visit);
            }
        }

    }

    static boolean isValid(int i, int j, int rows, int column) {
        return i >= 0 && j >= 0 && i < rows && j < column;
    }
}

