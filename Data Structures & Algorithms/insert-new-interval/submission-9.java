class Solution {
    public int[][] insert(int[][] inter, int[] newInter) {
        Arrays.sort(inter, Comparator.<int[]>comparingInt(obj -> obj[0])
        .thenComparingInt(obj-> obj[1]));

        int[][] res = new int[inter.length+1][2];

        int ind1 = 0;
        int ind2 = 0;
        while(ind1 < inter.length && inter[ind1][1] < newInter[0]) {
            res[ind2][0] = inter[ind1][0];
            res[ind2][1] = inter[ind1][1];
            ind1++;
            ind2++;
        }

        while(ind1 < inter.length && newInter[1] >= inter[ind1][0]) {
            newInter[0] = Math.min(newInter[0], inter[ind1][0]);
            newInter[1] = Math.max(newInter[1], inter[ind1][1]);
            ind1++;
        }
        res[ind2][0] = newInter[0];
        res[ind2][1] = newInter[1];
        ind2++;

        while(ind1 < inter.length) {

            res[ind2][0] = inter[ind1][0];
            res[ind2][1] = inter[ind1][1];
            ind1++;
            ind2++;
        }

        return Arrays.copyOfRange(res, 0, ind2);

    }
}
