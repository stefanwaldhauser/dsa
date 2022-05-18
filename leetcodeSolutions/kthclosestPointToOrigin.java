class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        // create maxHeap with custom euclidiean distance comporator
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(this.d(b), this.d(a)));
        
        // We could simple use a minHea[ BUT optimiziation: to get O(n log(k)) instead of O(n log(n)) we restrict the height
        // of a maxheap to k (we are only interested in the k smallest items)
        // Remember: to get the k smallest use a maxHeap of size k and kick out root and add if smaller
        // Remember: to get the k largest use a minHeap of size k and kick out root and add if larger
        
        
        for(int i = 0; i < points.length; i++) {
            if(maxHeap.size() < k) {
                maxHeap.add(points[i]);
            } else {
                if(d(maxHeap.peek()) > d(points[i])) {
                    maxHeap.poll();
                    maxHeap.add(points[i]);
                }
            }
        }
        
        // poll k times to the k points with the samllest distance to the origin
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    
    // euclidian distance to origin
    private double d(int[] a) {
        return Math.sqrt(Math.pow((a[0]), 2)+Math.pow((a[1]), 2));
    }
    
}