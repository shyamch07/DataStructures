class UnionByRank { 
    int parent[];
    int rank[];
    UnionByRank(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
          parent[i] = i;
        }
    }
    int findParent(int u){
        if(parent[u] == u){
           return u;
        }
        return parent[u] = findParent(parent[u]);
    }
    void disJoint(int u,int v){
        int parentU = findParent(u);
        int parentV = findParent(v);
        if(parentU == parentV){
          return;
        }else if(rank[parentU] < rank[parentV]){
           parent[parentU] = parentV;
        }else if(rank[parentV] < rank[parentU]){
           parent[parentV] = parentU;
        }else{
            parent[parentV] = parentU;
            rank[parentU] +=1;
        }
    }
}

public class Union {
   public static void main(String args[]){
    int n = 5;
    UnionByRank unionByRank = new UnionByRank(n);
    unionByRank.disJoint(0, 2);
    unionByRank.disJoint(4, 2);
    unionByRank.disJoint(3, 1);
    if(unionByRank.findParent(4) == unionByRank.findParent(0)){
        System.out.println("Same");
    }else{
        System.out.println("Not Same");
    }
   }
}
