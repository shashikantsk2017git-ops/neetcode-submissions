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

    //Monotonic Deque approach
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
                dq.pollFirst(); //Delete previous window element once you come in next window
            }

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
                //If you found any element which is more than all previous then delete all smaller
                //If not larget then keep that because it may be large in next window once you 
                //remove previous window element
            }
            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }

        return res.stream().mapToInt( i -> i).toArray();
    }
}
