class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private Integer k;
    
    public KthLargest(int k, int[] nums) {  
        this.k = k;
        // create min heap
        this.minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x, y)); 
        for(int i = 0; i < nums.length; i++) {
            this.minHeap.add(nums[i]);
        }
        // careful: kth largest means kth position in the ascending sorted array
        // meaning for 2 3 4 5 8 
        // 2 is k = 1
        // 3 is k = 2
        // 4 is k = 3 and so on
        // we notice the following. the kth largest element is larger
        // than k-1 elements. so if we keep a min array with size k
        // the root element is larger than k-1 elements, therefore
        // it is the kth largest element
        while(this.minHeap.size() > k) {
            this.minHeap.poll();
        }
    }
    
    public int add(int val) {
        this.minHeap.add(val);
        while(this.minHeap.size() != k) {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }
}

// Time Complexity
// creating initital pq is O(n * log(n)) (each insert is log(n))
// each m call to add is inserted so O(m * log(m)). Peeking and polling is O(1) so can be ignored
// O(n log(n) + m log(m))