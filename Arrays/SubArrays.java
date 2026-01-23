public class SubArrays {
    public static void SubArrays(int numbers[]){
        int ts=0;
        for(int i=0;i<numbers.length;i++){
            int start= i;
            for(int j=i; j<numbers.length; j++){
                int end= j;
                for(int k=start; k<=end; k++){
                    System.out.print(numbers[k]+" ");
                    
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total SubArrays of arrays: "+ts);
    }
    
    public static void main(String args[]){
        int numbers[] = {5,6,10,11,14,16,25};
        SubArrays(numbers);
    }
}
