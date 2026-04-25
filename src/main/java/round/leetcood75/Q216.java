package round.leetcood75;

import java.util.ArrayList;
import java.util.List;

public class Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < (1 + k) * k / 2) return res;

        backTrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> path, int n, int k, int cur ) {
        if (path.size() == k && sumList(path) == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (cur > 9 || path.size() > k || sumList(path) > n) {
            return;
        }

        for (int i = cur; i < 9 ; i++) {
            if(sumList(path) + i > n) break;
            path.add(i);
            backTrack(res, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }

    }

    private int sumList(List<Integer> path) {
        int sum = 0;
        if (path.size() == 0 || path == null) return 0;

        for(int i : path) {
            sum += i;
        }
        return sum;
    }
}
