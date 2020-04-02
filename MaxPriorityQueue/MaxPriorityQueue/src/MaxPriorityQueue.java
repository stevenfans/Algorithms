import java.util.Arrays;
import java.util.Scanner;

public class MaxPriorityQueue {

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

        System.out.println("Max Heap Array: ");
        print_array(A); 

        System.out.println("\nHeight: " + height);
    }

    public static void print_array(int[]A){
        for (int element:A){
            System.out.print(element + "  ");
        }
    }
    // =================================================================


    public static void Insert(int[]S,int x){
        ;
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

    public static void 
    
    public static void main(String [] args){

        int [] testArr = {5,10,8,13,2,17,12};

        Scanner user_input = new Scanner(System.in); // Create a Scanner Obj for user input 
        int option = 0;  

        while(option!=5){
            System.out.println("Choose from the following options:\n");
            System.out.println("1. Insert");
            System.out.println("2. Maximum");
            System.out.println("3. Extract-Max");
            System.out.println("4. Increase-Key");
            System.out.println("5. Exit");
            
            // get the user input
            option = user_input.nextInt();
        }

        user_input.close(); // close the scanner

        System.out.println("Hello World");
    }
}