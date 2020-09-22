import java.util.*;

public class EaglesAndDogs {

    private static class Edge {
        int src;
        int dst;
        int wt;

        Edge(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        
        while(t-- > 0) {
            int n = scn.nextInt();

            // BUILDING GRAPH
            ArrayList<Edge>[] graph = new ArrayList[n];
            for( int idx = 0 ; idx < n ; idx++ )
                graph[idx] = new ArrayList<>();

            for(int idx = 0 ; idx < n - 1 ; idx++) {
                int vtx1 = scn.nextInt() - 1; 
                int vtx2 = scn.nextInt() - 1;
                int wt = scn.nextInt();

                graph[vtx1].add(new Edge(vtx1, vtx2, wt));
                graph[vtx2].add(new Edge(vtx2, vtx1, wt));
            }
            
            // APPLYING DFS TO FIND MAX WEIGHT PATH
            int[] dp = new int[n];
            Arrays.fill(dp, -1);   // DOGS AND EAGLES NEVER BE -1
            for( int vtx = 0 ; vtx < n ; vtx++ ) { 
                int vis[] = new int[n]; 
                Arrays.fill(vis, -1);
                dp[vtx] = dfs(graph, vtx, vis);
            }
        
            // DISPLAYING OUTPUT
            for(int idx = 0 ; idx < n ; idx++) 
                System.out.print(dp[idx] + " ");
            System.out.println();
        }
    }

    private static int dfs(ArrayList<Edge>[] graph, int cvtx, int[] vis) {
        vis[cvtx] = 0;
        for(Edge edge : graph[cvtx]) 
            if(vis[edge.dst] == -1)
                vis[cvtx] = Math.max(vis[cvtx], dfs(graph, edge.dst, vis) + edge.wt);
        
        return vis[cvtx];
    }
}
