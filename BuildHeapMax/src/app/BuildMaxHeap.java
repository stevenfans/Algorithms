package app; 

public class BuildMaxHeap{

    public static void max_heapify(int[] A, int i){
        // based from 6.2 algorithm
        int l = 2*i+1;
        int r = 2*i+2;
        int largest = 0;

        if ((l<=A.length) && (A[l] > A[i])){
            largest = l;    
        }
        else{
            largest = i; 
        }

        if ((r<=A.length) && (A[r] > A[largest])){
            largest = r;
        }

        if (largest != i){
            // swap values
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            max_heapify(A, largest);
        }
        System.out.println("end of max heapify");
    }

    public static void main(String[] args){
        // int[] testArr = {4,5,1,7,3,3,8};
        int[] testArr = {16,4,10,14,7,9,3,2,8,1};
        max_heapify(testArr, 1
        );
        System.out.println("Hello World");

    }
}
