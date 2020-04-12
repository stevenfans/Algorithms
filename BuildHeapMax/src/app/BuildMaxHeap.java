// Abigail Kwan
// Dennis Vivanco
// Steven Phan

package app; 
import java.lang.Math;
import java.util.Arrays;

public class BuildMaxHeap{

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
        
        // TODO: find a better way to fix this problem, but there could a chance
        //       where there is no data on the right child. To compensate
        //       insert a null at the end of the array
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

    public static void main(String[] args){
        // int [] testArr = {4,5,1,7,3,3,8};

        // build_max_heap(testArr);
        int [] int_array = new int[args.length];

        // convert args string to ints in A
        
        for (int i=0; i<args.length;i++){
            int_array[i] = Integer.parseInt(args[i]);
        }
        
        build_max_heap(int_array);
    }
}
