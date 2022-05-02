class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int[] solution = new int[2];
        while(i <= nums.length - 1) {
            int j = i + 1;
            while(j <= nums.length - 1) {
                if(nums[i] + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                    break;
                }
                j++;
            }
            i++;
        }
        return solution;
    }
}
Time Complexity O(n^2)
Space Complexity O(1)