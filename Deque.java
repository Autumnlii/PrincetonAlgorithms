public class Deque<Item>  {//implements Iterable<Item> {

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
         if(first == null && last == null) {
             last = new Node();
             last.item = item;
             last.next = null;
             last.prev = null;
             first = last;
         }
        if(first != null && first == last){
             Node new_first = new Node();
            first = new_first;
            first.item = item;
            first.next = last;
            last.prev = first;
        }
        if(first != null && last != null && first != last) {
            Node new_first = new Node();
            Node old_first = first;
            first = new_first;
            first.item = item;
            first.next = old_first;
            old_first.prev = first;
        }

        size ++;

    }

    // add the item to the back
    public void addLast(Item item) {
        if(first == null && last == null) {
            last = new Node();
            last.item = item;
            last.next = null;
            last.prev = null;
            first = last;
        }
        if(first != null && first == last){
            Node new_last = new Node();
            last = new_last;
            last.item = item;
            last.prev = first;
            first.next = last;
        }
        if(first != null && last != null && first != last) {
           Node  new_last = new Node();
           Node old_last = last;
            last = new_last;
            last.item = item;
            last.prev = old_last;
            old_last.next = last;
        }

         size++ ;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if(first == null && last == null) {
            throw new IllegalArgumentException("Too poor to give");
        }


    }

    // remove and return the item from the back
    public Item removeLast() {
        if (first == null && last == null) {
            throw new IllegalArgumentException("Too poor to give");
        }
        size--;
    }

    // return an iterator over items in order from front to back
    //public Iterator<Item> iterator()

    // unit testing (required)
   //
    public static void main(String[] args) {
         Deque d = new Deque();
         d.addFirst(0);
         d.addLast(9);
         d.removeFirst();
    }

}