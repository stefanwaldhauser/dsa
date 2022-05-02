class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int x = result.length - 1;
        while(i <= j) {
            if((nums[i] * nums[i]) > (nums[j] * nums[j])) {
                result[x] = nums[i] * nums[i];
                i++;
            } else {
                result[x] = nums[j] * nums[j];
                j--;
            }
            x--;
        }
        return result;
    }
}