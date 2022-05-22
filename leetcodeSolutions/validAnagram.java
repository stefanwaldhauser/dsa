
   
class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        // O(n)
        for (int i = 0; i < s.length(); i++){
            Character code = s.charAt(i);        
            Integer count = sMap.get(code);
            if(count == null) {
                sMap.put(code,1);
            } else {
                sMap.put(code,count+1);
            }
        }
        
        // O(m)
        for (int i = 0; i < t.length(); i++){
            Character code = t.charAt(i);        
            Integer count = tMap.get(code);
            if(count == null) {
                tMap.put(code,1);
            } else {
                tMap.put(code,count+1);
            }
        }
        
        // O(n)
        // as s and t are the same length it is enough to just check one direction and not both
        for(Character c : sMap.keySet()) {
            if(!sMap.get(c).equals(tMap.get(c))) return false;
        }
        return true;
        
        // RUNTIME: O(2n + m)
    }
}