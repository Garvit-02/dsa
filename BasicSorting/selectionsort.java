package BasicSorting;

public class selectionsort {
    public static void selectionsort(int arr[]){
        // to calculate no of turns
        for(int i=0; i<arr.length-1; i++){
            // to check/find the smallest element from reset of unsorted array
            int minPost = i;
            for(int j=i+1; j<arr.length; j++){
                //condition
                if(arr[minPost] > arr[j]){
                    minPost = j;
                }
            }
            //swap
            int temp = arr[minPost];
            arr[minPost] = arr[i];
            arr[i] = temp;
        }
    }
    public static void printarr(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={5,4,1,3,2};
        selectionsort(arr);
        printarr(arr);
    }
}
