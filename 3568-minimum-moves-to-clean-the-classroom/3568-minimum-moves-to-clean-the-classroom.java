import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] litter = new int[10][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litter[litterCount][0] = i;
                    litter[litterCount][1] = j;
                    litterCount++;
                }
            }
        }

        int allCollected = (1 << litterCount) - 1;
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc, energy, 0, 0});
        visited[sr][sc][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];
            if (mask == allCollected) {
                return moves;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }
                if (e == 0) {
                    continue;
                }

                int newEnergy = e - 1;
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }
                int newMask = mask;

                for (int i = 0; i < litterCount; i++) {
                    if (litter[i][0] == nr && litter[i][1] == nc) {
                        newMask |= (1 << i);
                        break;
                    }
                }

                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(new int[]{
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}