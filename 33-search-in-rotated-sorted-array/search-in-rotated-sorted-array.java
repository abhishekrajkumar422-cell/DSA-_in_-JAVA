class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target mil gaya
            if (nums[mid] == target) {
                return mid;
            }

            // Left half sorted hai
            if (nums[left] <= nums[mid]) {

                // Target left sorted half ke andar hai
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }

                // Target right half mein hai
                else {
                    left = mid + 1;
                }
            }

            // Right half sorted hai
            else {

                // Target right sorted half ke andar hai
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }

                // Target left half mein hai
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}