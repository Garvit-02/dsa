class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int lt=0;
        int minLen = Integer.MAX_VALUE;
        
        // 2 3 1 2 4 3
        //           l
        //           r
        // len = 5-4+1 = 2
        // minLen = 2
        //sum = 0+2 = 2+3 = 5+1 = 6+2 = 8-2 = 6+4 = 10-3 = 7-1 = 6+3 =9-2 = 7
        int sum=0;
        for(int rt=0; rt<n; rt++){
            sum += nums[rt];

            while(sum>=target){
                int len = rt-lt+1;
                minLen = Math.min(minLen,len);
                sum -= nums[lt];
                lt++;
            }
        }
        return (minLen == Integer.MAX_VALUE)? 0 : minLen;
    }
}