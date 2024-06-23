
public class MyQueue<E> {
    private E[] element;
    private int size;
    private int DEFAULT_CAPACITY = 10;

    private int head;
    private int tail;


    //TODO: Constructor with default capacity



    //TODO: Constructor with input capacity



    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     */
    //TODO: implement a public method: enQueue according the above description




    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    //TODO: implement a public method: deQueue according the above description






    /**
     * Print all elements from the head to tail.
     */
    public void showElements() {
        for (int i = 0; i < size; i++) {
            System.out.println(element[(i+head) % element.length]);
        }
    }

    public static void main(String[] args) {
         System.out.println("**********Integer queue test**********");
         MyQueue myQueue = new MyQueue(4);
         myQueue.enQueue(6);
         myQueue.enQueue(7);
         myQueue.enQueue(8);
         System.out.println("**********After enqueue**********");
         myQueue.showElements();
         myQueue.deQueue();
         myQueue.deQueue();
         System.out.println("**********After dequeue**********");
         myQueue.showElements();
         myQueue.enQueue(9);
         myQueue.enQueue(10);
         System.out.println("**********After enqueue**********");
         myQueue.showElements();
         myQueue.deQueue();
         System.out.println("**********After dequeue**********");
         myQueue.showElements();
         myQueue.enQueue(11);
         myQueue.enQueue(12);
         myQueue.enQueue(13);
         System.out.println("**********After enqueue**********");
         myQueue.showElements();
         System.out.println();


         System.out.println("**********String queue test**********");
         MyQueue strQueue = new MyQueue(2);
         strQueue.enQueue("A");
         strQueue.enQueue("B");
         strQueue.enQueue("C");
         System.out.println("**********After enqueue**********");
         strQueue.showElements();
         strQueue.deQueue();
         System.out.println("**********After dequeue**********");
         strQueue.showElements();
         strQueue.enQueue("D");
         System.out.println("**********After enqueue**********");
         strQueue.showElements();
         strQueue.deQueue();
         strQueue.deQueue();
         System.out.println("**********After dequeue**********");
         strQueue.showElements();
         strQueue.enQueue("E");
         strQueue.enQueue("F");
         strQueue.enQueue("G");
         System.out.println("**********After enqueue**********");
         strQueue.showElements();
				
    }
}
