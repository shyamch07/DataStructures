import java.util.ArrayList;
import java.util.PriorityQueue;
class Pair{
    int weight , u;
    Pair(int u,int weight){
        this.weight = weight;
        this.u = u;
    }
}
public class MinimumSpanningTree {
    public static int spanningTree(int V, int[][] edges) {
        boolean vis[] = new boolean[V];
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->{
            return a.weight - b.weight;
        });
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0] , v = edge[1] , weight = edge[2];
            adj.get(u).add(new Pair(v,weight));
            adj.get(v).add(new Pair(u,weight));
        }
        int sum = 0;
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
           Pair p1 = q.poll();
           if(vis[p1.u]) continue;
           sum+=p1.weight;
           vis[p1.u] = true;
           for(Pair p : adj.get(p1.u)){
               if(!vis[p.u]){
                   q.add(p);
               }
           }
        }
        return sum;
        
    }
    public static void main(String args[]){
        int V = 5;
        int[][] edges = {
        {0, 1, 2},
        {0, 3, 6},
        {1, 2, 3},
        {1, 3, 8},
        {1, 4, 5},
        {2, 4, 7},
        {3, 4, 9}
        };
        int ans = spanningTree(V,edges);
        System.out.println("Minimum Spanning Tree weight is : "+ans);
    }
}
