class Solution {

    public void helper(int[][] image, int r, int c,
                       int color, boolean vis[][], int orgCol) {

        if (r < 0 || c < 0 || r >= image.length ||
            c >= image[0].length || vis[r][c] ||
            image[r][c] != orgCol) {
            return;
        }

        vis[r][c] = true;
        image[r][c] = color;

        helper(image, r - 1, c, color, vis, orgCol);
        helper(image, r + 1, c, color, vis, orgCol);
        helper(image, r, c - 1, color, vis, orgCol);
        helper(image, r, c + 1, color, vis, orgCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean vis[][] =
            new boolean[image.length][image[0].length];

        helper(image, sr, sc, color, vis, image[sr][sc]);

        return image;
    }
}