import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MaxPriorityQueue {

    // class Heap{
    //     int[] S;
    // }
    int [] S;
    int x; //insert 

    // ============= BUILD MAX HEAP METHODS==========================
    public static void max_heapify(int[] A, int i){
        // based from 6.2 algorithm
        int l = 2*i+1;
        int r = 2*i+2;
        int largest = 0;

        if ((l<=A.length-1) && (A[l] > A[i])){
            largest = l;    
        }
        else{
            largest = i; 
        }

        if ((r<=A.length-1) && (A[r] > A[largest])){
            largest = r;
        }

        if (largest != i){
            // swap values
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            max_heapify(A, largest);
        }
    }

    public static void build_max_heap(int[] A){
        int heapSize = A.length;
        
        A = Arrays.copyOf(A, A.length+1);
        
        int mid = (int) Math.floor(A.length/2 - 1);

        for (int i = mid; i>=0; i--){
            max_heapify(A, i);
        }

        // decrease array back to normal
        A = Arrays.copyOf(A, A.length-1);

        // determine the height: 2^(h+1) - 1
        int height = (int) (Math.log(heapSize+1)/Math.log(2))-1; 

        System.out.print("Outputted Max Heap: ");
        print_array(A); 

        // System.out.println("\nHeight: " + height);
    }

    public static void print_array(int[]A){
        for (int element:A){
            System.out.print(element + "  ");
        }
    }
    // =================================================================


    public static int[] Insert(int[]S,int x){
        
        int [] new_S; 
        new_S = Arrays.copyOf(S, S.length+1); 
        new_S[S.length] = x; 

        return new_S;
    }

    public static void Maximum(int[]S){
        ;
    }

    public static void ExtractMax(int[]S){
        ;
    }

    public static void IncreaseKey(int[]S,int x,int k){
        ;
    }

    public static int[] executeOption(int[]S, int option){

        MaxPriorityQueue heap = new MaxPriorityQueue(); 
        Scanner input = new Scanner(System.in);
        int [] new_S={0}; 

        switch(option){
            case 1: 
                System.out.println("\nInsert\n");
                // create scanner object for the integer to input
                System.out.print("Input the integer you want inserted: ");
                int x = input.nextInt();
                new_S = Insert(S, x);
                // break;
            case 2:
                System.out.println("\nMaximum\n");
                break;
            case 3:
                System.out.println("\nExtract-Max\n");
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
                new_S = t;
                return new_S;
        } 
        return new_S;
    } 
    
    public static void main(String [] args){

        int [] testArr = {5,10,8,13,2,17,12};

        Scanner user_input = new Scanner(System.in); // Create a Scanner Obj for user input 
        int option = 0;  

        // Heap heap = new MaxPriorityQueue(). new Heap();
        // heap.S = testArr;
        MaxPriorityQueue heap = new MaxPriorityQueue();
        heap.S = testArr;

        while(option!=5){

            build_max_heap(heap.S);

            System.out.println("\nChoose from the following options:\n");
            System.out.println("1. Insert");
            System.out.println("2. Maximum");
            System.out.println("3. Extract-Max");
            System.out.println("4. Increase-Key");
            System.out.println("5. Exit");
            
            // get the user input
            option = user_input.nextInt();

            heap.S = executeOption(heap.S,option);
        }

        user_input.close(); // close the scanner

        System.out.println("Hello World");
    }
}