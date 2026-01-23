package Leetcode;

public class maxAscendingSum {
    public int maxAscendingSum(int[] nums) {
        int currSum =nums[0];
        int maxSum = Integer.MIN_VALUE;
        for(int i =1; i<nums.length; i++){
            if( nums[i] > nums[i-1]){
                currSum += nums[i];
            }
            else{
                maxSum = Math.max(currSum,maxSum);
                currSum = nums[i];
            }
        }
        return Math.max(currSum,maxSum);
    }
    public static void main(String[] args) {
        int nums[] = {6,10,6};
        maxAscendingSum(nums);
    }
}
