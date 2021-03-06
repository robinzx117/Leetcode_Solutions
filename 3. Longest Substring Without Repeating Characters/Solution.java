/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring1(String s) {
        int n=s.length(), ans=0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int j=0, i=0; j<n; j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n=s.length(), ans=0;
        int[] index = new int[128];
        for(int j=0, i=0; j<n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j-i+1);
            index[s.charAt(j)] = j+1;
        }
        return ans;
    }
}