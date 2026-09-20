class Solution {
    public int reverseDegree(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int reversePosition = 26 - (s.charAt(i) - 'a');

            ans += (i + 1) * reversePosition;
        }

        return ans;
    }
}