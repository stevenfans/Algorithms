// Steven Phan 
// Dennis Vivanco
// Abigail Kwan
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
                head = tmpRemoveNode;  // reset the head 
            // System.out.println("test");
            }
            else{
                tmpRemoveNode = tmpRemoveNode.prev;
                tmpRemoveNode.next = startingHead.next; 
                startingHead= startingHead.next; 
                startingHead.prev = tmpRemoveNode; 
            }

            list_size--;
        }

        public void moveNodeBehind(String targetToAddBehind, String newData){
            Node startingHead = head;
            Node targetNode = new Node(newData);  

            //move head of the startingHead. prev is null
            while(startingHead.data != targetToAddBehind){
                startingHead = startingHead.next;
            }
            
            targetNode.prev = startingHead.prev;
            startingHead.prev = targetNode;
            targetNode.next = startingHead; 

            //check for null nodes
            if(targetNode.prev!=null){
                targetNode.prev.next = targetNode;  
            } 
            else{head = targetNode;}

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
                System.out.printf("%s ",n.data); 
                if(n.next!=null)n = n.next; // check if the next point is null
                else break; 
            }
            System.out.println();
        }
    }
//==============================================================================

    //function takes in node and read char index of string to return a  number
    public static int getNum(Node n, int charIndex){
        //get a letter and turn it into ascii number
        if(charIndex>n.data.length()-1){
            charIndex=n.data.length()-1;
        }
        int asciiNumber = (int) n.data.charAt(charIndex);
        return asciiNumber; 
    }

    public static boolean isBigger(Node leftNode, Node rightNode){
        boolean isBigger = false;
        //smaller ascii number means word should be in front
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

        for(int i=1; i<size;i++){
            //get second node pointer
            Node key = list.getNodeAtElement(i); 
            //Node key = tmpList.moveToNextNode(); // start off at the next indes
            Node beforeKey = key.prev; 
            //check key and previous element data
            while(isBigger(beforeKey,key)){
                tmpList.removeNode(key.data);
                tmpList.moveNodeBehind(beforeKey.data, key.data);
                // System.out.println('y');
                if(beforeKey.prev!=null)beforeKey = beforeKey.prev.prev;
                // System.out.print("x");
            }
        }

    }
    
    public static void main(String[]args){

        // create an empty linked list
        DoublyLinkedList dll = new InsertionSort(). new DoublyLinkedList(); 
        
      //  String[] tstArry = new String[]{"java", "asdf", "bear", "yum"};
        int arrLength = args.length; 
       
        //put the items in the array into a doubly linked list
        for(int i=0; i<arrLength; i++){
            dll.addinFront(args[i]);
        }
        //sort the linked list
        insertionSort(dll, dll.list_size);

        //print the linked list
        dll.printList(); 
    }
}                 
