public class QuickUnionUF{
    int id[];
    public QuickUnionUF(int N){
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    private int root(int p){
        while(id[p] != p)
            p = id[p];
        return p;
    }
    
    public boolean connected(int p, int q){
        if(root(p) == root(q))
            return true;
        else
            return false;
    }
    public int union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}

