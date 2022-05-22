class Solution {
    public int lengthOfLongestSubstring(String s) {
        // edge case
        if(s.length() == 0) {
            return 0;
        }
        // use hash map to keep track of letters in current window
        HashMap<Character,Integer> hm = new HashMap<>();   
        // keep track of the longest window we have seen so far
        int maxWindow = 1;
        int l = 0;
        hm.put(s.charAt(l), 1);
        
        int r = 1;
        while(r < s.length() && l < s.length()) {
            boolean rightMostLetterSeen = hm.get(s.charAt(r)) != null;
            if(rightMostLetterSeen) { // duplicate character found -> move left side
                hm.remove(s.charAt(l));                
                l++;
            } else { // new character
               hm.put(s.charAt(r), 1);    
               int length = r - l + 1;
               if(length > maxWindow) {
                   maxWindow = length;
               }
               r++;
            }
        }
        return maxWindow;
        
        // Runtime: Length of string is n
        // In the worst case ababababab so move r than left and so on so O(2*n)
    }
}