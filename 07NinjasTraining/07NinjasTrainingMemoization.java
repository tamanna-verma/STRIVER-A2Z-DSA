class Solution {
    public int maximumPoints(int matrix[][]) {
       
     int [][]dp = new int [matrix.length][4];
      for(int i=0;i<matrix.length;i++){
        for(int j=0;j<4;j++){
            dp[i][j]=-1;
        }
      }
     int ans = helper(matrix , dp , matrix.length-1 , 3);
     return ans;
    }

    public static int helper(int [][]matrix , int [][]dp , int index , int prev){
        if(index < 0)return 0;
        if(dp[index][prev]!=-1)return dp[index][prev];
         int max =Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(prev!=i){
               int smaller = helper(matrix , dp , index -1 , i) + matrix[index][i];
               max = Math.max(max , smaller);
            }
        }
        dp[index][prev] = max;
        return max;
    }

}