class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m+1][n+1];
        for(int i =0;i<m;i++){
            Arrays.fill(paths[i],-1);
        }

        return totalPath(0,0,m,n,paths);
    }

    public int totalPath(int i, int j,int m, int n, int[][]paths){

        if(i>=m || j>=n) return 0;
        if(i == m-1 && j==n-1 ) return 1;

        if(paths[i][j] != -1){
            return paths[i][j];
        }

        int right = totalPath(i,j+1,m,n,paths);
        int down = totalPath(i+1,j,m,n,paths);

        return paths[i][j] =  right+down;

    }
}
