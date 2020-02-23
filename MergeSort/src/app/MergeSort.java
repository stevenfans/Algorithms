package app;

import java.lang.invoke.LambdaMetafactory;

public class MergeSort{

    public static int mergeSort(int[]A, int left, int right){
        
        int arrLen = A.length;
        
        // check if the length of the array is one and return it since its the 
        // last one 
        if (arrLen<=1){
            return A[0];
        }
        else if (left<right){
            int middle = (left+right)/2;
            System.out.println("The middle element is: "+A[middle]);
            mergeSort(A,left,middle);
            mergeSort(A,middle+1,right);
            merge(A,left,middle,right);
        }
        return 0;
    }

    public static void merge(int[] A, int left, int middle, int right){
        System.out.println("Testing merge");
        System.out.println("LEFT: "+A[left]);
        System.out.println("MID: "+A[middle]);
        System.out.println("RIGHT: "+A[right]);

        // create left and right arrays
        int [] retArr;
        int [] leftArr= new int[9]; 
        int [] rightArr= new int[9]; 
        int test = leftArr.length;
        leftArr[leftArr.length]= left; 
        rightArr[rightArr.length] = right; 



    }

    public static void main(String[]args){

        int []testArr = {4,5,1,7,3,3,8};
        int start = 0; int end = 6;
        
        mergeSort(testArr, start, end);

        System.out.println("Hello World");
    }
}