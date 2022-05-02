// Slighly optimized brute force solution
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int[] solution = new int[2];
        while (i <= numbers.length - 1) {
            int lookingFor = target - numbers[i];
            int j = i + 1;
            while(j <= numbers.length - 1 && numbers[j] <= lookingFor) {
                if(numbers[j] == lookingFor) {
                    solution[0] = i + 1;
                    solution[1] = j + 1;
                    break;
                }
                j++;
            }
            i++;
        }
        return solution;
        
    }
}
// Time Complexity O(n^2)
// Space Complexity O(1)



// We can do this in O(n) with two pointers at both ends
// imagine a sorted array [1,2,3,4,5,6] and a target 9
// let i start at the left side and j and the right side i --> && <-- k
// The array is ascendingly sorted, so we get the following guarantee:
// moving i increases the sum of numbers[i] + numbers[j]
// moving j decreases the sum of numbers[i] + numbers[j]
// We can use this to our advantage by basically determining at each step if the sum is larger than our target or smaller than our taget
// if larger -> decrease by moving j
// if smaller -> increase by moving i


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] solution = new int[2];
        
        
        while(i < j) {
            int currentSum = numbers[i] + numbers[j];
            // found the solution -> break early
            if(currentSum == target) {
                solution[0] = i+1;
                solution[1] = j+1;
                break;
            }
            // too large --> decrease sum by moving j
            if(currentSum > target) {
                j--;
            }
            // too small --> increase sum by moving i
            if(currentSum < target) {
                i++;
            }    
        }
        return solution;     
    }
}