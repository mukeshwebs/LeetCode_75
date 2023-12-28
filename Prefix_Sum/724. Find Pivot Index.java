https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75

/*
Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

---------------------------------------------------------------
Approach: we have to find the point at which left sum and right sum are equal so in this soln we are maintaining the left sum and right sum 
left sum -> keep adding the values in currrent iteration
right sum-> total sum - left sum - curr idx values
curr idx values is subtracted to accurately find the left elements

TC: O(n)
SC: O(1)
*/

class Solution {
    public int pivotIndex(int[] nums) {
        int total_sum = 0;
        int res = -1;
        for (int num : nums) {
            total_sum += num;
        }

        int Lsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Lsum == total_sum - Lsum-nums[i]) {
                res = i;
                break;
            }
            Lsum += nums[i];
        }
        return res;
    }
}
