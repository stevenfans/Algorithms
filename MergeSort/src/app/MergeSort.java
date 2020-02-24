// Steven Phan
// Dennis Vivanco
// Abigail Kwan
package app;

public class MergeSort{

    static int compCnt = 0;//counter for the merge comparisons

    public static void mergeSort(int[] A, int left, int right) {

        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(A, left, middle);
            mergeSort(A, middle + 1, right);
            merge(A, left, middle, right);
        }
    }

    public static void merge(int[] A, int left, int middle, int right) {

        // get the size for the array
        int arrSize = right - left + 1;
        // get the length of the left temp array
        int mid = (left + right) / 2;
        int leftArrSize = mid - left + 1;
        // get the length of the right temp array
        int rightArrSize = right - (mid + 1) + 1;

        // create the tmp left and right arrays
        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];

        // create the output array from merged left and right array
        int[] mergedArr = new int[arrSize];

        // add everthing from the left size to the left array
        for (int i = 0; i < leftArrSize; i++) {
            leftArr[i] = A[i + left]; // need to have +left for the offset
        }
        // add everthing from the left size to the left array
        for (int i = 0; i < rightArrSize; i++) {
            rightArr[i] = A[i + (mid + 1)];
        }

        // index counters
        int leftElem = 0; int rightElem = 0; int mergeElem = 0;

        // compare elements from left and right array 
        while (leftElem != leftArrSize && rightElem != rightArrSize) { // exit if left|right max reached
            // put left element into merged array if the right is bigger
            if (leftArr[leftElem] <= rightArr[rightElem]) {
                mergedArr[mergeElem++] = leftArr[leftElem++];
                // if(leftElem<leftArrSize){leftElem++;}
            } else {
                mergedArr[mergeElem++] = rightArr[rightElem++];
                // if(rightElem<rightArrSize){rightElem++;}
            } compCnt++;
        }

        // place in the merged array left over values
        while(leftElem<leftArrSize || rightElem<rightArrSize){
            if(leftElem<=rightElem){
                mergedArr[mergeElem++]=leftArr[leftElem];
                if(leftElem<leftArrSize){leftElem++;}
            }
            else{
                mergedArr[mergeElem++]=rightArr[rightElem];
                if(rightElem<rightArrSize){rightElem++;}
            }
        }
        // update the main Array with the sorted values
        for(int i=0; i<arrSize;i++){
            A[i+left] = mergedArr[i];
        }
        // System.out.println("test");
    }

    public static void main(String [] args){

        // int []testArr = {1,2,1};
        int [] testArr = new int [args.length];
        int start = 0; int end = args.length-1;
        // TODO: need to fix the string arguments
        // for now get string args array and turn it 
        // into a int array

        for(int i=0; i<args.length;i++){
            testArr[i] = Integer.parseInt(args[i]);
        }
        
        System.out.println("Unsorted Array");
        for(int element:testArr){
            System.out.print(element + " ");
        }        
        System.out.println("\n");

        mergeSort(testArr, start, end);

        System.out.println("Sorted Array");
        for(int element:testArr){
            System.out.print(element+" ");
        }
        System.out.println("\n");

        System.out.println("Number of comparisons: "+compCnt);
    }
}
        