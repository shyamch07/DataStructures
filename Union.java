class UnionBySize{
    int parent[];
    int size[];
    UnionBySize(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
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
        }
        if(size[parentU] < size[parentV]){
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        }else if(size[parentV] < size[parentU]){
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        }else{
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        }

    }
}
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
    UnionBySize unionBySize = new UnionBySize(n);
    unionBySize.disJoint(0, 2);
    unionBySize.disJoint(4, 2);
    unionBySize.disJoint(3, 1);
    if(unionBySize.findParent(4) == unionBySize.findParent(0)){
        System.out.println("Both Nodes belongs to same Component");
    }else{
        System.out.println("Both Nodes belongs to different Components");
    }
   }
}
