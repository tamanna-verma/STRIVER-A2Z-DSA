class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int [n];
        dp[0]=matrix[0][0];
        for(int i=1;i<n;i++){
            dp[i] = matrix[0][i-1]+dp[i-1];
        }     
            for(int i=1;i<m;i++){
                int []temp = new int [n];
                for(int j=0;j<n;j++){   
                   int min = Integer.MAX_VALUE;
                   for(int k =-1;k<=1;k++){
                      if(j+k>=0 && j+k<n){
                        min=Math.min(dp[j+k],min);
                      }
                   }
                   temp[j]=min+matrix[i][j];
                }
                dp = temp.clone();
            }
         int min = Integer.MAX_VALUE;
         for(int i =0;i<m;i++){
            min = Math.min(min ,dp[i] );
         }
         return min;
    }
}
//so , now i want to do tabulation , 
//I need to have a base case that will be top down 
//base case will be starting from i,j value of dp i,j will be matrix[i][j]
//moving onwards , 