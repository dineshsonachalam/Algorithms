/*
 * Algorithm for Quick Union.
 * -Integer array id[] of size N.
 * -Interpretation: id[i] is parent of i.
 *
 *       0  1  2  3  4  5  6  7  8  9
 * id[]  0  1  9  4  9  6  6  7  8  9
 *
 *   0  1  9  6  7  8
 *        / \ |
 *        2 4 5
 *          |
 *          3
 * Improvement #1: 
 * If we put smaller tree along with larger
 * tree then it would be more efficient than
 * putting larger tree along with small tree
 * as we would have to iterate more for larger
 * tree. And we would have to maintain an
 * array to record size of each tree.
 *
 * Improvement #2:
 * When we iterate over the array, if we find
 * that a lower tree is "indirectly" connected
 * to a element then we automatically connect
 * it to the upper element detaching it from
 * the original position.
 *
 */

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

