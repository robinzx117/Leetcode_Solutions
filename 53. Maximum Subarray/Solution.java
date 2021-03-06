/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [0]
Output: 0

Example 4:
Input: nums = [-1]
Output: -1

Example 5:
Input: nums = [-2147483647]
Output: -2147483647

Constraints:
1 <= nums.length <= 2 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int preSum=Integer.MIN_VALUE, currentSum=0, maxSum=Integer.MIN_VALUE;
        for(int num : nums){
            if(preSum<0){currentSum = num;}
            else{currentSum = preSum + num;}
            preSum = currentSum;
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}