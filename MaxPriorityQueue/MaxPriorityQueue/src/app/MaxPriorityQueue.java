package app; 
// import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MaxPriorityQueue {

    int[] node;
    int x; // insert SSS

    // ============= BUILD MAX HEAP METHODS==========================
    public static void max_heapify(int[] A, int i) {

        // based from 6.2 algorithm
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = 0;

        if ((l <= A.length - 1) && (A[l] > A[i])) {
            largest = l;
        } else {
            largest = i;
        }

        if ((r <= A.length - 1) && (A[r] > A[largest])) {
            largest = r;
        }

        if (largest != i) {
            // swap values
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            max_heapify(A, largest);
        }
    }

    public static int[] build_max_heap(int[] A) {
        // int heapSize = A.length;

        A = Arrays.copyOf(A, A.length + 1);

        int mid = (int) Math.floor(A.length / 2 - 1);

        for (int i = mid; i >= 0; i--) {
            max_heapify(A, i);
        }

        // decrease array back to normal
        A = Arrays.copyOf(A, A.length - 1);

        // determine the height: 2^(h+1) - 1
        // int height = (int) (Math.log(heapSize+1)/Math.log(2))-1;

        System.out.print("Outputted Max Heap: ");
        print_array(A);
        return A;
        // System.out.println("\nHeight: " + height);
    }

    public static void print_array(int[] A) {
        for (int element : A) {
            System.out.print(element + "  ");
        }
    }
    // =================================================================

    public void Insert(int[]S,int x){
        node = Arrays.copyOf(S,S.length+1);
        node[node.length-1] = x;  
        // System.out.print("STOP"); 
    }

    public int Maximum(int[]S){
        return S[0];
    }

    public int ExtractMax(int[]S){
        int max; 
        if (S.length<1){
            System.out.println("Heap Underflow");
            max = 0; 
        }
        else{
            max = S[0]; 
            S[0] = S[S.length-1]; 
            node = Arrays.copyOf(S,S.length-2); 
            max_heapify(node, 1);
        }
        return max; 
    }

    public static void IncreaseKey(int[]S,int x,int k){
        ;
    }

    // public static int[] executeOption(int[]S, int option){
    public static MaxPriorityQueue executeOption(MaxPriorityQueue heap, int option){

        // MaxPriorityQueue heap = new MaxPriorityQueue(); 
        Scanner input = new Scanner(System.in);
        // int [] new_S = {0}; 

        switch(option){
            case 1: 
                System.out.println("\nInsert\n");
                
                // create scanner object for the integer to input
                System.out.print("Input the integer you want inserted: ");
                int x = input.nextInt();
                heap.Insert(heap.node, x);

                break;
            case 2:
                System.out.println("\nMaximum\n");
                // int max = Maximum(heap.S);
                int max = heap.Maximum(heap.node);
                System.out.print("Maximum value is: ");
                System.out.println(max);
                break;
            case 3:
                System.out.println("\nExtract-Max\n");
                heap.ExtractMax(heap.node);
                break;
            case 4: 
                System.out.println("\nIncrease-key\n");
                break;
            case 5:
                System.out.println("\nExit\n");
                break;
            default:
                System.out.println("\nPlease Enter a Valid Option\n");
                // break;
                int [] t = {0};
                // new_S = t;

        } 

        // input.close(); //close scanner

        return heap;
    } 
    
    public static void main(String [] args){


        // Create HEAP Object

        int [] testArr = {5,10,8,13,2,17,12};

        int option = 0;  
        
        // Heap heap = new MaxPriorityQueue(). new Heap();
        // heap.S = testArr;
        MaxPriorityQueue heap = new MaxPriorityQueue();
        heap.node = testArr;

        Scanner user_input = new Scanner(System.in); // Create a Scanner Obj for user input 
        
        while(option!=5){

            
            heap.node = build_max_heap(heap.node);

            System.out.println("\nChoose from the following options:\n");
            System.out.println("1. Insert");
            System.out.println("2. Maximum");
            System.out.println("3. Extract-Max");
            System.out.println("4. Increase-Key");
            System.out.println("5. Exit");
            
            // get the user input
            option = user_input.nextInt();
            executeOption(heap,option);
        }

        user_input.close(); // close the scanner

        System.out.println("Hello World");
    }
}