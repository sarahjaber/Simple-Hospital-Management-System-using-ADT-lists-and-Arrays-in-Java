public class LQueue implements QueueInterface
{
   private Node frontNode;
   private Node backNode;
 
   public LQueue()
   {
    frontNode = null;
    backNode = null;
   }
   private class Node
   {
    private Object data;
    private Node next;
 
    private Node(Object dataPortion)
    {
        data = dataPortion;
        next = null;
    }
    private Node(Object dataPortion, Node nextNode)
    {
        data = dataPortion;
        next = nextNode;
    }
   }
   public Object getFront()
   {
    Object front=null;
    if(!isEmpty())
    {
    front = frontNode.data;
    }
   return front;
   }
   public void enqueue(Object newEntry)
   {
     Node newNode = new Node(newEntry, null);
    if (isEmpty())
    frontNode = newNode;
    else
    backNode.next = newNode;
    backNode = newNode;
   }
 
   public Object dequeue()
   {
     Object front = null;
     if(!isEmpty())
     { front = frontNode. data;
     frontNode = frontNode.next ;
     if (frontNode == null)
     backNode = null;
     }
     return front;
     }
     public boolean isEmpty()
     {
        return frontNode==null;
     }
     public void clear()
     {
        frontNode=null;
        backNode=null;
     }
     public void display() {
        if (isEmpty()) {
            System.out.println("NONE");
        } else {
            Node currentNode = frontNode;
            System.out.println(" ");
            while (currentNode != null) {
                System.out.println(currentNode.data);
                currentNode = currentNode.next; // Move to the next node
            }
        }
    }
    
}