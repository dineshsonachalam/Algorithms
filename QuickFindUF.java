public class QuickFindUF{
    private int id[];
    public QuickFindUF(int N){
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }
    public boolean connected(int p, int q){
        if(id[p] == id[q])
            return true;
        else
            return false;
    }
    public void union(int p, int q){
        if(!connected(p, q)){
            int pid = id[p];
            int qid = id[q];

            for(int i = 0; i < id.length; i++){
                if(id[i] == pid)
                    id[i] = qid;
            }
        }
        else
            return;
    }
}
