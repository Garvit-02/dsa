public class mergeSort {
    public static void merge(int arr[],int si,int mid,int ei){
        int merged[] = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid+1;
        int x = 0;
        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<arr[idx2]){
                merged[x++] = arr[idx1++];
            }else{
                merged[x++] = arr[idx2++];
            }
        }
        while(idx1<=mid){
            merged[x++] = arr[idx1++];
        }
        while(idx2<=ei){
            merged[x++] = arr[idx2++];
        }
        for(int i=0,j=si;i<merged.length;i++,j++){
            arr[j] = merged[i];
        }
    }
    public static int mergeSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        //motive
        int mid =(si+ei)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] ={6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        print(arr);
    }
}
