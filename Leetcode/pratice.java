class Solution {
    public void nextPermutation(int[] A) {
        int pivot =-1;
        int n =A.length;

        //finding the pivot
        for(int i= n-2;i>=0;i--){ 
            if(A[i] < A[i+1]){
                pivot =i;
                break;
            }
        }
        if(pivot == -1){
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
            return;
        }

        //RME
        for(int i=n-1;i>pivot;i--){
            if(A[i]>A[pivot]){
                //swap
                int temp = A[pivot];
                A[pivot] = A[i];
                A[i] = pivot;
                break;
            }
        }
    }
    public static void main(String[] args) {
        int A[] ={1,2,3};
    }
}