class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue(Comparator.reverseOrder());
        minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        //Add into max heap for larger element in front
        maxHeap.offer(num);

        //Took from max heap and add to min heap
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2.0d;
        }
        return maxHeap.peek();
    }
}
