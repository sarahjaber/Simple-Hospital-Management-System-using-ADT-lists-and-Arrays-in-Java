public interface QueueInterface {
    public void enqueue(Object newEntry);
    public Object getFront();
    public Object dequeue();
    public boolean isEmpty();
    public void display();
}
