public class QuickUnionUF{
    int id[];
    int sz[];
    public QuickUnionUF(int N){
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 0;
        }
    }

    private int root(int p){
        while(id[p] != p){
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    
    public boolean connected(int p, int q){
        if(root(p) == root(q))
            return true;
        else
            return false;
    }
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j)
            return;
        else{
            if(sz[i] < sz[j]){
                id[i] = j;
                sz[i] += sz[j];
            }
            else{
                id[j] = i;
                sz[j] += sz[i];
            }
        }
    }
}

