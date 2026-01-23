// this is for normal MaxSubarray sum but this is not best way of find it because tc is o(n3)

// public class MaxSubarray {
//     public static void MaxSubarraySum(int numbers[]){
//         int currSum=0;
//         int maxSum=Integer.MIN_VALUE;

//         for(int i=0;i<numbers.length;i++){
//             int start= i;
//             for(int j=i; j<numbers.length; j++){
//                 int end= j;
//                 currSum =0;
//                 for(int k=start; k<=end; k++){
//                     //Sum of subarrays
//                     currSum += numbers[k];
                    
//                 }
//                 System.out.println(currSum);
//                 if(maxSum < currSum){
//                     maxSum = currSum;
//                 }
//             }
//         }
//         System.out.println("MaxSum of arrays: "+maxSum);
//     }
    
//     public static void main(String args[]){
//         int numbers[] = {1,-2,6,-1,3};
//         MaxSubarraySum(numbers);
//     }
// }


// prefix Sum

// public class MaxSubarray {
//     public static void MaxSubarraySum(int numbers[]){
//         int currSum=0;
//         int maxSum=Integer.MIN_VALUE;
//         int prefix[] = new int[numbers.length];

//         //prefix calculation
//         prefix[0] = numbers[0];
//         for(int i=1; i<numbers.length; i++){
//             prefix[i] = prefix[i-1] + numbers[i];
//         }

//         for(int i=0;i<numbers.length;i++){
//             int start= i;
//             for(int j=i; j<numbers.length; j++){
//                 int end= j;
//                 currSum =   start == 0 ?prefix[end] :prefix[end]-prefix[start-1];  //ternary operator 


//                 // for(int k=start; k<=end; k++){
//                 //     //Sum of subarrays
//                 //     currSum += numbers[k];
                    
//                 // }
                
//                 if(maxSum < currSum){
//                     maxSum = currSum;
//                 }
//             }
//         }
//         System.out.println("MaxSum of arrays: "+maxSum);
//     }
    
//     public static void main(String args[]){
//         int numbers[] = {1,-2,6,-1,3};
//         MaxSubarraySum(numbers);
//     }
// }



// Kadane's Algorithm
public class MaxSubarray {
    public static void Kadane(int numbers[]){
        int cs =0;
        int ms=0;

        for(int i=0; i<numbers.length; i++){
            cs = cs + numbers[i];
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
        }
        System.out.println("Maximum Sum in an array: "+ms);
    }

    public static void KadaneWithNegativeElememt(int numbers[]){
        int cs =0;
        int ms=0;

        for(int i=1; i<numbers.length; i++){
            cs = Math.max(cs,cs + numbers[i]);
            ms = Math.max(cs,ms);
        }
        System.out.println("Maximum Sum in an array: "+ms);
    }
    public static void main(String args[]){
        // int numbers[] = {1,-2,6,-1,3};
        int numbers[] = {-2,-3,4,-1,-2,1,5,-3};
        // Kadane(numbers);
        KadaneWithNegativeElememt(numbers);
    }
}

