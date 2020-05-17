/**
 * Created by qiuying on 2020/5/4.
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;



    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        //Throw an IllegalArgumentException in the constructor if either n ≤ 0 or trials ≤ 0.
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("trials have to be greater than 0");
        }

        double[] percolationThresholds = new double[trials];
        for(int j = 0; j < trials; j++){

            int run = 0;
            Percolation p = new Percolation(n);
            while(!p.percolates()) {
                int row;
                int col;

                do {
                    row = 1 + StdRandom.uniform(n);
                    col = 1 + StdRandom.uniform(n);

                } while(p.isOpen(row, col));

                 p.open(row, col);
                 run++;
            }
            percolationThresholds[j] = run/(double) (n * n);

        }
            mean = StdStats.mean(percolationThresholds);
            stddev = StdStats.stddev(percolationThresholds);
            double confidenceFraction = (1.96 * stddev()) / Math.sqrt(trials);
            confidenceLo = mean - confidenceFraction;
            confidenceHi = mean + confidenceFraction;


    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, trails);
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());

    }

}
