import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int n = nums.length;

        int[] prefixSum = new int[n];

        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < n; i++) {

            int rem = prefixSum[i] % k;

            if(rem == 0) count++;

            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}