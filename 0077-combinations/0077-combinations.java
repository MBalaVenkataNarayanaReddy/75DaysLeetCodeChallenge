
import java.util.*;

class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        List<Integer> list = new ArrayList<>();
        solve(1, n, k, list);

        return answer;
    }

    void solve(int start, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);

            solve(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}

