// // Write an insertion sort algorithm wth: 
// //     1.  using doubly linked list
// //     2.  able to sort lower case string words alphabetically
// //     3.  able to sort up to 20 words

public class InsertionSort{
    
    public static void main(String[]args){

        // create an empty linked list
        DoublyLinkedList dll = new DoublyLinkedList(); 
        dll.addinFront("apple");
        dll.addinFront("test");
        dll.addinFront("going");
        dll.addinFront("zeebra");
        dll.addinFront("aardvark");
        dll.removeNode("going");
        dll.insertNodeBefore("test", "fuck");
        dll.printList(); 
        //dll.insertNode(dll,3, "newData");
        //dll.printList(dll.head);
        //dll.insertNodeBefore(1, 3);
    }
}