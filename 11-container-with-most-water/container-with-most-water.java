class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int MostWater = 0;

        while (left < right) {

            int width = right - left;

            int ht = Math.min(height[left], height[right]);

            MostWater = Math.max(MostWater, width* ht);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return MostWater;
    }
}