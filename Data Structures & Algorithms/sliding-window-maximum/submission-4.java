class Solution {

    public int[] maxSlidingWindow0(int[] nums, int k) {
        int[] res = new int[nums.length];

        int ind = 0;
        while(ind <= nums.length - k) {
            int maxInd = ind + k - 1;

            int max = Integer.MIN_VALUE;
            for(int i = ind; i <= maxInd ; i++) {
                max = Math.max(nums[i], max);
            }
            res[ind] = max;
            ind++;
        }

        return Arrays.copyOfRange(res, 0, ind);
    }

     public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);
        for(int i = k; i < nums.length; i++) {

            if(!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }

        return res.stream().mapToInt( i -> i).toArray();
    }
}
