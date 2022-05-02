class Solution {
    public boolean isPalindrome(String s) {
        String l = s.toLowerCase();
        int i = 0;
        int j = l.length() - 1;


        while(i < j) {
            // move i to next alphabetic letter
            Character ci = null;
            // i <= j so case [a] is possible
            while(i <= l.length() - 1 && i <= j) {
               if(this.isAlphabetic(l.charAt(i))) {
                   ci = l.charAt(i);
                   break; // found char -> break out
               } else {
                   i++;
               }              
            }
            System.out.println(ci);
            // i <= j so case [a] is possible
            Character cj = null;
            while(j >= 0 && i <= j) {
               if(this.isAlphabetic(l.charAt(j))) {
                   cj = l.charAt(j);
                   break; // found char -> break out
               } else {
                   j--;
               }              
            }
            System.out.println(ci);
            // compare letters -> false if not the same
            if(ci == null && cj != null) {
                return false;
            }
            if(ci != null && cj == null) {
                return false;
            }
            if(ci != cj) {
                return false;
            }
            // move i and j
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isAlphabetic(char c) {
        return 
            (c >= 'a' && c <= 'z') 
            ||
            (c >= '0' && c <= '9');
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        String l = s.toLowerCase();
        int i = 0;
        int j = l.length() - 1;
        // if string is odd -> i and j will meet in the middle [aaa] and a single letter is automatically a palindrome, so nothing to compae the middle letter with
        // if string is even --> i and j will cross each other meaning we have compared all the ltters
        while(i < j) {
            // find next letter for i
            while(i < j && !this.isAlphaNumeric(l.charAt(i))) {
                i++;
            }
            // find next letter for j
            while(i < j && !this.isAlphaNumeric(l.charAt(j))) {
                j--;
            }
            // if letters are not the same, not a palindrome
            if(l.charAt(i) != l.charAt(j)) {
                return false;
            }
            i++;
            j--;
            
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char c) {
        return 
            (c >= 'A' && c <= 'Z') 
            ||
            (c >= 'a' && c <= 'z') 
            ||
            (c >= '0' && c <= '9');
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
