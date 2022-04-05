import java.util.ArrayList;
import java.util.List;

public class BackTrack {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, n, 1, k, new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int n, int num, int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = num; i <= n; i++) {
                list.add(i);
                backtrack(res, n, i + 1, k, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
