public class MinimalGridPath {
    public static void main(String[] args) {
        char[][] matrix = {
                { 'A', 'A', 'C', 'A' },
                { 'B', 'A', 'B', 'C' },
                { 'A', 'B', 'D', 'A' },
                { 'A', 'A', 'C', 'A' }
        };
        int n = 4;
        System.out.println(helper(matrix, 0, 0, n));
    }

    static int helper(char[][] matrix, int row, int column, int n) {
        if (row == n - 1 && column == n - 1)
            return 1;

        int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
        if (isValid(row, column + 1, n)) {
            right = Math.min(right , 1 + helper(matrix,row,column+1,n));
        }
        if (isValid(row + 1, column, n)) {
           down = Math.min(down,1 + helper(matrix,row+1,column,n));
        }
        return Math.min(right,down);
    }

    static boolean isValid(int row, int column, int n) {
        return row >= 0 && column >= 0 && row < n && column < n;
    }
}
