

public class DoublyLinkedList{

    // create the starting point
    Node head;
    Node tail; 
    int  list_size; 
    
    // node class
    class Node{
        private String data; 
        private Node next; 
        private Node prev; 

        //node constructor
        Node(String animal){
            data = animal; 
        }
    }

    // constructor of linked list
    DoublyLinkedList(){
        this.head = null; 
        this.tail = null; 
        this.list_size = 0; 
    }
    
    public void addinFront(String n) {
        
        //create a new node
        Node temp = new Node(n);
        
        //next point of the new node points to the head of the list
        temp.next = head; 
        //make the previous point to null
        temp.prev = null; 

        // check if the head  is the start of the linked list
        if (head!= null) { 
            head.prev = temp; 
        }

        head = temp; 
    }

    public static DoublyLinkedList insertNode(DoublyLinkedList list, int locationToReplace, String newData) {

        int i = 0; 
        //create a dummy linked list
        DoublyLinkedList tmpList = list; 
        Node startingHead = list.head; 
        //create a new empty node 
        Node tmp = new DoublyLinkedList(). new Node(newData);

        //traverse thru the list to the location of where you want to repalce it
        while(i!=locationToReplace){
            startingHead = startingHead.next;
            i++; 
        }

        //now at the element that you want to replace
       // System.out.println(startingHead.data);
        
        //startingHead = startingHead.prev;
        //System.out.println("Starting Head:"+startingHead.data);
        Node trail = startingHead; //trail is old location 
        
        //traverse one more back
        startingHead = startingHead.prev; 
        startingHead.next = tmp; 
        tmp.prev = startingHead; 
        tmp.next = trail; 
        trail.prev = tmp.next;
        

        //make the new node equal to the previous pointer of startingHead
        
       // System.out.println(tmp.data);

        return tmpList;
    }

    public static void printList(Node n){
        // check if the current node not null, print data
        while(n.data!=null){
            System.out.println(n.data); 
            if(n.next!=null)n = n.next; // check if the next point is null
            else break; 
        }
    }

    //to test class
    public static void main(String[]args){
        
        //System.out.println("tst");

        // create an empty linked list
        DoublyLinkedList dll = new DoublyLinkedList(); 
        dll.addinFront("apple");
        dll.addinFront("test");
        dll.addinFront("going");
        dll.addinFront("zeebra");
        dll.addinFront("aardvark");
        //System.out.printnln("asdf");
        //printList(dll.head); 
        insertNode(dll,3, "newData");
        printList(dll.head);
        
    }
}
