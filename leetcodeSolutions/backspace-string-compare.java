// Naive solution
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    // basically simulte keystroges
    public String build(String S) {
        Stack<Character> ans = new Stack(); //
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c); // add on our stack
            else if (!ans.empty())
                ans.pop(); // remove from our stack the last typed
        }
        return String.valueOf(ans);
    }
}

// Time Complexity: O(N + M)
// Space Complexity: O(N + M)


// Two Pointer Solution

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0; // encountered skips in S by i
        int skipT = 0; // encountered skips in T by j


        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            // SEARCH IN S FOR NEXT CHAR
            while (i >= 0) { // Find position of next possible char in build(S) if it exists (negative otherwise)
                if (S.charAt(i) == '#') {
                    skipS++; 
                    i--;
                } else if (skipS > 0) { // we have encountered a normal char BUT we still have a skip
                    skipS--; 
                    i--;
                } else break; // encountered a normal char and no skips left
            }
            // SEARCH IN T FOR NEXT CHAR
            while (j >= 0) { // Find position of next possible char in build(T) if it exists (negative otherwise)
                if (T.charAt(j) == '#') {
                    skipT++; 
                    j--;}
                else if (skipT > 0) {
                    skipT--; 
                    j--;}
                else break;
            }


            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;

            i--; 
            j--;
        }


        return true;
    }
}


// Time Complexity: O(N + M)
// Space Complexity: O(1)

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;


        // a# and a####### are also possible -> not && HERE
        while(i >= 0 || j >= 0) {
            System.out.println(i);
            // find index of next char in S (negative if does not exist)
            int skipsS = 0;
            while(i >= 0) {
                char c = s.charAt(i);
                if(c == '#') {
                    skipsS++;
                } else {
                    if(skipsS > 0) {
                         skipsS--;
                    } else {
                     break;
                    }
                }
                i--;
            }
            // find index of next char in T (negative if does not exist)
            int skipsT = 0;
            while(j >= 0) {
                char c = t.charAt(j);
                if(c == '#') {
                    skipsT++;
                } else {
                    if(skipsT > 0) {
                         skipsT--;
                    } else {
                     break;   
                    }
                }
                j--;
            }
            // they differ in the next found character
            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            // i has one more character than j
            if(i >= 0 && j < 0) {
                return false;
            }
            // j has one more character than i
            if(i < 0 && j >=0 ) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }