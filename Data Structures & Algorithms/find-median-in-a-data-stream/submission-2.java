class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        list.sort(Comparator.naturalOrder());
    }
    
    public double findMedian() {
        int mid = list.size()/2;
        if(list.size() % 2 == 0) {
            double d = list.get(mid);
            double d1 = list.get(mid-1);
            return (d+d1)/2;
        } else {
            return list.get(mid);
        }
    }
}
