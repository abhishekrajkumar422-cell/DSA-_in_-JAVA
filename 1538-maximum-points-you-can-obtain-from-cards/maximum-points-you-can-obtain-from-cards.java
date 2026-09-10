class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int lsum = 0;
        int rsum = 0;
        int maxsum = 0;

        for(int i=0;i<k;i++){
            lsum +=cardPoints[i];
        }

        maxsum = lsum;
        int rIndex = n-1;

        for(int i=k-1;i>=0;i--){

            lsum = lsum-cardPoints[i];
            rsum += cardPoints[rIndex];
            rIndex--;

            maxsum = Math.max(maxsum,lsum+rsum);
        }

        return maxsum;
    }
}