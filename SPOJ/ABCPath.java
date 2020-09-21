import java.util.*;

public class ABCPath {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int tc = 0;
        while (true) {
            int m = scn.nextInt();
            int n = scn.nextInt();

            if (m == 0 && n == 0)
                return;

            if (m == 0 || n == 0) {
                System.out.println(0);
                return ;
            }

            char[][] mat = new char[m][n];
            scn.nextLine(); // remove newline char left after taking ints
            for (int i = 0; i < m; i++)
                mat[i] = scn.nextLine().toCharArray();

            // NEED TO FIND LONGEST PATH OF CONSECUTIVE LETTERS
            int vis[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (vis[i][j] == 0)
                        dfs(mat, i, j, vis);
                }
            }

            int maxlength = 0;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (mat[i][j] == 'A')
                        maxlength = Math.max(maxlength, vis[i][j]);
            System.out.println("Case " + ++tc + ": " + maxlength);
        }
    }

    private static int dfs(char[][] mat, int i, int j, int[][] vis) {
        int m = mat.length;
        int n = mat[0].length;

        if (vis[i][j] != 0)
            return vis[i][j];

        int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };
        for (int idx = 0; idx < dir.length; idx++) {
            int r = i + dir[idx][0];
            int c = j + dir[idx][1];

            if (r >= 0 && r < m && c >= 0 && c < n) {
                if (mat[i][j] + 1 == mat[r][c]) {
                    vis[i][j] = Math.max(vis[i][j], dfs(mat, r, c, vis) + 1);
                }
            }
        }

        if (vis[i][j] == 0)
            vis[i][j] = 1;
        return vis[i][j];
    }
}
