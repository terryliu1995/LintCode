public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        //situation trasistion: sum[k] = max（sum(k-1) + nums[k], nums[k]）
        // this equation can get the largest sum from 0 to k.
        //based on this largest sum from 0 to k, we consider the largest sum from k + 1 to n
        //In the process of geting these sums, we find the largest one.
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            //if nums[i] > sum_(i-1) + nums[i], 
            //the largest sum we can get from 0 to i is nums[i]
            sum = Math.max(sum, nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
