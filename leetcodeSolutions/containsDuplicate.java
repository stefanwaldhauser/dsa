class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Number -> Count
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i <= nums.length - 1; i++) {
            Integer number = nums[i];
            Integer count = hm.get(number);
            if(count == null) {
                hm.put(number, 1);
            } else {
                count = count + 1;
                // early stop if we have found a duplicate
                if(count > 1) {
                    return true;
                }
                hm.put(number,count);
            }
        }
        return false;
        //Worst Case Runtime (no duplicates -> whole array): O(n)
    }