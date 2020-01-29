

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

    //find the node that matches the data and remove it
    public void removeNode(String nodeData){
        
        //create node starting head
        Node startingHead = head; 

        //traverse linked list and find the node
        while(startingHead.data != nodeData){
            startingHead = startingHead.next; 
        }
        // create a new node pointer to before the remove node location 
        Node tmpRemoveNode = startingHead; 
        
        if(startingHead.next == null){
            tmpRemoveNode = tmpRemoveNode.prev; 
            tmpRemoveNode.next = null; 
        }
        else if(startingHead.prev==null){
            // if at the beginning, must move the
            tmpRemoveNode = tmpRemoveNode.next;
            tmpRemoveNode.prev = null ;
            head = tmpRemoveNode; 
           // System.out.println("test");
        }
        else{
            tmpRemoveNode = tmpRemoveNode.prev;
            tmpRemoveNode.next = startingHead.next; 
            startingHead= startingHead.next; 
            startingHead.prev = tmpRemoveNode; 
        }
       // System.out.println("Node Removed");
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

        Node trail = startingHead; //trail is old location 
        
        //traverse one more back
        startingHead = startingHead.prev; 
        startingHead.next = tmp; 
        tmp.prev = startingHead; 
        tmp.next = trail; 
        trail.prev = tmp.next;

        return tmpList;
    }

    // function creates a Node for the new data and places behind a specified data 
    // in the linked list
    public void insertNodeBefore(String insertBeforeThisData , String newData){

        Node startingHead = head;

        //get the starting head to the location of the node to be moved
        while(startingHead.data != insertBeforeThisData){
            startingHead = startingHead.next; 
        }

        //create a Nod for the new data
        Node newNode = new Node(newData);

        if(startingHead.prev == null){
            newNode.prev = null; 
            newNode.next = startingHead; 
            startingHead.prev = newNode; 
            head = newNode; 
            // System.out.println("Enawfeawef");
        }
        else {
        //fix the pointers
            newNode.prev = startingHead.prev; 
            newNode.next = startingHead;
            startingHead.prev = newNode; 
            startingHead = startingHead.prev;
            newNode = newNode.prev;
        // startingHead = startingHead.prev; 
            newNode.next = startingHead; 
        }
        System.out.println("End of isnert node before");

    }

    public void printList(){

        Node n = head;
        // check if the current node not null, print data
        while(n.data!=null){
            System.out.println(n.data); 
            if(n.next!=null)n = n.next; // check if the next point is null
            else break; 
        }
    }

    // //to test class
    // public static void main(String[]args){
        
    //     //System.out.println("tst");

    //     // create an empty linked list
    //     DoublyLinkedList dll = new DoublyLinkedList(); 
    //     dll.addinFront("apple");
    //     dll.addinFront("test");
    //     dll.addinFront("going");
    //     dll.addinFront("zeebra");
    //     dll.addinFront("aardvark");
    //     //System.out.printnln("asdf");
    //     //printList(dll.head); 
    //     insertNode(dll,3, "newData");
    //     printList(dll.head);
    // }
}
