

// // Write an insertion sort algorithm wth: 
// //     1.  using doubly linked list
// //     2.  able to sort lower case string words alphabetically
// //     3.  able to sort up to 20 words

public class InsertionSort{

    public static int getNum(char letter){
        int asciiNumber = (int) letter; 
        return asciiNumber; 
    }

    public static void insertionSort(DoublyLinkedList list, int size){
        
        DoublyLinkedList tmpList = list; 


        System.out.println("asdfjkl;asdf");
    }
    
    public static void main(String[]args){

        char a = 'z'; 
        int x = (int) a; 
        System.out.println(x); 
        
        // create an empty linked list
        DoublyLinkedList dll = new DoublyLinkedList(); 
        dll.addinFront("apple");
        dll.addinFront("test");
        dll.addinFront("going");
        dll.addinFront("zeebra");
        dll.addinFront("aardvark");
        dll.removeNode("test");
        dll.insertNodeBefore("aardvark", "fuck");
        dll.printList(); 

        insertionSort(dll, dll.list_size);
    }
}