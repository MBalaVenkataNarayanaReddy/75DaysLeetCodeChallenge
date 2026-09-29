
import java.util.*;

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> current = new ArrayList<>();

        findSubsets(nums, 0, current);

        return result;
    }

    void findSubsets(int[] nums, int index, List<Integer> current) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            current.add(nums[i]);

            findSubsets(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}

