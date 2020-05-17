import java.util.Arrays;

/**
 * Created by qiuying on 2020/4/19.
 */
public class UnionFindSize {
    private int[] id;
    private int[] sz;

    public UnionFindSize(int N) {
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int p){
        while(id[p] != p) id[p] = p;
        return p;
    }
    public void union (int p, int q){
        int i = id[p];
        int j = id[q];
        if( i ==j) return;
        if(sz[i] < sz[i]) {
            id[i] = j;
            sz[j] = sz[j] + sz[i];
        } else{
            id[j] = i;
            sz[i] = sz[i]+ sz[j];
        }
    }
    public void PrintId(){
        System.out.println(Arrays.toString(id));
    }
}
