import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // map.put(0, 1); or first if condition

        int count = 0;

        for (int i = 1; i <= n; i++) {

            if (prefix[i] == k) {
                count++;
            }

            int required = prefix[i] - k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(prefix[i],
                    map.getOrDefault(prefix[i], 0) + 1);
        }

        return count;
    }
}