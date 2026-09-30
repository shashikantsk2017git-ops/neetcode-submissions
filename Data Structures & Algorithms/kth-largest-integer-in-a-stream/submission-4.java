class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        // pq = new PriorityQueue<>((a , b) -> a - b);
        // pq = new PriorityQueue<>(Comparator.comparingInt(obj -> obj));
        this.k = k;
        for(int num: nums) pq.add(num);
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() > k) pq.poll();
        return pq.peek();
    }
}
