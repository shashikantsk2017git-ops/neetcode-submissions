class Solution {
    public int[][] merge(int[][] inter) {
        Arrays.sort(inter, Comparator.<int[]>comparingInt(obj -> obj[0]).thenComparingInt(obj -> obj[1]));

        int[][] res = new int[inter.length][2];

        int ind = 0;
        int lastTime = inter[0][1];
        int startTime = inter[0][0];

        res[ind][0] = startTime;
        res[ind][1] = lastTime;
        for(int i = 1; i < inter.length; i++) {
            if(inter[i][0] <= lastTime) {
                lastTime = Math.max(lastTime, inter[i][1]);
            } else {
                lastTime = inter[i][1];
                startTime = inter[i][0];
                ind++;
            }
            res[ind][0] = startTime;
            res[ind][1] = lastTime;
        }
        return Arrays.copyOfRange(res, 0, ind+1);
    }
}
