

public class Main {

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.connected(2, 5);
        uf.union(2, 5);
        uf.printId();

        QuickUnionUF qkuf = new QuickUnionUF(10);
        qkuf.union(6, 9);
        qkuf.printId();

        UnionFindSize ufsz = new UnionFindSize(10);
        ufsz.union(4,8);
        ufsz.PrintId();

        UnionFindPath ufp = new UnionFindPath(10);
        ufp.union(4,8);
        ufp.PrintId();


    }
}
