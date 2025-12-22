class Solution {
    public int minPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int [n];
        dp[0]=matrix[0][0];
        for(int i=1;i<n;i++){
            dp[i] = matrix[0][i]+dp[i-1];
        }     
            for(int i=1;i<m;i++){
                int []temp = new int [n];
                for(int j=0;j<n;j++){   
                   int min = Integer.MAX_VALUE;
                    int top=Integer.MAX_VALUE,left = Integer.MAX_VALUE;
                    top = dp[j];
                    if(j>0)left = temp[j-1];
                    min = Math.min(top,left);
                   temp[j]=min+matrix[i][j];
                }
                dp = temp.clone();
            }
         return dp[n-1];
    }
}