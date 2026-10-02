class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        //max-heap (largest on top, stores the smaller half ).
        maxHeap = new PriorityQueue(Comparator.reverseOrder());
        //min-heap (smallest on top, stores the larger half).
        minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        //Don't know at starting so add first element in smaller half
        maxHeap.offer(num);
        //move maximum from lower half to maximum half
        minHeap.offer(maxHeap.poll());

        //Move lower elemet from maximum half to minimum half
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

// class MedianFinder {
//     List<Integer> list;

//     public MedianFinder() {
//         list = new ArrayList<>();
//     }

//     public void addNum(int num) {
//         list.add(num);
//     }

//     public double findMedian() {
//         int n = list.size();
//         list.sort(Comparator.naturalOrder());

//         if (n % 2 == 1) {
//             return list.get(n / 2);
//         } else {
//             return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
//         }
//     }
// }
