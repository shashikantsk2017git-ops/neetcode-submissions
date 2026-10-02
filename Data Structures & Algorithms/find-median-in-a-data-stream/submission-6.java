class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue(Comparator.reverseOrder());
        maxHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        //Add into max heap for larger element in front
        minHeap.offer(num);

        //Took from max heap and add to min heap
        maxHeap.offer(minHeap.poll());

        if(minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2.0d;
        }
        return minHeap.peek();
    }
}
