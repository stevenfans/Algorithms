package app;

public class MergeSort{

    static int compCnt = 0;

    public static int mergeSort(int[] A, int left, int right) {

        int arrLen = A.length;

        // check if the length of the array is one and return it since its the
        // last one
        if (arrLen <= 1) {
            return A[0];
        } else if (left < right) {
            int middle = (left + right) / 2;
            System.out.println("The middle element is: " + A[middle]);
            mergeSort(A, left, middle);
            mergeSort(A, middle + 1, right);
            merge(A, left, middle, right);
        }
        return 0;
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

        int leftElem = 0;
        int rightElem = 0;
        int mergeElem = 0;
        while (leftElem != leftArrSize && rightElem != rightArrSize) {
            if (leftArr[leftElem] < rightArr[rightElem]) {
                mergedArr[mergeElem++] = leftArr[leftElem];
                if(leftElem<leftArrSize){leftElem++;}
            } else {
                mergedArr[mergeElem++] = rightArr[rightElem];
                if(rightElem<rightArrSize){rightElem++;}
            }
            compCnt++;
        }
        
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
        System.out.println("test");
    }

    public static void main(String[]args){

        int []testArr = {4,5,1,7,3,3,8};
        int start = 0; int end = testArr.length-1;
        
        mergeSort(testArr, start, end);

        for(int element:testArr){
            System.out.println(element);
        }
        System.out.println(compCnt);
        System.out.println("Hello World");
    }
}
        