class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] row = new long[m];
        long[] col = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans += (row[i] - 1) * (col[j] - 1);
                }
            }
        }

        return ans;
    }
}