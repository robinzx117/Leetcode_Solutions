/*
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set,
which results in repetition of one number and loss of another number.
Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is
missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]

Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.
*/

import java.util.HashMap;

class Solution {
    public int[] findErrorNums1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int miss = 0, dup = 0;
        for(int i=1; i<=nums.length; i++) {
            if(!map.containsKey(i)) {
                miss = i;
            }
            else {
                if(map.get(i) == 2) {
                    dup = i;
                }
            }
        }
        int[] result = {dup, miss};
        return result;
    }

    public int[] findErrorNums2(int[] nums) {
        int[] arr = new int[nums.length + 1];
        int dup = 0, miss = 0;
        for (int i=0; i<nums.length; i++) {
            arr[nums[i]] += 1;
        }
        for (int i=1; i<arr.length; i++) {
            if (arr[i] == 0) {
                miss = i;
            }
            else if (arr[i] == 2) {
                dup = i;
            }
        }
        return new int[]{dup, miss};
    }
}