class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> out = new ArrayList<>();
        return findAll2(words, out);
    }

    public List<String> findAll1(String[] words, List<String> out) {
        Set<String> mem = new HashSet<>();
        for(String word: words) mem.add(word);
        //Check for each word if it can be formed using two or more words
        for(String word: words) {
            if(canForm(word, mem, 0)) {
                out.add(word);
            }
        }
        return out;
    }

    public boolean canForm(String word, Set<String> mem, int ind) {
        if(ind == word.length()) return true;
        for(int i = ind; i < word.length(); i++) {
            String prefix = word.substring(ind, i+1);
            if(mem.contains(prefix) && !prefix.equals(word) && canForm(word, mem, i+1)) {
                return true;
            }
        }
        return false;
    }

    public List<String> findAll2(String[] words, List<String> out) {
        Set<String> set = new HashSet<>();
        for(String str: words) set.add(str);

        for(String str: words) {
            // int[][] dp = new int[str.length()+1][1];
            // for(int i = 0; i < dp.length; i++)
            //     Arrays.fill(dp[i], -1);
            // if(canForm(str, set, 0, false, dp)) out.add(str);
            int[] dp = new int[str.length()+1];
            Arrays.fill(dp, -1);
            if(canFormN(str, set, 0, dp)) out.add(str);
        }

        return out;
    }

    public boolean canFormN(String word, Set<String> mem, int ind, int[] dp) {
        if(dp[ind] != -1) return dp[ind] == 1;
        if(ind == word.length()) {
            dp[ind] = 1;
            return true;
        }
        for(int i = ind; i < word.length(); i++) {
            String prefix = word.substring(ind, i+1);
            if(mem.contains(prefix) && !prefix.equals(word) && canFormN(word, mem, i+1, dp)) {
                dp[ind] = 1;
                return true;
            }
        }
        dp[ind] = 0;
        return false;
    }

    //we don't need any foundPrefix flag if ind reaches to str.length() means return true because it will reach there if any prefix found
    public boolean canForm(String str, Set<String> set, int ind, boolean foundPrefix, int[][] dp) {
        if(dp[ind][0] != -1) return dp[ind][0] == 1;
        if(ind == str.length()) return true;
        for(int i = ind ; i < str.length(); i++) {
            String prefix = str.substring(ind, i+1);
            if(set.contains(prefix) && !prefix.equals(str) && canForm(str, set, i+1, true, dp)) {
                dp[ind][0] = 1;
                return true;
            }
        }
        dp[ind][0] = 0;
        return false;
    }

    public List<String> findAll3(String[] words, List<String> out) {
        Set<String> set = new HashSet<>();
        for(String str: words) set.add(str);

        for(String str: words) {
            int[] dp = new int[str.length()+1];
            Arrays.fill(dp, -1);
            if(canForm(str, set, 0, dp)) out.add(str);
        }

        return out;
    }

    public boolean canForm(String str, Set<String> set, int ind, int[] dp) {
        if(dp[ind] != -1) return dp[ind] == 1;
        if(ind == str.length()) return true;
        for(int i = ind ; i < str.length(); i++) {
            String prefix = str.substring(ind, i+1);
            if(set.contains(prefix) && !prefix.equals(str) && canForm(str, set, i+1, dp)) {
                dp[ind] = 1;
                return true;
            }
        }
        dp[ind] = 0;
        return false;
    }
}