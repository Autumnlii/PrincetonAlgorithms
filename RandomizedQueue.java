import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
    public int size;
    public Item[] q;




    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        q = (Item[]) new Object[1];


    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;

    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    public void resize(int new_size) {
        Item[] copy = (Item[]) new Object[new_size];
        for (int i = 0; i < size; i++){
            copy[i] = q[i];
        }
        q = copy;

    }


    // add the item
    public void enqueue(Item item) {
        if(item == null) {
            throw new NullPointerException();

        }
        if(size == q.length) {
            System.out.println("size is");
            System.out.println(size);
            System.out.println("length is");
            System.out.println(q.length);
            resize(2*q.length);
            q[size++] = item;

        }
        else{
            q[size++] = item;
        }
    }

    // remove and return a random item
    public Item dequeue() {
        int randomIndex = StdRandom.uniform(size);
        Item temp = q[randomIndex];
        q[randomIndex] = q[size-1];
        q[size-1] = temp;
        Item item = q[--size];
        q[size] = null;
        if(size == q.length/4) {
            resize(q.length/2);
        }

         return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if(isEmpty()){
            throw new java.util.NoSuchElementException();

        }
        int m = StdRandom.uniform(size);
        return q[m];


    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i;

        public ArrayIterator() {
            i = 0;
        }

        public boolean hasNext() {
            return i < size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return q[i++];
        }
    }







    // unit testing (required)
    public static void main(String[] args) {


        int n = 5;
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 0; i < n; i++) {
            System.out.println(i);
            queue.enqueue(i);

        }
        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }


    }

}