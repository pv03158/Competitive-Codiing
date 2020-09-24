import java.util.*;

public class Akbar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-- > 0) {
            int n = scn.nextInt();
            int r = scn.nextInt();
            int m = scn.nextInt();

            ArrayList<Integer>[] graph = new ArrayList[n];
            for(int idx = 0 ; idx < n ; idx++)
                graph[idx] = new ArrayList<>();

            // ADDING EDGES
            for(int idx = 0 ; idx < r ; idx ++) {
                int a = scn.nextInt() - 1;
                int b = scn.nextInt() - 1;

                graph[a].add(b);
                graph[b].add(a);
            }

            int vis[] = new int[n];
            boolean ans = true;
            for(int idx = 0 ; idx < m ; idx++) {
                int k = scn.nextInt() - 1; 
                int s = scn.nextInt();

                if (ans) 
                    if( !bfs(graph, k, s, vis))
                        ans = false;
            }

            for(int idx = 0 ; idx < n ; idx++) {
                if(vis[idx] == 0) {
                    ans = false;
                    break;
                }
            }

            if(ans) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static boolean bfs(ArrayList<Integer>[] graph, int cvtx , int stren, int[] vis) {
        int base = cvtx + 1;
        if( vis[cvtx] != 0 )
            return false;
            
        Queue<Pair> q = new ArrayDeque<>((int)1e6 + 10);
        q.add(new Pair(cvtx, 0));
        vis[cvtx] = base;

        while(q.size() != 0) {
            Pair pair = q.remove();
            cvtx = pair.vtx;
            int level = pair.level;

            if(level >= stren)
                return true;

            for(int nbr : graph[cvtx]) {
                if( vis[nbr] == base )
                    continue;
                else if( vis[nbr] == 0 ) {
                    q.add( new Pair(nbr, level + 1));
                    vis[nbr] = base;
                }
                else 
                    return false;
            }
        }

        return true;
    }

    private static class Pair {
        int vtx;
        int level;

        Pair(int vtx, int level) {
            this.vtx = vtx;
            this.level = level;
        }
    }
}