import java.util.Arrays;

/**
 * Created by qiuying on 2020/4/19.
 */
public class UnionFindPath {
    public int[] id;

    public UnionFindPath (int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int p) {
        while( p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;

    }

    public void PrintId(){
        System.out.println(Arrays.toString(id));
    }
}
