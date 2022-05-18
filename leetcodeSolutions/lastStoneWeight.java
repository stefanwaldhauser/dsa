class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for(int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size() > 1) {
            int x = maxHeap.poll(); // O(1)
            int y = maxHeap.poll(); // O(1)
            if(x != y) {
             maxHeap.add(x-y); // O(log n))   
            }
        }
        if(maxHeap.peek() == null) {
            return 0;
        } else {
        return maxHeap.poll();             
        }
    }
    
    // worst case runtime O(n * log(n))
}