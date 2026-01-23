                                            //Arrays
import java.util.HashSet;
import java.util.Set;

class importantTopics {
//Two-pointer approach :- 
    // Used to find a pair in a sorted array with a given sum
    public static boolean pairSum(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                System.out.println("Pair found: (" + arr[left] + ", " + arr[right] + ")");
                return true;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    //When arrays is unsorted then we use Hashset ro Hashmaps
    public static int pairSumUnsorted(int arr[], int target) {
        Set<Integer> map = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (map.contains(complement)) {
                System.out.println("Pair found: " + num + ", " + complement);
                break;
            }
            map.add(num);
        }
        return -1;
    }

//Sliding Window Technique :-
    public static int maxSumSubarray(int arr[], int k) {
        int maxSum = 0;
        int windowSum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window from start to end of the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element and remove the first element of the previous window
            maxSum = Math.max(maxSum, windowSum); // Update maxSum if needed
        }

        return maxSum;
    }
    public static void main(String[] args) {
        
    }
}
