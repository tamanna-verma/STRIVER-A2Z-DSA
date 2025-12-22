class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int minans = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int [][]dp = new int [m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            minans = Math.min(PathSum(matrix , m-1, i ,dp ), minans);
        }
        return minans;
    }
    public int PathSum(int matrix [][] , int row , int col , int dp[][]){
       if(col<0 || col>=matrix[0].length)return Integer.MAX_VALUE;
       if(row==0) return matrix[row][col];

       if(dp[row][col]!=-1)return dp[row][col];

       int minans = Integer.MAX_VALUE;
       for(int i=-1;i<=1;i++){
         minans = Math.min(minans , PathSum(matrix , row-1 , col+i , dp));
        }
       return dp[row][col] = minans + matrix[row][col];     
    }
}

//there can be 3 starting points , we will be looping on the no of columns for the starting point
// recursion function will be getting a start point , row , column , now it can move in [m+1,n-1] , [m, n], [m+1,n+]
//so we will be storing these answers in a dp array , we will be trying to make the dp array of same grid size, int case of tabulation optimization , we can try to further reduce it to dp array of columns size 

