package app;

public class MergeSort{

    public static void mergeSort(Integer[] A, left, right){

        if (left<right){
            middle = (left+right)/2;
            mergeSort(A,left,middle);
            mergeSort(A,middle+1,right);
            merge(A,left,middle,right);
        }
    }

    public static void merge(Integer[] A, left, middle, right){
        
    }
    public static void main(Integer[] args){
        System.out.println("Hello World");
    }
}