class Solution {
    public int[][] insert(int[][] in, int[] newInt) {
        //Already Sored so no need to sort the intervals

        int[][] res = new int[in.length+1][2];
        int ind1 = 0; // To iterate over intervals array
        int ind2 = 0; // To add to output array
        //4 steps - All will be adding to output from the intervals

        //1. Add intervals to result until new doesnot fall
        while(ind1 < in.length && in[ind1][1] < newInt[0]){
            res[ind2][0] = in[ind1][0];
            res[ind2][1] = in[ind1][1];
            ind1++;
            ind2++;
        }

        //2. Do not add intervals until overlapping
        while(ind1 < in.length && newInt[1] >= in[ind1][0]) {
            newInt[0] = Math.min(newInt[0], in[ind1][0]);
            newInt[1] = Math.max(newInt[1], in[ind1][1]);
            ind1++;
        }

        //3. If new interval does not overlap then add new intervals
        res[ind2][0] = newInt[0];
        res[ind2][1] = newInt[1];
        ind2++;


        //4. Add all remaing intervals to output
        while(ind1 < in.length) {
            res[ind2][0] = in[ind1][0];
            res[ind2][1] = in[ind1][1];
            ind1++;
            ind2++;
        }

        return Arrays.copyOfRange(res, 0, ind2);
    }
}
