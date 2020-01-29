package app;
// Write an insertion sort algorithm wth: 
//     1.  using doubly linked list
//     2.  able to sort lower case string words alphabetically
//     3.  able to sort up to 20 words

public class InsertionSort{

//==============Doubly Linked List============================
    class Node{
        private String data; 
        private Node next; 
        private Node prev; 

        //node constructor
        Node(String animal){
            data = animal; 
        }
    }
    public class DoublyLinkedList{

        // create the starting point
        Node head;
        Node tail; 
        int  list_size; 
        
        // node class
        // class Node{
        //     private String data; 
        //     private Node next; 
        //     private Node prev; 

        //     //node constructor
        //     Node(String animal){
        //         data = animal; 
        //     }
        // }

        // constructor of linked list
        DoublyLinkedList(){
            this.head = null; 
            this.tail = null; 
            this.list_size = 0; 
        }
        //add a new node to the front of the list
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
            list_size++; 
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

            list_size--;
        // System.out.println("Node Removed");
        }
        // insert a new node the location specified
        public DoublyLinkedList insertNode(DoublyLinkedList list, int locationToReplace, String newData) {

            int i = 0; 
            //create a dummy linked list
            DoublyLinkedList tmpList = list; 
            Node startingHead = list.head; 
            //create a new empty node 
            Node tmp = new Node(newData);

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
        // function creates a Node for the new data and places behind a specified  
        // data in the linked list
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
                newNode.next = startingHead; 
            }

            System.out.println("End of insert node before");
        }

        public void moveNodeBehind(String targetToAddBehind, String newData){
            Node startingHead = head;
            Node targetNode = new Node(newData);  

            while(startingHead.data != targetToAddBehind){
                startingHead = startingHead.next;
            }
            
            targetNode.prev = startingHead.prev;
            startingHead.prev = targetNode;
            targetNode.next = startingHead; 
            if(targetNode.prev!=null){
                targetNode.prev.next = targetNode;  
            } 

            System.out.print("asdf");
        }

        //get the node specified element location 
        public Node getNodeAtElement(int element){
            //get temp starting head
            Node tmp = head; 

            for(int i=0; i<element; i++){
                tmp = tmp.next;
            }

            return tmp ;
        }

        public Node moveToNextNode(){
            Node tmp = head; 
            if(tmp.next!=null){return tmp=tmp.next;}
            else{return tmp;}
        }
        //print out every node in the linked list
        public void printList(){

            Node n = head;
            // check if the current node not null, print data
            while(n.data!=null){
                System.out.println(n.data); 
                if(n.next!=null)n = n.next; // check if the next point is null
                else break; 
            }
        }
    }
//==========================================================

    public static int getNum(Node n, int charIndex){
        int asciiNumber = (int) n.data.charAt(charIndex);

        return asciiNumber; 
    }

    public static boolean isBigger(Node leftNode, Node rightNode){
        boolean isBigger = false;
        
        if(leftNode!=null&&rightNode!=null){
            for(int i=0; i<(leftNode.data.length()|rightNode.data.length()); i++){
                if(getNum(leftNode,i)>getNum(rightNode,i)){
                    isBigger=true;
                    break;
                }
                else if(getNum(leftNode,i)<getNum(rightNode,i)){
                    break;
                }
            }
        }
        return isBigger;
    }

    public static void insertionSort(DoublyLinkedList list, int size){
        
        DoublyLinkedList tmpList = list;
        DoublyLinkedList origList = list; 

        for(int i=1; i<size;i++){
            //get second node pointer
            // Node key = list.getNodeAtElement(i); 
            Node key = tmpList.moveToNextNode(); // start off at the next indes
            Node beforeKey = key.prev; 
            
            while(isBigger(beforeKey,key)){
                tmpList.removeNode(key.data);
                tmpList.moveNodeBehind(beforeKey.data, key.data);
                System.out.println('y');
                if(beforeKey.prev!=null)beforeKey = beforeKey.prev.prev;
                System.out.print("x");
            }
        }
        System.out.println("asdfjkl;asdf");
    }
    
    public static void main(String[]args){
        
        // create an empty linked list
        DoublyLinkedList dll = new InsertionSort(). new DoublyLinkedList(); 
        // dll.addinFront("apple");
        // dll.addinFront("test");
        // dll.addinFront("going");
        // dll.addinFront("zeebra");
        // dll.addinFront("aardvark");
        dll.addinFront("b");
        dll.addinFront("e");
        dll.addinFront("a");
        dll.addinFront("c");
        dll.addinFront("d");
        //dll.insertNodeBefore("aardvark", "fuck");
      //  dll.printList(); 

        insertionSort(dll, dll.list_size);
        // dll.removeNode("b");
        // dll.moveNodeBehind("c","b");
        System.out.println("fucking work bro");
    }
}                 
