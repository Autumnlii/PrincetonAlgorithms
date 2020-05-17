//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private WeightedQuickUnionUF wf;
    private boolean[] flags;
    private int dimension;
    private int counter;
    private int virtualTop;
    private int virtualBottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n < 0) throw new IllegalArgumentException("dummies, do it again");
        dimension = n;
        counter = 0;
        wf = new WeightedQuickUnionUF(n*n+2);
        virtualTop = n*n;
        virtualBottom = n*n+1;
        flags = new boolean[n*n];
//        System.out.println("hello, world");
    }

    private int position (int row, int col) {
//        System.out.println("Row is: " + Integer.toString(row));
//        System.out.println("Col is: " + Integer.toString(col));

        row--; col--;

        if (row < 0 || col < 0 || row >= dimension || col >= dimension) {

            throw new IllegalArgumentException("dummies, do it again");
        }
        return row * dimension + col;

    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        //first open the position in the flags array
        // second check its neighbors are open, if so
        // third, weighted union find to connect them
        int index = position(row, col);
        if (flags[index]) return;

        flags[index] =true;
        counter ++;

        // if on the top row, union with virtual top

        if(row == 1 ) wf.union(index, virtualTop);

        // if on the bottom row, then union with virtual bottom
        if(row == dimension) wf.union(index, virtualBottom);

        // if on the bottom row, union with the virtual bottom


        // check valid left neighbor(can't be on the edges);

        if(col > 1 && flags[index -1]) wf.union(index, index -1);

        if(col < dimension && flags[index+1]) wf.union(index, index+1);


        // check the upper neighbor
        if(row > 1 && flags[index -dimension]) wf.union(index, index-dimension);

        if (row < dimension  && flags[index +dimension]) wf.union(index, index+dimension);

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = position(row, col);
//        System.out.println(index);
//        System.out.println(flags[index]);
        return flags[index];

    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        // the object is connected to the top row
        return wf.find(position(row, col)) == wf.find(virtualTop);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {

        return counter;
    }

    // does the system percolate?
    public boolean percolates() {
        // top row is connected to the bottom row


        return wf.find(virtualTop) == wf.find(virtualBottom);

    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(2);
//        System.out.println(p.position(1,1));
//        System.out.println(p.isOpen(0,1));
        p.open(1, 2);
        p.open(2, 1);
        System.out.println(p.percolates());
    }
}