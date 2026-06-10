class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        int n = list.size();
        list.sort(Comparator.naturalOrder());

        if (n % 2 == 1) {
            // Odd: return the single middle element
            return list.get(n / 2);
        } else {
            // Even: return average of the two middle elements
            return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
        }
    }
}