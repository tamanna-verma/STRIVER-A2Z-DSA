class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]= new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(m-1 , n-1 , dp);

    }
    public static int helper(int m , int n , int[][]dp){
        if(m==0 && n==0)return 1;

         if(dp[m][n]!=-1)return dp[m][n];
        int left=0,right=0;
        if(m>=1){
            left = helper(m-1 , n , dp);
        }
        if(n>=1){
            right = helper(m , n-1 , dp);
        }
        int total = left + right ;
        dp[m][n] = total;
        return total ;
    }
}