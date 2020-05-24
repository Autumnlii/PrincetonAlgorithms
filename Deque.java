
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Deque<Item> {//implements Iterable<Item> {

    private int size;
    private Node first;
    private Node last;

    private class Node {
        Item item;
        Node prev;
        Node next;
    }


    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;


    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {

        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {

        //
        if(item == null) {
            throw new IllegalArgumentException("null is not an item");

        }
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            first = last;
        }
        if (!isEmpty() && first == last) {
            Node new_first = new Node();
            first = new_first;
            first.item = item;
            first.next = last;
            last.prev = first;
        }
        if (!isEmpty() && first != last) {
            Node new_first = new Node();
            Node old_first = first;
            first = new_first;
            first.item = item;
            first.next = old_first;
            old_first.prev = first;
        }

        size++;

    }

    // add the item to the back
    public void addLast(Item item) {
        if(item == null) {
            throw new IllegalArgumentException("null is not an item");

        }
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            last.next = null;
            last.prev = null;
            first = last;
        }
        if (!isEmpty() && first == last) {
            Node new_last = new Node();
            last = new_last;
            last.item = item;
            last.prev = first;
            first.next = last;
        }
        if (!isEmpty() && first != last) {
            Node new_last = new Node();
            Node old_last = last;
            last = new_last;
            last.item = item;
            last.prev = old_last;
            old_last.next = last;
        }

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {

        Node new_node;

        if (first == null) {

            throw new java.util.NoSuchElementException();

        }

        new_node = first;
        size--;

        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }


        return new_node.item;
    }


    // remove and return the item from the back
    public Item removeLast() {


        if (last == null) {
            throw new java.util.NoSuchElementException();
        }
        Node new_node = last;
        size--;
        if (isEmpty()) {

            first = null;
            last = first;
        } else {
            last = last.prev;
            last.next = null;
        }
        return new_node.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new iterators();

}
    private class iterators implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current.next != last;
        }

        public Item next() {
            if(!hasNext()){

                throw new java.util.NoSuchElementException();

            }
            else{
                current = current.next;
                return current.item;
            }

        }
        public void remove() {
            throw new UnsupportedOperationException("Remove unsupported.");
        }

        }




    // unit testing (required)
   //
    public static void main(String[] args) {
         Deque d = new Deque();
         StdOut.println("Test isEmpty? " + d.isEmpty());
         d.addLast(1);
         d.addFirst(4);
         d.addLast(7);
         d.addFirst(5);
         d.addLast(2);
         d.addFirst(6);
         d.addFirst(4);


         StdOut.println("Test remove Last " + d.removeLast());
         StdOut.println("Test remove first " + d.removeFirst());
         StdOut.println("Test hasNext " + d.iterator().hasNext());
         StdOut.println("Test Next " + d.iterator().next());

         StdOut.println("Test size " + d.size);

         Deque c = new Deque();
         c.addFirst(6);
         c.addFirst(5);
         c.addLast(7);
        //c.addLast(null);
       // StdOut.println("Test remove Last empty " + c.removeLast());
        StdOut.println("Test remove first empty " + c.removeLast());
        StdOut.println("Test remove first empty " + c.removeLast());
        StdOut.println("Test remove first empty " + c.removeFirst());










    }

}