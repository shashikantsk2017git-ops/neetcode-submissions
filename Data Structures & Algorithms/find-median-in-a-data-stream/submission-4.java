class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num); //add lower half first
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0d;
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